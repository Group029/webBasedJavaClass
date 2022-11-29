package assignment;

import java.util.Collection;
import java.util.Scanner;

public class JdbcCustomerExample {
	private static void showAllCustomer() {
		IDao<Customer, String,Integer> idaoRef = new CustomerDao();
		Collection<Customer> customerList = idaoRef.getAll();
		for(Customer cus : customerList) {
			System.out.println(cus);
		}
	}
	private static void findCustomer() {
		IDao<Customer,String,Integer> ref = new CustomerDao();
		String id=null;
		Scanner sc = new Scanner(System.in);
			System.out.print("Enter id to find customer :-");
			 id = sc.nextLine();
		
		Customer searchedCustomer = ref.getOne(id);
		if(searchedCustomer!=null) {
			System.out.print(searchedCustomer);
		}
		else
			System.out.print("Course not found");
	}
	private static void seniorCitizenscustomer(int age) {
		IDao<Customer,String,Integer> ref = new CustomerDao();
		Collection<Customer> customerList = ref.getSpecficCustomer(age);
		if(customerList!=null) {
			for(Customer cus : customerList) {
				System.out.println(cus);
			}
		}
		else
			System.out.print("Customer not found..!!");
	}
	private static void addNewCustomer() {
		IDao<Customer,String,Integer> ref=new CustomerDao();
		System.out.print("\n-----Enter new Customer details------\n");
		Scanner sc = new Scanner(System.in);

			System.out.print("Enter New Customer id :-");
				
				 String id = sc.nextLine();

				System.out.print("Enter Customer Name :- ");
				 String name = sc.nextLine();
				
				System.out.print("Enter Customer Mail :- ");
				String mail= sc.nextLine();
				
				System.out.print("Enter Customer age :- ");
				int age = sc.nextInt();
				
		Customer cus = new Customer(id, name, mail, age);
		ref.create(cus);
		
		
	}
	private static void updateCustomerDetails() {
		IDao<Customer, String, Integer> ref = new CustomerDao();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer id :-");
		String id = sc.nextLine();
		Customer updateCustomer = ref.getOne(id);

		
		System.out.print("Enter Customer name :- ");
			String name = sc.nextLine();
		
		System.out.print("Enter Customer Mail :- ");
			String mail= sc.nextLine();
		
		System.out.print("Enter Customer age :- ");
			int age = sc.nextInt();
		
			updateCustomer.setName(name);
			updateCustomer.setEmail(mail);
			updateCustomer.setAge(age);
		
		ref.upadte(updateCustomer);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		do {

			int i;
			System.out.print("\n1. Create New Customer");
			System.out.print("\n2. Search Customer");
			System.out.print("\n3. Show Senior Citizen Customers");
			System.out.print("\nExit");
			Scanner sc = new Scanner(System.in);
			System.out.print("\n\nEnter your option : ");

				i = sc.nextInt();
			switch(i) {
			case 1:

				addNewCustomer();
				break;
			
			case 2:
					findCustomer();
				break;
			
			case 3:
				System.out.println("Senionr citizens");
				seniorCitizenscustomer(65);
				break;
			case 4:
				showAllCustomer();
				break;
				
			case 5:
				updateCustomerDetails();
				break;
				
			case 6:
				System.out.println("Bye");
				System.exit(0);
				
			}

		}while(true);
		
	}
}

