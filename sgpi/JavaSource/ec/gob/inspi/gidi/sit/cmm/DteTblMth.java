package ec.gob.inspi.gidi.sit.cmm;

public class DteTblMth {

	private int IMthCde;
	private String SMthNme;
	private String SMthCde;

	public DteTblMth() {
	}

	public DteTblMth(int IMthCde, String SMthNme, String SMthCde) {
		this.IMthCde = IMthCde;
		this.SMthNme = SMthNme;
		this.SMthCde = SMthCde;
	}

	public int getIMthCde() {
		return IMthCde;
	}

	public void setIMthCde(int iMthCde) {
		IMthCde = iMthCde;
	}

	public String getSMthNme() {
		return SMthNme;
	}

	public void setSMthNme(String sMthNme) {
		SMthNme = sMthNme;
	}

	public String getSMthCde() {
		return SMthCde;
	}

	public void setSMthCde(String sMthCde) {
		SMthCde = sMthCde;
	}

}
