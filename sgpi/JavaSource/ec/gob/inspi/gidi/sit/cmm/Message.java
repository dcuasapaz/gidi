package ec.gob.inspi.gidi.sit.cmm;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ViewScoped
public class Message {

	public static final String T_MSG_PRJ = "SGPI | ";

	public Message() {

	}

	public static String S_LOG_NME_SRV = "SERVICE --> ";
	public static String S_LOG_NME_CTL = "CONTROLLER --> ";

	public static String D_MSG_FRM01_PRC_DTE() {
		return "Date Process";
	}

	public static String S_MSG_FRM01_PRC() {
		return "Process";
	}

	public static String S_MSG_FRM01_STE() {
		return "Location";
	}

	public static String S_MSG_FRM01_TRP() {
		return "Trap";
	}

	public static String S_MSG_FRM01_NMB() {
		return "Number";
	}

	public static String S_MSG_FRM01_TCH_FLD() {
		return "Field agent";
	}

	public static String D_MSG_FRM01_DTE_SET() {
		return "Date ovitrap Set";
	}

	public static String D_MSG_FRM01_DTE_CLC() {
		return "Date ovitrap Colected";
	}

	/*******************************************************************************************************/
	public static String I_MSG_FRM01_EGS_WHL() {
		return "N°. Whole Eggs";
	}

	public static String I_MSG_FRM01_EGS_BRK() {
		return "N°. Broken Eggs";
	}

	public static String I_MSG_FRM01_EGS_VLB() {
		return "N°. Viable Eggs";
	}

	public static String I_MSG_FRM01_EGS_VLB_NO() {
		return "N°. No Viable Eggs";
	}

	/*******************************************************************************************************/
	public static String I_MSG_FRM01_LRP_NMB() {
		return "N°. Live";
	}

	public static String I_MSG_FRM01_LRP_NMB_DD() {
		return "N°. Dead";
	}

	public static String I_MSG_FRM01_LRP_STG() {
		return "Stage";
	}
	
	public static String I_MSG_FRM01_LRP_CTN() {
		return "Contain";
	}

	/*******************************************************************************************************/
	public static String S_MSG_FRMO1_INPUT_DST_ZERO = "Enter a non-zero value";

	/*******************************************************************************************************/

	/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
	// AUTOR | DATE | OBJECT | DESCRIPTION
	// --------------------------------------------------------------
	// Diego Cuasapaz | 2022-02-22 | Adults | Message, default ":"
	// --------------------------------------------------------------
	public static String I_MSG_FRM01_ADL_NMB() {
		return "N°. Live";
	}

	public static String I_MSG_FRM01_ADL_NMB_DD() {
		return "N°. Dead";
	}

	public static String I_MSG_FRM01_ADL_SEX() {
		return "Sex";
	}

	public static String I_MSG_FRM01_ADL_GNR() {
		return "Genus/Species";
	}

	public String ntaRcvPss() {
		return "<b>Nota: </b>Es recomendable cambiar la contraseï¿½a para que pueda recordarla. ";
	}

