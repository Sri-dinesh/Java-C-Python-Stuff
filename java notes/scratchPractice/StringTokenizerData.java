import java.util.Date;
import java.util.StringTokenizer;

public class StringTokenizerData {
    public static void main(String[] args) {

        System.out.println("*********String Tokeinzer*********");

        String data = "Java,Python,C,Cplusplus";
        System.out.println("String is: " + data);

        StringTokenizer st = new StringTokenizer(data, ",");

        System.out.println("Tokens are");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println();

        System.out.println("*********Date Class*********");

        Date today = new Date();
        System.out.println("Current date and time");
        System.out.println(today);

        System.out.println("Hours " + today.getHours());
        System.out.println("Minutes " + today.getMinutes());
        System.out.println("Seconds " + today.getSeconds());
    }
}
