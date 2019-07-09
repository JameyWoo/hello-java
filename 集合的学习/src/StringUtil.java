import java.util.Scanner;

public class StringUtil {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine(); // 输入一行
        System.out.print(a.replace(" ", ""));
        String b = in.next(); // 普通的输入
        System.out.println(b);
        while (in.hasNext()) { // while (cin >> s). 同时会读取之前的输入
            String tmp = in.next();
            System.out.println(tmp);
        }
    }
}