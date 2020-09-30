package pojo;

public class Address {
	private String zipcode;

	private String city;

	private String street;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "ClassPojo [zipcode = " + zipcode + ", city = " + city + ", street = " + street + "]";
	}
}