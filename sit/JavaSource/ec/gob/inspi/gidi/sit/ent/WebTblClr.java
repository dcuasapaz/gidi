package ec.gob.inspi.gidi.sit.ent;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the web_tbl_clr database table.
 * 
 */
@Entity
@Table(name="web_tbl_clr")
@NamedQuery(name="WebTblClr.findAll", query="SELECT w FROM WebTblClr w")
public class WebTblClr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="i_clr_id")
	private Integer iClrId;

	@Column(name="s_clr_dsc")
	private String sClrDsc;

	@Column(name="s_clr_hex")
	private String sClrHex;

	@Column(name="s_clr_nme")
	private String sClrNme;

	@Column(name="s_clr_rgb")
	private String sClrRgb;

	public WebTblClr() {
	}

	public Integer getIClrId() {
		return this.iClrId;
	}

	public void setIClrId(Integer iClrId) {
		this.iClrId = iClrId;
	}

	public String getSClrDsc() {
		return this.sClrDsc;
	}

	public void setSClrDsc(String sClrDsc) {
		this.sClrDsc = sClrDsc;
	}

	public String getSClrHex() {
		return this.sClrHex;
	}

	public void setSClrHex(String sClrHex) {
		this.sClrHex = sClrHex;
	}

	public String getSClrNme() {
		return this.sClrNme;
	}

	public void setSClrNme(String sClrNme) {
		this.sClrNme = sClrNme;
	}

	public String getSClrRgb() {
		return this.sClrRgb;
	}

	public void setSClrRgb(String sClrRgb) {
		this.sClrRgb = sClrRgb;
	}

}