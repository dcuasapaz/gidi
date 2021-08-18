package ec.gob.inspi.gidi.sit.ent;

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

	@Column(name="i_prv_cde")
	private Integer iPrvCde;

	@Column(name="s_cnt_nme")
	private String sCntNme;

	//bi-directional many-to-one association to DpaTblPrq
	@OneToMany(mappedBy="dpaTblCnt")
	private List<DpaTblPrq> dpaTblPrqs;

	public DpaTblCnt() {
	}

	public Integer getICntCde() {
		return this.iCntCde;
	}

	public void setICntCde(Integer iCntCde) {
		this.iCntCde = iCntCde;
	}

	public Integer getIPrvCde() {
		return this.iPrvCde;
	}

	public void setIPrvCde(Integer iPrvCde) {
		this.iPrvCde = iPrvCde;
	}

	public String getSCntNme() {
		return this.sCntNme;
	}

	public void setSCntNme(String sCntNme) {
		this.sCntNme = sCntNme;
	}

	public List<DpaTblPrq> getDpaTblPrqs() {
		return this.dpaTblPrqs;
	}

	public void setDpaTblPrqs(List<DpaTblPrq> dpaTblPrqs) {
		this.dpaTblPrqs = dpaTblPrqs;
	}

	public DpaTblPrq addDpaTblPrq(DpaTblPrq dpaTblPrq) {
		getDpaTblPrqs().add(dpaTblPrq);
		dpaTblPrq.setDpaTblCnt(this);

		return dpaTblPrq;
	}

	public DpaTblPrq removeDpaTblPrq(DpaTblPrq dpaTblPrq) {
		getDpaTblPrqs().remove(dpaTblPrq);
		dpaTblPrq.setDpaTblCnt(null);

		return dpaTblPrq;
	}

}