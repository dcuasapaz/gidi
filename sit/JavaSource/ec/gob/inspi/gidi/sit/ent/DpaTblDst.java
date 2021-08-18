package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dpa_tbl_dst database table.
 * 
 */
@Entity
@Table(name="dpa_tbl_dst")
@NamedQuery(name="DpaTblDst.findAll", query="SELECT d FROM DpaTblDst d")
public class DpaTblDst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_dst_cde")
	private Integer iDstCde;

	@Column(name="i_prv_cde")
	private Integer iPrvCde;

	@Column(name="i_zna_cde")
	private Integer iZnaCde;

	@Column(name="s_dst_cde")
	private String sDstCde;

	@Column(name="s_dst_nme")
	private String sDstNme;

	//bi-directional many-to-one association to DpaTblCrc
	@OneToMany(mappedBy="dpaTblDst")
	private List<DpaTblCrc> dpaTblCrcs;

	public DpaTblDst() {
	}

	public Integer getIDstCde() {
		return this.iDstCde;
	}

	public void setIDstCde(Integer iDstCde) {
		this.iDstCde = iDstCde;
	}

	public Integer getIPrvCde() {
		return this.iPrvCde;
	}

	public void setIPrvCde(Integer iPrvCde) {
		this.iPrvCde = iPrvCde;
	}

	public Integer getIZnaCde() {
		return this.iZnaCde;
	}

	public void setIZnaCde(Integer iZnaCde) {
		this.iZnaCde = iZnaCde;
	}

	public String getSDstCde() {
		return this.sDstCde;
	}

	public void setSDstCde(String sDstCde) {
		this.sDstCde = sDstCde;
	}

	public String getSDstNme() {
		return this.sDstNme;
	}

	public void setSDstNme(String sDstNme) {
		this.sDstNme = sDstNme;
	}

	public List<DpaTblCrc> getDpaTblCrcs() {
		return this.dpaTblCrcs;
	}

	public void setDpaTblCrcs(List<DpaTblCrc> dpaTblCrcs) {
		this.dpaTblCrcs = dpaTblCrcs;
	}

	public DpaTblCrc addDpaTblCrc(DpaTblCrc dpaTblCrc) {
		getDpaTblCrcs().add(dpaTblCrc);
		dpaTblCrc.setDpaTblDst(this);

		return dpaTblCrc;
	}

	public DpaTblCrc removeDpaTblCrc(DpaTblCrc dpaTblCrc) {
		getDpaTblCrcs().remove(dpaTblCrc);
		dpaTblCrc.setDpaTblDst(null);

		return dpaTblCrc;
	}

}