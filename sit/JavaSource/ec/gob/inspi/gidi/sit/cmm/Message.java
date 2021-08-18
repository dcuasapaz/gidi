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

	public Message() {

	}

	public String ntaRcvPss() {
		return "<b>Nota: </b>Es recomendable cambiar la contrase�a para que pueda recordarla. ";
	}

	public void msgInf(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_INFO, "SIT | ", msg));
	}

	public void msgWrn(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_WARN, "SIT | ", msg));
	}

	public void msgErr(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "SIT | ", msg));
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
	public String ttlMsg() {
		return "SIT | ";
	}

	public String dtaEmlErrorSnt() {
		return "The email syntax is not correct ";
	}

	public String obl() {
		return "Mandatory";
	}

	public void cmpObl() {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_ERROR, this.ttlMsg(), "Mandatory"));
	}

	public void cmpIdnInc() {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(),
				new FacesMessage(FacesMessage.SEVERITY_WARN, this.ttlMsg(), "Incorrect Identification"));
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Create account */
	/*---------------------------------------------------------------------------------------------------------*/
	public String dtaPrsEmlObl() {
		return this.ttlMsg() + "Email Mandatory";
	}

	public void dtaPrsEmlObl(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_ERROR, this.ttlMsg(), msg));
	}

	public String dtaPrsPswObl() {
		return "Password Mandatory";
	}

	public void dtaPrsPswObl(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_ERROR, this.ttlMsg(), msg));
	}

	public void prsPswObl() {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(),
				new FacesMessage(FacesMessage.SEVERITY_ERROR, this.ttlMsg(), this.dtaPrsPswObl()));
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
		return this.ttlMsg() + "Contrase�as no coinciden";
	}

	public String dtaPrsPswRptObl() {
		return this.ttlMsg() + "Confirmar contrase�a es obligatorio";
	}

	public String dtaPrsPwsRptLbl() {
		return "Confirme su contrase�a";
	}

	public String dtaPrsGrt() {
		return this.ttlMsg() + "Saludo es obligatorio";
	}

	public String dtaPrsNme() {
		return this.ttlMsg() + "Nombres es obligatorio";
	}

	public String dtaPrsNmeLst() {
		return this.ttlMsg() + "Apellidos es obligatorio";
	}

	public String dtaPrsCnr() {
		return this.ttlMsg() + "Pa�s es obligatorio";
	}

	public String dtaPrsCty() {
		return this.ttlMsg() + "Ciudad es obligatoria";
	}

	public String insTpe() {
		return this.ttlMsg() + "Tipo Instituci�n es obligatoria";
	}

	public String insEnt() {
		return this.ttlMsg() + "Instituci�n es obligatoria";
	}

	public String insEntOth() {
		return this.ttlMsg() + "Otra Instituci�n es obligatoria";
	}

	public String insUnt() {
		return this.ttlMsg() + "�rea es obligatoria";
	}

	public String insUntOth() {
		return this.ttlMsg() + "Otra �rea es obligatoria";
	}

	public String insApn() {
		return this.ttlMsg() + "Cargo es obligatorio";
	}

	public String insApnOth() {
		return this.ttlMsg() + "Otro cargo es obligatorio";
	}

	public String dtaEdcLvl() {
		return this.ttlMsg() + "Grado acad�mico es obligatorio";
	}

	public String dtaEdcDsc() {
		return this.ttlMsg() + "Disciplina es obligatoria";
	}

	public String dtaEdcDscSub() {
		return this.ttlMsg() + "Subdisciplina es obligatoria";
	}

	public String emlUsrTxt() {
		return "El registro al Sistema de Gesti�n de Servicios de la Plataforma EpiSIG del INSPI LIP, se ha completado con �xito.";
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
		return "SGI | Cambio de correo electr�nico";
	}

	public String usrChg() {
		return "SGI | Cambio de correo electr�nico";
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

	public String msgErrSndEml = "! Ocurri� un error al generar su nueva contrase�a, contactarse a episig.inspi@gmail.com !";

	public String getMsgErrSndEml() {
		return msgErrSndEml;
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: Login */
	/*---------------------------------------------------------------------------------------------------------*/

	public String msgEmlInc = "! Correo electr�nico Incorrecto !";
	public String msgEmlRqr = "Correo electr�nico/Usuario Obligatorio *";
	public String msgEml = "Correo electr�nico *";

	public String getMsgEml() {
		return msgEml;
	}

	public String msgUsrRqr = "Usuario Obligatorio *";
	public String msgPssRqr = "Contrase�a Obligatoria *";
	public String msgWrnEml = "! Correo electr�nico/Usuario ingresado no existe !";
	public String msgWrnEmlAln = "! Correo electr�nico ingresado no existe !";
	public String msgWrnPsw = "Contrase�a incorrecta";
	public String msgPrfRqr = "Perfil Obligatorio";

	public String getMsgEmlInc() {
		return msgEmlInc;
	}

	public String getMsgWrnEmlAln() {
		return msgWrnEmlAln;
	}

	public String getMsgEmlRqr() {
		return msgEmlRqr;
	}

	public String getMsgPssRqr() {
		return msgPssRqr;
	}

	public String getMsgWrnEml() {
		return msgWrnEml;
	}

	public String getMsgWrnPsw() {
		return msgWrnPsw;
	}

	public String getMsgPrfRqr() {
		return msgPrfRqr;
	}

	public String getMsgUsrRqr() {
		return msgUsrRqr;
	}

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
