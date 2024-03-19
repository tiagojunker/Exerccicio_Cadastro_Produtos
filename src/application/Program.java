package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberOfProducts = sc.nextInt();
		
		
		
		for(int i = 1; i <= numberOfProducts; i++) {
			
			System.out.println("\nEnter Product #" + i + " data: ");
			
			System.out.print("Commom, Used or Imported (c, u, i): ");
			char type = sc.next().charAt(0);

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
		
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(type == 'i') {
				System.out.print("Customs fee: ");
				Double customFee = sc.nextDouble();
				
				products.add(new ImportedProduct(name, price, customFee));
				
			} else if(type == 'u') {
				System.out.print("Manufacture Date (DD/MM/AAAA): ");
				String manufactureDate = sc.next();
				
				products.add(new UsedProduct(name, price, dateFormatter(manufactureDate)));
				
			} else {
				products.add(new Product(name, price));
				
			}			
			
		}
		
		
		System.out.println("\nPRICE TAGS: ");
		for(Product product: products) {
			System.out.println(product.priceTag());
		}
		
				
		sc.close();
	}
	
	public static LocalDate dateFormatter(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, formatter);
	}
	
	

}
