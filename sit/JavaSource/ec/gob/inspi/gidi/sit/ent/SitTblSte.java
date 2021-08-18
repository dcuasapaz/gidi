package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sit_tbl_ste database table.
 * 
 */
@Entity
@Table(name="sit_tbl_ste")
@NamedQuery(name="SitTblSte.findAll", query="SELECT s FROM SitTblSte s")
public class SitTblSte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_ste_id")
	private Integer iSteId;

	@Column(name="i_prj_id")
	private Integer iPrjId;

	@Column(name="s_ste_nme")
	private String sSteNme;

	//bi-directional many-to-one association to SitTblNmb
	@OneToMany(mappedBy="sitTblSte")
	private List<SitTblNmb> sitTblNmbs;

	public SitTblSte() {
	}

	public Integer getISteId() {
		return this.iSteId;
	}

	public void setISteId(Integer iSteId) {
		this.iSteId = iSteId;
	}

	public Integer getIPrjId() {
		return this.iPrjId;
	}

	public void setIPrjId(Integer iPrjId) {
		this.iPrjId = iPrjId;
	}

	public String getSSteNme() {
		return this.sSteNme;
	}

	public void setSSteNme(String sSteNme) {
		this.sSteNme = sSteNme;
	}

	public List<SitTblNmb> getSitTblNmbs() {
		return this.sitTblNmbs;
	}

	public void setSitTblNmbs(List<SitTblNmb> sitTblNmbs) {
		this.sitTblNmbs = sitTblNmbs;
	}

	public SitTblNmb addSitTblNmb(SitTblNmb sitTblNmb) {
		getSitTblNmbs().add(sitTblNmb);
		sitTblNmb.setSitTblSte(this);

		return sitTblNmb;
	}

	public SitTblNmb removeSitTblNmb(SitTblNmb sitTblNmb) {
		getSitTblNmbs().remove(sitTblNmb);
		sitTblNmb.setSitTblSte(null);

		return sitTblNmb;
	}

}