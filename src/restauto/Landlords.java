package restauto;

import java.util.List;

import com.google.gson.Gson;

public class Landlords {
	String address;
	int price;
	int square;
	List<String> features;
	boolean active;

	public Landlords(String addr, int pri, int squ, List<String> fea,
			boolean act) {
		address = addr;
		price = pri;
		square = squ;
		features = fea;
		active = act;

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

	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
