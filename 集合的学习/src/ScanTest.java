import java.util.*;

public class ScanTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String test = scan.next();
        System.out.println(test);
        if (scan.hasNext()) {
            test = scan.next();
            System.out.println(test);
        }
    }
}
