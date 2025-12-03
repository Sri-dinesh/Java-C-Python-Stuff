public class StringBufferBuilder {
    public static void main(String[] args) {

        System.out.println("String Buffer Operations.");
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Creation: " + sb);
        sb.append(" Java");
        System.out.println("Append: " + sb);
        sb.insert(5, " World");
        System.out.println("Insert: " + sb);
        sb.delete(6, 11);
        System.out.println("Delete: " + sb);
        sb.reverse();
        System.out.println("Reverse: " + sb);
        System.out.println(sb.length());

        System.out.println("******************************************************");
        System.out.println("String Builder Operations.");
        StringBuilder sbd = new StringBuilder("Programming");
        System.out.println("Creation: " + sbd);
        sbd.append(" Language");
        System.out.println("Append: " + sbd);
        sbd.insert(0, "Java ");
        System.out.println("Insert: " + sbd);
        sbd.delete(5, 16);
        System.out.println("Delete: " + sbd);
        sbd.reverse();
        System.out.println("Reverse: " + sbd);
        System.out.println(sbd.length());
    }
}

/*
 * insert(index, index) | delete(index, index) | append(value)
 * delete(index,index) | length();
 * 
 * 1. Thread safety
 * StringBuffer is synchronized - thread safe.
 * StringBuilder is not synchronized - not thread safe.
 * 
 * 2. Speed
 * StringBuffer is slower because synchronization adds extra processing.
 * StringBuilder is faster because it has no synchronization overhead.
 * 
 * 3. Usage
 * StringBuffer is used in multithreaded programs.
 * StringBuilder is used in single threaded programs for better performance.
 */