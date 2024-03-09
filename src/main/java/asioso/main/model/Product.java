package asioso.main.model;

import java.util.List;

public class Product {
	
	private int id;
	
	private String name;
	
	private String self_link;
	
	private double price;
	
	private List<Vendor> vendors;
	
	private String image_link;
	
	
	public Product () {
		
	}

	public Product(int id, String name, String self_link, double price, List<Vendor> vendors, String image_link) {
		super();
		this.id = id;
		this.name = name;
		this.self_link = self_link;
		this.price = price;
		this.vendors = vendors;
		this.image_link = image_link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSelf_link() {
		return self_link;
	}

	public void setSelf_link(String self_link) {
		this.self_link = self_link;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

}
