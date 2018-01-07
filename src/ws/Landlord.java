package ws;

public class Landlord {
	String firstName;
	String lastName;
	boolean trusted;

	public Landlord(String fn, String ln, boolean trus) {
		firstName = fn;
		lastName = ln;
		trusted = trus;

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

}
