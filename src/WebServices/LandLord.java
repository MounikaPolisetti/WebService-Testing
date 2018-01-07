package WebServices;

import java.util.List;

public class LandLord {

	String id;
	String firstName;
	String lastName;
	boolean trusted;
	Apartments apartments;

	public LandLord(String fn, String ln,boolean trus, Apartments apt) {
		//this.id = id;
		firstName = fn;
		lastName = ln;
		trusted = trus;
		apartments = apt;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isTrusted() {
		return trusted;
	}

	public void setTrusted(boolean trusted) {
		this.trusted = trusted;
	}

	public Apartments getApartments() {
		return apartments;
	}

	public void setApartments(Apartments apartments) {
		this.apartments = apartments;
	}

}

class Apartments {
	String id;
	String address;
	int price;
	int square;
	List<String> features;
	boolean active;

	public Apartments(String addr, int pri, int squ,
			List<String> fea, boolean act) {
		//this.id = id;
		address = addr;
		price = pri;
		square = squ;
		features = fea;
		active = act;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
