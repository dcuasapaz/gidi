package ec.gob.msp.pms.cmm;

public class PMS {
	private String nme = "Herramienta informática de análisis: Municipios Saludables";
	private String lnk = "http://app.episig.inspi.gob.ec/pms/";
	private String eml = "app.pms.msp@gmail.com";
	private String psw = "Msp!*20Pms";

	private String sbjRgsPrf = "Profesional registrado correctamente ";
	private String toEml = "MSP-PMS";

	public PMS() {

	}

	public String getNme() {
		return nme;
	}

	public String getLnk() {
		return lnk;
	}

	public String getEml() {
		return eml;
	}

	public String getPsw() {
		return psw;
	}

	public String getSbjRgsPrf() {
		return sbjRgsPrf;
	}

	public String getToEml() {
		return toEml;
	}

}
