package Programs;
import java.util.*;

public class HashDemo {
  public static void main(String[] args) {

    HashSet<String> hsd = new HashSet<>();

    hsd.add("Mumbai");
    hsd.add("Hyderabad");
    hsd.add("Pune");
    hsd.add("Bangalore");
    hsd.add("Bangalore");
    hsd.add("Rajasthan");

    System.out.println(hsd);

    System.out.println("\nUsing Iterator");
    Iterator<String> i = hsd.iterator();

    while (i.hasNext()) {
      System.out.println(i.next());
    }

    System.out.println("\nAfter Removing Element - Pune");
    hsd.remove("Pune");

    System.out.println(hsd);

    HashSet<String> s2 = new HashSet<>();

    s2.add("Delhi");
    s2.add("Dubai");

    System.out.println("\n" + s2);

    hsd.addAll(s2);

    System.out.println("\n" + hsd);

    hsd.clear();
    System.out.println("After Clearing all Elements");

  }
}
