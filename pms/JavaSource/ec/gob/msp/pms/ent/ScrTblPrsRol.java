package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the scr_tbl_prs_rol database table.
 * 
 */
@Entity
@Table(name="scr_tbl_prs_rol")
@NamedQuery(name="ScrTblPrsRol.findAll", query="SELECT s FROM ScrTblPrsRol s")
public class ScrTblPrsRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_prs_rol_id")
	private Integer iPrsRolId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_prs_rol_dte_rgs")
	private Date dPrsRolDteRgs;

	@Column(name="i_rol_id")
	private Integer iRolId;

	@Column(name="i_stt_id")
	private Integer iSttId;

	@Column(name="s_prs_rol_tme_rgs")
	private String sPrsRolTmeRgs;

	//bi-directional many-to-one association to HstTblCntPrsRol
	@OneToMany(mappedBy="scrTblPrsRol")
	private List<HstTblCntPrsRol> hstTblCntPrsRols;

	//bi-directional many-to-one association to PmsTblMnc
	@OneToMany(mappedBy="scrTblPrsRol")
	private List<PmsTblMnc> pmsTblMncs;

	//bi-directional many-to-one association to DpaTblCnt
	@ManyToOne
	@JoinColumn(name="i_ent_pms")
	private DpaTblCnt dpaTblCnt;

	//bi-directional many-to-one association to DtaTblPr
	@ManyToOne
	@JoinColumn(name="i_prs_id")
	private DtaTblPr dtaTblPr;

	public ScrTblPrsRol() {
	}

	public Integer getIPrsRolId() {
		return this.iPrsRolId;
	}

	public void setIPrsRolId(Integer iPrsRolId) {
		this.iPrsRolId = iPrsRolId;
	}

	public Date getDPrsRolDteRgs() {
		return this.dPrsRolDteRgs;
	}

	public void setDPrsRolDteRgs(Date dPrsRolDteRgs) {
		this.dPrsRolDteRgs = dPrsRolDteRgs;
	}

	public Integer getIRolId() {
		return this.iRolId;
	}

	public void setIRolId(Integer iRolId) {
		this.iRolId = iRolId;
	}

	public Integer getISttId() {
		return this.iSttId;
	}

	public void setISttId(Integer iSttId) {
		this.iSttId = iSttId;
	}

	public String getSPrsRolTmeRgs() {
		return this.sPrsRolTmeRgs;
	}

	public void setSPrsRolTmeRgs(String sPrsRolTmeRgs) {
		this.sPrsRolTmeRgs = sPrsRolTmeRgs;
	}

	public List<HstTblCntPrsRol> getHstTblCntPrsRols() {
		return this.hstTblCntPrsRols;
	}

	public void setHstTblCntPrsRols(List<HstTblCntPrsRol> hstTblCntPrsRols) {
		this.hstTblCntPrsRols = hstTblCntPrsRols;
	}

	public HstTblCntPrsRol addHstTblCntPrsRol(HstTblCntPrsRol hstTblCntPrsRol) {
		getHstTblCntPrsRols().add(hstTblCntPrsRol);
		hstTblCntPrsRol.setScrTblPrsRol(this);

		return hstTblCntPrsRol;
	}

	public HstTblCntPrsRol removeHstTblCntPrsRol(HstTblCntPrsRol hstTblCntPrsRol) {
		getHstTblCntPrsRols().remove(hstTblCntPrsRol);
		hstTblCntPrsRol.setScrTblPrsRol(null);

		return hstTblCntPrsRol;
	}

	public List<PmsTblMnc> getPmsTblMncs() {
		return this.pmsTblMncs;
	}

	public void setPmsTblMncs(List<PmsTblMnc> pmsTblMncs) {
		this.pmsTblMncs = pmsTblMncs;
	}

	public PmsTblMnc addPmsTblMnc(PmsTblMnc pmsTblMnc) {
		getPmsTblMncs().add(pmsTblMnc);
		pmsTblMnc.setScrTblPrsRol(this);

		return pmsTblMnc;
	}

	public PmsTblMnc removePmsTblMnc(PmsTblMnc pmsTblMnc) {
		getPmsTblMncs().remove(pmsTblMnc);
		pmsTblMnc.setScrTblPrsRol(null);

		return pmsTblMnc;
	}

	public DpaTblCnt getDpaTblCnt() {
		return this.dpaTblCnt;
	}

	public void setDpaTblCnt(DpaTblCnt dpaTblCnt) {
		this.dpaTblCnt = dpaTblCnt;
	}

	public DtaTblPr getDtaTblPr() {
		return this.dtaTblPr;
	}

	public void setDtaTblPr(DtaTblPr dtaTblPr) {
		this.dtaTblPr = dtaTblPr;
	}

}