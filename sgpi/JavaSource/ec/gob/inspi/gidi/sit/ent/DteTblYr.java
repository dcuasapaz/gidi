package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dte_tbl_yr database table.
 * 
 */
@Entity
@Table(name="dte_tbl_yr")
@NamedQuery(name="DteTblYr.findAll", query="SELECT d FROM DteTblYr d")
public class DteTblYr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_yr_id")
	private Integer iYrId;

	@Column(name="i_mdl_id")
	private Integer iMdlId;

	@Column(name="i_yr_vle")
	private Integer iYrVle;

	public DteTblYr() {
	}

	public Integer getIYrId() {
		return this.iYrId;
	}

	public void setIYrId(Integer iYrId) {
		this.iYrId = iYrId;
	}

	public Integer getIMdlId() {
		return this.iMdlId;
	}

	public void setIMdlId(Integer iMdlId) {
		this.iMdlId = iMdlId;
	}

	public Integer getIYrVle() {
		return this.iYrVle;
	}

	public void setIYrVle(Integer iYrVle) {
		this.iYrVle = iYrVle;
	}

}