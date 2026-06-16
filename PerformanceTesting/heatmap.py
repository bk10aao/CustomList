import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# 1. Load the benchmark data files
custom_df = pd.read_csv('customlist_performance.csv', sep=';')
jdk_df = pd.read_csv('list_performance.csv', sep=';')

# 2. Extract input sizes and isolate methods (excluding metadata and 'equals')
methods = [col for col in custom_df.columns if col not in ['Size', 'equals(Object)']]
sizes = custom_df['Size'].tolist()

# 3. Construct the relative performance matrix (Log2 ratios)
heatmap_data = np.zeros((len(methods), len(sizes)))
text_labels = []

for i, m in enumerate(methods):
    row_labels = []
    for j, size in enumerate(sizes):
        c_val = custom_df.loc[custom_df['Size'] == size, m].values[0]
        j_val = jdk_df.loc[jdk_df['Size'] == size, m].values[0]

        # Prevent division by zero errors
        if c_val == 0: c_val = 1
        if j_val == 0: j_val = 1

        # Log2 converts ratios into a perfectly symmetrical linear scale:
        # e.g., Log2(2/1) = +1 (Custom 2x faster), Log2(1/2) = -1 (JDK 2x faster)
        ratio = np.log2(j_val / c_val)
        heatmap_data[i, j] = ratio

        # Generate user-friendly absolute text markers for the cell annotations
        if j_val > c_val:
            factor = j_val / c_val
            row_labels.append(f"+{factor:.1f}x")  # Custom is faster
        else:
            factor = c_val / j_val
            row_labels.append(f"-{factor:.1f}x")  # JDK is faster

    text_labels.append(row_labels)

text_labels = np.array(text_labels)

# 4. Sort the methods from top to bottom by their geometric trends
avg_ratios = np.mean(heatmap_data, axis=1)
sorted_idx = np.argsort(avg_ratios)

heatmap_data = heatmap_data[sorted_idx]
text_labels = text_labels[sorted_idx]
sorted_methods = [methods[idx] for idx in sorted_idx]

# 5. Initialize the plot canvas with a explicit dark frame background
fig, ax = plt.subplots(figsize=(14, 13))
fig.patch.set_facecolor('#1e1e1e')
ax.set_facecolor('#1e1e1e')

# 6. Clip visual color mapping to [-3.0, 3.0] (up to an 8x speedup variation)
# This prevents extreme micro-noise spikes from drowning out subtle 1.5x - 3x insights
clipped_heatmap_data = np.clip(heatmap_data, -3.0, 3.0)

# 7. Create a custom divergent colormap (Red = JDK Faster, Blue = Custom Faster)
cmap = sns.diverging_palette(15, 240, as_cmap=True)

# 8. Render the Seaborn Heatmap
sns.heatmap(clipped_heatmap_data,
            annot=text_labels,
            fmt="",
            cmap=cmap,
            center=0,
            xticklabels=sizes,
            yticklabels=sorted_methods,
            ax=ax,
            cbar_kws={'label': '← JDK Faster  |  Relative Speedup Scale (Clipped for Contrast)  |  Custom Faster →'},
            linewidths=0.8,
            linecolor='#2d2d2d',
            annot_kws={'size': 11, 'weight': 'bold'})

# 9. Format Title, Labels, and Colorbar styling to match dark theme guidelines
ax.set_title(
    'Performance Speedup Matrix Heatmap Across Sizes\n(Symmetric Scaling Factor Comparison | "equals" Excluded)',
    color='#ffffff', fontsize=16, fontweight='bold', pad=20)
ax.set_ylabel('Benchmark Methods', color='#aaaaaa', fontsize=13, labelpad=10)
ax.set_xlabel('Collection Size (Elements)', color='#aaaaaa', fontsize=13, labelpad=10)

ax.tick_params(colors='#ffffff', labelsize=12)
plt.xticks(rotation=0)
plt.yticks(rotation=0)

# Style color bar text matching
cbar = ax.collections[0].colorbar
cbar.ax.tick_params(colors='#ffffff', labelsize=10)
cbar.ax.yaxis.label.set_color('#ffffff')
cbar.ax.yaxis.label.set_fontsize(12)

# 10. Compute strict boundaries and save out image asset
plt.tight_layout()
plt.savefig('heatmap.png', dpi=300, facecolor=fig.get_facecolor(), edgecolor='none')
plt.close()