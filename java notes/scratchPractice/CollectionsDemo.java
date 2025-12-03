/*
 **ArrayList Important Methods**

* add(element)
* add(index, element)
* get(index)
* set(index, element)
* remove(index)
* remove(Object)
* size()
* contains(element)
* isEmpty()
* clear()
* indexOf(element)

 **LinkedList Important Methods**

(contains all ArrayList methods plus extra ones specific to LinkedList)

* addFirst(element)
* addLast(element)
* removeFirst()
* removeLast()
* getFirst()
* getLast()
* offer(element)
* poll()
* peek()

Also supports

* add
* get
* set
* remove
* size
* contains
* clear

 **HashSet Important Methods**

* add(element)
* remove(element)
* contains(element)
* size()
* isEmpty()
* clear()
* iterator()

 **TreeSet Important Methods**

* add(element)
* remove(element)
* first()
* last()
* ceiling(element)
* floor(element)
* higher(element)
* lower(element)
* contains(element)
* size()
* clear()
* iterator()

 */

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        System.out.println("\n==== ArrayList Demo ====");
        arrayListDemo();

        System.out.println("\n==== LinkedList Demo ====");
        linkedListDemo();

        System.out.println("\n==== HashSet Demo ====");
        hashSetDemo();

        System.out.println("\n==== TreeSet Demo ====");
        treeSetDemo();
    }

    // -------------------------
    // ArrayList : dynamic array
    // -------------------------
    static void arrayListDemo() {
        ArrayList<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Cherry");
        list.add(1, "Banana");
        System.out.println("After adds: " + list);

        System.out.println("get(2): " + list.get(2));

        list.set(2, "Cranberry");
        System.out.println("After set(2): " + list);

        System.out.println("contains 'Apple' : " + list.contains("Apple"));
        System.out.println("indexOf 'Banana' : " + list.indexOf("Banana"));
        System.out.println("lastIndexOf 'Banana' : " + list.lastIndexOf("Banana"));

        list.remove("Blueberry");
        System.out.println("After removes: " + list);

        System.out.println("size: " + list.size());
        System.out.println("isEmpty: " + list.isEmpty());

        System.out.print("Iterate (Iterator): ");
        Iterator<String> it = list.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();

        Collections.sort(list);
        System.out.println("After sort: " + list);

        list.clear();
    }

    // -----------------------------------
    // LinkedList : list + deque operations
    // -----------------------------------
    static void linkedListDemo() {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(10);
        ll.add(20);
        ll.add(30);

        ll.addFirst(5);
        ll.addLast(40);
        System.out.println("After adds: " + ll);

        System.out.println("getFirst: " + ll.getFirst());
        System.out.println("getLast: " + ll.getLast());

        ll.removeFirst();
        ll.removeLast();
        System.out.println("After removeFirst/removeLast: " + ll);

        ll.offer(50);
        System.out.println("After offer(50): " + ll);
        System.out.println("peek(): " + ll.peek());
        System.out.println("poll(): " + ll.poll());
        System.out.println("After poll: " + ll);

        System.out.println("contains 20: " + ll.contains(20));
        ll.add(1, 15);
        System.out.println("After add(1,15): " + ll);
        ll.remove((Integer) 20);
        System.out.println("After remove(20): " + ll);

        System.out.print("Descending order: ");
        Iterator<Integer> dit = ll.descendingIterator();
        while (dit.hasNext())
            System.out.print(dit.next() + " ");
        System.out.println();

        ll.clear();
        System.out.println("After clear, isEmpty: " + ll.isEmpty());
    }

    // -------------------------
    // HashSet : unordered, unique
    // -------------------------
    static void hashSetDemo() {
        HashSet<String> hs = new HashSet<>();

        hs.add("Red");
        hs.add("Green");
        hs.add("Blue");
        hs.add("Red");
        System.out.println("After adds (duplicates ignored): " + hs);

        System.out.println("contains 'Green': " + hs.contains("Green"));
        hs.remove("Green");
        System.out.println("After remove 'Green': " + hs);

        System.out.println("size: " + hs.size());
        System.out.println("isEmpty: " + hs.isEmpty());

        HashSet<String> other = new HashSet<>(Arrays.asList("Blue", "Yellow", "Black"));
        hs.addAll(other);
        System.out.println("After addAll(other): " + hs);
        System.out.println("containsAll(other): " + hs.containsAll(other));

        hs.removeAll(Collections.singleton("Black"));
        System.out.println("After removeAll('Black'): " + hs);

        hs.retainAll(other);
        System.out.println("After retainAll(other) (intersection): " + hs);

        System.out.print("Iterate HashSet: ");
        for (String s : hs)
            System.out.print(s + " ");
        System.out.println();

        hs.clear();
        System.out.println("After clear, size: " + hs.size());
    }

    // ------------------------------------------
    // TreeSet : ordered set (sorted), navigable set
    // ------------------------------------------
    static void treeSetDemo() {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(50);
        ts.add(10);
        ts.add(30);
        ts.add(20);
        ts.add(40);
        System.out.println("After adds (sorted): " + ts);

        System.out.println("first(): " + ts.first());
        System.out.println("last(): " + ts.last());

        System.out.println("ceiling(25): " + ts.ceiling(25));
        System.out.println("floor(25): " + ts.floor(25));
        System.out.println("higher(30): " + ts.higher(30));
        System.out.println("lower(30): " + ts.lower(30));

        System.out.println("headSet(30): " + ts.headSet(30));
        System.out.println("tailSet(30): " + ts.tailSet(30));

        System.out.println("pollFirst(): " + ts.pollFirst());
        System.out.println("After pollFirst, TreeSet: " + ts);
        System.out.println("pollLast(): " + ts.pollLast());
        System.out.println("After pollLast, TreeSet: " + ts);

        System.out.print("Iterate TreeSet: ");
        for (Integer n : ts)
            System.out.print(n + " ");
        System.out.println();

        ts.clear();
        System.out.println("After clear, isEmpty: " + ts.isEmpty());
    }
}
