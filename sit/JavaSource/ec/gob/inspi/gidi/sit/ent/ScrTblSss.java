package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the scr_tbl_sss database table.
 * 
 */
@Entity
@Table(name="scr_tbl_sss")
@NamedQuery(name="ScrTblSss.findAll", query="SELECT s FROM ScrTblSss s")
public class ScrTblSss implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_sss_id")
	private Integer iSssId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_sss_dte")
	private Date dSssDte;

	@Column(name="i_prs_rol_id")
	private Integer iPrsRolId;

	@Column(name="s_sss_tme_dsc")
	private String sSssTmeDsc;

	@Column(name="s_sss_tme_end")
	private String sSssTmeEnd;

	@Column(name="s_sss_tme_srt")
	private String sSssTmeSrt;

	public ScrTblSss() {
	}

	public Integer getISssId() {
		return this.iSssId;
	}

	public void setISssId(Integer iSssId) {
		this.iSssId = iSssId;
	}

	public Date getDSssDte() {
		return this.dSssDte;
	}

	public void setDSssDte(Date dSssDte) {
		this.dSssDte = dSssDte;
	}

	public Integer getIPrsRolId() {
		return this.iPrsRolId;
	}

	public void setIPrsRolId(Integer iPrsRolId) {
		this.iPrsRolId = iPrsRolId;
	}

	public String getSSssTmeDsc() {
		return this.sSssTmeDsc;
	}

	public void setSSssTmeDsc(String sSssTmeDsc) {
		this.sSssTmeDsc = sSssTmeDsc;
	}

	public String getSSssTmeEnd() {
		return this.sSssTmeEnd;
	}

	public void setSSssTmeEnd(String sSssTmeEnd) {
		this.sSssTmeEnd = sSssTmeEnd;
	}

	public String getSSssTmeSrt() {
		return this.sSssTmeSrt;
	}

	public void setSSssTmeSrt(String sSssTmeSrt) {
		this.sSssTmeSrt = sSssTmeSrt;
	}

}