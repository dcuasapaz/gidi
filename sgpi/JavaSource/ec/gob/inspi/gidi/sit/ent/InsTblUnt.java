package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ins_tbl_unt database table.
 * 
 */
@Entity
@Table(name="ins_tbl_unt")
@NamedQuery(name="InsTblUnt.findAll", query="SELECT i FROM InsTblUnt i")
public class InsTblUnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_unt_id")
	private Integer iUntId;

	@Temporal(TemporalType.DATE)
	@Column(name="d_unt_dte_rgs")
	private Date dUntDteRgs;

	@Column(name="i_lvl_id")
	private Integer iLvlId;

	@Column(name="i_unt_cde")
	private Integer iUntCde;

	@Column(name="s_unt_acr")
	private String sUntAcr;

	@Column(name="s_unt_nme")
	private String sUntNme;

	@Column(name="s_unt_tme_rgs")
	private String sUntTmeRgs;

	//bi-directional many-to-one association to InsTblApn
	@OneToMany(mappedBy="insTblUnt")
	private List<InsTblApn> insTblApns;

	//bi-directional many-to-one association to InsTblEnt
	@ManyToOne
	@JoinColumn(name="i_ent_cde")
	private InsTblEnt insTblEnt;

	public InsTblUnt() {
	}

	public Integer getIUntId() {
		return this.iUntId;
	}

	public void setIUntId(Integer iUntId) {
		this.iUntId = iUntId;
	}

	public Date getDUntDteRgs() {
		return this.dUntDteRgs;
	}

	public void setDUntDteRgs(Date dUntDteRgs) {
		this.dUntDteRgs = dUntDteRgs;
	}

	public Integer getILvlId() {
		return this.iLvlId;
	}

	public void setILvlId(Integer iLvlId) {
		this.iLvlId = iLvlId;
	}

	public Integer getIUntCde() {
		return this.iUntCde;
	}

	public void setIUntCde(Integer iUntCde) {
		this.iUntCde = iUntCde;
	}

	public String getSUntAcr() {
		return this.sUntAcr;
	}

	public void setSUntAcr(String sUntAcr) {
		this.sUntAcr = sUntAcr;
	}

	public String getSUntNme() {
		return this.sUntNme;
	}

	public void setSUntNme(String sUntNme) {
		this.sUntNme = sUntNme;
	}

	public String getSUntTmeRgs() {
		return this.sUntTmeRgs;
	}

	public void setSUntTmeRgs(String sUntTmeRgs) {
		this.sUntTmeRgs = sUntTmeRgs;
	}

	public List<InsTblApn> getInsTblApns() {
		return this.insTblApns;
	}

	public void setInsTblApns(List<InsTblApn> insTblApns) {
		this.insTblApns = insTblApns;
	}

	public InsTblApn addInsTblApn(InsTblApn insTblApn) {
		getInsTblApns().add(insTblApn);
		insTblApn.setInsTblUnt(this);

		return insTblApn;
	}

	public InsTblApn removeInsTblApn(InsTblApn insTblApn) {
		getInsTblApns().remove(insTblApn);
		insTblApn.setInsTblUnt(null);

		return insTblApn;
	}

	public InsTblEnt getInsTblEnt() {
		return this.insTblEnt;
	}

	public void setInsTblEnt(InsTblEnt insTblEnt) {
		this.insTblEnt = insTblEnt;
	}

}