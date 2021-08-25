package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the scr_tbl_opt database table.
 * 
 */
@Entity
@Table(name="scr_tbl_opt")
@NamedQuery(name="ScrTblOpt.findAll", query="SELECT s FROM ScrTblOpt s")
public class ScrTblOpt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_opt_cde")
	private Integer iOptCde;

	@Column(name="b_opt_stt")
	private Boolean bOptStt;

	@Temporal(TemporalType.DATE)
	@Column(name="d_opt_dte_rgs")
	private Date dOptDteRgs;

	@Column(name="i_clr_cde")
	private Integer iClrCde;

	@Column(name="i_opt_ctg")
	private Integer iOptCtg;

	@Column(name="i_opt_tpe")
	private Integer iOptTpe;

	@Column(name="i_stt_cde")
	private Integer iSttCde;

	@Column(name="s_opt_acr")
	private String sOptAcr;

	@Column(name="s_opt_dsc")
	private String sOptDsc;

	@Column(name="s_opt_nme")
	private String sOptNme;

	@Column(name="s_opt_tme_rgs")
	private String sOptTmeRgs;

	public ScrTblOpt() {
	}

	public Integer getIOptCde() {
		return this.iOptCde;
	}

	public void setIOptCde(Integer iOptCde) {
		this.iOptCde = iOptCde;
	}

	public Boolean getBOptStt() {
		return this.bOptStt;
	}

	public void setBOptStt(Boolean bOptStt) {
		this.bOptStt = bOptStt;
	}

	public Date getDOptDteRgs() {
		return this.dOptDteRgs;
	}

	public void setDOptDteRgs(Date dOptDteRgs) {
		this.dOptDteRgs = dOptDteRgs;
	}

	public Integer getIClrCde() {
		return this.iClrCde;
	}

	public void setIClrCde(Integer iClrCde) {
		this.iClrCde = iClrCde;
	}

	public Integer getIOptCtg() {
		return this.iOptCtg;
	}

	public void setIOptCtg(Integer iOptCtg) {
		this.iOptCtg = iOptCtg;
	}

	public Integer getIOptTpe() {
		return this.iOptTpe;
	}

	public void setIOptTpe(Integer iOptTpe) {
		this.iOptTpe = iOptTpe;
	}

	public Integer getISttCde() {
		return this.iSttCde;
	}

	public void setISttCde(Integer iSttCde) {
		this.iSttCde = iSttCde;
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

	public String getSOptTmeRgs() {
		return this.sOptTmeRgs;
	}

	public void setSOptTmeRgs(String sOptTmeRgs) {
		this.sOptTmeRgs = sOptTmeRgs;
	}

}