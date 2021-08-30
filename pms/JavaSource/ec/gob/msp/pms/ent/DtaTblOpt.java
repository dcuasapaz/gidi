package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dta_tbl_opt database table.
 * 
 */
@Entity
@Table(name="dta_tbl_opt")
@NamedQuery(name="DtaTblOpt.findAll", query="SELECT d FROM DtaTblOpt d")
public class DtaTblOpt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_opt_id")
	private Integer iOptId;

	@Column(name="b_opt_stt")
	private Boolean bOptStt;

	@Column(name="i_opt_ctg")
	private Integer iOptCtg;

	@Column(name="i_opt_tpe")
	private Integer iOptTpe;

	@Column(name="s_opt_acr")
	private String sOptAcr;

	@Column(name="s_opt_dsc")
	private String sOptDsc;

	@Column(name="s_opt_nme")
	private String sOptNme;

	public DtaTblOpt() {
	}

	public Integer getIOptId() {
		return this.iOptId;
	}

	public void setIOptId(Integer iOptId) {
		this.iOptId = iOptId;
	}

	public Boolean getBOptStt() {
		return this.bOptStt;
	}

	public void setBOptStt(Boolean bOptStt) {
		this.bOptStt = bOptStt;
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

}