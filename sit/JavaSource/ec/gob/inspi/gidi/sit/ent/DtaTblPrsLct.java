package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dta_tbl_prs_lct database table.
 * 
 */
@Entity
@Table(name="dta_tbl_prs_lct")
@NamedQuery(name="DtaTblPrsLct.findAll", query="SELECT d FROM DtaTblPrsLct d")
public class DtaTblPrsLct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_lct_id")
	private Integer iLctId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_lct_dte_rgs")
	private Date dLctDteRgs;

	@Column(name="i_prs_id")
	private Integer iPrsId;

	@Column(name="s_lct_adr")
	private String sLctAdr;

	@Column(name="s_lct_cty")
	private String sLctCty;

	@Column(name="s_lct_tme_rgs")
	private String sLctTmeRgs;

	public DtaTblPrsLct() {
	}

	public Integer getILctId() {
		return this.iLctId;
	}

	public void setILctId(Integer iLctId) {
		this.iLctId = iLctId;
	}

	public Date getDLctDteRgs() {
		return this.dLctDteRgs;
	}

	public void setDLctDteRgs(Date dLctDteRgs) {
		this.dLctDteRgs = dLctDteRgs;
	}

	public Integer getIPrsId() {
		return this.iPrsId;
	}

	public void setIPrsId(Integer iPrsId) {
		this.iPrsId = iPrsId;
	}

	public String getSLctAdr() {
		return this.sLctAdr;
	}

	public void setSLctAdr(String sLctAdr) {
		this.sLctAdr = sLctAdr;
	}

	public String getSLctCty() {
		return this.sLctCty;
	}

	public void setSLctCty(String sLctCty) {
		this.sLctCty = sLctCty;
	}

	public String getSLctTmeRgs() {
		return this.sLctTmeRgs;
	}

	public void setSLctTmeRgs(String sLctTmeRgs) {
		this.sLctTmeRgs = sLctTmeRgs;
	}

}