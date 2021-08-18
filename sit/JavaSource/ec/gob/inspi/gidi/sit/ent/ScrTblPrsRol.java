package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the scr_tbl_prs_rol database table.
 * 
 */
@Entity
@Table(name = "scr_tbl_prs_rol")
@NamedQuery(name = "ScrTblPrsRol.findAll", query = "SELECT s FROM ScrTblPrsRol s")
public class ScrTblPrsRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_prs_rol_id")
	private Integer iPrsRolId;

	@Column(name = "b_prs_rol_stt")
	private Boolean bPrsRolStt;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_prs_rol_dte_rgs")
	private Date dPrsRolDteRgs;

	@Column(name = "i_rol_id")
	private Integer iRolId;

	@Column(name = "i_stt_id")
	private Integer iSttId;
	@Column(name = "i_prj_id")
	private Integer IPrjId;
	@Column(name = "s_prs_rol_tme_rgs")
	private String sPrsRolTmeRgs;

	// bi-directional many-to-one association to DtaTblPr
	@ManyToOne
	@JoinColumn(name = "i_prs_id")
	private DtaTblPr dtaTblPr;

	// bi-directional many-to-one association to SitTblGnr
	@OneToMany(mappedBy = "scrTblPrsRol")
	private List<SitTblGnr> sitTblGnrs;

	// bi-directional many-to-one association to SitTblGnrPrsPrf
	@OneToMany(mappedBy = "scrTblPrsRol")
	private List<SitTblGnrPrsPrf> sitTblGnrPrsPrfs;

	public ScrTblPrsRol() {
	}

	public Integer getIPrsRolId() {
		return this.iPrsRolId;
	}

	public void setIPrsRolId(Integer iPrsRolId) {
		this.iPrsRolId = iPrsRolId;
	}

	public Boolean getBPrsRolStt() {
		return this.bPrsRolStt;
	}

	public void setBPrsRolStt(Boolean bPrsRolStt) {
		this.bPrsRolStt = bPrsRolStt;
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

	public DtaTblPr getDtaTblPr() {
		return this.dtaTblPr;
	}

	public void setDtaTblPr(DtaTblPr dtaTblPr) {
		this.dtaTblPr = dtaTblPr;
	}

	public List<SitTblGnr> getSitTblGnrs() {
		return this.sitTblGnrs;
	}

	public void setSitTblGnrs(List<SitTblGnr> sitTblGnrs) {
		this.sitTblGnrs = sitTblGnrs;
	}

	public SitTblGnr addSitTblGnr(SitTblGnr sitTblGnr) {
		getSitTblGnrs().add(sitTblGnr);
		sitTblGnr.setScrTblPrsRol(this);

		return sitTblGnr;
	}

	public SitTblGnr removeSitTblGnr(SitTblGnr sitTblGnr) {
		getSitTblGnrs().remove(sitTblGnr);
		sitTblGnr.setScrTblPrsRol(null);

		return sitTblGnr;
	}

	public List<SitTblGnrPrsPrf> getSitTblGnrPrsPrfs() {
		return this.sitTblGnrPrsPrfs;
	}

	public void setSitTblGnrPrsPrfs(List<SitTblGnrPrsPrf> sitTblGnrPrsPrfs) {
		this.sitTblGnrPrsPrfs = sitTblGnrPrsPrfs;
	}

	public SitTblGnrPrsPrf addSitTblGnrPrsPrf(SitTblGnrPrsPrf sitTblGnrPrsPrf) {
		getSitTblGnrPrsPrfs().add(sitTblGnrPrsPrf);
		sitTblGnrPrsPrf.setScrTblPrsRol(this);

		return sitTblGnrPrsPrf;
	}

	public SitTblGnrPrsPrf removeSitTblGnrPrsPrf(SitTblGnrPrsPrf sitTblGnrPrsPrf) {
		getSitTblGnrPrsPrfs().remove(sitTblGnrPrsPrf);
		sitTblGnrPrsPrf.setScrTblPrsRol(null);

		return sitTblGnrPrsPrf;
	}

	public Integer getIPrjId() {
		return IPrjId;
	}

	public void setIPrjId(Integer iPrjId) {
		IPrjId = iPrjId;
	}

}