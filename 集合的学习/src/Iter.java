import java.util.*;

/**
 * @author 姬小野
 * @desc: 增删遍历索引的测试
 */

public class Iter {
    public static void main(String[] args) {
        List<String> list_str = new ArrayList<String>();
        list_str.add("name");
        list_str.add("year");
        list_str.add("family");
        System.out.println(list_str);
        // for each遍历方法
        for (String each: list_str) {
            System.out.println(each);
        }
        // 第二种, 把List变成Array的方法
        String[] list_array = new String[list_str.size()];
        list_str.toArray(list_array);
        for (int i = 0; i < list_array.length; ++i) {
            System.out.println(list_array[i]);
        }

        // 第三种, 迭代器方法
        Iterator<String> it = list_str.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ' ');
        }
    }
}
