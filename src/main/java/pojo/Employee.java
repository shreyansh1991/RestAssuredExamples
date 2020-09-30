package pojo;

public class Employee {
	private String id;
	private String name;
	private String permanent;
	private Address address;
	private String[] phoneNumbers;

	private String role;

	private String[] cities;

	private Properties properties;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}

	public String getPermanent() {
		return permanent;
	}

	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "ClassPojo [address = " + address + ", role = " + role + ", cities = " + cities + ", permanent = "
				+ permanent + ", name = " + name + ", id = " + id + ", phoneNumbers = " + phoneNumbers
				+ ", properties = " + properties + "]";
	}
}
