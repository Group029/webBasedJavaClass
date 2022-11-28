package assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class CustomerDao implements IDao<Customer, String> {

	@Override
	public Collection<Customer> getAll() {
		// TODO Auto-generated method stub
		Collection<Customer> allCustomers =new ArrayList<>();
		String sqlQuery = "select customerId, name, email, age from customer";
		try (Connection conn= JdbcUtils.obtainConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)){
			while(rs.next()) {
				String customerId = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int age = rs.getInt(4);
				
				Customer cus = new Customer(customerId, name, email, age);
				allCustomers.add(cus);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allCustomers;
	}

	@Override
	public Customer getOne(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Customer t) {
		// TODO Auto-generated method stub
		
	}

}
