package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dpa_tbl_opt database table.
 * 
 */
@Entity
@Table(name="dpa_tbl_opt")
@NamedQuery(name="DpaTblOpt.findAll", query="SELECT d FROM DpaTblOpt d")
public class DpaTblOpt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_opt_id")
	private Integer iOptId;

	@Column(name="i_opt_cde")
	private Integer iOptCde;

	@Column(name="i_opt_tpe")
	private Integer iOptTpe;

	@Column(name="s_opt_acr")
	private String sOptAcr;

	@Column(name="s_opt_dsc")
	private String sOptDsc;

	@Column(name="s_opt_nme")
	private String sOptNme;

	public DpaTblOpt() {
	}

	public Integer getIOptId() {
		return this.iOptId;
	}

	public void setIOptId(Integer iOptId) {
		this.iOptId = iOptId;
	}

	public Integer getIOptCde() {
		return this.iOptCde;
	}

	public void setIOptCde(Integer iOptCde) {
		this.iOptCde = iOptCde;
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