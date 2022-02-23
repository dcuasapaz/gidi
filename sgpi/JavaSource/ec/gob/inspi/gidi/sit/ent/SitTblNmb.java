package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sit_tbl_nmb database table.
 * 
 */
@Entity
@Table(name = "sit_tbl_nmb")
@NamedQuery(name = "SitTblNmb.findAll", query = "SELECT s FROM SitTblNmb s")
public class SitTblNmb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_nmb_id")
	private Integer iNmbId;

	@Column(name = "r_nmb_x")
	private double rNmbX;

	@Column(name = "r_nmb_y")
	private double rNmbY;

	@Column(name = "s_nmb_trap")
	private String sNmbTrap;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_nmb_rgs_dte")
	private Date dNmbRgsDte;

	@Column(name = "s_nmb_rgs_tme")
	private String sNmbRgsTme;

	@Column(name = "b_nmb_stt")
	private Boolean bNmbStt;

	@ManyToOne
	@JoinColumn(name = "i_nmb_rgs_prs_rol_id")
	private ScrTblPrsRol scrTblPrsRol;

	// bi-directional many-to-one association to SitTblGnr
	@OneToMany(mappedBy = "sitTblNmb")
	private List<SitTblGnr> sitTblGnrs;

	// bi-directional many-to-one association to SitTblSte
	@ManyToOne
	@JoinColumn(name = "i_ste_id")
	private SitTblSte sitTblSte;

	public SitTblNmb() {
	}

	public Integer getINmbId() {
		return this.iNmbId;
	}

	public void setINmbId(Integer iNmbId) {
		this.iNmbId = iNmbId;
	}

	public double getRNmbX() {
		return this.rNmbX;
	}

	public void setRNmbX(double rNmbX) {
		this.rNmbX = rNmbX;
	}

	public double getRNmbY() {
		return this.rNmbY;
	}

	public void setRNmbY(double rNmbY) {
		this.rNmbY = rNmbY;
	}

	public String getSNmbTrap() {
		return this.sNmbTrap;
	}

	public void setSNmbTrap(String sNmbTrap) {
		this.sNmbTrap = sNmbTrap;
	}

	public List<SitTblGnr> getSitTblGnrs() {
		return this.sitTblGnrs;
	}

	public void setSitTblGnrs(List<SitTblGnr> sitTblGnrs) {
		this.sitTblGnrs = sitTblGnrs;
	}

	public SitTblGnr addSitTblGnr(SitTblGnr sitTblGnr) {
		getSitTblGnrs().add(sitTblGnr);
		sitTblGnr.setSitTblNmb(this);

		return sitTblGnr;
	}

	public SitTblGnr removeSitTblGnr(SitTblGnr sitTblGnr) {
		getSitTblGnrs().remove(sitTblGnr);
		sitTblGnr.setSitTblNmb(null);

		return sitTblGnr;
	}

	public SitTblSte getSitTblSte() {
		return this.sitTblSte;
	}

	public void setSitTblSte(SitTblSte sitTblSte) {
		this.sitTblSte = sitTblSte;
	}

	public Date getdNmbRgsDte() {
		return dNmbRgsDte;
	}

	public void setdNmbRgsDte(Date dNmbRgsDte) {
		this.dNmbRgsDte = dNmbRgsDte;
	}

	public String getsNmbRgsTme() {
		return sNmbRgsTme;
	}

	public void setsNmbRgsTme(String sNmbRgsTme) {
		this.sNmbRgsTme = sNmbRgsTme;
	}

	public Boolean getbNmbStt() {
		return bNmbStt;
	}

	public void setbNmbStt(Boolean bNmbStt) {
		this.bNmbStt = bNmbStt;
	}

	public ScrTblPrsRol getScrTblPrsRol() {
		return scrTblPrsRol;
	}

	public void setScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		this.scrTblPrsRol = scrTblPrsRol;
	}

}