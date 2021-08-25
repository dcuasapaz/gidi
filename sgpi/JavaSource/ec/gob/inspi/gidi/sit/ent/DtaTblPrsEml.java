package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dta_tbl_prs_eml database table.
 * 
 */
@Entity
@Table(name="dta_tbl_prs_eml")
@NamedQuery(name="DtaTblPrsEml.findAll", query="SELECT d FROM DtaTblPrsEml d")
public class DtaTblPrsEml implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_eml_id")
	private Integer iEmlId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_eml_dte_rgs")
	private Date dEmlDteRgs;

	@Column(name="i_prs_id")
	private Integer iPrsId;

	@Column(name="i_tpe_id")
	private Integer iTpeId;

	@Column(name="s_eml_dsc")
	private String sEmlDsc;

	@Column(name="s_eml_tme_rgs")
	private String sEmlTmeRgs;

	public DtaTblPrsEml() {
	}

	public Integer getIEmlId() {
		return this.iEmlId;
	}

	public void setIEmlId(Integer iEmlId) {
		this.iEmlId = iEmlId;
	}

	public Date getDEmlDteRgs() {
		return this.dEmlDteRgs;
	}

	public void setDEmlDteRgs(Date dEmlDteRgs) {
		this.dEmlDteRgs = dEmlDteRgs;
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

	public String getSEmlDsc() {
		return this.sEmlDsc;
	}

	public void setSEmlDsc(String sEmlDsc) {
		this.sEmlDsc = sEmlDsc;
	}

	public String getSEmlTmeRgs() {
		return this.sEmlTmeRgs;
	}

	public void setSEmlTmeRgs(String sEmlTmeRgs) {
		this.sEmlTmeRgs = sEmlTmeRgs;
	}

}