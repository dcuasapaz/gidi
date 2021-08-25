package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
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

}