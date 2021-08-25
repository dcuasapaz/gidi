package ec.gob.inspi.gidi.sit.cmm;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Html {
	public Html() {
		// TODO Auto-generated constructor stub
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/*
	 * L: LABEL; O: OPTION; P: PLACEHOLDER; I: IMAGE;
	 */
	/*---------------------------------------------------------------------------------------------------------*/

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ PAGE: LOGIN ++++++++++++++++++++++++++++ */
	/****************************************************************************/

	public final String L_PRS_USR() {
		return "User/Email *:";
	}

	public final String L_PRS_PSW() {
		return "Password *:";
	}

	public final String L_SCR_PRF() {
		return "Profile *:";
	}

	public final String O_SCR_PRF() {
		return "Select Profile *:";
	}

	public final String P_PRS_USR() {
		return "Enter Email/User";
	}

	public String P_PRS_PSW() {
		return "Enter Password";
	}
	
	public String I_LGO_SECUNDATY() {
		return "/img/lgo/gidi.png";
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Title */
	/*---------------------------------------------------------------------------------------------------------*/
	public String ttlPgeField = "Field";

	public String imgLoad = "/img/gif/load.gif";
	public String slcOne = "Select one";
	public String dteYr = "Year";
	public String dteMth = "Month";
	public String dteDay = "Day";
	public String dteEpiWek = "Epi Week";

	/*** Adult ***/
	private String sitTtlAdl = "Adult";
	private String sitLblAdlNmb = "Number:";
	private String sitLblAdlSex = "Sex:";
	private String sitLblAdlSpc = "Genus/Species:";

	/*** Professional ***/
	private String sitTtlPfs = "Professional";
	private String sitLblPfsAgn = "Field agent:";
	private String sitLblPfsTch = "Lab technician:";

	/*---------------------------------------------------------------------------------------------------------*/
	/* IMAGES: */
	/*---------------------------------------------------------------------------------------------------------*/
	public String imgLdn = "/img/gif/load.gif";
	public String imgUsrs = "/img/users.png";

	/*---------------------------------------------------------------------------------------------------------*/
	/* ICONS: */
	/*---------------------------------------------------------------------------------------------------------*/
	public String hme = "hme";
	public String add = "add";
	public String addUsr = "addUsr";
	public String nvo = "new";
	public String sve = "sve";
	public String upd = "upd";
	public String dlt = "dlt";
	public String src = "src";
	public String rfr = "rfr";
	public String edt = "edt";
	public String arw = "arw";

	public String pdf = "pdf";
	public String xls = "xls";
	public String fle = "fle";

	public String png = "png";
	public String jpg = "jpg";
	public String gif = "gif";
	public String pthIcn = "/img/icn/";

	public String icn(String icn, int sze, String frm) {
		String icono = "";
		if (this.add.compareTo(icn) == 0) {
			icono = pthIcn + add + sze + "." + frm;
		} else if (this.nvo.compareTo(icn) == 0) {
			icono = pthIcn + nvo + sze + "." + frm;
		} else if (this.sve.compareTo(icn) == 0) {
			icono = pthIcn + sve + sze + "." + frm;
		} else if (this.upd.compareTo(icn) == 0) {
			icono = pthIcn + upd + sze + "." + frm;
		} else if (this.dlt.compareTo(icn) == 0) {
			icono = pthIcn + dlt + sze + "." + frm;
		} else if (this.src.compareTo(icn) == 0) {
			icono = pthIcn + src + sze + "." + frm;
		} else if (this.rfr.compareTo(icn) == 0) {
			icono = pthIcn + rfr + sze + "." + frm;
		} else if (this.edt.compareTo(icn) == 0) {
			icono = pthIcn + edt + sze + "." + frm;
		} else if (this.pdf.compareTo(icn) == 0) {
			icono = pthIcn + pdf + sze + "." + frm;
		} else if (this.xls.compareTo(icn) == 0) {
			icono = pthIcn + xls + sze + "." + frm;
		} else if (this.addUsr.compareTo(icn) == 0) {
			icono = pthIcn + addUsr + sze + "." + frm;
		} else if (this.hme.compareTo(icn) == 0) {
			icono = pthIcn + hme + sze + "." + frm;
		}

		return icono;

	}

	public String icono(String icn, int sze, String frm) {
		return pthIcn + icn + sze + "." + frm;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Login */
	/*---------------------------------------------------------------------------------------------------------*/
	public String plhEmlAln = "Email *";

	public String lblBtn = "Login";
	public String lblLnkCrt = "Crear Cuenta";
	public String lblLnkRst = "Recuperar Contrase�a";
	public String ttlPgeLgn = "Login";
	public String lblBtnNxt = "Continuar";
	public String lnkMain = "http://www.investigacionsalud.gob.ec/";
	public String lnkSecundary = "http://www.investigacionsalud.gob.ec/webs/cirev/";
	public String lnkOeia = "https://www.iaea.org/";

	public String lgoMain = "/img/lgo/main.png";
	
	public String lgoOeia = "/img/lgo/oiea_nrm.png";

	public String getPlhEmlAln() {
		return plhEmlAln;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Create account */
	/*---------------------------------------------------------------------------------------------------------*/
	public String ttlPgeRgs = "Crear cuenta";

	public String ttlPgeRgsGood = "Usuario Registrado Correctamente";
	public String ttlPgeRgsError = "Usuario No Se Registro Correctamente";

	public String plhEmail = "Correo electr�nico *";
	public String plhEmailMsg = "Su correo electr�nico es su nombre de usuario";

	public String plhPsw = "Contrase�a *";
	public String plhPswMsg = "La contrase�a debe tener letras may�sculas y min�sculas, al menos un n�mero, no coincidir con ninguna parte de su correo electr�nico y tener al menos 8 caracteres";

	public String plhPswRpt = "Confirmar Contrase�a *";
	public String plhGrt = "Saludo *";
	public String plhNme = "Nombres *";
	public String plhLstNme = "Apellidos *";
	public String plhCnr = "Pa�s *";
	public String plhCty = "Ciudad *";
	public String plhPhn = "Tel�fono celular ";
	public String plhEmailAlt = "Correo electr�nico alternativo ";

	public String plhTpeEnt = "Tipo Instituci�n *";
	public String plhEnt = "Instituci�n *";
	public String plhEntOth = "Otra Instituci�n *";
	public String plhUnt = "�rea *";
	public String plhUntOth = "Otra �rea *";
	public String plhApn = "Cargo *";
	public String plhApnOth = "Otro Cargo *";

	public String plhAcd = "Grado acad�mico *";
	public String plhDsc = "Disciplina *";
	public String plhDscSub = "Subdisciplina *";

	/*---------------------------------------------------------------------------------------------------------*/
	/* OBJECTS: Buttons */
	/*---------------------------------------------------------------------------------------------------------*/
	public String lblBtnCrtAcc = "Crear cuenta";
	/*---------------------------------------------------------------------------------------------------------*/
	/* OBJECTS: List */
	/*---------------------------------------------------------------------------------------------------------*/
	private String msgLstEmpty = "* No se encontrar�n registros *";

	public String getMsgLstEmpty() {
		return msgLstEmpty;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Prf My Profile */
	/*---------------------------------------------------------------------------------------------------------*/
	public String ttlPgeMyPfl = "Mi Perfil";

	public String ttlPgeEvents = "Eventos";

	public String ttlBtnHme = "Inicio";
	public String ttlBtnNew = "Nuevo registro";
	public String ttlBtnAdd = "A�adir registro";
	public String ttlBtnSve = "Guardar registro";
	public String ttlBtnEdt = "Editar registro";
	public String ttlBtnDlt = "Eliminar regsitro";
	public String ttlBtnSee = "Ver registro";
	public String ttlBtnUpd = "Guardar cambios";
	public String ttlBtnRfr = "Refrescar";

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Tsk */
	/*---------------------------------------------------------------------------------------------------------*/
	public String ttlPgeTask = "Actividades";
	public String ttlPgeMnuTask = "Men�";
	public String imgTask = "/img/icn/mdl_tsk.png";
	public String lblTask = "Actividades";
	public String pgeMnuTask = "/prf/menu_task.jsf";
	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Date */
	public String SDteYr = "A�o *";
	public String SDteMnt = "Mes *";
	public String SDteDay = "D�a *";

	public String getSDteYr() {
		return SDteYr;
	}

	public String getSDteMnt() {
		return SDteMnt;
	}

	public String getSDteDay() {
		return SDteDay;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------------------------------------*/
	/* MENU: Administrador */
	/*---------------------------------------------------------------------------------------------------------*/
	public String ttlPgeEnt = "Entidad";
	public String ttlPgeUnt = "Unidad/Sub-unidad";
	public String ttlPgeApn = "Puesto";
	public String ttlPgePrsApn = "Profesional - Puesto";
	public String ttlPgePrs = "Profesional";
	public String ttlPgePrf = "Perfil";

	public String getTtlPgePrf() {
		return ttlPgePrf;
	}

	public String getTtlPgePrsApn() {
		return ttlPgePrsApn;
	}

	public String getTtlPgePrs() {
		return ttlPgePrs;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* MENU: Profesional */
	/*---------------------------------------------------------------------------------------------------------*/
	public String ttlPgeTsk = "Registro de Actividades";
	public String ttlPgeRsl = "Registro de Entregables";
	public String ttlPgePrm = "Registro de Permisos";
	public String ttlPgeMain = "Registro de Temas principales";
	public String ttlPgePrt = "Registro de Participantes";

	public String getTtlPgeMain() {
		return ttlPgeMain;
	}

	public String getTtlPgePrm() {
		return ttlPgePrm;
	}

	public String getTtlPgeTsk() {
		return ttlPgeTsk;
	}

	public String getTtlPgeRsl() {
		return ttlPgeRsl;
	}

	public String getTtlPgePrt() {
		return ttlPgePrt;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* MENU: FORM */
	/*---------------------------------------------------------------------------------------------------------*/
	public String hmeBtnId = "frm-btn-hme";
	public String hmeBtnNme = "Inicio";
	public String hmeBtnIcn = "ui-icon-home";
	public String hmeBtnDsc = "Regresar al men� principal";
	public String hmeCsvBtnImg = "/img/icn/home256.png";

	public String newBtnId = "frm-btn-new";
	public String newBtnNme = "Nuevo";
	public String newBtnIcn = "ui-icon-document";

	public String sveBtnId = "frm-btn-sve";
	public String sveBtnNme = "Guardar";
	public String sveBtnIcn = "ui-icon-disk";

	public String shwBtnId = "frm-tbl-btn-shw";
	public String shwBtnNme = "Ver";
	public String shwBtnIcn = "ui-icon-arrowrefresh-1-n";
	public String shwBtnDsc = "Ver detalles de registro";
	public String shwCsvBtnImg = "/img/icn/src16.png";

	public String edtBtnId = "frm-tbl-btn-edt";
	public String edtBtnNme = "Editar";
	public String edtBtnIcn = "ui-icon-pencil";
	public String edtBtnDsc = "Editar registro";
	public String edtCsvBtnImg = "/img/icn/edt16.png";

	public String updBtnId = "frm-btn-upd";
	public String updBtnNme = "Guardar cambios";
	public String updBtnIcn = "ui-icon-disk";

	public String dltBtnId = "frm-tbl-btn-dlt";
	public String dltBtnNme = "Eliminar";
	public String dltBtnIcn = "ui-icon-trash";
	public String dltBtnDsc = "Eliminar registro";
	public String dltCsvBtnImg = "/img/icn/dlt16.png";

	public String rfrBtnId = "frm-btn-rfr";
	public String rfrBtnNme = "Regresar";
	public String rfrBtnIcn = "ui-icon-arrowrefresh-1-n";
	public String rfrBtnDsc = "Recargar ventana";
	public String rfrCsvBtnImg = "/img/icn/refresh256.png";

	public String newBlcId = "frm-blc-btn-new";
	public String sveBlcId = "frm-blc-btn-sve";
	public String updBlcId = "frm-blc-btn-upd";
	public String shwBlcId = "frm-blc-tbl-btn-shw";
	public String edtBlcId = "frm-blc-tbl-btn-edt";
	public String dltBlcId = "frm-blc-tbl-btn-dlt";

	public String dwnCsvBtnId = "frm-btn-dwn-csv";
	public String dwnCsvBtnNme = "Descargar csv";
	public String dwnCsvBtnBtnIcn = "ui-icon-circle-arrow-s";
	public String dwnCsvBtnDsc = "Descargar en CSV";
	public String dwnCsvBtnImg = "/img/icn/csv256.png";

	public String dwnXlsBtnId = "frm-btn-dwn-xls";
	public String dwnXlsBtnNme = "Descargar xls";
	public String dwnXlsBtnBtnIcn = "ui-icon-circle-arrow-s";
	public String dwnXlsBtnDsc = "Descargar en xls";
	public String dwnXlsBtnImg = "/img/icn/xls256.png";

	public String getDwnXlsBtnId() {
		return dwnXlsBtnId;
	}

	public String getDwnXlsBtnNme() {
		return dwnXlsBtnNme;
	}

	public String getDwnXlsBtnBtnIcn() {
		return dwnXlsBtnBtnIcn;
	}

	public String getDwnXlsBtnDsc() {
		return dwnXlsBtnDsc;
	}

	public String getDwnXlsBtnImg() {
		return dwnXlsBtnImg;
	}

	public String getShwBlcId() {
		return shwBlcId;
	}

	public String getShwBtnId() {
		return shwBtnId;
	}

	public String getShwBtnNme() {
		return shwBtnNme;
	}

	public String getShwBtnIcn() {
		return shwBtnIcn;
	}

	public String getShwBtnDsc() {
		return shwBtnDsc;
	}

	public String getShwCsvBtnImg() {
		return shwCsvBtnImg;
	}

	public String getEdtBtnIcn() {
		return edtBtnIcn;
	}

	public String getEdtBtnDsc() {
		return edtBtnDsc;
	}

	public String getEdtCsvBtnImg() {
		return edtCsvBtnImg;
	}

	public String getDltBtnIcn() {
		return dltBtnIcn;
	}

	public String getDltBtnDsc() {
		return dltBtnDsc;
	}

	public String getDltCsvBtnImg() {
		return dltCsvBtnImg;
	}

	public String getHmeCsvBtnImg() {
		return hmeCsvBtnImg;
	}

	public String getRfrCsvBtnImg() {
		return rfrCsvBtnImg;
	}

	public String getDwnCsvBtnImg() {
		return dwnCsvBtnImg;
	}

	public String getHmeBtnDsc() {
		return hmeBtnDsc;
	}

	public String getRfrBtnDsc() {
		return rfrBtnDsc;
	}

	public String getDwnCsvBtnDsc() {
		return dwnCsvBtnDsc;
	}

	public String getDwnCsvBtnId() {
		return dwnCsvBtnId;
	}

	public String getDwnCsvBtnNme() {
		return dwnCsvBtnNme;
	}

	public String getDwnCsvBtnBtnIcn() {
		return dwnCsvBtnBtnIcn;
	}

	public String getNewBlcId() {
		return newBlcId;
	}

	public String getSveBlcId() {
		return sveBlcId;
	}

	public String getUpdBlcId() {
		return updBlcId;
	}

	public String getEdtBlcId() {
		return edtBlcId;
	}

	public String getDltBlcId() {
		return dltBlcId;
	}

	public String getHmeBtnId() {
		return hmeBtnId;
	}

	public String getHmeBtnNme() {
		return hmeBtnNme;
	}

	public String getHmeBtnIcn() {
		return hmeBtnIcn;
	}

	public String getNewBtnId() {
		return newBtnId;
	}

	public String getNewBtnNme() {
		return newBtnNme;
	}

	public String getNewBtnIcn() {
		return newBtnIcn;
	}

	public String getSveBtnId() {
		return sveBtnId;
	}

	public String getSveBtnNme() {
		return sveBtnNme;
	}

	public String getSveBtnIcn() {
		return sveBtnIcn;
	}

	public String getEdtBtnId() {
		return edtBtnId;
	}

	public String getEdtBtnNme() {
		return edtBtnNme;
	}

	public String getUpdBtnId() {
		return updBtnId;
	}

	public String getUpdBtnNme() {
		return updBtnNme;
	}

	public String getUpdBtnIcn() {
		return updBtnIcn;
	}

	public String getDltBtnId() {
		return dltBtnId;
	}

	public String getDltBtnNme() {
		return dltBtnNme;
	}

	public String getRfrBtnId() {
		return rfrBtnId;
	}

	public String getRfrBtnNme() {
		return rfrBtnNme;
	}

	public String getRfrBtnIcn() {
		return rfrBtnIcn;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: ADMIN */
	/*---------------------------------------------------------------------------------------------------------*/
	public String ttlAdmin = "Menu ";
	public String ttlAtrSlc = "Selected";
	public String ttlAtrObl = "Mandatory";
	public String ttlAtrOpt = "OPtional";

	public String getTtlAtrObl() {
		return ttlAtrObl;
	}

	public String getTtlAtrOpt() {
		return ttlAtrOpt;
	}

	public String getTtlPgeApn() {
		return ttlPgeApn;
	}

	public String getArw() {
		return arw;
	}

	public String getLnkMain() {
		return lnkMain;
	}

	public String getLnkSecundary() {
		return lnkSecundary;
	}

	public String getLgoMain() {
		return lgoMain;
	}

	public String getTtlAdmin() {
		return ttlAdmin;
	}

	public String getTtlAtrSlc() {
		return ttlAtrSlc;
	}

	public String getTtlPgeUnt() {
		return ttlPgeUnt;
	}

	public String getTtlPgeEnt() {
		return ttlPgeEnt;
	}

	public String cmbSlc = "Todos";

	public String getPgeMnuTask() {
		return pgeMnuTask;
	}

	public void setPgeMnuTask(String pgeMnuTask) {
		this.pgeMnuTask = pgeMnuTask;
	}

	public String getTtlBtnHme() {
		return ttlBtnHme;
	}

	public void setTtlBtnHme(String ttlBtnHme) {
		this.ttlBtnHme = ttlBtnHme;
	}

	public String getHme() {
		return hme;
	}

	public void setHme(String hme) {
		this.hme = hme;
	}

	public String getLblTask() {
		return lblTask;
	}

	public void setLblTask(String lblTask) {
		this.lblTask = lblTask;
	}

	public String getImgTask() {
		return imgTask;
	}

	public void setImgTask(String imgTask) {
		this.imgTask = imgTask;
	}

	public String getTtlPgeMnuTask() {
		return ttlPgeMnuTask;
	}

	public void setTtlPgeMnuTask(String ttlPgeMnuTask) {
		this.ttlPgeMnuTask = ttlPgeMnuTask;
	}

	public void setImgLoad(String imgLoad) {
		this.imgLoad = imgLoad;
	}

	public String getImgLdn() {
		return imgLdn;
	}

	public void setImgLdn(String imgLdn) {
		this.imgLdn = imgLdn;
	}

	public String getImgUsrs() {
		return imgUsrs;
	}

	public void setImgUsrs(String imgUsrs) {
		this.imgUsrs = imgUsrs;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getAddUsr() {
		return addUsr;
	}

	public void setAddUsr(String addUsr) {
		this.addUsr = addUsr;
	}

	public String getNvo() {
		return nvo;
	}

	public void setNvo(String nvo) {
		this.nvo = nvo;
	}

	public String getSve() {
		return sve;
	}

	public void setSve(String sve) {
		this.sve = sve;
	}

	public String getUpd() {
		return upd;
	}

	public void setUpd(String upd) {
		this.upd = upd;
	}

	public String getDlt() {
		return dlt;
	}

	public void setDlt(String dlt) {
		this.dlt = dlt;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getRfr() {
		return rfr;
	}

	public void setRfr(String rfr) {
		this.rfr = rfr;
	}

	public String getEdt() {
		return edt;
	}

	public void setEdt(String edt) {
		this.edt = edt;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getXls() {
		return xls;
	}

	public void setXls(String xls) {
		this.xls = xls;
	}

	public String getFle() {
		return fle;
	}

	public void setFle(String fle) {
		this.fle = fle;
	}

	public String getPng() {
		return png;
	}

	public void setPng(String png) {
		this.png = png;
	}

	public String getJpg() {
		return jpg;
	}

	public void setJpg(String jpg) {
		this.jpg = jpg;
	}

	public String getGif() {
		return gif;
	}

	public void setGif(String gif) {
		this.gif = gif;
	}

	public String getPthIcn() {
		return pthIcn;
	}

	public void setPthIcn(String pthIcn) {
		this.pthIcn = pthIcn;
	}

	public String getLblBtn() {
		return lblBtn;
	}

	public void setLblBtn(String lblBtn) {
		this.lblBtn = lblBtn;
	}

	public String getLblLnkCrt() {
		return lblLnkCrt;
	}

	public void setLblLnkCrt(String lblLnkCrt) {
		this.lblLnkCrt = lblLnkCrt;
	}

	public String getLblLnkRst() {
		return lblLnkRst;
	}

	public void setLblLnkRst(String lblLnkRst) {
		this.lblLnkRst = lblLnkRst;
	}

	public String getTtlPgeLgn() {
		return ttlPgeLgn;
	}

	public void setTtlPgeLgn(String ttlPgeLgn) {
		this.ttlPgeLgn = ttlPgeLgn;
	}

	public String getLblBtnNxt() {
		return lblBtnNxt;
	}

	public void setLblBtnNxt(String lblBtnNxt) {
		this.lblBtnNxt = lblBtnNxt;
	}

	public String getTtlPgeRgs() {
		return ttlPgeRgs;
	}

	public void setTtlPgeRgs(String ttlPgeRgs) {
		this.ttlPgeRgs = ttlPgeRgs;
	}

	public String getTtlPgeRgsGood() {
		return ttlPgeRgsGood;
	}

	public void setTtlPgeRgsGood(String ttlPgeRgsGood) {
		this.ttlPgeRgsGood = ttlPgeRgsGood;
	}

	public String getTtlPgeRgsError() {
		return ttlPgeRgsError;
	}

	public void setTtlPgeRgsError(String ttlPgeRgsError) {
		this.ttlPgeRgsError = ttlPgeRgsError;
	}

	public String getPlhEmail() {
		return plhEmail;
	}

	public void setPlhEmail(String plhEmail) {
		this.plhEmail = plhEmail;
	}

	public String getPlhEmailMsg() {
		return plhEmailMsg;
	}

	public void setPlhEmailMsg(String plhEmailMsg) {
		this.plhEmailMsg = plhEmailMsg;
	}

	public String getPlhPsw() {
		return plhPsw;
	}

	public void setPlhPsw(String plhPsw) {
		this.plhPsw = plhPsw;
	}

	public String getPlhPswMsg() {
		return plhPswMsg;
	}

	public void setPlhPswMsg(String plhPswMsg) {
		this.plhPswMsg = plhPswMsg;
	}

	public String getPlhPswRpt() {
		return plhPswRpt;
	}

	public void setPlhPswRpt(String plhPswRpt) {
		this.plhPswRpt = plhPswRpt;
	}

	public String getPlhGrt() {
		return plhGrt;
	}

	public void setPlhGrt(String plhGrt) {
		this.plhGrt = plhGrt;
	}

	public String getPlhNme() {
		return plhNme;
	}

	public void setPlhNme(String plhNme) {
		this.plhNme = plhNme;
	}

	public String getPlhLstNme() {
		return plhLstNme;
	}

	public void setPlhLstNme(String plhLstNme) {
		this.plhLstNme = plhLstNme;
	}

	public String getPlhCnr() {
		return plhCnr;
	}

	public void setPlhCnr(String plhCnr) {
		this.plhCnr = plhCnr;
	}

	public String getPlhCty() {
		return plhCty;
	}

	public void setPlhCty(String plhCty) {
		this.plhCty = plhCty;
	}

	public String getPlhPhn() {
		return plhPhn;
	}

	public void setPlhPhn(String plhPhn) {
		this.plhPhn = plhPhn;
	}

	public String getPlhEmailAlt() {
		return plhEmailAlt;
	}

	public void setPlhEmailAlt(String plhEmailAlt) {
		this.plhEmailAlt = plhEmailAlt;
	}

	public String getPlhTpeEnt() {
		return plhTpeEnt;
	}

	public void setPlhTpeEnt(String plhTpeEnt) {
		this.plhTpeEnt = plhTpeEnt;
	}

	public String getPlhEnt() {
		return plhEnt;
	}

	public void setPlhEnt(String plhEnt) {
		this.plhEnt = plhEnt;
	}

	public String getPlhEntOth() {
		return plhEntOth;
	}

	public void setPlhEntOth(String plhEntOth) {
		this.plhEntOth = plhEntOth;
	}

	public String getPlhUnt() {
		return plhUnt;
	}

	public void setPlhUnt(String plhUnt) {
		this.plhUnt = plhUnt;
	}

	public String getPlhUntOth() {
		return plhUntOth;
	}

	public void setPlhUntOth(String plhUntOth) {
		this.plhUntOth = plhUntOth;
	}

	public String getPlhApn() {
		return plhApn;
	}

	public void setPlhApn(String plhApn) {
		this.plhApn = plhApn;
	}

	public String getPlhApnOth() {
		return plhApnOth;
	}

	public void setPlhApnOth(String plhApnOth) {
		this.plhApnOth = plhApnOth;
	}

	public String getPlhAcd() {
		return plhAcd;
	}

	public void setPlhAcd(String plhAcd) {
		this.plhAcd = plhAcd;
	}

	public String getPlhDsc() {
		return plhDsc;
	}

	public void setPlhDsc(String plhDsc) {
		this.plhDsc = plhDsc;
	}

	public String getPlhDscSub() {
		return plhDscSub;
	}

	public void setPlhDscSub(String plhDscSub) {
		this.plhDscSub = plhDscSub;
	}

	public String getLblBtnCrtAcc() {
		return lblBtnCrtAcc;
	}

	public void setLblBtnCrtAcc(String lblBtnCrtAcc) {
		this.lblBtnCrtAcc = lblBtnCrtAcc;
	}

	public String getTtlPgeMyPfl() {
		return ttlPgeMyPfl;
	}

	public void setTtlPgeMyPfl(String ttlPgeMyPfl) {
		this.ttlPgeMyPfl = ttlPgeMyPfl;
	}

	public String getTtlPgeEvents() {
		return ttlPgeEvents;
	}

	public void setTtlPgeEvents(String ttlPgeEvents) {
		this.ttlPgeEvents = ttlPgeEvents;
	}

	public String getTtlBtnNew() {
		return ttlBtnNew;
	}

	public void setTtlBtnNew(String ttlBtnNew) {
		this.ttlBtnNew = ttlBtnNew;
	}

	public String getTtlBtnAdd() {
		return ttlBtnAdd;
	}

	public void setTtlBtnAdd(String ttlBtnAdd) {
		this.ttlBtnAdd = ttlBtnAdd;
	}

	public String getTtlBtnSve() {
		return ttlBtnSve;
	}

	public void setTtlBtnSve(String ttlBtnSve) {
		this.ttlBtnSve = ttlBtnSve;
	}

	public String getTtlBtnEdt() {
		return ttlBtnEdt;
	}

	public void setTtlBtnEdt(String ttlBtnEdt) {
		this.ttlBtnEdt = ttlBtnEdt;
	}

	public String getTtlBtnDlt() {
		return ttlBtnDlt;
	}

	public void setTtlBtnDlt(String ttlBtnDlt) {
		this.ttlBtnDlt = ttlBtnDlt;
	}

	public String getTtlBtnSee() {
		return ttlBtnSee;
	}

	public void setTtlBtnSee(String ttlBtnSee) {
		this.ttlBtnSee = ttlBtnSee;
	}

	public String getTtlBtnUpd() {
		return ttlBtnUpd;
	}

	public void setTtlBtnUpd(String ttlBtnUpd) {
		this.ttlBtnUpd = ttlBtnUpd;
	}

	public String getTtlBtnRfr() {
		return ttlBtnRfr;
	}

	public void setTtlBtnRfr(String ttlBtnRfr) {
		this.ttlBtnRfr = ttlBtnRfr;
	}

	public String getTtlPgeTask() {
		return ttlPgeTask;
	}

	public void setTtlPgeTask(String ttlPgeTask) {
		this.ttlPgeTask = ttlPgeTask;
	}

	public String getCmbSlc() {
		return cmbSlc;
	}

	public void setCmbSlc(String cmbSlc) {
		this.cmbSlc = cmbSlc;
	}

	public String getTtlPgeField() {
		return ttlPgeField;
	}

	public String getLnkOeia() {
		return lnkOeia;
	}

	public String getLgoOeia() {
		return lgoOeia;
	}

	public String getImgLoad() {
		return imgLoad;
	}

	public String getSlcOne() {
		return slcOne;
	}

	public String getDteYr() {
		return dteYr;
	}

	public String getDteMth() {
		return dteMth;
	}

	public String getDteDay() {
		return dteDay;
	}

	public String getDteEpiWek() {
		return dteEpiWek;
	}

	public String getSitTtlPfs() {
		return sitTtlPfs;
	}

	public String getSitLblPfsAgn() {
		return sitLblPfsAgn;
	}

	public String getSitLblPfsTch() {
		return sitLblPfsTch;
	}

	public String getSitTtlAdl() {
		return sitTtlAdl;
	}

	public String getSitLblAdlNmb() {
		return sitLblAdlNmb;
	}

	public String getSitLblAdlSex() {
		return sitLblAdlSex;
	}

	public String getSitLblAdlSpc() {
		return sitLblAdlSpc;
	}
}
