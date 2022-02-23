package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the sit_tbl_opt database table.
 * 
 */
@Entity
@Table(name="sit_tbl_opt")
@NamedQuery(name="SitTblOpt.findAll", query="SELECT s FROM SitTblOpt s")
public class SitTblOpt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_opt_id")
	private Integer iOptId;

	@Column(name="i_opt_fth")
	private Integer iOptFth;

	@Column(name="s_opt_acr")
	private String sOptAcr;

	@Column(name="s_opt_dsc")
	private String sOptDsc;

	@Column(name="s_opt_nme")
	private String sOptNme;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_opt_rgs_dte")
	private Date dOptRgsDte;
	
	@Column(name="s_opt_rgs_tme")
	private String sOptRgsTme;
	
	@Column(name="b_opt_stt")
	private Boolean bOptStt;
	
	@ManyToOne
	@JoinColumn(name = "i_opt_rgs_prs_rol_id")
	private ScrTblPrsRol scrTblPrsRol;
	
	@Column(name="i_opt_ctg")
	private Integer iOptCtg;

	public SitTblOpt() {
	}

	public Integer getIOptId() {
		return this.iOptId;
	}

	public void setIOptId(Integer iOptId) {
		this.iOptId = iOptId;
	}

	public Integer getIOptFth() {
		return this.iOptFth;
	}

	public void setIOptFth(Integer iOptFth) {
		this.iOptFth = iOptFth;
	}

	public String getSOptAcr() {
		return this.sOptAcr;
	}

	public void setSOptAcr(String sOptAcr) {
		this.sOptAcr = sOptAcr;
	}

	public String getSOptDsc() {
		return this.sOptDsc;
	}

	public void setSOptDsc(String sOptDsc) {
		this.sOptDsc = sOptDsc;
	}

	public String getSOptNme() {
		return this.sOptNme;
	}

	public void setSOptNme(String sOptNme) {
		this.sOptNme = sOptNme;
	}

	public Date getdOptRgsDte() {
		return dOptRgsDte;
	}

	public void setdOptRgsDte(Date dOptRgsDte) {
		this.dOptRgsDte = dOptRgsDte;
	}

	public String getsOptRgsTme() {
		return sOptRgsTme;
	}

	public void setsOptRgsTme(String sOptRgsTme) {
		this.sOptRgsTme = sOptRgsTme;
	}

	public Boolean getbOptStt() {
		return bOptStt;
	}

	public void setbOptStt(Boolean bOptStt) {
		this.bOptStt = bOptStt;
	}

	public ScrTblPrsRol getScrTblPrsRol() {
		return scrTblPrsRol;
	}

	public void setScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		this.scrTblPrsRol = scrTblPrsRol;
	}

	public Integer getiOptCtg() {
		return iOptCtg;
	}

	public void setiOptCtg(Integer iOptCtg) {
		this.iOptCtg = iOptCtg;
	}

}