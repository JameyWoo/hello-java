import java.util.ArrayList;
import java.util.Collection;


public class TestList {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        System.out.println(c.size());
        c.add("姬小野");
        System.out.println(c);
    }

}
