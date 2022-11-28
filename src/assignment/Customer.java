package assignment;

public class Customer {
	private String CustomerId;
	private String name;
	private String email;
	private int age;
	
	public Customer(String customerId, String name, String email, int age) {
		super();
		CustomerId = customerId;
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public Customer() {
	
	}

	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}
	
}




