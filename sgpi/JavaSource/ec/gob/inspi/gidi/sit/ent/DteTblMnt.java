package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dte_tbl_mnt database table.
 * 
 */
@Entity
@Table(name="dte_tbl_mnt")
@NamedQuery(name="DteTblMnt.findAll", query="SELECT d FROM DteTblMnt d")
public class DteTblMnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_mnt_cde")
	private Integer iMntCde;

	@Column(name="s_mnt_alm")
	private String sMntAlm;

	@Column(name="s_mnt_cde")
	private String sMntCde;

	@Column(name="s_mnt_eng")
	private String sMntEng;

	@Column(name="s_mnt_fra")
	private String sMntFra;

	@Column(name="s_mnt_itl")
	private String sMntItl;

	@Column(name="s_mnt_ptg")
	private String sMntPtg;

	@Column(name="s_mnt_qch")
	private String sMntQch;

	@Column(name="s_mnt_spn")
	private String sMntSpn;

	public DteTblMnt() {
	}

	public Integer getIMntCde() {
		return this.iMntCde;
	}

	public void setIMntCde(Integer iMntCde) {
		this.iMntCde = iMntCde;
	}

	public String getSMntAlm() {
		return this.sMntAlm;
	}

	public void setSMntAlm(String sMntAlm) {
		this.sMntAlm = sMntAlm;
	}

	public String getSMntCde() {
		return this.sMntCde;
	}

	public void setSMntCde(String sMntCde) {
		this.sMntCde = sMntCde;
	}

	public String getSMntEng() {
		return this.sMntEng;
	}

	public void setSMntEng(String sMntEng) {
		this.sMntEng = sMntEng;
	}

	public String getSMntFra() {
		return this.sMntFra;
	}

	public void setSMntFra(String sMntFra) {
		this.sMntFra = sMntFra;
	}

	public String getSMntItl() {
		return this.sMntItl;
	}

	public void setSMntItl(String sMntItl) {
		this.sMntItl = sMntItl;
	}

	public String getSMntPtg() {
		return this.sMntPtg;
	}

	public void setSMntPtg(String sMntPtg) {
		this.sMntPtg = sMntPtg;
	}

	public String getSMntQch() {
		return this.sMntQch;
	}

	public void setSMntQch(String sMntQch) {
		this.sMntQch = sMntQch;
	}

	public String getSMntSpn() {
		return this.sMntSpn;
	}

	public void setSMntSpn(String sMntSpn) {
		this.sMntSpn = sMntSpn;
	}

}