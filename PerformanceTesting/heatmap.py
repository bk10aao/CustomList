import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Load the benchmark data files
custom_df = pd.read_csv('customlist_performance.csv', sep=';')
jdk_df = pd.read_csv('list_performance.csv', sep=';')

# Extract input sizes and isolate methods (excluding metadata and 'equals')
methods = [col for col in custom_df.columns]
sizes = custom_df['Size'].tolist()

# Construct the relative performance matrix (Log2 ratios)
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

        ratio = np.log2(j_val / c_val)
        heatmap_data[i, j] = ratio

        if j_val > c_val:
            factor = j_val / c_val
            row_labels.append(f"+{factor:.1f}x")
        else:
            factor = c_val / j_val
            row_labels.append(f"-{factor:.1f}x")

    text_labels.append(row_labels)

text_labels = np.array(text_labels)

# Sort the methods from top to bottom by their geometric trends
avg_ratios = np.mean(heatmap_data, axis=1)
sorted_idx = np.argsort(avg_ratios)

heatmap_data = heatmap_data[sorted_idx]
text_labels = text_labels[sorted_idx]
sorted_methods = [methods[idx] for idx in sorted_idx]

# Initialize the plot canvas with a fully transparent background
fig, ax = plt.subplots(figsize=(14, 13), facecolor='none')
ax.set_facecolor('none')

# Clip visual color mapping to [-3.0, 3.0]
clipped_heatmap_data = np.clip(heatmap_data, -3.0, 3.0)

# Create a custom divergent colormap (Red = JDK Faster, Blue = Custom Faster)
cmap = sns.diverging_palette(15, 240, as_cmap=True)

# Render the Seaborn Heatmap with clear transparent cell boundaries
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
            linecolor='#555555',  # Subtle grid line divider between blocks
            annot_kws={'size': 11, 'weight': 'bold'})

# Format Title, Labels, and Colorbar styling to match dark/transparent theme guidelines
ax.set_title(
    'Performance Speedup Matrix Heatmap Across Sizes\n(Symmetric Scaling Factor Comparison)',
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

# Compute strict boundaries and save out transparent image asset
plt.tight_layout()
plt.savefig('heatmap.png', dpi=300, transparent=True)
plt.close()

print("Transparent heatmap matrix generated successfully!")