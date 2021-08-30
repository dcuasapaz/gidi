package ec.gob.msp.pms.cmm;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Html {
	public Html() {

	}

	/*******************************************************/
	public String tmncTtlPgeMain = "Principal";
	public String mainTtl = "Programa Nacional de Municipios Saludables";
	public String mainLgo = "/img/lgo/lgo_pms.png";
	public String mainDsc = "Es una propuesta liderada por el Ministerio de Salud Pública para impulsar que los Gobiernos Autónomos Descentralizados –GAD- municipales aborden de manera integral los determinantes que influyen en el estado de la salud de la población, mejorando el bienestar y la calidad de vida de la ciudadanía.";
	public String mainCrt = "Es una herramienta de diagnóstico para analizar la diferentes dimensiones que determinan la salud de la población y ayuda a evaluar hasta que punto una municipalidad es un entorno saludable. El modelo aborda siete componentes:";
	public String mainTtlCrt = "Modelo de certificación";
	public String mainTtlSmrInd = "Resumen Indicadores --> ";

	public String tmncTtlPgeCmp = "Componente";

	public String getTmncTtlPgeCmp() {
		return tmncTtlPgeCmp;
	}

	public String getTmncTtlPgeMain() {
		return tmncTtlPgeMain;
	}

	/*******************************************************/
	// Table

	public String msgTblEmp = "No se encontraron registros.";

	/*******************************************************/
	public String SPmsSys = "Sistema";
	public String SPmsPfs = "Profesional";
	public String SPmsPrf = "Perfil";
	public String SPmsIns = "Institución";
	public String SPmsAct = "Acciones";
	public String TBLPmsPfsRgs = "Registro de profesionales";
	public String TBLPmsMncRgs = "Registro de Municipios";
	public String SPmsRgsInf = "Registro de información";
	public String SObl = "Obligatorio";
	public String SOpt = "Opcional";
	public String SSlc = "Seleccione";
	// dta_tbl_prs
	public String SPrsNme = "Nombre";
	public String SPrsLstNme = "Apellido";
	public String SPrsUsr = "Usuario";
	public String SPrsEml = "Email";
	public String SPrsPsw = "Contraseña";
	// scr_tbl_prs_rol
	public String SPrsRolNme = "Rol";
	public String SPrsRolStt = "Estado";
	// dta_tbl_cnt
	public String ICntCde = "Código";
	public String SCntPrv = "Provincia";
	public String SCntNme = "Cantón";
	public String SCntCmp = "Comprobante (PDF, máximo 2MB)";
	public String SCntCmpTbl = "Comprobante";
	public String SCntChgCmpTbl = "Cambiar Comprobante";
	public String DCntDte = "Fecha adhesión";
	public String SCntPrg = "Programa";
	public String SCntMnc = "Municipio";
	public String SCntStt = "Estado";
	// General
	public String SGnrObs = "Observaciones";
	public String DGnrYr = "Año";
	public String DGnrMth = "Mes";
	public String DGnrDay = "Día";
	/*******************************************************/
	public String SBtnUpl = "Subir";
	public String SBtnCnc = "Cancelar";
	public String SBtnSlc = "Seleccionar";

	/*******************************************************/
	public String imgLdn() {
		return "/img/gif/load.gif";
	}

	public String inspi() {
		return "Instituto Nacional de Investigación en Salud Pública";
	}

	public String episig() {
		return "INSPI | Centro de Investigación en Epidemiología, Geomática y ciencias afines";
	}

	public String msp() {
		return "Ministerio de Salud Pública";
	}

	public String dtaEmpty() {
		return "No se encontraron registros.";
	}

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
	public String dwn = "dwn";

	public String pdf = "pdf";
	public String fle = "fle";
	public String csv = "csv";

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
		} else if (this.csv.compareTo(icn) == 0) {
			icono = pthIcn + csv + sze + "." + frm;
		} else if (this.addUsr.compareTo(icn) == 0) {
			icono = pthIcn + addUsr + sze + "." + frm;
		} else if (this.hme.compareTo(icn) == 0) {
			icono = pthIcn + hme + sze + "." + frm;
		} else if (this.dwn.compareTo(icn) == 0) {
			icono = pthIcn + dwn + sze + "." + frm;
		}

		return icono;
	}

	public String hmeBtnId = "frm-btn-hme";
	public String hmeBtnNme = "Inicio";
	public String hmeBtnIcn = "ui-icon-home";
	public String hmeBtnDsc = "Regresar al menú principal";
	public String hmeCsvBtnImg = "/img/icn/home256.png";

	public String newBtnId = "frm-btn-new";
	public String newBtnNme = "Nuevo";
	public String newBtnIcn = "ui-icon-document";
	public String newBtnDsc = "Nuevo registro";

	public String sveBtnId = "frm-btn-sve";
	public String sveBtnNme = "Guardar";
	public String sveBtnIcn = "ui-icon-disk";
	public String sveBtnDsc = "Guardar registro";

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
	public String updBtnDsc = "Guardar los cambios en el registro seleccionado";

	public String dltBtnId = "frm-tbl-btn-dlt";
	public String dltBtnNme = "Eliminar";
	public String dltBtnIcn = "ui-icon-trash";
	public String dltBtnDsc = "Eliminar registro";
	public String dltCsvBtnImg = "/img/icn/dlt16.png";

	public String rfrBtnId = "frm-btn-rfr";
	public String rfrBtnNme = "Regresar";
	public String rfrBtnIcn = "ui-icon-circle-arrow-w";
	public String rfrBtnDsc = "Regresar a tabla";
	public String rfrCsvBtnImg = "/img/icn/refresh256.png";

	public String csvBtnId = "frm-btn-dwn-csv";
	public String csvBtnNme = "Descargar csv";
	public String csvBtnDsc = "Descargar en CSV";

	public String pdfBtnId = "frm-btn-dwn-pdf";
	public String pdfBtnNme = "Descargar pdf";
	public String pdfBtnDsc = "Descargar en pdf";

	public String vldBtnId = "frm-btn-vld";
	public String vldBtnNme = "Validar";
	public String vldBtnDsc = "Permite validar el parámetro asociado";

	public String gntrBtnId = "frm-btn-gntr";
	public String gntrBtnNme = "Generar";
	public String gntrBtnDsc = "Permite generar un valor automático";

	public String addBtnId = "frm-btn-add";
	public String addBtnNme = "Añadir";
	public String addBtnDsc = "Añadir registro";

	public String dwnBtnId = "frm-btn-dwn";
	public String dwnBtnNme = "Descargar";
	public String dwnBtnDsc = "Descargar archivo";

	public String getNewBtnDsc() {
		return newBtnDsc;
	}

	public String getSveBtnDsc() {
		return sveBtnDsc;
	}

	public String getUpdBtnDsc() {
		return updBtnDsc;
	}

	public String getHme() {
		return hme;
	}

	public String getAdd() {
		return add;
	}

	public String getAddUsr() {
		return addUsr;
	}

	public String getCsv() {
		return csv;
	}

	public String getNvo() {
		return nvo;
	}

	public String getSve() {
		return sve;
	}

	public String getUpd() {
		return upd;
	}

	public String getDlt() {
		return dlt;
	}

	public String getSrc() {
		return src;
	}

	public String getRfr() {
		return rfr;
	}

	public String getEdt() {
		return edt;
	}

	public String getArw() {
		return arw;
	}

	public String getPdf() {
		return pdf;
	}

	public String getFle() {
		return fle;
	}

	public String getPng() {
		return png;
	}

	public String getJpg() {
		return jpg;
	}

	public String getGif() {
		return gif;
	}

	public String getPthIcn() {
		return pthIcn;
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

	public String getHmeBtnDsc() {
		return hmeBtnDsc;
	}

	public String getHmeCsvBtnImg() {
		return hmeCsvBtnImg;
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

	public String getEdtBtnId() {
		return edtBtnId;
	}

	public String getEdtBtnNme() {
		return edtBtnNme;
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

	public String getDltBtnIcn() {
		return dltBtnIcn;
	}

	public String getDltBtnDsc() {
		return dltBtnDsc;
	}

	public String getDltCsvBtnImg() {
		return dltCsvBtnImg;
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

	public String getRfrBtnDsc() {
		return rfrBtnDsc;
	}

	public String getRfrCsvBtnImg() {
		return rfrCsvBtnImg;
	}

	public String getCsvBtnId() {
		return csvBtnId;
	}

	public String getCsvBtnNme() {
		return csvBtnNme;
	}

	public String getCsvBtnDsc() {
		return csvBtnDsc;
	}

	public String getPdfBtnId() {
		return pdfBtnId;
	}

	public String getPdfBtnNme() {
		return pdfBtnNme;
	}

	public String getPdfBtnDsc() {
		return pdfBtnDsc;
	}

	public String getSPmsSys() {
		return SPmsSys;
	}

	public String getSPmsPfs() {
		return SPmsPfs;
	}

	public String getSPmsPrf() {
		return SPmsPrf;
	}

	public String getSPmsIns() {
		return SPmsIns;
	}

	public String getSPmsAct() {
		return SPmsAct;
	}

	public String getTBLPmsPfsRgs() {
		return TBLPmsPfsRgs;
	}

	public String getSPrsNme() {
		return SPrsNme;
	}

	public String getSPrsLstNme() {
		return SPrsLstNme;
	}

	public String getSPrsUsr() {
		return SPrsUsr;
	}

	public String getSPrsEml() {
		return SPrsEml;
	}

	public String getSPmsRgsInf() {
		return SPmsRgsInf;
	}

	public String getSPrsPsw() {
		return SPrsPsw;
	}

	public String getSObl() {
		return SObl;
	}

	public String getSOpt() {
		return SOpt;
	}

	public String getSSlc() {
		return SSlc;
	}

	public String getVldBtnId() {
		return vldBtnId;
	}

	public String getVldBtnNme() {
		return vldBtnNme;
	}

	public String getVldBtnDsc() {
		return vldBtnDsc;
	}

	public String getGntrBtnId() {
		return gntrBtnId;
	}

	public String getGntrBtnNme() {
		return gntrBtnNme;
	}

	public String getGntrBtnDsc() {
		return gntrBtnDsc;
	}

	public String getSPrsRolNme() {
		return SPrsRolNme;
	}

	public String getSPrsRolStt() {
		return SPrsRolStt;
	}

	public String getAddBtnId() {
		return addBtnId;
	}

	public String getAddBtnNme() {
		return addBtnNme;
	}

	public String getAddBtnDsc() {
		return addBtnDsc;
	}

	public String getSCntPrv() {
		return SCntPrv;
	}

	public String getSCntNme() {
		return SCntNme;
	}

	public String getSCntCmp() {
		return SCntCmp;
	}

	public String getDCntDte() {
		return DCntDte;
	}

	public String getSGnrObs() {
		return SGnrObs;
	}

	public String getDGnrYr() {
		return DGnrYr;
	}

	public String getDGnrMth() {
		return DGnrMth;
	}

	public String getDGnrDay() {
		return DGnrDay;
	}

	public String getSBtnUpl() {
		return SBtnUpl;
	}

	public String getSBtnCnc() {
		return SBtnCnc;
	}

	public String getSBtnSlc() {
		return SBtnSlc;
	}

	public String getICntCde() {
		return ICntCde;
	}

	public String getDwn() {
		return dwn;
	}

	public String getDwnBtnId() {
		return dwnBtnId;
	}

	public String getDwnBtnNme() {
		return dwnBtnNme;
	}

	public String getDwnBtnDsc() {
		return dwnBtnDsc;
	}

	public String getTBLPmsMncRgs() {
		return TBLPmsMncRgs;
	}

	public String getSCntPrg() {
		return SCntPrg;
	}

	public String getSCntMnc() {
		return SCntMnc;
	}

	public String getSCntStt() {
		return SCntStt;
	}

	public String getSCntCmpTbl() {
		return SCntCmpTbl;
	}

	public String getSCntChgCmpTbl() {
		return SCntChgCmpTbl;
	}

	public String getMsgTblEmp() {
		return msgTblEmp;
	}

	public String getMainTtl() {
		return mainTtl;
	}

	public String getMainLgo() {
		return mainLgo;
	}

	public String getMainDsc() {
		return mainDsc;
	}

	public String getMainCrt() {
		return mainCrt;
	}

	public String getMainTtlCrt() {
		return mainTtlCrt;
	}

	public String getMainTtlSmrInd() {
		return mainTtlSmrInd;
	}
}
