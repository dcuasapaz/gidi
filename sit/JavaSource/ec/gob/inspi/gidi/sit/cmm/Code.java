package ec.gob.inspi.gidi.sit.cmm;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Code {
	public Code() {

	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: DTA +++++++++++++++++++++++++++++++ */
	/****************************************************************************/

	public int dtaPrfAdm() {
		return 102;
	}

	public int dtaPrfAgn() {
		return 103;
	}

	public int dtaPrfTch() {
		return 104;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: SIT +++++++++++++++++++++++++++++++ */
	/****************************************************************************/

	public int sitTrp() {
		return 2;
	}

	public int sitTpe() {
		return 7;
	}

	public int sitPrj() {
		return 1;
	}

	public int sitSex() {
		return 4;
	}

	public int sitSpc() {
		return 5;
	}

	public int sitStg() {
		return 6;
	}

	public int sitLrv() {
		return 301;
	}

	public int sitAdl() {
		return 302;
	}

	/****************************************************************************/
	/* ++++++++++++++++++++++++++++++++ PASSWORD +++++++++++++++++++++++++++++++ */
	/****************************************************************************/

	public String keySecurity() {
		return "SGIEpiSIG";
	}

	/****************************************************************************/
	/* ++++++++++++++++++++++++++++++++ DEFAULT +++++++++++++++++++++++++++++++ */
	/****************************************************************************/
	public int otherValue() {
		return -99;
	}

	public String other() {
		return "Otro(a) (ingresar)";
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: WEB +++++++++++++++++++++++++++++++ */
	/****************************************************************************/
	/* ------------------------------ WebTblMnu ------------------------------- */

	public int mnuTsk() {
		return 20000;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: DTA +++++++++++++++++++++++++++++++ */
	/****************************************************************************/

	public int dtaGrt() {
		return 1;
	}

	public int dtaGnd() {
		return 3;
	}

	public int dtaIdn() {
		return 2;
	}

	public int dtaStt() {
		return 9;
	}

	public int dtaIdnNne() {
		return 201;
	}

	public int dtaIdnCdl() {
		return 3000001;
	}

	public int dtaLvl() {
		return 4000000;
	}

	public int dtaPhnTpe() {
		return 5000000;
	}

	public int dtaEmlTpe() {
		return 6000000;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: DPA +++++++++++++++++++++++++++++++ */
	/****************************************************************************/
	public int dpaCnrEcd() {
		return 57;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: INS +++++++++++++++++++++++++++++++ */
	/****************************************************************************/
	public int insEntTpe() {
		return 1;
	}

	public int insUntEpiSIG() {
		return 2;
	}

	public int insUntGIDi() {
		return 1;
	}

	public int insUntLvl() {
		return 2;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: SCR +++++++++++++++++++++++++++++++ */
	/****************************************************************************/

	/* --------------------------------- ENT ---------------------------------- */
	public int scrMdl() {
		return 100;
	}

	public int scrRol() {
		return 1;
	}

	public int scrStt() {
		return 9;
	}

	/* ------------------------------- SCR: ROL ------------------------------- */
	public int scrRolMng() {
		return 101;
	}

	public int scrRolPrf() {
		return 102;
	}

	public int scrRolUsr() {
		return 103;
	}

	public int scrRolLdr() {
		return 105;
	}
	
	public int scrRolTchGlp() {
		return 107;
	}

	public int scrRolMain() {
		return 109;
	}

	public int scrRolScn() {
		return 110;
	}

	/* ------------------------------- ENT: STT ------------------------------- */
	public int sctSttSss() {
		return 901;
	}

	public int sctSttNoSss() {
		return 900;
	}

	public int sctSttRgs() {
		return 902;
	}

	/* ------------------------------- ENT: MDL ------------------------------- */

	public int scrMdlScr() {
		return 201;
	}

	public int scrMdlTsk() {
		return 202;
	}

	public int scrMdlAtc() {
		return 203;
	}

	public int scrMdlEvn() {
		return 25;
	}

	public int scrMdlDpa() {
		return 205;
	}

	public int scrMdlIns() {
		return 206;
	}

	public int scrMdlDta() {
		return 207;
	}

	public int scrMdlDte() {
		return 208;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: DTE +++++++++++++++++++++++++++++++ */
	/****************************************************************************/
	public int dteDayBss() {
		return 29;
	}

	public int dteDayBssNo() {
		return 28;
	}

	public int dteDayNrm() {
		return 31;
	}

	public int dteDayNrmNo() {
		return 30;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: TSK +++++++++++++++++++++++++++++++ */
	/****************************************************************************/
	/* ------------------------------- ENTITIES ------------------------------- */

	public int tskCtg() {
		return 100;
	}

	public int tskCtgSub() {
		return 10000;
	}

	public int tskGnrTpe() {
		return 200;
	}

	public int tskTpe() {
		return 300;
	}

	public int tskRslExp() {
		return 600;
	}

	public int tskRslSpc() {
		return 700;
	}

	public int tskFleStt() {
		return 800;
	}

	public int tskPrmTpe() {
		return 400;
	}

	public int tskRslTpeItg() {
		return 710;
	}

	public int tskRslHlf() {
		return 5000;
	}

	public int tskRslNne() {
		return 827;
	}

	public int tskFrc() {
		return 1000;
	}

	public int tskDvs() {
		return 2000;
	}

	public int tskStt() {
		return 3000;
	}

	public int tskPrmStt() {
		return 900;
	}

	public int tskGrp() {
		return 4000;
	}

	public int tskMtv() {
		return 500;
	}

	public int tskPrmLve() {
		return 401;
	}

	public int tskPrmHld() {
		return 402;
	}

	/* ------------------------------- ESPECIFIC ------------------------------- */
	public int tskFrcTp() {
		return 1001;
	}

	public int tskFrcTc() {
		return 1002;
	}

	public int tskDvsDia() {
		return 2001;
	}

	public int tskDvsPrd() {
		return 2004;
	}

	public int tskGrpInd() {
		return 4001;
	}

	public int tskGrpMlt() {
		return 4002;
	}

	/* ------------------------------- DEFAULT ------------------------------- */
	public int tskFrcCmpHr() {
		return 8;
	}

	public int tskRgsHrNmb() {
		return 1;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ MDL: EVN +++++++++++++++++++++++++++++++ */
	/****************************************************************************/

	public int evnTpeRgs() {
		return -100;
	}

	public int evnTpeRgsEcn() {
		return -101;
	}

	public int evnTpeRgsDcm() {
		return -102;
	}

	public int evnRqs() {
		return 100;
	}

	public int evnTpeEcn() {
		return 200;
	}

	public int evnTpeDcm() {
		return 1000;
	}

	public int evnStt() {
		return 300;
	}

	public int evnTpeCrs() {
		return 206;
	}

	public int evnChsTpr() {
		return 2001;
	}

	public int evnChsAnl() {
		return 2002;
	}

	public int evnChsAgua() {
		return 2003;
	}

	public int evnChsOpt() {
		return 2004;
	}

	public int evnChsOptSi() {
		return 13;
	}

	public int evnChsOptNo() {
		return 14;
	}

}
