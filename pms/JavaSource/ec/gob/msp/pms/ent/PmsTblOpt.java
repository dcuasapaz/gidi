package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the pms_tbl_opt database table.
 * 
 */
@Entity
@Table(name = "pms_tbl_opt")
@NamedQuery(name = "PmsTblOpt.findAll", query = "SELECT p FROM PmsTblOpt p")
public class PmsTblOpt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_opt_id")
	private Integer iOptId;

	@Column(name = "i_opt_crt")
	private Integer iOptCrt;

	@Column(name = "i_opt_vrb")
	private Integer iOptVrb;

	@Column(name = "s_opt_dsc")
	private String sOptDsc;

	@Column(name = "s_opt_nme")
	private String sOptNme;

	@Column(name = "i_clr_id")
	private Integer IClrId;

	public Integer getIClrId() {
		return IClrId;
	}

	public void setIClrId(Integer iClrId) {
		IClrId = iClrId;
	}

	public PmsTblOpt() {
	}

	public Integer getIOptId() {
		return this.iOptId;
	}

	public void setIOptId(Integer iOptId) {
		this.iOptId = iOptId;
	}

	public Integer getIOptCrt() {
		return this.iOptCrt;
	}

	public void setIOptCrt(Integer iOptCrt) {
		this.iOptCrt = iOptCrt;
	}

	public Integer getIOptVrb() {
		return this.iOptVrb;
	}

	public void setIOptVrb(Integer iOptVrb) {
		this.iOptVrb = iOptVrb;
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