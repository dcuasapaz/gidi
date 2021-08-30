package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the web_tbl_mnu_sub database table.
 * 
 */
@Entity
@Table(name = "web_tbl_mnu_sub")
@NamedQuery(name = "WebTblMnuSub.findAll", query = "SELECT w FROM WebTblMnuSub w")
public class WebTblMnuSub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_mnu_sub_id")
	private Integer iMnuSubId;

	@Column(name = "i_mnu_sub_ctg")
	private Integer iMnuSubCtg;

	@Column(name = "s_mnu_sub_dsc")
	private String sMnuSubDsc;

	@Column(name = "s_mnu_sub_icn")
	private String sMnuSubIcn;

	@Column(name = "s_mnu_sub_lnk")
	private String sMnuSubLnk;

	@Column(name = "s_mnu_sub_nme")
	private String sMnuSubName;

	@Column(name = "i_mdl_id")
	private Integer IMdlId;
	
	@Column(name = "b_mnu_sub_stt")
	private boolean BMnuSubStt;

	// bi-directional many-to-one association to WebTblMnu
	@ManyToOne
	@JoinColumn(name = "i_mnu_id")
	private WebTblMnu webTblMnu;

	public WebTblMnuSub() {
	}

	public Integer getIMdlId() {
		return IMdlId;
	}

	public void setIMdlId(Integer iMdlId) {
		IMdlId = iMdlId;
	}

	public Integer getIMnuSubId() {
		return this.iMnuSubId;
	}

	public void setIMnuSubId(Integer iMnuSubId) {
		this.iMnuSubId = iMnuSubId;
	}

	public Integer getIMnuSubCtg() {
		return this.iMnuSubCtg;
	}

	public void setIMnuSubCtg(Integer iMnuSubCtg) {
		this.iMnuSubCtg = iMnuSubCtg;
	}

	public String getSMnuSubDsc() {
		return this.sMnuSubDsc;
	}

	public void setSMnuSubDsc(String sMnuSubDsc) {
		this.sMnuSubDsc = sMnuSubDsc;
	}

	public String getSMnuSubIcn() {
		return this.sMnuSubIcn;
	}

	public void setSMnuSubIcn(String sMnuSubIcn) {
		this.sMnuSubIcn = sMnuSubIcn;
	}

	public String getSMnuSubLnk() {
		return this.sMnuSubLnk;
	}

	public void setSMnuSubLnk(String sMnuSubLnk) {
		this.sMnuSubLnk = sMnuSubLnk;
	}

	public String getSMnuSubName() {
		return this.sMnuSubName;
	}

	public void setSMnuSubName(String sMnuSubName) {
		this.sMnuSubName = sMnuSubName;
	}

	public WebTblMnu getWebTblMnu() {
		return this.webTblMnu;
	}

	public void setWebTblMnu(WebTblMnu webTblMnu) {
		this.webTblMnu = webTblMnu;
	}

	public boolean getBMnuSubStt() {
		return BMnuSubStt;
	}

	public void setBMnuSubStt(boolean bMnuSubStt) {
		BMnuSubStt = bMnuSubStt;
	}

}