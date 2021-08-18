package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the web_tbl_mnu_sub database table.
 * 
 */
@Entity
@Table(name="web_tbl_mnu_sub")
@NamedQuery(name="WebTblMnuSub.findAll", query="SELECT w FROM WebTblMnuSub w")
public class WebTblMnuSub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_mnu_sub_id")
	private Integer iMnuSubId;

	@Column(name="b_mnu_sub_stt")
	private Boolean bMnuSubStt;

	@Column(name="i_mdl_id")
	private Integer iMdlId;

	@Column(name="i_mnu_id")
	private Integer iMnuId;

	@Column(name="i_mnu_sub_ctg")
	private Integer iMnuSubCtg;

	@Column(name="s_mnu_sub_dsc")
	private String sMnuSubDsc;

	@Column(name="s_mnu_sub_img")
	private String sMnuSubImg;

	@Column(name="s_mnu_sub_lnk")
	private String sMnuSubLnk;

	@Column(name="s_mnu_sub_nme")
	private String sMnuSubNme;

	public WebTblMnuSub() {
	}

	public Integer getIMnuSubId() {
		return this.iMnuSubId;
	}

	public void setIMnuSubId(Integer iMnuSubId) {
		this.iMnuSubId = iMnuSubId;
	}

	public Boolean getBMnuSubStt() {
		return this.bMnuSubStt;
	}

	public void setBMnuSubStt(Boolean bMnuSubStt) {
		this.bMnuSubStt = bMnuSubStt;
	}

	public Integer getIMdlId() {
		return this.iMdlId;
	}

	public void setIMdlId(Integer iMdlId) {
		this.iMdlId = iMdlId;
	}

	public Integer getIMnuId() {
		return this.iMnuId;
	}

	public void setIMnuId(Integer iMnuId) {
		this.iMnuId = iMnuId;
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

	public String getSMnuSubImg() {
		return this.sMnuSubImg;
	}

	public void setSMnuSubImg(String sMnuSubImg) {
		this.sMnuSubImg = sMnuSubImg;
	}

	public String getSMnuSubLnk() {
		return this.sMnuSubLnk;
	}

	public void setSMnuSubLnk(String sMnuSubLnk) {
		this.sMnuSubLnk = sMnuSubLnk;
	}

	public String getSMnuSubNme() {
		return this.sMnuSubNme;
	}

	public void setSMnuSubNme(String sMnuSubNme) {
		this.sMnuSubNme = sMnuSubNme;
	}

}