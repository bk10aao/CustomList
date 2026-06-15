import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import gmean

# Load the data files
custom_df = pd.read_csv('customlist_performance.csv', sep=';')
jdk_df = pd.read_csv('list_performance.csv', sep=';')

# Clean up any 0 values to prevent geometric mean zero-collapse, and exclude 'equals(Object)'
methods = [col for col in custom_df.columns if col not in ['Size', 'equals(Object)']]
custom_df_fixed = custom_df.copy()
jdk_df_fixed = jdk_df.copy()

for col in methods:
    custom_df_fixed[col] = custom_df_fixed[col].replace(0, 1)
    jdk_df_fixed[col] = jdk_df_fixed[col].replace(0, 1)

ratios = []
labels = []
colors = []

custom_win_color = '#4DA6FF' # Sky Blue
jdk_win_color = '#FF4D4D'    # Light Coral

for m in methods:
    g_c = gmean(custom_df_fixed[m])
    g_j = gmean(jdk_df_fixed[m])

    if g_c < g_j:
        speedup = g_j / g_c
        ratios.append(speedup - 1)  # Positive side of the baseline (Custom faster)
        colors.append(custom_win_color)
    else:
        speedup = g_c / g_j
        ratios.append(-(speedup - 1)) # Negative side of the baseline (JDK faster)
        colors.append(jdk_win_color)
    labels.append(m)

sorted_indices = np.argsort(ratios)
sorted_ratios = [ratios[idx] for idx in sorted_indices]
sorted_labels = [labels[idx] for idx in sorted_indices]
sorted_colors = [colors[idx] for idx in sorted_indices]

# Initialize figure canvas with fully transparent backgrounds
fig, ax = plt.subplots(figsize=(14, 12), facecolor='none')
ax.set_facecolor('none')

# Plot the horizontal bar chart layout
bars = ax.barh(sorted_labels, sorted_ratios, color=sorted_colors, alpha=0.9)

# Draw a sharp white baseline divider at the 'Tie' marker (x=0)
ax.axvline(x=0, color='#ffffff', linewidth=1.2)

# Set the X-axis range symmetrically from 2.00x JDK Faster (-1.0) to 2.00x Custom Faster (1.0)
ax.set_xlim(-1.0, 1.0)

# Set fixed tick positions for clean spacing
fixed_ticks = np.array([-1.0, -0.5, 0.0, 0.5, 1.0])
ax.set_xticks(fixed_ticks)

# Format X-ticks dynamically into descriptive absolute factors
new_labels = [f'{abs(t)+1:.2f}x' if t != 0 else 'Tie' for t in fixed_ticks]
ax.set_xticklabels(new_labels, color='#ffffff', fontsize=12)

# Apply typography, sizing rules, and custom text options
ax.set_title('Overall Relative Performance Comparison\n(Geometric Mean Across All Sizes)',
             fontsize=16, fontweight='bold', pad=15, color='#ffffff')
ax.set_xlabel('← JDK Faster  |  Relative Speedup Factor  |  Custom Faster →',
              fontsize=14, labelpad=12, color='#ffffff')

# Add subtle background grid lines along the X-axis for measurement tracking
ax.grid(True, axis='x', linestyle='--', alpha=0.3, color='#888888')
ax.tick_params(colors='#ffffff', which='both', labelsize=12)

# Color the bounding spines to match the dark layout structure cleanly
for spine in ax.spines.values():
    spine.set_edgecolor('#cccccc')

# Enforce larger font styling configurations exclusively on the method labels
ax.set_yticks(range(len(sorted_labels)))
ax.set_yticklabels(sorted_labels, color='#ffffff', fontsize=14)

# Tighten boundaries up and output file with transparency flags active
plt.tight_layout()
plt.savefig('steady_state_performance_chart_transparent.png', dpi=300, transparent=True)
plt.close()

print("Successfully updated the chart range symmetrically from 2.00x to 2.00x!")