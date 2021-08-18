package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dta_tbl_prs_phn database table.
 * 
 */
@Entity
@Table(name="dta_tbl_prs_phn")
@NamedQuery(name="DtaTblPrsPhn.findAll", query="SELECT d FROM DtaTblPrsPhn d")
public class DtaTblPrsPhn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_phn_id")
	private Integer iPhnId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_phn_dte_rgs")
	private Date dPhnDteRgs;

	@Column(name="i_prs_id")
	private Integer iPrsId;

	@Column(name="i_tpe_id")
	private Integer iTpeId;

	@Column(name="s_phn_dsc")
	private String sPhnDsc;

	@Column(name="s_phn_tme_rgs")
	private String sPhnTmeRgs;

	public DtaTblPrsPhn() {
	}

	public Integer getIPhnId() {
		return this.iPhnId;
	}

	public void setIPhnId(Integer iPhnId) {
		this.iPhnId = iPhnId;
	}

	public Date getDPhnDteRgs() {
		return this.dPhnDteRgs;
	}

	public void setDPhnDteRgs(Date dPhnDteRgs) {
		this.dPhnDteRgs = dPhnDteRgs;
	}

	public Integer getIPrsId() {
		return this.iPrsId;
	}

	public void setIPrsId(Integer iPrsId) {
		this.iPrsId = iPrsId;
	}

	public Integer getITpeId() {
		return this.iTpeId;
	}

	public void setITpeId(Integer iTpeId) {
		this.iTpeId = iTpeId;
	}

	public String getSPhnDsc() {
		return this.sPhnDsc;
	}

	public void setSPhnDsc(String sPhnDsc) {
		this.sPhnDsc = sPhnDsc;
	}

	public String getSPhnTmeRgs() {
		return this.sPhnTmeRgs;
	}

	public void setSPhnTmeRgs(String sPhnTmeRgs) {
		this.sPhnTmeRgs = sPhnTmeRgs;
	}

}