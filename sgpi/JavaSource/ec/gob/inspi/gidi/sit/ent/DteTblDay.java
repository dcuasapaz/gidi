package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dte_tbl_day database table.
 * 
 */
@Entity
@Table(name="dte_tbl_day")
@NamedQuery(name="DteTblDay.findAll", query="SELECT d FROM DteTblDay d")
public class DteTblDay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_day_id")
	private Integer iDayId;

	@Column(name="i_day_idn")
	private Integer iDayIdn;

	@Column(name="i_day_vle")
	private Integer iDayVle;

	@Column(name="s_day_vle")
	private String sDayVle;

	public DteTblDay() {
	}

	public Integer getIDayId() {
		return this.iDayId;
	}

	public void setIDayId(Integer iDayId) {
		this.iDayId = iDayId;
	}

	public Integer getIDayIdn() {
		return this.iDayIdn;
	}

	public void setIDayIdn(Integer iDayIdn) {
		this.iDayIdn = iDayIdn;
	}

	public Integer getIDayVle() {
		return this.iDayVle;
	}

	public void setIDayVle(Integer iDayVle) {
		this.iDayVle = iDayVle;
	}

	public String getSDayVle() {
		return this.sDayVle;
	}

	public void setSDayVle(String sDayVle) {
		this.sDayVle = sDayVle;
	}

}