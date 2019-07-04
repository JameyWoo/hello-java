/**
 * @author 姬小野
 * @data 2019/7/3 下午7:10
 */
import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException { // 捕获异常, 不然报错
        /**
         * 函数测试
         */
        File f = new File("./files/testFile.txt");
        System.out.println(f); // 文件的路径
        System.out.println(System.getProperty("user.dir")); // 项目目录

        File f2 = new File("./files/create.txt");
        f2.createNewFile();
    }
}
