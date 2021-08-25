package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dpa_tbl_cnr database table.
 * 
 */
@Entity
@Table(name="dpa_tbl_cnr")
@NamedQuery(name="DpaTblCnr.findAll", query="SELECT d FROM DpaTblCnr d")
public class DpaTblCnr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_cnr_id")
	private Integer iCnrId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_cnr_dte_rgs")
	private Date dCnrDteRgs;

	@Column(name="s_cnr_acr")
	private String sCnrAcr;

	@Column(name="s_cnr_acr_thr")
	private String sCnrAcrThr;

	@Column(name="s_cnr_acr_two")
	private String sCnrAcrTwo;

	@Column(name="s_cnr_cde_phn")
	private String sCnrCdePhn;

	@Column(name="s_cnr_nme_eng")
	private String sCnrNmeEng;

	@Column(name="s_cnr_nme_fra")
	private String sCnrNmeFra;

	@Column(name="s_cnr_nme_spn")
	private String sCnrNmeSpn;

	@Column(name="s_cnr_prf")
	private String sCnrPrf;

	@Column(name="s_cnr_tme_rgs")
	private String sCnrTmeRgs;

	//bi-directional many-to-one association to DtaTblPr
	@OneToMany(mappedBy="dpaTblCnr")
	private List<DtaTblPr> dtaTblPrs;

	public DpaTblCnr() {
	}

	public Integer getICnrId() {
		return this.iCnrId;
	}

	public void setICnrId(Integer iCnrId) {
		this.iCnrId = iCnrId;
	}

	public Date getDCnrDteRgs() {
		return this.dCnrDteRgs;
	}

	public void setDCnrDteRgs(Date dCnrDteRgs) {
		this.dCnrDteRgs = dCnrDteRgs;
	}

	public String getSCnrAcr() {
		return this.sCnrAcr;
	}

	public void setSCnrAcr(String sCnrAcr) {
		this.sCnrAcr = sCnrAcr;
	}

	public String getSCnrAcrThr() {
		return this.sCnrAcrThr;
	}

	public void setSCnrAcrThr(String sCnrAcrThr) {
		this.sCnrAcrThr = sCnrAcrThr;
	}

	public String getSCnrAcrTwo() {
		return this.sCnrAcrTwo;
	}

	public void setSCnrAcrTwo(String sCnrAcrTwo) {
		this.sCnrAcrTwo = sCnrAcrTwo;
	}

	public String getSCnrCdePhn() {
		return this.sCnrCdePhn;
	}

	public void setSCnrCdePhn(String sCnrCdePhn) {
		this.sCnrCdePhn = sCnrCdePhn;
	}

	public String getSCnrNmeEng() {
		return this.sCnrNmeEng;
	}

	public void setSCnrNmeEng(String sCnrNmeEng) {
		this.sCnrNmeEng = sCnrNmeEng;
	}

	public String getSCnrNmeFra() {
		return this.sCnrNmeFra;
	}

	public void setSCnrNmeFra(String sCnrNmeFra) {
		this.sCnrNmeFra = sCnrNmeFra;
	}

	public String getSCnrNmeSpn() {
		return this.sCnrNmeSpn;
	}

	public void setSCnrNmeSpn(String sCnrNmeSpn) {
		this.sCnrNmeSpn = sCnrNmeSpn;
	}

	public String getSCnrPrf() {
		return this.sCnrPrf;
	}

	public void setSCnrPrf(String sCnrPrf) {
		this.sCnrPrf = sCnrPrf;
	}

	public String getSCnrTmeRgs() {
		return this.sCnrTmeRgs;
	}

	public void setSCnrTmeRgs(String sCnrTmeRgs) {
		this.sCnrTmeRgs = sCnrTmeRgs;
	}

	public List<DtaTblPr> getDtaTblPrs() {
		return this.dtaTblPrs;
	}

	public void setDtaTblPrs(List<DtaTblPr> dtaTblPrs) {
		this.dtaTblPrs = dtaTblPrs;
	}

	public DtaTblPr addDtaTblPr(DtaTblPr dtaTblPr) {
		getDtaTblPrs().add(dtaTblPr);
		dtaTblPr.setDpaTblCnr(this);

		return dtaTblPr;
	}

	public DtaTblPr removeDtaTblPr(DtaTblPr dtaTblPr) {
		getDtaTblPrs().remove(dtaTblPr);
		dtaTblPr.setDpaTblCnr(null);

		return dtaTblPr;
	}

}