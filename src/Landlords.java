import com.google.gson.Gson;

public class Landlords {

	String firstName;
	String lastName;
	boolean trusted;
	Apartments apartments;

	public Landlords(String fn, String ln, boolean trus, Apartments apt) {

		firstName = fn;
		lastName = ln;
		trusted = trus;
		apartments = apt;
	}

	public Apartments getApts() {
		return apartments;
	}

	public void setApts(Apartments apts) {
		this.apartments = apts;
	}

	public boolean isTrusted() {
		return trusted;
	}

	public void setTrusted(boolean trusted) {
		this.trusted = trusted;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

class Apartments {
	String id;
	String address;
	int price;
	int square;

	public Apartments(String id, String add, int pri, int sqr) {
		this.id = id;
		address = add;
		price = pri;
		square = sqr;
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

}
