package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dta_tbl_prs database table.
 * 
 */
@Entity
@Table(name="dta_tbl_prs")
@NamedQuery(name="DtaTblPr.findAll", query="SELECT d FROM DtaTblPr d")
public class DtaTblPr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_prs_id")
	private Integer iPrsId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_prs_dte_rgs")
	private Date dPrsDteRgs;


	@Column(name="s_prs_eml")
	private String sPrsEml;

	@Column(name="s_prs_lst_nme")
	private String sPrsLstNme;

	@Column(name="s_prs_nme")
	private String sPrsNme;

	@Column(name="s_prs_psw")
	private String sPrsPsw;

	@Column(name="s_prs_tme_rgs")
	private String sPrsTmeRgs;

	@Column(name="s_prs_usr")
	private String sPrsUsr;

	//bi-directional many-to-one association to ScrTblPrsRol
	@OneToMany(mappedBy="dtaTblPr")
	private List<ScrTblPrsRol> scrTblPrsRols;

	public DtaTblPr() {
	}

	public Integer getIPrsId() {
		return this.iPrsId;
	}

	public void setIPrsId(Integer iPrsId) {
		this.iPrsId = iPrsId;
	}

	public Date getDPrsDteRgs() {
		return this.dPrsDteRgs;
	}

	public void setDPrsDteRgs(Date dPrsDteRgs) {
		this.dPrsDteRgs = dPrsDteRgs;
	}

	public String getSPrsEml() {
		return this.sPrsEml;
	}

	public void setSPrsEml(String sPrsEml) {
		this.sPrsEml = sPrsEml;
	}

	public String getSPrsLstNme() {
		return this.sPrsLstNme;
	}

	public void setSPrsLstNme(String sPrsLstNme) {
		this.sPrsLstNme = sPrsLstNme;
	}

	public String getSPrsNme() {
		return this.sPrsNme;
	}

	public void setSPrsNme(String sPrsNme) {
		this.sPrsNme = sPrsNme;
	}

	public String getSPrsPsw() {
		return this.sPrsPsw;
	}

	public void setSPrsPsw(String sPrsPsw) {
		this.sPrsPsw = sPrsPsw;
	}

	public String getSPrsTmeRgs() {
		return this.sPrsTmeRgs;
	}

	public void setSPrsTmeRgs(String sPrsTmeRgs) {
		this.sPrsTmeRgs = sPrsTmeRgs;
	}

	public String getSPrsUsr() {
		return this.sPrsUsr;
	}

	public void setSPrsUsr(String sPrsUsr) {
		this.sPrsUsr = sPrsUsr;
	}

	public List<ScrTblPrsRol> getScrTblPrsRols() {
		return this.scrTblPrsRols;
	}

	public void setScrTblPrsRols(List<ScrTblPrsRol> scrTblPrsRols) {
		this.scrTblPrsRols = scrTblPrsRols;
	}

	public ScrTblPrsRol addScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		getScrTblPrsRols().add(scrTblPrsRol);
		scrTblPrsRol.setDtaTblPr(this);

		return scrTblPrsRol;
	}

	public ScrTblPrsRol removeScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		getScrTblPrsRols().remove(scrTblPrsRol);
		scrTblPrsRol.setDtaTblPr(null);

		return scrTblPrsRol;
	}

}