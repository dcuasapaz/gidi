package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dpa_tbl_cnt database table.
 * 
 */
@Entity
@Table(name="dpa_tbl_cnt")
@NamedQuery(name="DpaTblCnt.findAll", query="SELECT d FROM DpaTblCnt d")
public class DpaTblCnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_cnt_cde")
	private Integer iCntCde;

	@Column(name="i_cnt_dte_end_prc_day")
	private Integer iCntDteEndPrcDay;

	@Column(name="i_cnt_dte_end_prc_mth")
	private Integer iCntDteEndPrcMth;

	@Column(name="i_cnt_dte_end_prc_yr")
	private Integer iCntDteEndPrcYr;

	@Column(name="i_cnt_dte_str_prc_day")
	private Integer iCntDteStrPrcDay;

	@Column(name="i_cnt_dte_str_prc_mth")
	private Integer iCntDteStrPrcMth;

	@Column(name="i_cnt_dte_str_prc_yr")
	private Integer iCntDteStrPrcYr;

	@Column(name="i_prv_cde")
	private Integer iPrvCde;

	@Column(name="i_stt_cde")
	private Integer iSttCde;

	@Column(name="s_cnt_dcm")
	private String sCntDcm;

	@Column(name="s_cnt_nme")
	private String sCntNme;

	@Column(name="s_cnt_obs")
	private String sCntObs;

	//bi-directional many-to-one association to HstTblCntPrsRol
	@OneToMany(mappedBy="dpaTblCnt")
	private List<HstTblCntPrsRol> hstTblCntPrsRols;

	//bi-directional many-to-one association to PmsTblMnc
	@OneToMany(mappedBy="dpaTblCnt")
	private List<PmsTblMnc> pmsTblMncs;

	//bi-directional many-to-one association to ScrTblPrsRol
	@OneToMany(mappedBy="dpaTblCnt")
	private List<ScrTblPrsRol> scrTblPrsRols;

	public DpaTblCnt() {
	}

	public Integer getICntCde() {
		return this.iCntCde;
	}

	public void setICntCde(Integer iCntCde) {
		this.iCntCde = iCntCde;
	}

	public Integer getICntDteEndPrcDay() {
		return this.iCntDteEndPrcDay;
	}

	public void setICntDteEndPrcDay(Integer iCntDteEndPrcDay) {
		this.iCntDteEndPrcDay = iCntDteEndPrcDay;
	}

	public Integer getICntDteEndPrcMth() {
		return this.iCntDteEndPrcMth;
	}

	public void setICntDteEndPrcMth(Integer iCntDteEndPrcMth) {
		this.iCntDteEndPrcMth = iCntDteEndPrcMth;
	}

	public Integer getICntDteEndPrcYr() {
		return this.iCntDteEndPrcYr;
	}

	public void setICntDteEndPrcYr(Integer iCntDteEndPrcYr) {
		this.iCntDteEndPrcYr = iCntDteEndPrcYr;
	}

	public Integer getICntDteStrPrcDay() {
		return this.iCntDteStrPrcDay;
	}

	public void setICntDteStrPrcDay(Integer iCntDteStrPrcDay) {
		this.iCntDteStrPrcDay = iCntDteStrPrcDay;
	}

	public Integer getICntDteStrPrcMth() {
		return this.iCntDteStrPrcMth;
	}

	public void setICntDteStrPrcMth(Integer iCntDteStrPrcMth) {
		this.iCntDteStrPrcMth = iCntDteStrPrcMth;
	}

	public Integer getICntDteStrPrcYr() {
		return this.iCntDteStrPrcYr;
	}

	public void setICntDteStrPrcYr(Integer iCntDteStrPrcYr) {
		this.iCntDteStrPrcYr = iCntDteStrPrcYr;
	}

	public Integer getIPrvCde() {
		return this.iPrvCde;
	}

	public void setIPrvCde(Integer iPrvCde) {
		this.iPrvCde = iPrvCde;
	}

	public Integer getISttCde() {
		return this.iSttCde;
	}

	public void setISttCde(Integer iSttCde) {
		this.iSttCde = iSttCde;
	}

	public String getSCntDcm() {
		return this.sCntDcm;
	}

	public void setSCntDcm(String sCntDcm) {
		this.sCntDcm = sCntDcm;
	}

	public String getSCntNme() {
		return this.sCntNme;
	}

	public void setSCntNme(String sCntNme) {
		this.sCntNme = sCntNme;
	}

	public String getSCntObs() {
		return this.sCntObs;
	}

	public void setSCntObs(String sCntObs) {
		this.sCntObs = sCntObs;
	}

	public List<HstTblCntPrsRol> getHstTblCntPrsRols() {
		return this.hstTblCntPrsRols;
	}

	public void setHstTblCntPrsRols(List<HstTblCntPrsRol> hstTblCntPrsRols) {
		this.hstTblCntPrsRols = hstTblCntPrsRols;
	}

	public HstTblCntPrsRol addHstTblCntPrsRol(HstTblCntPrsRol hstTblCntPrsRol) {
		getHstTblCntPrsRols().add(hstTblCntPrsRol);
		hstTblCntPrsRol.setDpaTblCnt(this);

		return hstTblCntPrsRol;
	}

	public HstTblCntPrsRol removeHstTblCntPrsRol(HstTblCntPrsRol hstTblCntPrsRol) {
		getHstTblCntPrsRols().remove(hstTblCntPrsRol);
		hstTblCntPrsRol.setDpaTblCnt(null);

		return hstTblCntPrsRol;
	}

	public List<PmsTblMnc> getPmsTblMncs() {
		return this.pmsTblMncs;
	}

	public void setPmsTblMncs(List<PmsTblMnc> pmsTblMncs) {
		this.pmsTblMncs = pmsTblMncs;
	}

	public PmsTblMnc addPmsTblMnc(PmsTblMnc pmsTblMnc) {
		getPmsTblMncs().add(pmsTblMnc);
		pmsTblMnc.setDpaTblCnt(this);

		return pmsTblMnc;
	}

	public PmsTblMnc removePmsTblMnc(PmsTblMnc pmsTblMnc) {
		getPmsTblMncs().remove(pmsTblMnc);
		pmsTblMnc.setDpaTblCnt(null);

		return pmsTblMnc;
	}

	public List<ScrTblPrsRol> getScrTblPrsRols() {
		return this.scrTblPrsRols;
	}

	public void setScrTblPrsRols(List<ScrTblPrsRol> scrTblPrsRols) {
		this.scrTblPrsRols = scrTblPrsRols;
	}

	public ScrTblPrsRol addScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		getScrTblPrsRols().add(scrTblPrsRol);
		scrTblPrsRol.setDpaTblCnt(this);

		return scrTblPrsRol;
	}

	public ScrTblPrsRol removeScrTblPrsRol(ScrTblPrsRol scrTblPrsRol) {
		getScrTblPrsRols().remove(scrTblPrsRol);
		scrTblPrsRol.setDpaTblCnt(null);

		return scrTblPrsRol;
	}

}