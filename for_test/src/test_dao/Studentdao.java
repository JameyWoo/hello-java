package test_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test_entity.Student;

public class Studentdao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://207.148.112.5:3306/person?useUnicode=true&characterEncoding=utf8&useSSL=false";
	static final String USER = "root";
	static final String PASS = "123456";

	public static boolean addStudent(Student student) { // 增加
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(JDBC_DRIVER); // 加载类
			conn = DriverManager.getConnection(DB_URL, USER, PASS);// 连接
			String sql = "insert into student values(?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, student.getId());
			ps.setObject(2, student.getName());
			ps.setObject(3, student.getMajor());
			int flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error!!");
		}
		return false;
	}

	public static boolean delStudentByID(String id) { // 删除
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(JDBC_DRIVER); // 加载类
			conn = DriverManager.getConnection(DB_URL, USER, PASS);// 连接
			String sql = "delete from student where id = ?;";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			int flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error!!");
		}
		return false;
	}

	public static boolean changeStudentMajorByID(String id, Student student) { // 改
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(JDBC_DRIVER); // 加载类
			conn = DriverManager.getConnection(DB_URL, USER, PASS);// 连接
			String sql = "update student set major = ? where id = ?;";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, student.getMajor());
			ps.setObject(2, id);
			int flag = ps.executeUpdate();
			if (flag > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("error!!");
		}
		return false;
	}

	public static Student queryStudentByid(String id) { // 查
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER); // 加载类
			conn = DriverManager.getConnection(DB_URL, USER, PASS);// 连接
			String sql = "select * from student where id = ?;";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			String[] temp = new String[3];
			while (rs.next()) {
				temp[0] = rs.getString(1);
				temp[1] = rs.getString(2);
				temp[2] = rs.getString(3);
			}
			Student student = new Student(temp[0], temp[1], temp[2]);
			return student;
		} catch (Exception e) {
			System.out.println("error!!");
		}
		return null;
	}

}
