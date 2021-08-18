package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ins_tbl_ent database table.
 * 
 */
@Entity
@Table(name="ins_tbl_ent")
@NamedQuery(name="InsTblEnt.findAll", query="SELECT i FROM InsTblEnt i")
public class InsTblEnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_ent_cde")
	private Integer iEntCde;

	@Temporal(TemporalType.DATE)
	@Column(name="d_ent_dte_rgs")
	private Date dEntDteRgs;

	@Column(name="i_cnr_id")
	private Integer iCnrId;

	@Column(name="i_lvl_id")
	private Integer iLvlId;

	@Column(name="i_tpe_id")
	private Integer iTpeId;

	@Column(name="s_ent_acr")
	private String sEntAcr;

	@Column(name="s_ent_cde")
	private String sEntCde;

	@Column(name="s_ent_nme")
	private String sEntNme;

	@Column(name="s_ent_tme_rgs")
	private String sEntTmeRgs;

	//bi-directional many-to-one association to InsTblUnt
	@OneToMany(mappedBy="insTblEnt")
	private List<InsTblUnt> insTblUnts;

	public InsTblEnt() {
	}

	public Integer getIEntCde() {
		return this.iEntCde;
	}

	public void setIEntCde(Integer iEntCde) {
		this.iEntCde = iEntCde;
	}

	public Date getDEntDteRgs() {
		return this.dEntDteRgs;
	}

	public void setDEntDteRgs(Date dEntDteRgs) {
		this.dEntDteRgs = dEntDteRgs;
	}

	public Integer getICnrId() {
		return this.iCnrId;
	}

	public void setICnrId(Integer iCnrId) {
		this.iCnrId = iCnrId;
	}

	public Integer getILvlId() {
		return this.iLvlId;
	}

	public void setILvlId(Integer iLvlId) {
		this.iLvlId = iLvlId;
	}

	public Integer getITpeId() {
		return this.iTpeId;
	}

	public void setITpeId(Integer iTpeId) {
		this.iTpeId = iTpeId;
	}

	public String getSEntAcr() {
		return this.sEntAcr;
	}

	public void setSEntAcr(String sEntAcr) {
		this.sEntAcr = sEntAcr;
	}

	public String getSEntCde() {
		return this.sEntCde;
	}

	public void setSEntCde(String sEntCde) {
		this.sEntCde = sEntCde;
	}

	public String getSEntNme() {
		return this.sEntNme;
	}

	public void setSEntNme(String sEntNme) {
		this.sEntNme = sEntNme;
	}

	public String getSEntTmeRgs() {
		return this.sEntTmeRgs;
	}

	public void setSEntTmeRgs(String sEntTmeRgs) {
		this.sEntTmeRgs = sEntTmeRgs;
	}

	public List<InsTblUnt> getInsTblUnts() {
		return this.insTblUnts;
	}

	public void setInsTblUnts(List<InsTblUnt> insTblUnts) {
		this.insTblUnts = insTblUnts;
	}

	public InsTblUnt addInsTblUnt(InsTblUnt insTblUnt) {
		getInsTblUnts().add(insTblUnt);
		insTblUnt.setInsTblEnt(this);

		return insTblUnt;
	}

	public InsTblUnt removeInsTblUnt(InsTblUnt insTblUnt) {
		getInsTblUnts().remove(insTblUnt);
		insTblUnt.setInsTblEnt(null);

		return insTblUnt;
	}

}