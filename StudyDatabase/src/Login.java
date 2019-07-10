/**
 * @author 姬小野
 * 2019/7/9 下午8:54
 */
import sun.rmi.runtime.Log;

import java.sql.*;

public class Login {

    Connection con; // 一个连接对象
    String driver = "com.mysql.cj.jdbc.Driver"; // 驱动
    String url = "jdbc:mysql://localhost:3306/studydb"; // mysql的url

    // 连接的用户名与密码
    String user = "root";
    String password = "fiveplus";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            System.out.println("数据库加载成功!");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库没有加载成功!");
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("数据库链接成功");
        } catch (SQLException e) {
            System.out.println("数据库没有链接成功!");
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {

        Login login = new Login();
        Connection con = login.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql;

            sql = "select * from table_1;";

            ResultSet results = stmt.executeQuery(sql);
            while (results.next()) {
                String name = results.getString("name");
                int age = results.getInt("age");
                String url = results.getString("url");

                System.out.println("name: " + name);
                System.out.println("age: " + age);
                System.out.println("url: " + url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
