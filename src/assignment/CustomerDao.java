package assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import assignment.JdbcUtils;

@SuppressWarnings("unused")
public class CustomerDao implements IDao<Customer, String, Integer> {

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
		Customer foundCustomer = null;
		String sqlQuery="select customerId, name, email, age from customer where customerId=?";
		
		try(Connection con = JdbcUtils.obtainConnection();
				PreparedStatement pstmt = con.prepareStatement(sqlQuery)){
			pstmt.setString(1, key);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String customer1Id = rs.getString(1);
				String name = rs.getString(2);
				String email =rs.getString(3);
				int age = rs.getInt(4);
				foundCustomer = new Customer(customer1Id,name,email,age); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundCustomer;
	}

	@Override
	public void create(Customer newCustomer) {
		String sqlQuery = "insert into customer values(?,?,?,?)";
		try(Connection conn = JdbcUtils.obtainConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
				){
	
			String id = newCustomer.getCustomerId();
			String name = newCustomer.getName();
			String email = newCustomer.getEmail();
			int age = newCustomer.getAge();
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setInt(4, age);
			
			int updatecount = pstmt.executeUpdate();
			if(updatecount != 0) {
				System.out.print("Inserted Record : "+updatecount);
			}
			} 
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

	@Override
	public Collection<Customer> getSpecficCustomer(Integer age) {
		// TODO Auto-generated method stub
		Collection<Customer> allCustomers =new ArrayList<>();
		Customer foundCustomer = null;
		String sqlQuery=
				"select customerId, name, email, age from customer where age >= ?";
		
		try(Connection conn = JdbcUtils.obtainConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
			pstmt.setInt(1, age);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String customer1Id = rs.getString(1);
				String name = rs.getString(2);
				String email =rs.getString(3);
				int age1 = rs.getInt(4);
				foundCustomer = new Customer(customer1Id, name, email, age1); 
				allCustomers.add(foundCustomer);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCustomers;
	}

	@Override
	public void upadte(Customer alterCustomer) {
		String sqlQuery ="update customer set name = ?, email = ?, age = ? where customerId=?";
		try(Connection conn = JdbcUtils.obtainConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
			String id = alterCustomer.getCustomerId();
			String name = alterCustomer.getName();
			String email = alterCustomer.getEmail();
			int age = alterCustomer.getAge();
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3,age);
			pstmt.setString(4,id);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println("Record updated count: "+updateCount);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
