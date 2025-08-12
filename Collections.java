
import java.util.*;

public class Collections {

    public static void main(String[] args) {

        System.out.println("ARRAYLIST");
        ArrayList<String> StudentsName = new ArrayList<>();

        StudentsName.add("Sridinesh");
        StudentsName.add("Eremika");
        StudentsName.add("Shunsui");

        System.out.println("LIST");
        // List<Integer> list = new ArrayList<>();
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(StudentsName);
        System.out.println(list);
        list.add(3, 20);
        // list.addAll(list);
        System.out.println(list);

        System.out.println(list.get(2));

        System.out.println(list.remove(3));
        System.out.println(list);

        list.remove(Integer.valueOf(6));
        System.out.println(list);

        // list.clear();
        // System.out.println(list);
        // O(n) -> Time Complexity
        list.set(1, 1000);
        System.out.println(list);

        System.out.println(list.contains(1000));

        System.out.println("for");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("for each");

        for (Integer element : list) {
            System.out.println(element);
        }

        System.out.println("ITERATOR");
        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("STACK");
        Stack<String> st = new Stack<>();

        st.push("Eremika");
        st.push("Mikasa");
        st.push("Tatakae");
        st.push("Eren Yeager");

        System.out.println(st);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st);

        System.out.println("LINKEDLIST");

        System.out.println("QUEUE");
        Queue<Integer> queue = new LinkedList<>();

        // adding elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue);

        // removing elements from the queue
        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue.remove());
        System.out.println(queue);

        System.out.println("PRIORITY QUEUE");
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // maxHeap
        // Queue<Integer> pq = new PriorityQueue<>(); --> minHeap

        // under-the-hood -> getting min.heap() applied, works with offer() only, not
        // with add() !!
        pq.offer(90);
        pq.offer(70);
        pq.offer(80);
        pq.offer(60);

        System.out.println(pq);

        System.out.println(pq.poll());
        System.out.println(pq);

        System.out.println(pq.peek());
        System.out.println(pq);

        System.out.println("ARRAY DEQUE");
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        ad.offer(50);
        ad.offerFirst(80);
        ad.offerLast(100);
        ad.offer(40);

        System.out.println(ad);

        System.out.println(ad.peek());
        System.out.println(ad.peekFirst());
        System.out.println(ad.peekLast());
        System.out.println(ad);

        System.out.println(ad.poll());
        System.out.println(ad);
        System.out.println(ad.pollFirst());
        System.out.println(ad.pollLast());
        System.out.println(ad);

    }
}
