/**
 * @author 姬小野
 * 2019/7/9 下午9:25
 */

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ZenShanGaiCha {
    // 据说这样能读中文?
    static String url = "jdbc:mysql://localhost:3306/studydb?useUnicode=true&characterEncoding=utf8";
    static String user = "root";
    static String password = "fiveplus";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库加载成功");

            con = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功");

            stmt = con.createStatement();

            // 生成(学号, 名字, 专业)的虚拟数据
            List ids = new ArrayList<>();
            List<String> names = new ArrayList<>();
            List<String> majors = new ArrayList<>();
            String[] all_names = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王"};
            String[] all_majors = {"计科", "软件", "信安", "通信"};

            for (int i = 1; i < 10; ++i) {
                ids.add(i * 12345 % 1000);
                names.add(all_names[(11*i + 7) % 8] + all_names[(i*123) % 8] + all_names[(i*111 / 3) % 8]);
                majors.add(all_majors[i*2357 % 4]);
            }
            for (int i = 0; i < ids.size(); ++i) {
                System.out.println(ids.get(i) + ", " + names.get(i) + ", " + majors.get(i));
            }

            String sql;
            ResultSet res;

            // 首先删除数据表的所有行, 权当是做一个初始化
            sql = "delete from student";
            stmt.executeUpdate(sql);

            // 增操作
            // sql = "insert into student values(3, \"名字\", \"major\")"; // 一条测试的语句, 测试中文
            // 用这条语句来设置数据库使用utf-8, 设置一次就好
            // stmt.executeUpdate("set character_set_database=\"utf8\"");
            // int count = stmt.executeUpdate(sql);
            for (int i = 0; i < ids.size(); ++i) {
                sql = "insert into student values(\'" + ids.get(i) + "\', \'"
                        + names.get(i) + "\', \'" + majors.get(i) + "\');";
                System.out.println(sql);
                int count = stmt.executeUpdate(sql);
                System.out.println("插入" + count + "条数据");
            }

            // 删除操作, 删除指定姓的行
            sql = "delete from student where name like \"孙%\""; // 通配符删除孙姓的行
            stmt.executeUpdate(sql);  // 接下来查看数据表的话, 会发现姓孙的行已经没有了

            // 改操作(更新)
            // 我们假设信安合并进入了计科, 下面在数据库中操作. 用即可表示新的计科
            sql = "update student set major = \'即可\' where major = \'信安\'";
            stmt.executeUpdate(sql);

            // 查操作, 查一下id在(100, 500) 以外的行
            sql = "select * from student where not id between 100 and 500";
            res = stmt.executeQuery(sql);
            System.out.println("当前数据库数据:");
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String major = res.getString("major");
                System.out.println("id: " + id + ", name: " + name + ", major: " + major);
            }

            // 统统关闭
            res.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}