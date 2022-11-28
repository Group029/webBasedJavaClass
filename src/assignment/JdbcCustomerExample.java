package assignment;

import java.util.Collection;

public class JdbcCustomerExample {
	private static void showAllCustomer() {
		IDao<Customer, String> idaoRef = new CustomerDao();
		Collection<Customer> customerList = idaoRef.getAll();
		for(Customer cus : customerList) {
			System.out.println(cus);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showAllCustomer();
	}

}
