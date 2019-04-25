package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TESTE 1: Seller FindById ==== ");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: Seller FindByDepartment ==== ");
		Department department = new Department(2 ,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== TESTE 3: Seller FindByAll ==== ");
		
		list = sellerDao.findAll();
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== TESTE 4: Seller Insert ==== ");
		Seller newSeller = new Seller(null , "Greg", "greg@gmail.com", new Date(), 4000.00, department );
		sellerDao.insert(newSeller);
		System.out.println("Inserido! ID: " + newSeller.getId());
	}

}