	public void msgInf(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ, new FacesMessage(FacesMessage.SEVERITY_INFO, Message.T_MSG_PRJ, msg));
	}

	public void msgWrn(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ, new FacesMessage(FacesMessage.SEVERITY_WARN, Message.T_MSG_PRJ, msg));
	}

	public void msgErr(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ, new FacesMessage(FacesMessage.SEVERITY_ERROR, Message.T_MSG_PRJ, msg));
	}

	public String txtStrSss(String time) {
		return "Start Session - " + time + " | ";
	}

	public String txtEndSss(String time) {
		return "End Session - " + time;
	}

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		if (arg2 == null) {
			throw new ValidatorException(new FacesMessage("Mandatory"));
		}
	}

	public String msgSaveInf() {
		return "Record Stored Correctly ";
	}

	public String msgUpdInf() {
		return "Record Updated Correctly";
	}

	public String msgDltInf() {
		return "Record Deleted Correctly";
	}

	public String msgSaveErr() {
		return "There was a problem storing the data ";
	}

	public String msgUpdErr() {
		return "There was a problem updating the data ";
	}

	public String msgDltErr() {
		return "Ocurrio un problema al eliminar los datos o el registro se encuentra asociado a un item";
	}

	public String msgDateErr() {
		return "! The Selected Date must be after the Start Date !";
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: General */
	/*---------------------------------------------------------------------------------------------------------*/

	public String dtaEmlErrorSnt() {
		return "The email syntax is not correct ";
	}

	public String obl() {
		return "Mandatory";
	}

	public void cmpObl() {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, Message.T_MSG_PRJ, "Mandatory"));
	}

	public void cmpIdnInc() {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ,
				new FacesMessage(FacesMessage.SEVERITY_WARN, Message.T_MSG_PRJ, "Incorrect Identification"));
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Create account */
	/*---------------------------------------------------------------------------------------------------------*/
	public String dtaPrsEmlObl() {
		return Message.T_MSG_PRJ + "Email Mandatory";
	}

	public void dtaPrsEmlObl(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ, new FacesMessage(FacesMessage.SEVERITY_ERROR, Message.T_MSG_PRJ, msg));
	}

	public String dtaPrsPswObl() {
		return "Password Mandatory";
	}

	public void dtaPrsPswObl(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ, new FacesMessage(FacesMessage.SEVERITY_ERROR, Message.T_MSG_PRJ, msg));
	}

	public void prsPswObl() {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(Message.T_MSG_PRJ,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, Message.T_MSG_PRJ, this.dtaPrsPswObl()));
	}

	public String dtaPrsPwsLbl() {
		return "Enter password";
	}

	public String dtaPrsPwsGood() {
		return "Good";
	}

	public String dtaPrsPwsLow() {
		return "Not Optimal";
	}

	public String dtaPrsPwsExc() {
		return "Very good";
	}

	public String dtaPrsPswVld() {
		return Message.T_MSG_PRJ + "Contraseï¿½as no coinciden";
	}

	public String dtaPrsPswRptObl() {
		return Message.T_MSG_PRJ + "Confirmar contraseï¿½a es obligatorio";
	}

	public String dtaPrsPwsRptLbl() {
		return "Confirme su contraseï¿½a";
	}

	public String dtaPrsGrt() {
		return Message.T_MSG_PRJ + "Saludo es obligatorio";
	}

	public String dtaPrsNme() {
		return Message.T_MSG_PRJ + "Nombres es obligatorio";
	}

	public String dtaPrsNmeLst() {
		return Message.T_MSG_PRJ + "Apellidos es obligatorio";
	}

	public String dtaPrsCnr() {
		return Message.T_MSG_PRJ + "Paï¿½s es obligatorio";
	}

	public String dtaPrsCty() {
		return Message.T_MSG_PRJ + "Ciudad es obligatoria";
	}

	public String insTpe() {
		return Message.T_MSG_PRJ + "Tipo Instituciï¿½n es obligatoria";
	}

	public String insEnt() {
		return Message.T_MSG_PRJ + "Instituciï¿½n es obligatoria";
	}

	public String insEntOth() {
		return Message.T_MSG_PRJ + "Otra Instituciï¿½n es obligatoria";
	}

	public String insUnt() {
		return Message.T_MSG_PRJ + "ï¿½rea es obligatoria";
	}

	public String insUntOth() {
		return Message.T_MSG_PRJ + "Otra ï¿½rea es obligatoria";
	}

	public String insApn() {
		return Message.T_MSG_PRJ + "Cargo es obligatorio";
	}

	public String insApnOth() {
		return Message.T_MSG_PRJ + "Otro cargo es obligatorio";
	}

	public String dtaEdcLvl() {
		return Message.T_MSG_PRJ + "Grado acadï¿½mico es obligatorio";
	}

	public String dtaEdcDsc() {
		return Message.T_MSG_PRJ + "Disciplina es obligatoria";
	}

	public String dtaEdcDscSub() {
		return Message.T_MSG_PRJ + "Subdisciplina es obligatoria";
	}

	public String emlUsrTxt() {
		return "El registro al Sistema de Gestiï¿½n de Servicios de la Plataforma EpiSIG del INSPI LIP, se ha completado con ï¿½xito.";
	}

	public String emlUsrGood() {
		return "SGI | Usuario Registrado Correctamente";
	}

	public String emlUsrIncorrect() {

		return "SGI | Usuario No Registrado Correctamente";
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* EMAIL: Profile */
	/*---------------------------------------------------------------------------------------------------------*/
	public String emlChg() {
		return "SGPI | Cambio de correo electrï¿½nico";
	}

	public String usrChg() {
		return "SGPI | Cambio de correo electrï¿½nico";
	}

	public String errDtaPrsEml() {
		return "! El email ingresado ya existe !";
	}

	public String errDtaPrsUsr() {
		return "! El usuario ingresado ya existe !";
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Recover password */
	/*---------------------------------------------------------------------------------------------------------*/

	public String msgErrSndEml = "! Ocurriï¿½ un error al generar su nueva contraseï¿½a, contactarse a episig.inspi@gmail.com !";

	public String getMsgErrSndEml() {
		return msgErrSndEml;
	}

	/****************************************************************************/
	/* +++++++++++++++++++++++++++++++ PAGE: LOGIN ++++++++++++++++++++++++++++ */
	/****************************************************************************/

	public String M_PRS_USR_WRN() {
		return "! Wrong User/Email !";
	}

	public String M_PRS_USR_MND() {
		return "User/Email Mandatory *";
	}

	public String M_PRS_PSW_MND() {
		return "Password Mandatory *";
	}

	public String M_SCR_PRF_MND() {
		return "Profile Mandatory *";
	}

	public static final String M_WRN_PRS_USR = "! User/Email not found !";
	public static final String M_WRN_PRS_PSW = "Wrong Password";

	/****************************************************************************/
	/* ++++++++++++++++++++++++++++++ PROCESS: LOG ++++++++++++++++++++++++++++ */
	/****************************************************************************/
	public static final String M_LGN_LOG_SCR_PRF = "! Profiles not found !";
	public static final String M_LGN_LOG_MTH_LGN = "Problems run login()";
	public static final String M_LGN_LOG_MTH_VLD = "Problems run vld()";
	public static final String M_LGN_LOG_MTH_VLD_PRL_SSS = "Problems add prs to sss";
	public static final String M_LGN_LOG_MTH_VLD_SSS_SSS = "Problems add sss to sss";
	public static final String M_LGN_LOG_MTH_VLD_MNU_PRL = "Problems search menu";

	public String msgErrSlc() {
		return "! Ocurrio un Inconveniente al Seleccionar el Registro !";
	}

	public String msgErrSave() {
		return "! Ocurrio un Inconveniente al Almacenar el Registro !";
	}

	public String msgErrDlt() {
		return "! Ocurrio un Inconveniente al Eliminar el Registro !";
	}

	public String msgWrnSlc() {
		return "! Seleccione al Menos un Registro !";
	}

	public String msgErrUpd() {
		return "! Ocurrio un Inconveniente al Actualizar el Registro !";
	}

}
