package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==== TESTE 1 seller findById ==== ");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("==== TESTE 2 seller findByDepartment ==== ");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj: list) {
			
			System.out.println(obj);
		}
		
		
		System.out.println("==== TESTE 3 seller findAll ==== ");
		
		list = sellerDao.findAll();
		
		for(Seller obj: list) {
			
			System.out.println(obj);
		}
		
		System.out.println("==== TESTE 4 seller INSERT ==== ");
		Seller newSeller = new Seller(null, "Thalles", "thalles@email.com", new Date(), 3000.00, department);
		sellerDao.insert(newSeller);
		
		System.out.println("==== New Seller " + newSeller.getId());
		
		System.out.println("==== TESTE 5 seller UPDATE ==== ");

		seller = sellerDao.findById(1);
		seller.setName("Leonardo");
		sellerDao.update(seller);
		
		System.out.println("==== Update completed ");
		
		System.out.println("==== TESTE 6 seller DELETE ==== ");
		System.out.println("==== Digite um ID para deleção ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);;
		
		System.out.println("==== deletado com sucesso ");
		
		
	}

}
