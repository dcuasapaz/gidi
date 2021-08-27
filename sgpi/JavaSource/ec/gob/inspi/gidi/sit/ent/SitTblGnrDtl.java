package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sit_tbl_gnr_dtl database table.
 * 
 */
@Entity
@Table(name="sit_tbl_gnr_dtl")
@NamedQuery(name="SitTblGnrDtl.findAll", query="SELECT s FROM SitTblGnrDtl s")
public class SitTblGnrDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_gnr_dtl_id")
	private Integer iGnrDtlId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_gnr_dtl_dte_rgs")
	private Date dGnrDtlDteRgs;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_gnr_dtl_dte_prc")
	private Date DGnrDtlDtePrc;

	@Column(name="i_gnr_dtl_nmb")
	private Integer iGnrDtlNmb;

	@Column(name="i_gns_id")
	private Integer iGnsId;

	@Column(name="i_sex_id")
	private Integer iSexId;

	@Column(name="i_stg_id")
	private Integer iStgId;

	@Column(name="i_tpe_dtl")
	private Integer iTpeDtl;
	
	@Column(name="i_ctn_id")
	private Integer ICtnId;
	
	@Column(name="i_prc_id")
	private Integer IPrcId;
	
	@Column(name="s_gnr_dtl_tme_rgs")
	private String sGnrDtlTmeRgs;

	//bi-directional many-to-one association to SitTblGnr
	@ManyToOne
	@JoinColumn(name="i_gnr_id")
	private SitTblGnr sitTblGnr;

	public SitTblGnrDtl() {
	}

	public Integer getIGnrDtlId() {
		return this.iGnrDtlId;
	}

	public void setIGnrDtlId(Integer iGnrDtlId) {
		this.iGnrDtlId = iGnrDtlId;
	}

	public Date getDGnrDtlDteRgs() {
		return this.dGnrDtlDteRgs;
	}

	public void setDGnrDtlDteRgs(Date dGnrDtlDteRgs) {
		this.dGnrDtlDteRgs = dGnrDtlDteRgs;
	}

	public Integer getIGnrDtlNmb() {
		return this.iGnrDtlNmb;
	}

	public void setIGnrDtlNmb(Integer iGnrDtlNmb) {
		this.iGnrDtlNmb = iGnrDtlNmb;
	}

	public Integer getIGnsId() {
		return this.iGnsId;
	}

	public void setIGnsId(Integer iGnsId) {
		this.iGnsId = iGnsId;
	}

	public Integer getISexId() {
		return this.iSexId;
	}

	public void setISexId(Integer iSexId) {
		this.iSexId = iSexId;
	}

	public Integer getIStgId() {
		return this.iStgId;
	}

	public void setIStgId(Integer iStgId) {
		this.iStgId = iStgId;
	}

	public Integer getITpeDtl() {
		return this.iTpeDtl;
	}

	public void setITpeDtl(Integer iTpeDtl) {
		this.iTpeDtl = iTpeDtl;
	}

	public String getSGnrDtlTmeRgs() {
		return this.sGnrDtlTmeRgs;
	}

	public void setSGnrDtlTmeRgs(String sGnrDtlTmeRgs) {
		this.sGnrDtlTmeRgs = sGnrDtlTmeRgs;
	}

	public SitTblGnr getSitTblGnr() {
		return this.sitTblGnr;
	}

	public void setSitTblGnr(SitTblGnr sitTblGnr) {
		this.sitTblGnr = sitTblGnr;
	}

	public Date getDGnrDtlDtePrc() {
		return DGnrDtlDtePrc;
	}

	public void setDGnrDtlDtePrc(Date dGnrDtlDtePrc) {
		DGnrDtlDtePrc = dGnrDtlDtePrc;
	}

	public Integer getICtnId() {
		return ICtnId;
	}

	public void setICtnId(Integer iCtnId) {
		ICtnId = iCtnId;
	}

	public Integer getIPrcId() {
		return IPrcId;
	}

	public void setIPrcId(Integer iPrcId) {
		IPrcId = iPrcId;
	}

}