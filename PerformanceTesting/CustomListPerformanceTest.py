import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import csv
import numpy as np
from collections import defaultdict

def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower() != 'size']

        for row in reader:
            size = int(row['Size'].strip('"'))
            if size < 2500:  # Skip sizes less than 2500 if needed
                continue
            for header in headers:
                val_str = row.get(f'"{header}"') or row.get(header) or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data

# Load data from CustomList CSV
custom_data = read_csv('/Users/drpsychoben/PycharmProjects/ListPerformanceCharts/customlist_performance.csv')

methods = sorted([m for m in custom_data.keys()])
sizes = sorted([size for size, _ in custom_data[methods[0]]])

fig, axes = plt.subplots(nrows=len(methods), ncols=1, figsize=(10, 4 * len(methods)))
if len(methods) == 1:
    axes = [axes]

scalar_formatter = ticker.ScalarFormatter()
scalar_formatter.set_scientific(False)
scalar_formatter.set_useOffset(False)

# Set x ticks every 10,000 from 10,000 to max size (100,000)
x_ticks = list(range(10000, max(sizes)+1, 10000))

for idx, method in enumerate(methods):
    times = [time for _, time in custom_data[method]]
    ax = axes[idx]

    ax.plot(sizes, times, label='CustomList', linestyle='-', linewidth=1.5)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.set_title(method)
    ax.legend()
    ax.grid(True)

    ax.set_xlim(min(sizes), max(sizes))
    y_max = max(times) if times else 1
    ax.set_ylim(0, y_max * 1.1)

    # Set the new x-axis ticks, format with commas, and rotate labels
    ax.set_xticks(x_ticks)
    ax.set_xticklabels([f"{tick:,}" for tick in x_ticks], rotation=45, ha='right')
    ax.xaxis.set_major_formatter(scalar_formatter)
    ax.yaxis.set_major_formatter(scalar_formatter)

plt.tight_layout()
plt.savefig('CustomList_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print(f"All performance charts saved in 'CustomList_Performance_Comparisons.png' for methods: {', '.join(methods)}")
