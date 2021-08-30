package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vrf_tbl_ins_mnc database table.
 * 
 */
@Entity
@Table(name="vrf_tbl_ins_mnc")
@NamedQuery(name="VrfTblInsMnc.findAll", query="SELECT v FROM VrfTblInsMnc v")
public class VrfTblInsMnc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_ins_mnc_id")
	private Integer iInsMncId;

	@Column(name="i_ins_mnc_day")
	private Integer iInsMncDay;

	@Column(name="i_ins_mnc_mth")
	private Integer iInsMncMth;

	@Column(name="i_ins_mnc_yr")
	private Integer iInsMncYr;

	@Column(name="r_ins_mnc_vle")
	private double rInsMncVle;

	@Column(name="s_ins_mnc_nme")
	private String sInsMncNme;

	//bi-directional many-to-one association to PmsTblMnc
	@ManyToOne
	@JoinColumn(name="i_mnc_id")
	private PmsTblMnc pmsTblMnc;

	//bi-directional many-to-one association to VrfTblIn
	@ManyToOne
	@JoinColumn(name="i_ins_id")
	private VrfTblIn vrfTblIn;

	public VrfTblInsMnc() {
	}

	public Integer getIInsMncId() {
		return this.iInsMncId;
	}

	public void setIInsMncId(Integer iInsMncId) {
		this.iInsMncId = iInsMncId;
	}

	public Integer getIInsMncDay() {
		return this.iInsMncDay;
	}

	public void setIInsMncDay(Integer iInsMncDay) {
		this.iInsMncDay = iInsMncDay;
	}

	public Integer getIInsMncMth() {
		return this.iInsMncMth;
	}

	public void setIInsMncMth(Integer iInsMncMth) {
		this.iInsMncMth = iInsMncMth;
	}

	public Integer getIInsMncYr() {
		return this.iInsMncYr;
	}

	public void setIInsMncYr(Integer iInsMncYr) {
		this.iInsMncYr = iInsMncYr;
	}

	public double getRInsMncVle() {
		return this.rInsMncVle;
	}

	public void setRInsMncVle(double rInsMncVle) {
		this.rInsMncVle = rInsMncVle;
	}

	public String getSInsMncNme() {
		return this.sInsMncNme;
	}

	public void setSInsMncNme(String sInsMncNme) {
		this.sInsMncNme = sInsMncNme;
	}

	public PmsTblMnc getPmsTblMnc() {
		return this.pmsTblMnc;
	}

	public void setPmsTblMnc(PmsTblMnc pmsTblMnc) {
		this.pmsTblMnc = pmsTblMnc;
	}

	public VrfTblIn getVrfTblIn() {
		return this.vrfTblIn;
	}

	public void setVrfTblIn(VrfTblIn vrfTblIn) {
		this.vrfTblIn = vrfTblIn;
	}

}