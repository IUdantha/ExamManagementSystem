package use.user;

public class User {
	private int id;
	private String name;
	private String NIC;
	private String phone;
	private String email;
	private String username;
	private String password;
	private String userType;
	
	public User(int id, String name, String NIC, String phone, String email, String username, String password, String userType) {
		
		this.id = id;
		this.name = name;
		this.NIC = NIC;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public String getNIC() {
		return NIC;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getuserType() {
		return userType;
	}

}

