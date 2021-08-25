package ec.gob.inspi.gidi.sit.cmm;

public class Person {

	private String lst_nme;
	private String nme;
	private String apn;
	private String unt;
	private String ent;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String lst_nme, String nme) {
		this.lst_nme = lst_nme;
		this.nme = nme;
	}

	public String getLst_nme() {
		return lst_nme;
	}

	public void setLst_nme(String lst_nme) {
		this.lst_nme = lst_nme;
	}

	public String getNme() {
		return nme;
	}

	public void setNme(String nme) {
		this.nme = nme;
	}

	public String getApn() {
		return apn;
	}

	public void setApn(String apn) {
		this.apn = apn;
	}

	public String getUnt() {
		return unt;
	}

	public void setUnt(String unt) {
		this.unt = unt;
	}

	public String getEnt() {
		return ent;
	}

	public void setEnt(String ent) {
		this.ent = ent;
	}

}
