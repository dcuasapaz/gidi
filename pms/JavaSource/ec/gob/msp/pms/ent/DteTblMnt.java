package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dte_tbl_mnt database table.
 * 
 */
@Entity
@Table(name="dte_tbl_mnt")
@NamedQuery(name="DteTblMnt.findAll", query="SELECT d FROM DteTblMnt d")
public class DteTblMnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_mnt_cde")
	private Integer iMntCde;

	@Column(name="s_mnt_cde")
	private String sMntCde;

	@Column(name="s_mnt_nme")
	private String sMntNme;

	public DteTblMnt() {
	}

	public Integer getIMntCde() {
		return this.iMntCde;
	}

	public void setIMntCde(Integer iMntCde) {
		this.iMntCde = iMntCde;
	}

	public String getSMntCde() {
		return this.sMntCde;
	}

	public void setSMntCde(String sMntCde) {
		this.sMntCde = sMntCde;
	}

	public String getSMntNme() {
		return this.sMntNme;
	}

	public void setSMntNme(String sMntNme) {
		this.sMntNme = sMntNme;
	}

}