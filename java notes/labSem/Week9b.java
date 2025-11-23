import java.util.*;

public class Week9b {
    public static void main(String[] args) {

        HashSet<String> cities = new HashSet<>();

        cities.add("Los Angeles");
        cities.add("Silicon Valley");
        cities.add("New York City");
        cities.add("Soul Society");
        cities.add("Rome");
        cities.add("Hollow World");
        cities.add("Silicon Valley");

        System.out.println("Just asusual - Priting Some amazing citiess");
        Iterator<String> i = cities.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        cities.remove("Hollow World");
        System.out.println("Trying to print normally using sout (removed Hollow World) city actually ->\n" + cities);

        HashSet<String> places = new HashSet<>();

        places.add("America");
        places.add("Italy");
        places.add("Dubai");
        places.add("Paris");
        places.add("HongKong");

        cities.addAll(places);
        System.out.println();

        System.out.println("Added some new richest places - so the updated list isss !!!");
        System.out.println(cities);
        System.out.println();

        System.out.println(
                "Removed the richest places from the cities list - cause for no reason --> just for fun i guess");
        cities.removeAll(places);

        System.out.println();
        cities.clear();

        System.out.println();

        System.out.println("whoowhooo - removed everything - cause again for no reason");
        System.out.println("So now the HashSet loookalike -->" + cities);

    }
}