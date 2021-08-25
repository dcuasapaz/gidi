package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dpa_tbl_crc database table.
 * 
 */
@Entity
@Table(name="dpa_tbl_crc")
@NamedQuery(name="DpaTblCrc.findAll", query="SELECT d FROM DpaTblCrc d")
public class DpaTblCrc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_crc_cde")
	private Integer iCrcCde;

	@Column(name="i_prv_cde")
	private Integer iPrvCde;

	@Column(name="s_crc_cde")
	private String sCrcCde;

	@Column(name="s_crc_nme")
	private String sCrcNme;

	//bi-directional many-to-one association to DpaTblDst
	@ManyToOne
	@JoinColumn(name="i_dst_cde")
	private DpaTblDst dpaTblDst;

	//bi-directional many-to-one association to DpaTblSbc
	@OneToMany(mappedBy="dpaTblCrc")
	private List<DpaTblSbc> dpaTblSbcs;

	public DpaTblCrc() {
	}

	public Integer getICrcCde() {
		return this.iCrcCde;
	}

	public void setICrcCde(Integer iCrcCde) {
		this.iCrcCde = iCrcCde;
	}

	public Integer getIPrvCde() {
		return this.iPrvCde;
	}

	public void setIPrvCde(Integer iPrvCde) {
		this.iPrvCde = iPrvCde;
	}

	public String getSCrcCde() {
		return this.sCrcCde;
	}

	public void setSCrcCde(String sCrcCde) {
		this.sCrcCde = sCrcCde;
	}

	public String getSCrcNme() {
		return this.sCrcNme;
	}

	public void setSCrcNme(String sCrcNme) {
		this.sCrcNme = sCrcNme;
	}

	public DpaTblDst getDpaTblDst() {
		return this.dpaTblDst;
	}

	public void setDpaTblDst(DpaTblDst dpaTblDst) {
		this.dpaTblDst = dpaTblDst;
	}

	public List<DpaTblSbc> getDpaTblSbcs() {
		return this.dpaTblSbcs;
	}

	public void setDpaTblSbcs(List<DpaTblSbc> dpaTblSbcs) {
		this.dpaTblSbcs = dpaTblSbcs;
	}

	public DpaTblSbc addDpaTblSbc(DpaTblSbc dpaTblSbc) {
		getDpaTblSbcs().add(dpaTblSbc);
		dpaTblSbc.setDpaTblCrc(this);

		return dpaTblSbc;
	}

	public DpaTblSbc removeDpaTblSbc(DpaTblSbc dpaTblSbc) {
		getDpaTblSbcs().remove(dpaTblSbc);
		dpaTblSbc.setDpaTblCrc(null);

		return dpaTblSbc;
	}

}