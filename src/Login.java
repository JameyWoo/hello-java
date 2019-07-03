import java.sql.*;     //导入java.sql包
public class Login {//创建Login类，保证文件名与类名相同
    //声明Connection对象
    Connection con;
    String driver = "com.mysql.cj.jdbc.Driver";

    //URL指向要访问的数据库名studydb
    String url = "jdbc:mysql://localhost:3306/studydb";

    //MySQL配置时的用户名
    String user = "root";

    //MySQL配置时的密码
    String password = "fiveplus";

    public Connection getConnection() {  //建立返回值为Connection的方法
        try {        //加载数据库驱动类
            Class.forName(driver);
            System.out.println("数据库驱动加载成功");
        } catch(ClassNotFoundException e){
            System.out.println("数据库驱动没有加载成功");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, password);//通过访问数据库的URL获取数据库连接对象
            System.out.println("数据库连接成功");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;//按方法要求返回一个Connection对象
    }
    public static void main(String[] args) {   //主方法
        Login c = new Login();    //创建本类方法
        c.getConnection();//调用连接数据库的方法
    }
}