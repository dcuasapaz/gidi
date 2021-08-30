package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ind_tbl_lvl database table.
 * 
 */
@Entity
@Table(name="ind_tbl_lvl")
@NamedQuery(name="IndTblLvl.findAll", query="SELECT i FROM IndTblLvl i")
public class IndTblLvl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_lvl_cde")
	private Integer iLvlCde;

	@Column(name="i_lvl_fth")
	private Integer iLvlFth;

	@Column(name="s_lvl_nme")
	private String sLvlNme;

	@Column(name="s_lvl_pth")
	private String sLvlPth;

	//bi-directional many-to-one association to IndTblMain
	@OneToMany(mappedBy="indTblLvl")
	private List<IndTblMain> indTblMains;

	public IndTblLvl() {
	}

	public Integer getILvlCde() {
		return this.iLvlCde;
	}

	public void setILvlCde(Integer iLvlCde) {
		this.iLvlCde = iLvlCde;
	}

	public Integer getILvlFth() {
		return this.iLvlFth;
	}

	public void setILvlFth(Integer iLvlFth) {
		this.iLvlFth = iLvlFth;
	}

	public String getSLvlNme() {
		return this.sLvlNme;
	}

	public void setSLvlNme(String sLvlNme) {
		this.sLvlNme = sLvlNme;
	}

	public String getSLvlPth() {
		return this.sLvlPth;
	}

	public void setSLvlPth(String sLvlPth) {
		this.sLvlPth = sLvlPth;
	}

	public List<IndTblMain> getIndTblMains() {
		return this.indTblMains;
	}

	public void setIndTblMains(List<IndTblMain> indTblMains) {
		this.indTblMains = indTblMains;
	}

	public IndTblMain addIndTblMain(IndTblMain indTblMain) {
		getIndTblMains().add(indTblMain);
		indTblMain.setIndTblLvl(this);

		return indTblMain;
	}

	public IndTblMain removeIndTblMain(IndTblMain indTblMain) {
		getIndTblMains().remove(indTblMain);
		indTblMain.setIndTblLvl(null);

		return indTblMain;
	}

}