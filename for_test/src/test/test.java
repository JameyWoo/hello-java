package test;

import test_dao.Studentdao;
import test_entity.Student;

public class test {

	
	
	
	
	/**
	 *     ע��û��д�ر�������Դ�� ������
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
			System.out.println("ɾ���ɹ�������");
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
			System.out.println("���ӳɹ�������");
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
			System.out.println("�޸ĳɹ�������");
		}

	}

}
