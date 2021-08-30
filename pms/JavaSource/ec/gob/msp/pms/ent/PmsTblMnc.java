package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pms_tbl_mnc database table.
 * 
 */
@Entity
@Table(name="pms_tbl_mnc")
@NamedQuery(name="PmsTblMnc.findAll", query="SELECT p FROM PmsTblMnc p")
public class PmsTblMnc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_mnc_id")
	private Integer iMncId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_mnc_dte_rgs")
	private Date dMncDteRgs;

	@Column(name="i_crt_day")
	private Integer iCrtDay;

	@Column(name="i_crt_day_src")
	private Integer iCrtDaySrc;

	@Column(name="i_crt_dte_tpe")
	private Integer iCrtDteTpe;

	@Column(name="i_crt_mth")
	private Integer iCrtMth;

	@Column(name="i_crt_mth_src")
	private Integer iCrtMthSrc;

	@Column(name="i_crt_yr")
	private Integer iCrtYr;

	@Column(name="i_crt_yr_src")
	private Integer iCrtYrSrc;

	@Column(name="i_stt_id")
	private Integer iSttId;

	@Column(name="r_crt_nmb")
	private double rCrtNmb;

	@Column(name="s_crt_obs")
	private String sCrtObs;

	@Column(name="s_crt_prf")
	private String sCrtPrf;

	@Column(name="s_crt_src")
	private String sCrtSrc;

	@Column(name="s_mnc_fle")
	private String sMncFle;

	@Column(name="s_mnc_tme_rgs")
	private String sMncTmeRgs;

	//bi-directional many-to-one association to DpaTblCnt
	@ManyToOne
	@JoinColumn(name="i_cnt_cde")
	private DpaTblCnt dpaTblCnt;

	//bi-directional many-to-one association to IndTblMain
	@ManyToOne
	@JoinColumn(name="i_lv3_id")
	private IndTblMain indTblMain;

	//bi-directional many-to-one association to ScrTblPrsRol
	@ManyToOne
	@JoinColumn(name="i_prs_rol_id")
	private ScrTblPrsRol scrTblPrsRol;

	//bi-directional many-to-one association to VrfTblInsMnc
	@OneToMany(mappedBy="pmsTblMnc")
	private List<VrfTblInsMnc> vrfTblInsMncs;

	public PmsTblMnc() {
	}

	public Integer getIMncId() {
		return this.iMncId;
	}

	public void setIMncId(Integer iMncId) {
		this.iMncId = iMncId;
	}

	public Date getDMncDteRgs() {
		return this.dMncDteRgs;
	}

	public void setDMncDteRgs(Date dMncDteRgs) {
		this.dMncDteRgs = dMncDteRgs;
	}

	public Integer getICrtDay() {
		return this.iCrtDay;
	}

	public void setICrtDay(Integer iCrtDay) {
		this.iCrtDay = iCrtDay;
	}

	public Integer getICrtDaySrc() {
		return this.iCrtDaySrc;
	}

	public void setICrtDaySrc(Integer iCrtDaySrc) {
		this.iCrtDaySrc = iCrtDaySrc;
	}

	public Integer getICrtDteTpe() {
		return this.iCrtDteTpe;
	}

	public void setICrtDteTpe(Integer iCrtDteTpe) {
		this.iCrtDteTpe = iCrtDteTpe;
	}

	public Integer getICrtMth() {
		return this.iCrtMth;
	}

	public void setICrtMth(Integer iCrtMth) {
		this.iCrtMth = iCrtMth;
	}

	public Integer getICrtMthSrc() {
		return this.iCrtMthSrc;
	}

	public void setICrtMthSrc(Integer iCrtMthSrc) {
		this.iCrtMthSrc = iCrtMthSrc;
	}

	public Integer getICrtYr() {
		return this.iCrtYr;
	}

	public void setICrtYr(Integer iCrtYr) {
		this.iCrtYr = iCrtYr;
	}

	public Integer getICrtYrSrc() {
		return this.iCrtYrSrc;
	}

	public void setICrtYrSrc(Integer iCrtYrSrc) {
		this.iCrtYrSrc = iCrtYrSrc;
	}

	public Integer getISttId() {
		return this.iSttId;
	}

	public void setISttId(Integer iSttId) {
		this.iSttId = iSttId;
	}

	public double getRCrtNmb() {
		return this.rCrtNmb;
	}

	public void setRCrtNmb(double rCrtNmb) {
		this.rCrtNmb = rCrtNmb;
	}

	public String getSCrtObs() {
		return this.sCrtObs;
	}

	public void setSCrtObs(String sCrtObs) {
		this.sCrtObs = sCrtObs;
	}

	public String getSCrtPrf() {
		return this.sCrtPrf;
	}

	public void setSCrtPrf(String sCrtPrf) {
		this.sCrtPrf = sCrtPrf;
	}

	public String getSCrtSrc() {
		return this.sCrtSrc;
	}

	public void setSCrtSrc(String sCrtSrc) {
		this.sCrtSrc = sCrtSrc;
	}

	public String getSMncFle() {
		return this.sMncFle;
	}

	public void setSMncFle(String sMncFle) {
		this.sMncFle = sMncFle;
	}

	public String getSMncTmeRgs() {
		return this.sMncTmeRgs;
	}

	public void setSMncTmeRgs(String sMncTmeRgs) {
		this.sMncTmeRgs = sMncTmeRgs;
	}

	public DpaTblCnt getDpaTblCnt() {
		return this.dpaTblCnt;
	}

	public void setDpaTblCnt(DpaTblCnt dpaTblCnt) {
		this.dpaTblCnt = dpaTblCnt;
	}

	public IndTblMain getIndTblMain() {
		return this.indTblMain;
	}

	public void setIndTblMain(IndTblMain indTblMain) {
		this.indTblMain = indTblMain;
	}

	public ScrTblPrsRol getScrTblPrsRol() {
		return this.scrTblPrsRol;
	}

	public void setScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		this.scrTblPrsRol = scrTblPrsRol;
	}

	public List<VrfTblInsMnc> getVrfTblInsMncs() {
		return this.vrfTblInsMncs;
	}

	public void setVrfTblInsMncs(List<VrfTblInsMnc> vrfTblInsMncs) {
		this.vrfTblInsMncs = vrfTblInsMncs;
	}

	public VrfTblInsMnc addVrfTblInsMnc(VrfTblInsMnc vrfTblInsMnc) {
		getVrfTblInsMncs().add(vrfTblInsMnc);
		vrfTblInsMnc.setPmsTblMnc(this);

		return vrfTblInsMnc;
	}

	public VrfTblInsMnc removeVrfTblInsMnc(VrfTblInsMnc vrfTblInsMnc) {
		getVrfTblInsMncs().remove(vrfTblInsMnc);
		vrfTblInsMnc.setPmsTblMnc(null);

		return vrfTblInsMnc;
	}

}