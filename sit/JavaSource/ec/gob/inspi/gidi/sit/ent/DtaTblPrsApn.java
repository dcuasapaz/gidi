package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dta_tbl_prs_apn database table.
 * 
 */
@Entity
@Table(name="dta_tbl_prs_apn")
@NamedQuery(name="DtaTblPrsApn.findAll", query="SELECT d FROM DtaTblPrsApn d")
public class DtaTblPrsApn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_prs_apn_id")
	private Integer iPrsApnId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_prs_apn_dte_rgs")
	private Date dPrsApnDteRgs;

	@Column(name="i_stt_cde")
	private Integer iSttCde;

	@Column(name="s_prs_apn_tme_rgs")
	private String sPrsApnTmeRgs;

	//bi-directional many-to-one association to DtaTblPr
	@ManyToOne
	@JoinColumn(name="i_prs_id")
	private DtaTblPr dtaTblPr;

	//bi-directional many-to-one association to InsTblApn
	@ManyToOne
	@JoinColumn(name="i_apn_id")
	private InsTblApn insTblApn;

	public DtaTblPrsApn() {
	}

	public Integer getIPrsApnId() {
		return this.iPrsApnId;
	}

	public void setIPrsApnId(Integer iPrsApnId) {
		this.iPrsApnId = iPrsApnId;
	}

	public Date getDPrsApnDteRgs() {
		return this.dPrsApnDteRgs;
	}

	public void setDPrsApnDteRgs(Date dPrsApnDteRgs) {
		this.dPrsApnDteRgs = dPrsApnDteRgs;
	}

	public Integer getISttCde() {
		return this.iSttCde;
	}

	public void setISttCde(Integer iSttCde) {
		this.iSttCde = iSttCde;
	}

	public String getSPrsApnTmeRgs() {
		return this.sPrsApnTmeRgs;
	}

	public void setSPrsApnTmeRgs(String sPrsApnTmeRgs) {
		this.sPrsApnTmeRgs = sPrsApnTmeRgs;
	}

	public DtaTblPr getDtaTblPr() {
		return this.dtaTblPr;
	}

	public void setDtaTblPr(DtaTblPr dtaTblPr) {
		this.dtaTblPr = dtaTblPr;
	}

	public InsTblApn getInsTblApn() {
		return this.insTblApn;
	}

	public void setInsTblApn(InsTblApn insTblApn) {
		this.insTblApn = insTblApn;
	}

}