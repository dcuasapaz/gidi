package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dta_tbl_prs_edc database table.
 * 
 */
@Entity
@Table(name="dta_tbl_prs_edc")
@NamedQuery(name="DtaTblPrsEdc.findAll", query="SELECT d FROM DtaTblPrsEdc d")
public class DtaTblPrsEdc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_edc_id")
	private Integer iEdcId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_edc_dte_rgs")
	private Date dEdcDteRgs;

	@Column(name="i_lvl_id")
	private Integer iLvlId;

	@Column(name="i_prs_id")
	private Integer iPrsId;

	@Column(name="s_edc_dsp")
	private String sEdcDsp;

	@Column(name="s_edc_dsp_sub")
	private String sEdcDspSub;

	@Column(name="s_edc_tme_rgs")
	private String sEdcTmeRgs;

	public DtaTblPrsEdc() {
	}

	public Integer getIEdcId() {
		return this.iEdcId;
	}

	public void setIEdcId(Integer iEdcId) {
		this.iEdcId = iEdcId;
	}

	public Date getDEdcDteRgs() {
		return this.dEdcDteRgs;
	}

	public void setDEdcDteRgs(Date dEdcDteRgs) {
		this.dEdcDteRgs = dEdcDteRgs;
	}

	public Integer getILvlId() {
		return this.iLvlId;
	}

	public void setILvlId(Integer iLvlId) {
		this.iLvlId = iLvlId;
	}

	public Integer getIPrsId() {
		return this.iPrsId;
	}

	public void setIPrsId(Integer iPrsId) {
		this.iPrsId = iPrsId;
	}

	public String getSEdcDsp() {
		return this.sEdcDsp;
	}

	public void setSEdcDsp(String sEdcDsp) {
		this.sEdcDsp = sEdcDsp;
	}

	public String getSEdcDspSub() {
		return this.sEdcDspSub;
	}

	public void setSEdcDspSub(String sEdcDspSub) {
		this.sEdcDspSub = sEdcDspSub;
	}

	public String getSEdcTmeRgs() {
		return this.sEdcTmeRgs;
	}

	public void setSEdcTmeRgs(String sEdcTmeRgs) {
		this.sEdcTmeRgs = sEdcTmeRgs;
	}

}