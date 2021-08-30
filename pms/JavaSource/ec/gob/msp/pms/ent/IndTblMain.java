package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ind_tbl_main database table.
 * 
 */
@Entity
@Table(name = "ind_tbl_main")
@NamedQuery(name = "IndTblMain.findAll", query = "SELECT i FROM IndTblMain i")
public class IndTblMain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_main_id")
	private Integer iMainId;

	@Column(name = "b_main_dsn")
	private Boolean bMainDsn;

	@Column(name = "b_main_mtr")
	private Boolean bMainMtr;

	@Column(name = "b_main_obl")
	private Boolean bMainObl;

	@Column(name = "b_main_qnt")
	private Boolean bMainQnt;

	@Column(name = "b_main_vln")
	private Boolean bMainVln;

	@Column(name = "i_main_cde")
	private Integer iMainCde;

	@Column(name = "r_inf")
	private String rInf;

	@Column(name = "r_spr")
	private String rSpr;

	@Column(name = "s_main_dsc")
	private String sMainDsc;

	@Column(name = "s_main_nme")
	private String sMainNme;

	@Column(name = "s_main_unt")
	private String sMainUnt;

	@Column(name = "s_main_v0")
	private String sMainV0;

	@Column(name = "s_main_v1")
	private String sMainV1;

	@Column(name = "s_main_v2")
	private String sMainV2;

	@Column(name = "s_main_v3")
	private String sMainV3;

	@Column(name = "s_rng")
	private String sRng;

	@Column(name = "s_main_fle")
	private String SMainFle;

	// bi-directional many-to-one association to IndTblLvl
	@ManyToOne
	@JoinColumn(name = "i_lvl_cde")
	private IndTblLvl indTblLvl;

	// bi-directional many-to-one association to PmsTblMnc
	@OneToMany(mappedBy = "indTblMain")
	private List<PmsTblMnc> pmsTblMncs;

	public IndTblMain() {
	}

	public Integer getIMainId() {
		return this.iMainId;
	}

	public void setIMainId(Integer iMainId) {
		this.iMainId = iMainId;
	}

	public Boolean getBMainDsn() {
		return this.bMainDsn;
	}

	public void setBMainDsn(Boolean bMainDsn) {
		this.bMainDsn = bMainDsn;
	}

	public Boolean getBMainMtr() {
		return this.bMainMtr;
	}

	public void setBMainMtr(Boolean bMainMtr) {
		this.bMainMtr = bMainMtr;
	}

	public Boolean getBMainObl() {
		return this.bMainObl;
	}

	public void setBMainObl(Boolean bMainObl) {
		this.bMainObl = bMainObl;
	}

	public Boolean getBMainQnt() {
		return this.bMainQnt;
	}

	public void setBMainQnt(Boolean bMainQnt) {
		this.bMainQnt = bMainQnt;
	}

	public Boolean getBMainVln() {
		return this.bMainVln;
	}

	public void setBMainVln(Boolean bMainVln) {
		this.bMainVln = bMainVln;
	}

	public Integer getIMainCde() {
		return this.iMainCde;
	}

	public void setIMainCde(Integer iMainCde) {
		this.iMainCde = iMainCde;
	}

	public String getRInf() {
		return this.rInf;
	}

	public void setRInf(String rInf) {
		this.rInf = rInf;
	}

	public String getRSpr() {
		return this.rSpr;
	}

	public void setRSpr(String rSpr) {
		this.rSpr = rSpr;
	}

	public String getSMainDsc() {
		return this.sMainDsc;
	}

	public void setSMainDsc(String sMainDsc) {
		this.sMainDsc = sMainDsc;
	}

	public String getSMainNme() {
		return this.sMainNme;
	}

	public void setSMainNme(String sMainNme) {
		this.sMainNme = sMainNme;
	}

	public String getSMainUnt() {
		return this.sMainUnt;
	}

	public void setSMainUnt(String sMainUnt) {
		this.sMainUnt = sMainUnt;
	}

	public String getSMainV0() {
		return this.sMainV0;
	}

	public void setSMainV0(String sMainV0) {
		this.sMainV0 = sMainV0;
	}

	public String getSMainV1() {
		return this.sMainV1;
	}

	public void setSMainV1(String sMainV1) {
		this.sMainV1 = sMainV1;
	}

	public String getSMainV2() {
		return this.sMainV2;
	}

	public void setSMainV2(String sMainV2) {
		this.sMainV2 = sMainV2;
	}

	public String getSMainV3() {
		return this.sMainV3;
	}

	public void setSMainV3(String sMainV3) {
		this.sMainV3 = sMainV3;
	}

	public String getSRng() {
		return this.sRng;
	}

	public void setSRng(String sRng) {
		this.sRng = sRng;
	}

	public IndTblLvl getIndTblLvl() {
		return this.indTblLvl;
	}

	public void setIndTblLvl(IndTblLvl indTblLvl) {
		this.indTblLvl = indTblLvl;
	}

	public List<PmsTblMnc> getPmsTblMncs() {
		return this.pmsTblMncs;
	}

	public void setPmsTblMncs(List<PmsTblMnc> pmsTblMncs) {
		this.pmsTblMncs = pmsTblMncs;
	}

	public PmsTblMnc addPmsTblMnc(PmsTblMnc pmsTblMnc) {
		getPmsTblMncs().add(pmsTblMnc);
		pmsTblMnc.setIndTblMain(this);

		return pmsTblMnc;
	}

	public PmsTblMnc removePmsTblMnc(PmsTblMnc pmsTblMnc) {
		getPmsTblMncs().remove(pmsTblMnc);
		pmsTblMnc.setIndTblMain(null);

		return pmsTblMnc;
	}

	public String getSMainFle() {
		return SMainFle;
	}

	public void setSMainFle(String sMainFle) {
		SMainFle = sMainFle;
	}

}