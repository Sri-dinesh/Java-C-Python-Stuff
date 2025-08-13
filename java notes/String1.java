
public class String1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Sridinesh");
        // provides 16bytes more size
        System.out.println("String Builder");
        System.out.println(sb.capacity());
        System.out.println(sb.length());

        sb.append(" Random Developer");
        System.out.println(sb);
        sb.insert(2, "Java");
        System.out.println(sb);
        sb.delete(0, 2);
        System.out.println(sb);
        System.out.println("----");
        // sb.reverse();
        System.out.println(sb);
        System.out.println("----");
        sb.charAt(2);
        System.out.println(sb);
        sb.substring(2, 4);
        System.out.println(sb);

        String str = sb.toString();
        System.out.println(str);

        System.out.println("-------------------------------------");
        System.out.println("String Builder");

        StringBuffer sbi = new StringBuffer();
        sb.append("mutable, method chaining, thread safe");

    }

}
