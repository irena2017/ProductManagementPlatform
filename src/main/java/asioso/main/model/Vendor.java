package asioso.main.model;

public class Vendor {
	
	private int id;
	
	private String name;
	
	private String self_link;
	
	public Vendor () {
		
	}

	public Vendor(String name, String self_link) {
		super();
		this.name = name;
		this.self_link = self_link;
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
	
	

}
