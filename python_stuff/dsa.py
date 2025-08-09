"""
Data Structures & Algorithms Visualizer
Single-file Tkinter application that demonstrates a modular architecture
using generator-based algorithm implementations for step-by-step animation.

Features (implemented core subset + extension hooks):
 - Tkinter GUI with Canvas visualization
 - Sorting visualizations (many implemented)
 - Searching (linear, binary)
 - Graph BFS/DFS visualizer
 - Binary Search Tree (insert/search/visualize)
 - Step / Continuous play, speed control, start/pause/resume/reset
 - Random or custom input
 - Pseudocode viewer that follows algorithm selection
 - Threading to keep GUI responsive

How it works: Each algorithm is implemented as a generator that yields
visual actions describing what happened (comparisons, swaps, highlights).
The Visualizer consumes those actions with delays determined by the speed slider.

Extending: Add a new generator returning actions and register it in
ALGORITHM_REGISTRY.

Run: python ds_algo_visualizer.py

"""

import tkinter as tk
from tkinter import ttk, simpledialog, messagebox, scrolledtext, filedialog
import random
import threading
import time
import math
from collections import deque

# ------------------------------- Utilities ----------------------------------

def clamp(x, a, b):
    return max(a, min(b, x))

# Action format: tuples like ("compare", i, j), ("swap", i, j), ("set", i, val), ("highlight", i), ("done",)

# --------------------------- Algorithm Generators --------------------------
# Each algorithm yields a sequence of actions for the visualizer to animate.

# Sorting Algorithms (array-based)

def bubble_sort(arr):
    n = len(arr)
    a = arr
    for i in range(n):
        for j in range(0, n - i - 1):
            yield ("compare", j, j + 1)
            if a[j] > a[j + 1]:
                a[j], a[j + 1] = a[j + 1], a[j]
                yield ("swap", j, j + 1)
    yield ("done",)


def selection_sort(arr):
    a = arr
    n = len(a)
    for i in range(n):
        min_idx = i
        for j in range(i + 1, n):
            yield ("compare", min_idx, j)
            if a[j] < a[min_idx]:
                min_idx = j
                yield ("highlight", min_idx)
        if i != min_idx:
            a[i], a[min_idx] = a[min_idx], a[i]
            yield ("swap", i, min_idx)
    yield ("done",)


def insertion_sort(arr):
    a = arr
    for i in range(1, len(a)):
        key = a[i]
        j = i - 1
        yield ("highlight", i)
        while j >= 0 and a[j] > key:
            yield ("compare", j, j + 1)
            a[j + 1] = a[j]
            yield ("set", j + 1, a[j + 1])
            j -= 1
        a[j + 1] = key
        yield ("set", j + 1, key)
    yield ("done",)


def merge_sort_generator(arr):
    a = list(arr)
    n = len(a)
    aux = [0] * n

    def merge(l, m, r):
        i, j, k = l, m + 1, l
        while i <= m and j <= r:
            yield ("compare", i, j)
            if a[i] <= a[j]:
                aux[k] = a[i]
                yield ("set", k, a[i])
                i += 1
            else:
                aux[k] = a[j]
                yield ("set", k, a[j])
                j += 1
            k += 1
        while i <= m:
            aux[k] = a[i]
            yield ("set", k, a[i])
            i += 1; k += 1
        while j <= r:
            aux[k] = a[j]
            yield ("set", k, a[j])
            j += 1; k += 1
        for x in range(l, r + 1):
            a[x] = aux[x]
            yield ("set", x, a[x])

    def ms(l, r):
        if l >= r:
            return
        m = (l + r) // 2
        yield from ms(l, m)
        yield from ms(m + 1, r)
        yield from merge(l, m, r)

    yield from ms(0, n - 1)
    yield ("done",)


