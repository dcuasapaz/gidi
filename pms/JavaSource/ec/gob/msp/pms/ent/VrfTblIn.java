package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vrf_tbl_ins database table.
 * 
 */
@Entity
@Table(name="vrf_tbl_ins")
@NamedQuery(name="VrfTblIn.findAll", query="SELECT v FROM VrfTblIn v")
public class VrfTblIn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_ins_id")
	private Integer iInsId;

	@Column(name="s_ins_acr")
	private String sInsAcr;

	@Column(name="s_ins_nme")
	private String sInsNme;

	//bi-directional many-to-one association to VrfTblInsMnc
	@OneToMany(mappedBy="vrfTblIn")
	private List<VrfTblInsMnc> vrfTblInsMncs;

	public VrfTblIn() {
	}

	public Integer getIInsId() {
		return this.iInsId;
	}

	public void setIInsId(Integer iInsId) {
		this.iInsId = iInsId;
	}

	public String getSInsAcr() {
		return this.sInsAcr;
	}

	public void setSInsAcr(String sInsAcr) {
		this.sInsAcr = sInsAcr;
	}

	public String getSInsNme() {
		return this.sInsNme;
	}

	public void setSInsNme(String sInsNme) {
		this.sInsNme = sInsNme;
	}

	public List<VrfTblInsMnc> getVrfTblInsMncs() {
		return this.vrfTblInsMncs;
	}

	public void setVrfTblInsMncs(List<VrfTblInsMnc> vrfTblInsMncs) {
		this.vrfTblInsMncs = vrfTblInsMncs;
	}

	public VrfTblInsMnc addVrfTblInsMnc(VrfTblInsMnc vrfTblInsMnc) {
		getVrfTblInsMncs().add(vrfTblInsMnc);
		vrfTblInsMnc.setVrfTblIn(this);

		return vrfTblInsMnc;
	}

	public VrfTblInsMnc removeVrfTblInsMnc(VrfTblInsMnc vrfTblInsMnc) {
		getVrfTblInsMncs().remove(vrfTblInsMnc);
		vrfTblInsMnc.setVrfTblIn(null);

		return vrfTblInsMnc;
	}

}