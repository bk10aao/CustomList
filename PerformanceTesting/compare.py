import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import csv
from collections import defaultdict

def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower() != 'size']

        for row in reader:
            size = int(row['Size'].strip('"'))
            # No size filtering, plot all
            for header in headers:
                val_str = row.get(f'"{header}"') or row.get(header) or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data

# Load CSV data for CustomList and ArrayList
custom_data = read_csv('customlist_performance.csv')
arraylist_data = read_csv('list_performance.csv')

# Find common methods between both datasets
common_methods = sorted(set(custom_data.keys()).intersection(set(arraylist_data.keys())))

if not common_methods:
    print("No common methods found between CustomList and ArrayList CSVs.")
    exit()

# Use sizes from CustomList for x-axis (assuming both use same sizes)
sizes = sorted([size for size, _ in custom_data[common_methods[0]]])

fig, axes = plt.subplots(nrows=len(common_methods), ncols=1, figsize=(10, 4 * len(common_methods)))
if len(common_methods) == 1:
    axes = [axes]

scalar_formatter = ticker.ScalarFormatter()
scalar_formatter.set_scientific(False)
scalar_formatter.set_useOffset(False)

# X-axis ticks every 10,000 between min and max size
x_min, x_max = min(sizes), max(sizes)
x_ticks = list(range((x_min // 10000) * 10000, x_max + 10000, 10000))

for idx, method in enumerate(common_methods):
    custom_times = [time for _, time in custom_data[method]]
    arraylist_times = [time for _, time in arraylist_data.get(method, [(0, 0)] * len(sizes))]

    ax = axes[idx]

    ax.plot(sizes, custom_times, label='CustomList', linestyle='-', linewidth=1.5)
    ax.plot(sizes, arraylist_times, label='ArrayList', linestyle='-', linewidth=1.5)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.set_title(method)
    ax.legend()
    ax.grid(True)

    ax.set_xlim(x_min, x_max)
    y_max = max(max(custom_times, default=0), max(arraylist_times, default=0))
    ax.set_ylim(0, y_max * 1.1 if y_max > 0 else 1)

    ax.set_xticks(x_ticks)
    ax.set_xticklabels([f"{tick:,}" for tick in x_ticks], rotation=45, ha='right')
    ax.xaxis.set_major_formatter(scalar_formatter)
    ax.yaxis.set_major_formatter(scalar_formatter)

plt.tight_layout()
plt.savefig('CustomList_vs_ArrayList_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print(f"Performance comparison charts saved in 'CustomList_vs_ArrayList_Performance_Comparisons.png' for methods: {', '.join(common_methods)}")
