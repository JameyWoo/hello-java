package test;

import test_dao.Studentdao;
import test_entity.Student;

public class test {

	
	
	
	
	/**
	 *     注意没有写关闭所有资源的 工具类
	 * @param args
	 */
	public static void main(String[] args) {

		test_addStudent();
		test_query();
		test_change();
		test_del();
	}

	public static void test_del() {
		// TODO Auto-generated method stub
		String id = "6";
		boolean flag = false;
		flag = false;
		flag = Studentdao.delStudentByID(id);

		if (flag) {
			System.out.println("删除成功！！！");
		}
	}

	public static void test_query() {
		// TODO Auto-generated method stub
		String id = "6";
		Student student2 = Studentdao.queryStudentByid(id);
		if (student2.getId() != null) {
			System.out.println(student2);
		}

	}

	public static void test_addStudent() {
		boolean flag = false;
		Student student = new Student("6", "firefly", "computer");
		flag = Studentdao.addStudent(student);
		if (flag) {
			System.out.println("增加成功！！！");
		}
	}

	public static void test_change() {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = false;
		String id = "6";
		Student student1 = new Student("6", "firefly", "computer_science");
		flag = Studentdao.changeStudentMajorByID(id, student1);
		if (flag) {
			System.out.println("修改成功！！！");
		}

	}

}
