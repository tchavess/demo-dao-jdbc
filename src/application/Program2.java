package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TESTE 1: Department Insert ==== ");
		Department newDepartment = new Department(null, "NewDep");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! ID: " + newDepartment.getId());

		System.out.println("\n=== TESTE 2: Department UPDATE ==== ");
		Department department = departmentDao.findById(5);
		department.setName("Music");
		departmentDao.update(department);
		System.out.println("UpDate Concluido");

		System.out.println("\n=== TESTE 3: Seller FindById ==== ");
		department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("\n=== TESTE 4: Department Delete ==== ");
		System.out.print("Digite o ID a ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("ID " + id + " deletado com sucesso!");

		System.out.println("\n=== TESTE 5: Seller FindAll ==== ");
		List<Department> list = departmentDao.findAll();
		list = departmentDao.findAll();
		for (Department x : list) {
			System.out.println(x);
		}

		sc.close();
	}

}
