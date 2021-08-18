package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dpa_tbl_sbc database table.
 * 
 */
@Entity
@Table(name="dpa_tbl_sbc")
@NamedQuery(name="DpaTblSbc.findAll", query="SELECT d FROM DpaTblSbc d")
public class DpaTblSbc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_sbc_cde")
	private Integer iSbcCde;

	@Column(name="i_dst_cde")
	private Integer iDstCde;

	@Column(name="i_prv_cde")
	private Integer iPrvCde;

	@Column(name="i_sbc_anio")
	private Integer iSbcAnio;

	@Column(name="s_sbc_cde")
	private String sSbcCde;

	@Column(name="s_sbc_cls")
	private String sSbcCls;

	@Column(name="s_sbc_intrv")
	private String sSbcIntrv;

	@Column(name="s_sbc_nme")
	private String sSbcNme;

	@Column(name="s_sbc_tpe")
	private String sSbcTpe;

	//bi-directional many-to-one association to DpaTblCrc
	@ManyToOne
	@JoinColumn(name="i_crc_cde")
	private DpaTblCrc dpaTblCrc;

	public DpaTblSbc() {
	}

	public Integer getISbcCde() {
		return this.iSbcCde;
	}

	public void setISbcCde(Integer iSbcCde) {
		this.iSbcCde = iSbcCde;
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

	public Integer getISbcAnio() {
		return this.iSbcAnio;
	}

	public void setISbcAnio(Integer iSbcAnio) {
		this.iSbcAnio = iSbcAnio;
	}

	public String getSSbcCde() {
		return this.sSbcCde;
	}

	public void setSSbcCde(String sSbcCde) {
		this.sSbcCde = sSbcCde;
	}

	public String getSSbcCls() {
		return this.sSbcCls;
	}

	public void setSSbcCls(String sSbcCls) {
		this.sSbcCls = sSbcCls;
	}

	public String getSSbcIntrv() {
		return this.sSbcIntrv;
	}

	public void setSSbcIntrv(String sSbcIntrv) {
		this.sSbcIntrv = sSbcIntrv;
	}

	public String getSSbcNme() {
		return this.sSbcNme;
	}

	public void setSSbcNme(String sSbcNme) {
		this.sSbcNme = sSbcNme;
	}

	public String getSSbcTpe() {
		return this.sSbcTpe;
	}

	public void setSSbcTpe(String sSbcTpe) {
		this.sSbcTpe = sSbcTpe;
	}

	public DpaTblCrc getDpaTblCrc() {
		return this.dpaTblCrc;
	}

	public void setDpaTblCrc(DpaTblCrc dpaTblCrc) {
		this.dpaTblCrc = dpaTblCrc;
	}

}