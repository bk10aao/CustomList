import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.lines import Line2D
import os
import numpy as np

# Load datasets
custom_df = pd.read_csv('customlist_performance.csv', sep=';')
native_df = pd.read_csv('list_performance.csv', sep=';')

# Get common columns excluding 'Size'
common_cols = sorted([col for col in custom_df.columns if col in native_df.columns and col != 'Size'])

# Filter for methods with valid data
valid_cols = [col for col in common_cols if pd.notna(custom_df[col].mean()) and pd.notna(native_df[col].mean())]

# Define specific colors
color_custom = '#ff4d4d'  # Red
color_native = '#4da6ff'  # Blue

# Create output directory for organization
output_dir = 'performance_plots_styled_v4'
os.makedirs(output_dir, exist_ok=True)

# Generate a plot for each valid method
for method in valid_cols:
    fig, ax = plt.subplots(figsize=(8, 5.5))

    # Plot data
    ax.plot(custom_df['Size'], custom_df[method], color=color_custom, marker='o', markersize=5, linestyle='-',
            linewidth=2)
    ax.plot(native_df['Size'], native_df[method], color=color_native, marker='o', markersize=5, linestyle='-',
            linewidth=2)

    # Set axes ranges as requested
    ax.set_xlim(5000, 50000)
    ax.set_ylim(bottom=0)

    # Set x-axis ticks
    ax.set_xticks(np.arange(5000, 50001, 5000))

    # Update text to be white for dark mode compatibility
    ax.set_title(method, fontsize=14, fontweight='bold', color='white', pad=15)
    ax.set_xlabel('Size', fontsize=11, color='white')
    ax.set_ylabel('Time (ns)', fontsize=11, color='white')

    # Update ticks and grid to be white/light
    ax.tick_params(axis='both', colors='white')
    ax.grid(True, linestyle='--', alpha=0.3, color='white')

    # Update axes borders to white
    for spine in ax.spines.values():
        spine.set_color('white')

    # Custom Legend
    legend_elements = [
        Line2D([0], [0], marker='o', color='none', label='CustomList',
               markerfacecolor=color_custom, markeredgecolor=color_custom, markersize=8, linestyle='None'),
        Line2D([0], [0], marker='o', color='none', label='ArrayList',
               markerfacecolor=color_native, markeredgecolor=color_native, markersize=8, linestyle='None')
    ]

    # Place legend
    legend = ax.legend(handles=legend_elements, loc='upper center', bbox_to_anchor=(0.5, -0.15),
                       fontsize=10, frameon=False, ncol=2)
    for text in legend.get_texts():
        text.set_color('white')

    # Make background completely transparent
    fig.patch.set_alpha(0.0)
    ax.patch.set_alpha(0.0)

    plt.tight_layout()

    # Sanitize the method name
    safe_filename = method.replace('(', '_').replace(')', '_').replace(',', '_').replace('.', '_').replace('<',
                                                                                                           '').replace(
        '>', '')

    # Save the plot
    plt.savefig(os.path.join(output_dir, f'plot_{safe_filename}.png'), transparent=True, bbox_inches='tight')
    plt.close()

print(f"Successfully generated {len(valid_cols)} performance graphs in '{output_dir}'.")