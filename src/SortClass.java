import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortClass implements Comparable<SortClass>{
    String name; // 知识点: 添加static结果name都是王五(最后一个), 共享变量?
    int age;
    public SortClass (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(SortClass sortClass) { // String可直接调用此方法进行比较大小
        boolean comp = this.age > sortClass.age;
        return comp ? -1 : 1; // 从大到小排序.
//        return this.age - sortClass.age; // 可以直接相减, 从小到大
        // boolean不可以直接转化为int. 0 代表相等
    }

    public String toString() { // 打印类的输出
        return this.name + ":" + age;
    }

    public static void main(String [] args) {
        SortClass [] one_man = new SortClass[3];
        one_man[0] = new SortClass("张三", 35);
        one_man[1] = new SortClass("李四", 14);
        one_man[2] = new SortClass("王五", 20);

        for (SortClass each: one_man) {
            System.out.print(each + "; ");
        }
        System.out.println();

        List<SortClass> pre_sorted = new ArrayList<SortClass>(3);

        for (SortClass each: one_man) {
            pre_sorted.add(each);
        }

        Collections.sort(pre_sorted); // 使用Collections工具进行排序

//        for (SortClass each: pre_sorted) {
//            System.out.println(each);
//        }
        System.out.println(pre_sorted); // 直接输出list
    }
}
