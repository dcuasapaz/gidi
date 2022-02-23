package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sit_tbl_gnr database table.
 * 
 */
@Entity
@Table(name = "sit_tbl_gnr")
@NamedQuery(name = "SitTblGnr.findAll", query = "SELECT s FROM SitTblGnr s")
public class SitTblGnr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_gnr_id")
	private Integer iGnrId;

	@Column(name = "b_gnr_adl")
	private Boolean bGnrAdl;

	@Column(name = "b_gnr_egs")
	private Boolean bGnrEgs;

	@Column(name = "b_gnr_lrs")
	private Boolean bGnrLrs;

	@Column(name = "b_gnr_trp_rcv")
	private Boolean bGnrTrpRcv;

	@Column(name = "b_gnr_trp_sup")
	private Boolean bGnrTrpSup;

	@Column(name = "b_gnr_stt")
	private Boolean BGnrStt;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_gnr_dte_rgs")
	private Date dGnrDteRgs;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_gnr_dte_set")
	private Date dGnrDteSet;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_gnr_dte_clc")
	private Date dGnrDteClc;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_gnr_rgs_dte")
	private Date dGnrRgsDte;

	@Column(name = "i_gnr_nmb_egs_brk")
	private Integer iGnrNmbEgsBrk;

	@Column(name = "i_gnr_nmb_egs_cpl")
	private Integer iGnrNmbEgsCpl;

	@Column(name = "i_gnr_nmb_egs_usd")
	private Integer iGnrNmbEgsUsd;

	@Column(name = "i_gnr_nmb_egs_vlb")
	private Integer iGnrNmbEgsVlb;

	@Column(name = "i_gnr_nmb_egs_vlb_no")
	private Integer iGnrNmbEgsVlbNo;

	@Column(name = "i_trp_id")
	private Integer iTrpId;

	@Column(name = "i_tpe_id")
	private Integer ITpeId;

	@Column(name = "s_gnr_obs")
	private String sGnrObs;

	@Column(name = "s_gnr_obs_adl")
	private String sGnrObsAdl;

	@Column(name = "s_gnr_obs_egs")
	private String sGnrObsEgs;

	@Column(name = "s_gnr_obs_lrv")
	private String sGnrObsLrv;

	@Column(name = "s_gnr_tme_rgs")
	private String sGnrTmeRgs;

	// bi-directional many-to-one association to ScrTblPrsRol
	@ManyToOne
	@JoinColumn(name = "i_prs_prf_id")
	private ScrTblPrsRol scrTblPrsRol;

	// bi-directional many-to-one association to SitTblNmb
	@ManyToOne
	@JoinColumn(name = "i_nmb_id")
	private SitTblNmb sitTblNmb;

	// bi-directional many-to-one association to SitTblGnrDtl
	@OneToMany(mappedBy = "sitTblGnr")
	private List<SitTblGnrDtl> sitTblGnrDtls;

	// bi-directional many-to-one association to SitTblGnrPrsPrf
	@OneToMany(mappedBy = "sitTblGnr")
	private List<SitTblGnrPrsPrf> sitTblGnrPrsPrfs;

	public SitTblGnr() {
	}

	public Integer getIGnrId() {
		return this.iGnrId;
	}

	public void setIGnrId(Integer iGnrId) {
		this.iGnrId = iGnrId;
	}

	public Boolean getBGnrAdl() {
		return this.bGnrAdl;
	}

	public void setBGnrAdl(Boolean bGnrAdl) {
		this.bGnrAdl = bGnrAdl;
	}

	public Boolean getBGnrEgs() {
		return this.bGnrEgs;
	}

	public void setBGnrEgs(Boolean bGnrEgs) {
		this.bGnrEgs = bGnrEgs;
	}

	public Boolean getBGnrLrs() {
		return this.bGnrLrs;
	}

	public void setBGnrLrs(Boolean bGnrLrs) {
		this.bGnrLrs = bGnrLrs;
	}

	public Boolean getBGnrTrpRcv() {
		return this.bGnrTrpRcv;
	}

	public void setBGnrTrpRcv(Boolean bGnrTrpRcv) {
		this.bGnrTrpRcv = bGnrTrpRcv;
	}

	public Boolean getBGnrTrpSup() {
		return this.bGnrTrpSup;
	}

	public void setBGnrTrpSup(Boolean bGnrTrpSup) {
		this.bGnrTrpSup = bGnrTrpSup;
	}

	public Date getDGnrDteRgs() {
		return this.dGnrDteRgs;
	}

	public void setDGnrDteRgs(Date dGnrDteRgs) {
		this.dGnrDteRgs = dGnrDteRgs;
	}

	public Integer getIGnrNmbEgsBrk() {
		return this.iGnrNmbEgsBrk;
	}

	public void setIGnrNmbEgsBrk(Integer iGnrNmbEgsBrk) {
		this.iGnrNmbEgsBrk = iGnrNmbEgsBrk;
	}

	public Integer getIGnrNmbEgsCpl() {
		return this.iGnrNmbEgsCpl;
	}

	public void setIGnrNmbEgsCpl(Integer iGnrNmbEgsCpl) {
		this.iGnrNmbEgsCpl = iGnrNmbEgsCpl;
	}

	public Integer getIGnrNmbEgsUsd() {
		return this.iGnrNmbEgsUsd;
	}

	public void setIGnrNmbEgsUsd(Integer iGnrNmbEgsUsd) {
		this.iGnrNmbEgsUsd = iGnrNmbEgsUsd;
	}

	public Integer getIGnrNmbEgsVlb() {
		return this.iGnrNmbEgsVlb;
	}

	public void setIGnrNmbEgsVlb(Integer iGnrNmbEgsVlb) {
		this.iGnrNmbEgsVlb = iGnrNmbEgsVlb;
	}

	public Integer getITrpId() {
		return this.iTrpId;
	}

	public void setITrpId(Integer iTrpId) {
		this.iTrpId = iTrpId;
	}

	public String getSGnrObs() {
		return this.sGnrObs;
	}

	public void setSGnrObs(String sGnrObs) {
		this.sGnrObs = sGnrObs;
	}

	public String getSGnrObsAdl() {
		return this.sGnrObsAdl;
	}

	public void setSGnrObsAdl(String sGnrObsAdl) {
		this.sGnrObsAdl = sGnrObsAdl;
	}

	public String getSGnrObsEgs() {
		return this.sGnrObsEgs;
	}

	public void setSGnrObsEgs(String sGnrObsEgs) {
		this.sGnrObsEgs = sGnrObsEgs;
	}

	public String getSGnrObsLrv() {
		return this.sGnrObsLrv;
	}

	public void setSGnrObsLrv(String sGnrObsLrv) {
		this.sGnrObsLrv = sGnrObsLrv;
	}

	public String getSGnrTmeRgs() {
		return this.sGnrTmeRgs;
	}

	public void setSGnrTmeRgs(String sGnrTmeRgs) {
		this.sGnrTmeRgs = sGnrTmeRgs;
	}

	public ScrTblPrsRol getScrTblPrsRol() {
		return this.scrTblPrsRol;
	}

	public void setScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		this.scrTblPrsRol = scrTblPrsRol;
	}

	public SitTblNmb getSitTblNmb() {
		return this.sitTblNmb;
	}

	public void setSitTblNmb(SitTblNmb sitTblNmb) {
		this.sitTblNmb = sitTblNmb;
	}

	public List<SitTblGnrDtl> getSitTblGnrDtls() {
		return this.sitTblGnrDtls;
	}

	public void setSitTblGnrDtls(List<SitTblGnrDtl> sitTblGnrDtls) {
		this.sitTblGnrDtls = sitTblGnrDtls;
	}

	public SitTblGnrDtl addSitTblGnrDtl(SitTblGnrDtl sitTblGnrDtl) {
		getSitTblGnrDtls().add(sitTblGnrDtl);
		sitTblGnrDtl.setSitTblGnr(this);

		return sitTblGnrDtl;
	}

	public SitTblGnrDtl removeSitTblGnrDtl(SitTblGnrDtl sitTblGnrDtl) {
		getSitTblGnrDtls().remove(sitTblGnrDtl);
		sitTblGnrDtl.setSitTblGnr(null);

		return sitTblGnrDtl;
	}

	public List<SitTblGnrPrsPrf> getSitTblGnrPrsPrfs() {
		return this.sitTblGnrPrsPrfs;
	}

	public void setSitTblGnrPrsPrfs(List<SitTblGnrPrsPrf> sitTblGnrPrsPrfs) {
		this.sitTblGnrPrsPrfs = sitTblGnrPrsPrfs;
	}

	public SitTblGnrPrsPrf addSitTblGnrPrsPrf(SitTblGnrPrsPrf sitTblGnrPrsPrf) {
		getSitTblGnrPrsPrfs().add(sitTblGnrPrsPrf);
		sitTblGnrPrsPrf.setSitTblGnr(this);

		return sitTblGnrPrsPrf;
	}

	public SitTblGnrPrsPrf removeSitTblGnrPrsPrf(SitTblGnrPrsPrf sitTblGnrPrsPrf) {
		getSitTblGnrPrsPrfs().remove(sitTblGnrPrsPrf);
		sitTblGnrPrsPrf.setSitTblGnr(null);

		return sitTblGnrPrsPrf;
	}

	public Integer getITpeId() {
		return ITpeId;
	}

	public void setITpeId(Integer iTpeId) {
		ITpeId = iTpeId;
	}

	public Boolean getBGnrStt() {
		return BGnrStt;
	}

	public void setBGnrStt(Boolean bGnrStt) {
		BGnrStt = bGnrStt;
	}

	public Date getdGnrDteSet() {
		return dGnrDteSet;
	}

	public void setdGnrDteSet(Date dGnrDteSet) {
		this.dGnrDteSet = dGnrDteSet;
	}

	public Date getdGnrDteClc() {
		return dGnrDteClc;
	}

	public void setdGnrDteClc(Date dGnrDteClc) {
		this.dGnrDteClc = dGnrDteClc;
	}

	public Integer getiGnrNmbEgsVlbNo() {
		return iGnrNmbEgsVlbNo;
	}

	public void setiGnrNmbEgsVlbNo(Integer iGnrNmbEgsVlbNo) {
		this.iGnrNmbEgsVlbNo = iGnrNmbEgsVlbNo;
	}

	public Date getdGnrRgsDte() {
		return dGnrRgsDte;
	}

	public void setdGnrRgsDte(Date dGnrRgsDte) {
		this.dGnrRgsDte = dGnrRgsDte;
	}

}