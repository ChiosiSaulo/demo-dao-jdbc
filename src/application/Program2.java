package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: department findById ===");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dep = departmentDao.findById(6);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n=== TEST 4: department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Cars");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department deleteById ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted");
		
		sc.close();


	}

}
