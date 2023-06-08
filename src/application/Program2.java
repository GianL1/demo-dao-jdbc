package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==== TESTE 1 department findById ==== ");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = departmentDao.findById(3);
		System.out.println(department);
	
		System.out.println("==== TESTE 2 department findAll ==== ");
		List<Department> list = departmentDao.findAll();
		
		for(Department obj: list) {
			
			System.out.println(obj);
		}
		
		System.out.println("==== TESTE 3 DEPARTMENT INSERT ==== ");
		Department newDepartment = new Department(null, "Comida Animal");
		departmentDao.insert(newDepartment);
		
		System.out.println("==== New Seller " + newDepartment.getId());
		
		System.out.println("==== TESTE 4 seller UPDATE ==== ");

		department = departmentDao.findById(1);
		department.setName("Tablets");
		departmentDao.update(department);
		
		System.out.println("==== Update completed ");
		
		System.out.println("==== TESTE 5 seller DELETE ==== ");
		System.out.println("==== Digite um ID para deleção ");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);;
		
		System.out.println("==== deletado com sucesso ");

	}

}
