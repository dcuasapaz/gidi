package ec.gob.msp.pms.ent;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the web_tbl_mnu database table.
 * 
 */
@Entity
@Table(name="web_tbl_mnu")
@NamedQuery(name="WebTblMnu.findAll", query="SELECT w FROM WebTblMnu w")
public class WebTblMnu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_mnu_id")
	private Integer iMnuId;

	@Column(name="b_mnu_stt")
	private Boolean bMnuStt;

	@Column(name="i_clr_id")
	private Integer iClrId;

	@Column(name="i_mnu_ctg")
	private Integer iMnuCtg;

	@Column(name="i_rol_id")
	private Integer iRolId;

	@Column(name="s_mnu_dsc")
	private String sMnuDsc;

	@Column(name="s_mnu_img")
	private String sMnuImg;

	@Column(name="s_mnu_lnk")
	private String sMnuLnk;

	@Column(name="s_mnu_nme")
	private String sMnuNme;

	//bi-directional many-to-one association to WebTblMnuSub
	@OneToMany(mappedBy="webTblMnu")
	private List<WebTblMnuSub> webTblMnuSubs;

	public WebTblMnu() {
	}

	public Integer getIMnuId() {
		return this.iMnuId;
	}

	public void setIMnuId(Integer iMnuId) {
		this.iMnuId = iMnuId;
	}

	public Boolean getBMnuStt() {
		return this.bMnuStt;
	}

	public void setBMnuStt(Boolean bMnuStt) {
		this.bMnuStt = bMnuStt;
	}

	public Integer getIClrId() {
		return this.iClrId;
	}

	public void setIClrId(Integer iClrId) {
		this.iClrId = iClrId;
	}

	public Integer getIMnuCtg() {
		return this.iMnuCtg;
	}

	public void setIMnuCtg(Integer iMnuCtg) {
		this.iMnuCtg = iMnuCtg;
	}

	public Integer getIRolId() {
		return this.iRolId;
	}

	public void setIRolId(Integer iRolId) {
		this.iRolId = iRolId;
	}

	public String getSMnuDsc() {
		return this.sMnuDsc;
	}

	public void setSMnuDsc(String sMnuDsc) {
		this.sMnuDsc = sMnuDsc;
	}

	public String getSMnuImg() {
		return this.sMnuImg;
	}

	public void setSMnuImg(String sMnuImg) {
		this.sMnuImg = sMnuImg;
	}

	public String getSMnuLnk() {
		return this.sMnuLnk;
	}

	public void setSMnuLnk(String sMnuLnk) {
		this.sMnuLnk = sMnuLnk;
	}

	public String getSMnuNme() {
		return this.sMnuNme;
	}

	public void setSMnuNme(String sMnuNme) {
		this.sMnuNme = sMnuNme;
	}

	public List<WebTblMnuSub> getWebTblMnuSubs() {
		return this.webTblMnuSubs;
	}

	public void setWebTblMnuSubs(List<WebTblMnuSub> webTblMnuSubs) {
		this.webTblMnuSubs = webTblMnuSubs;
	}

	public WebTblMnuSub addWebTblMnuSub(WebTblMnuSub webTblMnuSub) {
		getWebTblMnuSubs().add(webTblMnuSub);
		webTblMnuSub.setWebTblMnu(this);

		return webTblMnuSub;
	}

	public WebTblMnuSub removeWebTblMnuSub(WebTblMnuSub webTblMnuSub) {
		getWebTblMnuSubs().remove(webTblMnuSub);
		webTblMnuSub.setWebTblMnu(null);

		return webTblMnuSub;
	}

}