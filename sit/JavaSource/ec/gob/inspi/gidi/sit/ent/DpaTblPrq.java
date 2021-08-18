package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dpa_tbl_prq database table.
 * 
 */
@Entity
@Table(name="dpa_tbl_prq")
@NamedQuery(name="DpaTblPrq.findAll", query="SELECT d FROM DpaTblPrq d")
public class DpaTblPrq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_prq_cde")
	private Integer iPrqCde;

	@Column(name="i_prv_cde")
	private Integer iPrvCde;

	@Column(name="i_rgn_id")
	private Integer iRgnId;

	@Column(name="i_tpe_id")
	private Integer iTpeId;

	@Column(name="s_prq_nme")
	private String sPrqNme;

	//bi-directional many-to-one association to DpaTblCnt
	@ManyToOne
	@JoinColumn(name="i_cnt_cde")
	private DpaTblCnt dpaTblCnt;

	public DpaTblPrq() {
	}

	public Integer getIPrqCde() {
		return this.iPrqCde;
	}

	public void setIPrqCde(Integer iPrqCde) {
		this.iPrqCde = iPrqCde;
	}

	public Integer getIPrvCde() {
		return this.iPrvCde;
	}

	public void setIPrvCde(Integer iPrvCde) {
		this.iPrvCde = iPrvCde;
	}

	public Integer getIRgnId() {
		return this.iRgnId;
	}

	public void setIRgnId(Integer iRgnId) {
		this.iRgnId = iRgnId;
	}

	public Integer getITpeId() {
		return this.iTpeId;
	}

	public void setITpeId(Integer iTpeId) {
		this.iTpeId = iTpeId;
	}

	public String getSPrqNme() {
		return this.sPrqNme;
	}

	public void setSPrqNme(String sPrqNme) {
		this.sPrqNme = sPrqNme;
	}

	public DpaTblCnt getDpaTblCnt() {
		return this.dpaTblCnt;
	}

	public void setDpaTblCnt(DpaTblCnt dpaTblCnt) {
		this.dpaTblCnt = dpaTblCnt;
	}

}