def quick_sort_generator(arr):
    a = arr
    n = len(a)

    def partition(l, r):
        pivot = a[r]
        i = l - 1
        for j in range(l, r):
            yield ("compare", j, r)
            if a[j] <= pivot:
                i += 1
                a[i], a[j] = a[j], a[i]
                yield ("swap", i, j)
        a[i + 1], a[r] = a[r], a[i + 1]
        yield ("swap", i + 1, r)
        return i + 1

    def qs(l, r):
        if l < r:
            p = None
            # run partition but capture the returned pivot after partition completes
            gen = partition(l, r)
            for action in gen:
                if isinstance(action, tuple) and action[0] == 'swap' and action[1] == action[2] == r:
                    pass
                yield action
            # after partition generator finishes, compute pivot index manually
            # (for simplicity, recompute pivot)
            pivot_val = a[r]
            i = l - 1
            for j in range(l, r):
                if a[j] <= pivot_val:
                    i += 1
            p = i + 1
            yield from qs(l, p - 1)
            yield from qs(p + 1, r)

    yield from qs(0, n - 1)
    yield ("done",)


def heap_sort_generator(arr):
    a = arr
    n = len(a)

    def heapify(n, i):
        largest = i
        l = 2 * i + 1
        r = 2 * i + 2
        if l < n:
            yield ("compare", l, largest)
            if a[l] > a[largest]:
                largest = l
        if r < n:
            yield ("compare", r, largest)
            if a[r] > a[largest]:
                largest = r
        if largest != i:
            a[i], a[largest] = a[largest], a[i]
            yield ("swap", i, largest)
            yield from heapify(n, largest)

    for i in range(n // 2 - 1, -1, -1):
        yield from heapify(n, i)
    for i in range(n - 1, 0, -1):
        a[0], a[i] = a[i], a[0]
        yield ("swap", 0, i)
        yield from heapify(i, 0)
    yield ("done",)


def counting_sort_generator(arr):
    if not arr:
        yield ("done",)
        return
    a = arr
    minv = min(a)
    maxv = max(a)
    size = maxv - minv + 1
    count = [0] * size
    for num in a:
        count[num - minv] += 1
        idx = a.index(num)
        yield ("highlight", idx)
    # build output
    out = []
    for val, c in enumerate(count):
        for _ in range(c):
            out.append(val + minv)
    for i, v in enumerate(out):
        a[i] = v
        yield ("set", i, v)
    yield ("done",)


def radix_sort_generator(arr):
    a = list(arr)
    if not a:
        yield ("done",)
        return
    maxv = max(a)
    exp = 1
    n = len(a)
    while maxv // exp > 0:
        output = [0] * n
        count = [0] * 10
        for i in range(n):
            index = (a[i] // exp) % 10
            count[index] += 1
            yield ("highlight", i)
        for i in range(1, 10):
            count[i] += count[i - 1]
        i = n - 1
        while i >= 0:
            index = (a[i] // exp) % 10
            output[count[index] - 1] = a[i]
            count[index] -= 1
            i -= 1
        for i in range(n):
            a[i] = output[i]
            yield ("set", i, a[i])
        exp *= 10
    yield ("done",)

# Searching Algorithms

def linear_search_generator(arr, target):
    for i, v in enumerate(arr):
        yield ("compare", i, None)
        if v == target:
            yield ("found", i)
            break
    else:
        yield ("not_found",)
    yield ("done",)


def binary_search_generator(arr, target):
    a = sorted(arr)  # visualize on sorted array
    l, r = 0, len(a) - 1
    while l <= r:
        m = (l + r) // 2
        yield ("compare", m, None)
        if a[m] == target:
            yield ("found", m)
            break
        elif a[m] < target:
            l = m + 1
        else:
            r = m - 1
    else:
        yield ("not_found",)
    yield ("done",)

# Graph Traversal (BFS, DFS)

def bfs_generator(adj, start=0):
    n = len(adj)
    visited = [False] * n
    q = deque([start])
    visited[start] = True
    yield ("visit", start)
    while q:
        u = q.popleft()
        for v in adj[u]:
            yield ("compare_node", u, v)
            if not visited[v]:
                visited[v] = True
                q.append(v)
                yield ("visit", v)
    yield ("done",)


def dfs_generator(adj, start=0):
    n = len(adj)
    visited = [False] * n
    stack = [start]
    while stack:
        u = stack.pop()
        if visited[u]:
            continue
        visited[u] = True
        yield ("visit", u)
        for v in reversed(adj[u]):
            yield ("compare_node", u, v)
            if not visited[v]:
                stack.append(v)
    yield ("done",)

# BST operations (visualization friendly)

class BSTNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


def bst_insert_generator(root, key):
    if root is None:
        yield ("bst_insert_root", key)
        yield ("done",)
        return
    node = root
    path = []
    while True:
        yield ("bst_compare", node.key, key)
        if key < node.key:
            path.append((node, 'L'))
            if node.left is None:
                node.left = BSTNode(key)
                yield ("bst_insert", node.key, 'L', key)
                break
            node = node.left
        else:
            path.append((node, 'R'))
            if node.right is None:
                node.right = BSTNode(key)
                yield ("bst_insert", node.key, 'R', key)
                break
            node = node.right
    yield ("done",)


def bst_inorder_generator(root):
    def inorder(node):
        if not node:
            return
        yield from inorder(node.left)
        yield ("bst_visit", node.key)
        yield from inorder(node.right)
    yield from inorder(root)
    yield ("done",)

# ------------------------- Algorithm Registry ------------------------------

ALGORITHM_REGISTRY = {
    'Sorting': {
        'Bubble Sort': (bubble_sort, "Bubble Sort: repeatedly swap adjacent out-of-order items."),
        'Selection Sort': (selection_sort, "Selection Sort: repeatedly pick min and swap into place."),
        'Insertion Sort': (insertion_sort, "Insertion Sort: build sorted section by inserting elements."),
        'Merge Sort': (merge_sort_generator, "Merge Sort: divide and conquer merges sorted halves."),
        'Quick Sort': (quick_sort_generator, "Quick Sort: partition around pivots recursively."),
        'Heap Sort': (heap_sort_generator, "Heap Sort: build heap and extract max repeatedly."),
        'Counting Sort': (counting_sort_generator, "Counting Sort: counts occurrences (integer keys)."),
        'Radix Sort': (radix_sort_generator, "Radix Sort: sort by digit places (LSD)."),
    },
    'Searching': {
        'Linear Search': (linear_search_generator, "Linear Search: scan sequentially."),
        'Binary Search': (binary_search_generator, "Binary Search: search on sorted data (log n)."),
    },
    'Graph': {
        'BFS': (bfs_generator, "Breadth-First Search: explores by layers."),
        'DFS': (dfs_generator, "Depth-First Search: explores deep before backtracking."),
    },
    'Tree': {
        'BST Insert (demo)': (bst_insert_generator, "BST Insert: insert node preserving BST property."),
        'BST Inorder (demo)': (bst_inorder_generator, "BST Inorder traversal (sorted output)."),
    }
}

# --------------------------- Visualization Core ---------------------------

class VisualizerApp(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("DS & Algo Visualizer")
        self.geometry("1100x700")
        self.protocol("WM_DELETE_WINDOW", self.on_close)

        # Data
        self.array = []
        self.original_array = []
        self.adj = None
        self.bst_root = None

        # Control
        self.selected_category = tk.StringVar(value='Sorting')
        self.selected_algo = tk.StringVar(value='Bubble Sort')
        self.selected_ds = tk.StringVar(value='Array')
        self.size_var = tk.IntVar(value=20)
        self.speed_var = tk.DoubleVar(value=1.0)
        self.step_mode = tk.BooleanVar(value=False)
        self.running = False
        self.paused = threading.Event()
        self.paused.set()
        self._algo_thread = None
        self._algo_gen = None
        self.action_lock = threading.Lock()

        self._build_ui()
        self.reset_state()

    def _build_ui(self):
        # Top controls frame
        ctrl = ttk.Frame(self)
        ctrl.pack(side=tk.TOP, fill=tk.X, padx=6, pady=6)

        ttk.Label(ctrl, text='Category:').pack(side=tk.LEFT)
        cat_menu = ttk.OptionMenu(ctrl, self.selected_category, self.selected_category.get(), *ALGORITHM_REGISTRY.keys(), command=self._on_category_change)
        cat_menu.pack(side=tk.LEFT, padx=4)

        ttk.Label(ctrl, text='Algorithm:').pack(side=tk.LEFT, padx=(8, 0))
        self.algo_menu = ttk.OptionMenu(ctrl, self.selected_algo, self.selected_algo.get(), *ALGORITHM_REGISTRY['Sorting'].keys())
        self.algo_menu.pack(side=tk.LEFT, padx=4)

        ttk.Label(ctrl, text='Data Structure:').pack(side=tk.LEFT, padx=(8, 0))
        ds_menu = ttk.OptionMenu(ctrl, self.selected_ds, self.selected_ds.get(), 'Array', 'Linked List', 'Stack', 'Queue', 'Tree', 'Graph')
        ds_menu.pack(side=tk.LEFT, padx=4)

        ttk.Label(ctrl, text='Size:').pack(side=tk.LEFT, padx=(8, 0))
        size_scale = ttk.Scale(ctrl, from_=5, to=100, orient=tk.HORIZONTAL, variable=self.size_var)
        size_scale.pack(side=tk.LEFT, padx=4)

        ttk.Label(ctrl, text='Speed:').pack(side=tk.LEFT, padx=(8, 0))
        speed_scale = ttk.Scale(ctrl, from_=0.1, to=3.0, orient=tk.HORIZONTAL, variable=self.speed_var)
        speed_scale.pack(side=tk.LEFT, padx=4)

        ttk.Checkbutton(ctrl, text='Step Mode', variable=self.step_mode).pack(side=tk.LEFT, padx=(8, 0))

        ttk.Button(ctrl, text='Random Data', command=self.randomize_data).pack(side=tk.LEFT, padx=4)
        ttk.Button(ctrl, text='Custom Input', command=self.custom_input).pack(side=tk.LEFT, padx=4)

        # Buttons
        btn_frame = ttk.Frame(self)
        btn_frame.pack(side=tk.TOP, fill=tk.X, padx=6)
        ttk.Button(btn_frame, text='Start', command=self.start).pack(side=tk.LEFT, padx=4)
        ttk.Button(btn_frame, text='Pause', command=self.pause).pack(side=tk.LEFT, padx=4)
        ttk.Button(btn_frame, text='Resume', command=self.resume).pack(side=tk.LEFT, padx=4)
        ttk.Button(btn_frame, text='Step', command=self.step_once).pack(side=tk.LEFT, padx=4)
        ttk.Button(btn_frame, text='Reset', command=self.reset_state).pack(side=tk.LEFT, padx=4)

        # Main content: Canvas + Code Viewer
        content = ttk.Frame(self)
        content.pack(side=tk.TOP, fill=tk.BOTH, expand=True, padx=6, pady=6)

        # Canvas
        self.canvas = tk.Canvas(content, bg='#1e1e1e')
        self.canvas.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)

        # Right-side panel
        right = ttk.Frame(content, width=320)
        right.pack(side=tk.RIGHT, fill=tk.Y)

        ttk.Label(right, text='Pseudocode / Info').pack(anchor='nw')
        self.code_view = scrolledtext.ScrolledText(right, width=40, height=30)
        self.code_view.pack(fill=tk.BOTH, expand=True)
        self._update_code_view()

        # Bindings
        self.bind('<Configure>', lambda e: self.redraw())

    def _on_category_change(self, _=None):
        cat = self.selected_category.get()
        algos = list(ALGORITHM_REGISTRY.get(cat, {}).keys())
        if algos:
            self.selected_algo.set(algos[0])
            menu = self.algo_menu['menu']
            menu.delete(0, 'end')
            for name in algos:
                menu.add_command(label=name, command=lambda v=name: (self.selected_algo.set(v), self._update_code_view()))
        self._update_code_view()

    def _update_code_view(self):
        cat = self.selected_category.get()
        algo = self.selected_algo.get()
        info = ALGORITHM_REGISTRY.get(cat, {}).get(algo, (None, 'No description available.'))[1]
        self.code_view.delete('1.0', tk.END)
        self.code_view.insert(tk.END, f"Category: {cat}\nAlgorithm: {algo}\n\n{info}\n\n-- Pseudocode (simplified) --\n")
        # Minimal pseudocode examples
        pseudo = {
            'Bubble Sort': "for i in 0..n: for j in 0..n-i-1: if a[j] > a[j+1]: swap",
            'Selection Sort': "for i in 0..n: min = i; for j in i+1..n: if a[j] < a[min]: min = j; swap(a[i], a[min])",
            'Insertion Sort': "for i in 1..n: key = a[i]; j=i-1; while j>=0 and a[j]>key: a[j+1]=a[j]; j--; a[j+1]=key",
            'Merge Sort': "if l<r: mid=(l+r)//2; sort(l,mid); sort(mid+1,r); merge",
            'Quick Sort': "partition; quicksort(left); quicksort(right)",
            'BFS': "mark start; while queue: u=pop; for v in adj[u]: if not vis[v]: vis[v]=true; push(v)",
            'DFS': "visit node; for v in adj[u]: if not vis[v]: dfs(v)",
        }
        self.code_view.insert(tk.END, pseudo.get(algo, 'Pseudocode not available.'))

    # ---------------------- Data Management ----------------------
    def randomize_data(self):
        size = clamp(int(self.size_var.get()), 3, 200)
        cat = self.selected_category.get()
        if cat in ('Sorting', 'Searching') or self.selected_ds.get() == 'Array':
            # random array
            self.array = [random.randint(1, max(1, size * 5)) for _ in range(size)]
            self.original_array = list(self.array)
            self.adj = None
            self.bst_root = None
        elif self.selected_ds.get() == 'Graph' or cat == 'Graph':
            # build random graph
            n = clamp(size // 5 + 5, 5, 30)
            adj = [[] for _ in range(n)]
            for i in range(n):
                for j in range(i + 1, n):
                    if random.random() < 0.2:
                        adj[i].append(j);
                        adj[j].append(i)
            self.adj = adj
            self.array = []
            self.bst_root = None
        else:
            # fallback
            self.array = [random.randint(1, 100) for _ in range(size)]
            self.original_array = list(self.array)
        self.redraw()

    def custom_input(self):
        cat = self.selected_category.get()
        if cat in ('Sorting', 'Searching') or self.selected_ds.get() == 'Array':
            s = simpledialog.askstring("Custom Input", "Enter numbers separated by commas:\n(e.g. 5,3,9,1)")
            if s:
                try:
                    arr = [int(x.strip()) for x in s.split(',')]
                    self.array = arr
                    self.original_array = list(arr)
                    self.redraw()
                except Exception as e:
                    messagebox.showerror("Error", f"Invalid input: {e}")
        elif self.selected_ds.get() == 'Graph' or self.selected_category.get() == 'Graph':
            n = simpledialog.askinteger("Graph Size", "Number of nodes:", minvalue=2, maxvalue=200)
            if n:
                self.adj = [[] for _ in range(n)]
                # ask for edges line by line
                messagebox.showinfo("Info", "After pressing OK, input edges as pairs 'u v' one per line in the next dialog.\nLeave blank to finish.")
                edges = simpledialog.askstring("Edges", "Enter edges (one per line, 'u v'):")
                if edges:
                    lines = edges.strip().splitlines()
                    for line in lines:
                        parts = line.split()
                        if len(parts) >= 2:
                            u, v = int(parts[0]), int(parts[1])
                            if 0 <= u < n and 0 <= v < n:
                                self.adj[u].append(v)
                                self.adj[v].append(u)
                self.redraw()

    # ---------------------- Control Buttons ----------------------
    def start(self):
        if self.running:
            return
        self.running = True
        self.paused.set()  # not paused
        self._algo_gen = None
        self._algo_thread = threading.Thread(target=self._run_algorithm_thread, daemon=True)
        self._algo_thread.start()

    def pause(self):
        if not self.running:
            return
        self.paused.clear()

    def resume(self):
        if not self.running:
            return
        self.paused.set()

    def step_once(self):
        if not self.running:
            # start a one-step run
            self.running = True
            self.step_mode.set(True)
            self.paused.set()
            self._algo_gen = None
            self._algo_thread = threading.Thread(target=self._run_algorithm_thread, daemon=True)
            self._algo_thread.start()
        else:
            # if running and paused, allow one step
            if not self.paused.is_set():
                self.paused.set()
                # then will re-pause after one action inside the thread

    def reset_state(self):
        # stop running
        self.running = False
        self.paused.set()
        self._algo_gen = None
        # reset data
        if self.original_array:
            self.array = list(self.original_array)
        else:
            self.array = []
            self.adj = None
            self.bst_root = None
        self.redraw()

    def on_close(self):
        self.running = False
        self.destroy()

    # ------------------ Algorithm Thread & Execution ------------------
    def _run_algorithm_thread(self):
        try:
            cat = self.selected_category.get()
            algo_name = self.selected_algo.get()
            algo_entry = ALGORITHM_REGISTRY.get(cat, {}).get(algo_name)
            if not algo_entry:
                messagebox.showerror("Error", "Algorithm not implemented yet.")
                self.running = False
                return
            algo_func = algo_entry[0]

            # prepare generator
            if cat in ('Sorting', 'Searching'):
                if cat == 'Searching' and algo_name == 'Binary Search':
                    # asks target
                    target = simpledialog.askinteger("Binary Search", "Target value:")
                    gen = algo_func(list(self.array), target)
                elif cat == 'Searching' and algo_name == 'Linear Search':
                    target = simpledialog.askinteger("Linear Search", "Target value:")
                    gen = algo_func(list(self.array), target)
                else:
                    gen = algo_func(list(self.array))
            elif cat == 'Graph':
                if not self.adj:
                    # try to build a small random graph
                    self.randomize_data()
                start = 0
                gen = algo_func(self.adj, start)
            elif cat == 'Tree':
                if algo_name.startswith('BST Insert'):
                    key = simpledialog.askinteger("BST Insert", "Key to insert:")
                    gen = algo_func(self.bst_root, key)
                    # naive: we don't keep a persistent BST instance in this demo
                else:
                    gen = algo_func(self.bst_root)
            else:
                gen = algo_func(list(self.array))

            self._algo_gen = gen

            for action in gen:
                # wait if paused
                while not self.paused.is_set():
                    time.sleep(0.05)
                # process action
                self._process_action(action)
                # pause if step_mode
                if self.step_mode.get():
                    # if step_mode, pause after each action until user steps or resumes
                    self.paused.clear()
                # sleep according to speed
                speed = float(self.speed_var.get())
                delay = clamp(0.05 / speed, 0.001, 1.0)
                time.sleep(delay)
                if not self.running:
                    break
            self.running = False
        except Exception as e:
            messagebox.showerror("Error in algorithm thread", str(e))
            self.running = False

    # ------------------ Action Processing & Drawing ------------------
    def _process_action(self, action):
        typ = action[0]
        if typ == 'compare':
            i = action[1]
            j = action[2]
            self._highlight_indices([i, j] if j is not None else [i], color='yellow')
        elif typ == 'swap':
            i, j = action[1], action[2]
            self.array[i], self.array[j] = self.array[j], self.array[i]
            self.redraw(highlight=[i, j])
        elif typ == 'set':
            i, val = action[1], action[2]
            self.array[i] = val
            self.redraw(highlight=[i])
        elif typ == 'highlight':
            i = action[1]
            self._highlight_indices([i], color='orange')
        elif typ == 'found':
            i = action[1]
            self._highlight_indices([i], color='green')
        elif typ == 'not_found':
            messagebox.showinfo('Search', 'Item not found')
        elif typ == 'visit':
            node = action[1]
            self._highlight_graph_node(node, 'green')
        elif typ == 'compare_node':
            u, v = action[1], action[2]
            self._highlight_graph_edge(u, v, 'yellow')
        elif typ == 'bst_insert_root':
            key = action[1]
            self.bst_root = BSTNode(key)
            self.redraw()
        elif typ == 'bst_insert':
            parent_key, side, key = action[1], action[2], action[3]
            # naive: just redraw info (real BST persistence would require node references)
            messagebox.showinfo('BST', f'Inserted {key} as {side} child of {parent_key}')
            self.redraw()
        elif typ == 'bst_visit':
            key = action[1]
            self._show_temp_message(f'Visited {key}')
        elif typ == 'done':
            self._show_temp_message('Done')
            # when done, show final state
            self.redraw()
        else:
            # unknown action
            pass

    def _show_temp_message(self, text, duration=1.2):
        x = 10
        y = 10
        msg = self.canvas.create_text(x, y, anchor='nw', text=text, fill='white', font=('Helvetica', 12, 'bold'))
        self.after(int(duration * 1000), lambda: self.canvas.delete(msg))

    def _highlight_indices(self, indices, color='yellow'):
        self.redraw(highlight=indices, highlight_color=color)

    # ---------------- Drawing helpers ----------------
    def redraw(self, highlight=None, highlight_color='yellow'):
        # choose mode based on data available
        self.canvas.delete('all')
        w = self.canvas.winfo_width()
        h = self.canvas.winfo_height()
        if self.array:
            self._draw_array(self.array, w, h, highlight or [], highlight_color)
        elif self.adj is not None:
            self._draw_graph(self.adj, w, h, highlight or [], highlight_color)
        elif self.bst_root is not None:
            self._draw_bst(self.bst_root, w, h)
        else:
            self.canvas.create_text(w // 2, h // 2, text='No data - click Random Data or Custom Input', fill='white')

    def _draw_array(self, arr, w, h, highlight_indices, highlight_color):
        n = len(arr)
        bw = max(2, int(w / (n * 1.5)))
        gap = max(1, int(bw * 0.2))
        maxv = max(arr) if arr else 1
        for i, val in enumerate(arr):
            x0 = i * (bw + gap) + 5
            x1 = x0 + bw
            hval = int((val / maxv) * (h - 40))
            y0 = h - hval
            y1 = h
            color = highlight_color if i in highlight_indices else '#4fc3f7'
            self.canvas.create_rectangle(x0, y0, x1, y1, fill=color, outline='')
            if bw > 20:
                self.canvas.create_text(x0 + bw / 2, y0 - 8, text=str(val), fill='white', font=('Arial', 8))

    def _draw_graph(self, adj, w, h, highlight=None, highlight_color='yellow'):
        n = len(adj)
        # place nodes in circle
        cx, cy = w // 2, h // 2
        r = int(min(w, h) * 0.38)
        coords = []
        for i in range(n):
            theta = 2 * math.pi * i / n
            x = cx + int(r * math.cos(theta))
            y = cy + int(r * math.sin(theta))
            coords.append((x, y))
        # draw edges
        for u in range(n):
            for v in adj[u]:
                if v <= u:
                    continue
                x0, y0 = coords[u]
                x1, y1 = coords[v]
                self.canvas.create_line(x0, y0, x1, y1, fill='#888')
        # draw nodes
        for i, (x, y) in enumerate(coords):
            fill = 'green' if highlight and i in highlight else '#2196f3'
            self.canvas.create_oval(x - 18, y - 18, x + 18, y + 18, fill=fill)
            self.canvas.create_text(x, y, text=str(i), fill='white')

    def _draw_bst(self, root, w, h):
        nodes = []
        def traverse(node, depth=0, x_min=0, x_max=w):
            if not node:
                return
            x = (x_min + x_max) // 2
            y = 30 + depth * 70
            nodes.append((node.key, x, y, node.left, node.right))
            traverse(node.left, depth + 1, x_min, x)
            traverse(node.right, depth + 1, x, x_max)
        traverse(root)
        # draw edges
        for key, x, y, left, right in nodes:
            if left:
                # find left coords
                for k2, x2, y2, l2, r2 in nodes:
                    if k2 == left.key:
                        self.canvas.create_line(x, y, x2, y2)
                        break
            if right:
                for k2, x2, y2, l2, r2 in nodes:
                    if k2 == right.key:
                        self.canvas.create_line(x, y, x2, y2)
                        break
        # draw nodes
        for key, x, y, left, right in nodes:
            self.canvas.create_oval(x - 18, y - 18, x + 18, y + 18, fill='#ff7043')
            self.canvas.create_text(x, y, text=str(key), fill='white')

    def _highlight_graph_node(self, node, color='green'):
        # draw overlay: simple approach - regenerate with highlight
        self.redraw(highlight=[node], highlight_color=color)

    def _highlight_graph_edge(self, u, v, color='yellow'):
        # for simplicity, flash by drawing line
        w = self.canvas.winfo_width()
        h = self.canvas.winfo_height()
        n = len(self.adj)
        cx, cy = w // 2, h // 2
        r = int(min(w, h) * 0.38)
        coords = []
        for i in range(n):
            theta = 2 * math.pi * i / n
            x = cx + int(r * math.cos(theta))
            y = cy + int(r * math.sin(theta))
            coords.append((x, y))
        x0, y0 = coords[u]
        x1, y1 = coords[v]
        line = self.canvas.create_line(x0, y0, x1, y1, fill=color, width=3)
        self.after(300, lambda: self.canvas.delete(line))


# ----------------------------- Run App ------------------------------------

if __name__ == '__main__':
    app = VisualizerApp()
    app.randomize_data()
    app.mainloop()
