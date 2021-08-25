package ec.gob.inspi.gidi.sit.ent;

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

	@Column(name="i_gnd_cde")
	private Integer iGndCde;

	@Column(name="i_grt_id")
	private Integer iGrtId;

	@Column(name="i_idn_id")
	private Integer iIdnId;

	@Column(name="s_prs_eml")
	private String sPrsEml;

	@Column(name="s_prs_idn")
	private String sPrsIdn;

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

	//bi-directional many-to-one association to DpaTblCnr
	@ManyToOne
	@JoinColumn(name="i_cnr_id")
	private DpaTblCnr dpaTblCnr;

	//bi-directional many-to-one association to DtaTblPrsApn
	@OneToMany(mappedBy="dtaTblPr")
	private List<DtaTblPrsApn> dtaTblPrsApns;

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

	public Integer getIGndCde() {
		return this.iGndCde;
	}

	public void setIGndCde(Integer iGndCde) {
		this.iGndCde = iGndCde;
	}

	public Integer getIGrtId() {
		return this.iGrtId;
	}

	public void setIGrtId(Integer iGrtId) {
		this.iGrtId = iGrtId;
	}

	public Integer getIIdnId() {
		return this.iIdnId;
	}

	public void setIIdnId(Integer iIdnId) {
		this.iIdnId = iIdnId;
	}

	public String getSPrsEml() {
		return this.sPrsEml;
	}

	public void setSPrsEml(String sPrsEml) {
		this.sPrsEml = sPrsEml;
	}

	public String getSPrsIdn() {
		return this.sPrsIdn;
	}

	public void setSPrsIdn(String sPrsIdn) {
		this.sPrsIdn = sPrsIdn;
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

	public DpaTblCnr getDpaTblCnr() {
		return this.dpaTblCnr;
	}

	public void setDpaTblCnr(DpaTblCnr dpaTblCnr) {
		this.dpaTblCnr = dpaTblCnr;
	}

	public List<DtaTblPrsApn> getDtaTblPrsApns() {
		return this.dtaTblPrsApns;
	}

	public void setDtaTblPrsApns(List<DtaTblPrsApn> dtaTblPrsApns) {
		this.dtaTblPrsApns = dtaTblPrsApns;
	}

	public DtaTblPrsApn addDtaTblPrsApn(DtaTblPrsApn dtaTblPrsApn) {
		getDtaTblPrsApns().add(dtaTblPrsApn);
		dtaTblPrsApn.setDtaTblPr(this);

		return dtaTblPrsApn;
	}

	public DtaTblPrsApn removeDtaTblPrsApn(DtaTblPrsApn dtaTblPrsApn) {
		getDtaTblPrsApns().remove(dtaTblPrsApn);
		dtaTblPrsApn.setDtaTblPr(null);

		return dtaTblPrsApn;
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