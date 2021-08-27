package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inf_tbl_stm database table.
 * 
 */
@Entity
@Table(name="inf_tbl_stm")
@NamedQuery(name="InfTblStm.findAll", query="SELECT i FROM InfTblStm i")
public class InfTblStm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_stm_id")
	private Integer iStmId;

	@Column(name="i_cnr_id")
	private Integer iCnrId;

	@Column(name="i_ent_id")
	private Integer iEntId;

	@Column(name="i_unt_id")
	private Integer iUntId;

	@Column(name="s_smt_eml")
	private String sSmtEml;

	@Column(name="s_stm_acr")
	private String sStmAcr;

	@Column(name="s_stm_adr")
	private String sStmAdr;

	@Column(name="s_stm_cty")
	private String sStmCty;

	@Column(name="s_stm_lnk")
	private String sStmLnk;

	@Column(name="s_stm_nme")
	private String sStmNme;

	@Column(name="s_stm_psw")
	private String sStmPsw;

	@Column(name="s_stm_usr")
	private String sStmUsr;
	
	@Column(name="s_stm_srv")
	private String SStmSrv;

	@Column(name="i_stt_cde")
	private Integer ISttCde;
	
	public String getSStmSrv() {
		return SStmSrv;
	}

	public void setSStmSrv(String sStmSrv) {
		SStmSrv = sStmSrv;
	}

	public Integer getISttCde() {
		return ISttCde;
	}

	public void setISttCde(Integer iSttCde) {
		ISttCde = iSttCde;
	}

	public InfTblStm() {
	}

	public Integer getIStmId() {
		return this.iStmId;
	}

	public void setIStmId(Integer iStmId) {
		this.iStmId = iStmId;
	}

	public Integer getICnrId() {
		return this.iCnrId;
	}

	public void setICnrId(Integer iCnrId) {
		this.iCnrId = iCnrId;
	}

	public Integer getIEntId() {
		return this.iEntId;
	}

	public void setIEntId(Integer iEntId) {
		this.iEntId = iEntId;
	}

	public Integer getIUntId() {
		return this.iUntId;
	}

	public void setIUntId(Integer iUntId) {
		this.iUntId = iUntId;
	}

	public String getSSmtEml() {
		return this.sSmtEml;
	}

	public void setSSmtEml(String sSmtEml) {
		this.sSmtEml = sSmtEml;
	}

	public String getSStmAcr() {
		return this.sStmAcr;
	}

	public void setSStmAcr(String sStmAcr) {
		this.sStmAcr = sStmAcr;
	}

	public String getSStmAdr() {
		return this.sStmAdr;
	}

	public void setSStmAdr(String sStmAdr) {
		this.sStmAdr = sStmAdr;
	}

	public String getSStmCty() {
		return this.sStmCty;
	}

	public void setSStmCty(String sStmCty) {
		this.sStmCty = sStmCty;
	}

	public String getSStmLnk() {
		return this.sStmLnk;
	}

	public void setSStmLnk(String sStmLnk) {
		this.sStmLnk = sStmLnk;
	}

	public String getSStmNme() {
		return this.sStmNme;
	}

	public void setSStmNme(String sStmNme) {
		this.sStmNme = sStmNme;
	}

	public String getSStmPsw() {
		return this.sStmPsw;
	}

	public void setSStmPsw(String sStmPsw) {
		this.sStmPsw = sStmPsw;
	}

	public String getSStmUsr() {
		return this.sStmUsr;
	}

	public void setSStmUsr(String sStmUsr) {
		this.sStmUsr = sStmUsr;
	}

}