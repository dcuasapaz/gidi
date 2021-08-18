package ec.gob.inspi.gidi.sit.cmm;

public class Colour {

	private int id;
	private String name;

	public Colour() {
		// TODO Auto-generated constructor stub
	}

	public Colour(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String red() {
		return "FF0000";
	}

	public String yellow() {
		return "FFFF00";
	}

	public String green() {
		return "00FF00";
	}

	public String grey() {
		return "969696";
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
	
	
}
