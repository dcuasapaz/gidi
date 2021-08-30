package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hst_tbl_cnt_prs_rol database table.
 * 
 */
@Entity
@Table(name="hst_tbl_cnt_prs_rol")
@NamedQuery(name="HstTblCntPrsRol.findAll", query="SELECT h FROM HstTblCntPrsRol h")
public class HstTblCntPrsRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_cnt_prs_rol_id")
	private Integer iCntPrsRolId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_cnt_prs_rol_dte_rgs")
	private Date dCntPrsRolDteRgs;

	@Column(name="i_act_cde")
	private Integer iActCde;

	@Column(name="s_cnt_prs_rol_dtl")
	private String sCntPrsRolDtl;

	@Column(name="s_cnt_prs_rol_tme_rgs")
	private String sCntPrsRolTmeRgs;

	//bi-directional many-to-one association to DpaTblCnt
	@ManyToOne
	@JoinColumn(name="i_cnt_cde")
	private DpaTblCnt dpaTblCnt;

	//bi-directional many-to-one association to ScrTblPrsRol
	@ManyToOne
	@JoinColumn(name="i_prs_rol_id")
	private ScrTblPrsRol scrTblPrsRol;

	public HstTblCntPrsRol() {
	}

	public Integer getICntPrsRolId() {
		return this.iCntPrsRolId;
	}

	public void setICntPrsRolId(Integer iCntPrsRolId) {
		this.iCntPrsRolId = iCntPrsRolId;
	}

	public Date getDCntPrsRolDteRgs() {
		return this.dCntPrsRolDteRgs;
	}

	public void setDCntPrsRolDteRgs(Date dCntPrsRolDteRgs) {
		this.dCntPrsRolDteRgs = dCntPrsRolDteRgs;
	}

	public Integer getIActCde() {
		return this.iActCde;
	}

	public void setIActCde(Integer iActCde) {
		this.iActCde = iActCde;
	}

	public String getSCntPrsRolDtl() {
		return this.sCntPrsRolDtl;
	}

	public void setSCntPrsRolDtl(String sCntPrsRolDtl) {
		this.sCntPrsRolDtl = sCntPrsRolDtl;
	}

	public String getSCntPrsRolTmeRgs() {
		return this.sCntPrsRolTmeRgs;
	}

	public void setSCntPrsRolTmeRgs(String sCntPrsRolTmeRgs) {
		this.sCntPrsRolTmeRgs = sCntPrsRolTmeRgs;
	}

	public DpaTblCnt getDpaTblCnt() {
		return this.dpaTblCnt;
	}

	public void setDpaTblCnt(DpaTblCnt dpaTblCnt) {
		this.dpaTblCnt = dpaTblCnt;
	}

	public ScrTblPrsRol getScrTblPrsRol() {
		return this.scrTblPrsRol;
	}

	public void setScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		this.scrTblPrsRol = scrTblPrsRol;
	}

}