package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ins_tbl_apn database table.
 * 
 */
@Entity
@Table(name="ins_tbl_apn")
@NamedQuery(name="InsTblApn.findAll", query="SELECT i FROM InsTblApn i")
public class InsTblApn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_apn_id")
	private Integer iApnId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_apn_dte_rgs")
	private Date dApnDteRgs;

	@Column(name="s_apn_nme")
	private String sApnNme;

	@Column(name="s_apn_tme_rgs")
	private String sApnTmeRgs;

	//bi-directional many-to-one association to DtaTblPrsApn
	@OneToMany(mappedBy="insTblApn")
	private List<DtaTblPrsApn> dtaTblPrsApns;

	//bi-directional many-to-one association to InsTblUnt
	@ManyToOne
	@JoinColumn(name="i_unt_id")
	private InsTblUnt insTblUnt;

	public InsTblApn() {
	}

	public Integer getIApnId() {
		return this.iApnId;
	}

	public void setIApnId(Integer iApnId) {
		this.iApnId = iApnId;
	}

	public Date getDApnDteRgs() {
		return this.dApnDteRgs;
	}

	public void setDApnDteRgs(Date dApnDteRgs) {
		this.dApnDteRgs = dApnDteRgs;
	}

	public String getSApnNme() {
		return this.sApnNme;
	}

	public void setSApnNme(String sApnNme) {
		this.sApnNme = sApnNme;
	}

	public String getSApnTmeRgs() {
		return this.sApnTmeRgs;
	}

	public void setSApnTmeRgs(String sApnTmeRgs) {
		this.sApnTmeRgs = sApnTmeRgs;
	}

	public List<DtaTblPrsApn> getDtaTblPrsApns() {
		return this.dtaTblPrsApns;
	}

	public void setDtaTblPrsApns(List<DtaTblPrsApn> dtaTblPrsApns) {
		this.dtaTblPrsApns = dtaTblPrsApns;
	}

	public DtaTblPrsApn addDtaTblPrsApn(DtaTblPrsApn dtaTblPrsApn) {
		getDtaTblPrsApns().add(dtaTblPrsApn);
		dtaTblPrsApn.setInsTblApn(this);

		return dtaTblPrsApn;
	}

	public DtaTblPrsApn removeDtaTblPrsApn(DtaTblPrsApn dtaTblPrsApn) {
		getDtaTblPrsApns().remove(dtaTblPrsApn);
		dtaTblPrsApn.setInsTblApn(null);

		return dtaTblPrsApn;
	}

	public InsTblUnt getInsTblUnt() {
		return this.insTblUnt;
	}

	public void setInsTblUnt(InsTblUnt insTblUnt) {
		this.insTblUnt = insTblUnt;
	}

}