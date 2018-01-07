package ws;

import java.util.List;

import com.google.gson.Gson;

public class Apartment {
	String id;
	String address;
	int price;
	int square;
	List<String> features;
	boolean active;

	public Apartment(String id, String adr, int pri, int sq, List<String> fea,
			boolean act) {
		this.id = id;
		address = adr;
		price = pri;
		square = sq;
		features = fea;
		active = act;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}