package ec.gob.msp.pms.cmm;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Message {
	public Message() {
	}

	public static final String T_SCR_END_SSS = "End Session - " + Default.S_CURRENT_TIME();
	public static final String T_SCR_STR_SSS = "Start Session - " + Default.S_CURRENT_TIME() + " | ";

	public String ttlMsg() {
		return "PMS | ";
	}

	public String ttlLbl() {
		return "PMS | ";
	}

	public String msgErrSrcPrm = "Error al buscar variable";
	public String msgInfSrcEml = "Email libre";
	public String msgInfSrcUsr = "Usuario libre";
	public String msgWrnSrcEml = "Email pertenece a otro profesional";
	public String msgWrnSrcUsr = "Usuario pertenece a otro profesional";
	public String msgInfGntrPsw = "Contrase�a generada exitosamente";
	public String msgErrGntrPsw = "Error al generar la contrase�a";
	public String SMsgErrFrmPrsEml = "!Formato de Email incorrecto!";
	public String SMsgRqr = "!Campo obligatorio!";

	public String SMsgSveOk = "!Informaci�n almacenada correctamente!";
	public String SMsgUpdOk = "!Informaci�n actualizada correctamente!";
	public String SMsgDltOk = "!Informaci�n eliminada correctamente!";

	public String SMsgSveErr = "!Ocurri� un error al almacenar la informaci�n !";
	public String SMsgUpdErr = "!Ocurri� un error al actualizar la informaci�n !";
	public String SMsgDltErr = "!Ocurri� un error al eliminar la informaci�n !";

	public String SMsgErrFleSize = "! El archivo seleccionado ha superado el tama�o m�ximo !";
	public String SMsgErrFleFmt = "! El formato del archivo seleccionado es invalido !";
	public String SMsgErrFleSizeInv = "! Tama�o de archivo invalido !";

	public void msgInf(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_INFO, this.ttlLbl(), msg));
	}

	public void msgWrn(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_WARN, this.ttlLbl(), msg));
	}

	public void msgErr(String msg) {
		FacesContext aux = FacesContext.getCurrentInstance();
		aux.addMessage(this.ttlMsg(), new FacesMessage(FacesMessage.SEVERITY_ERROR, this.ttlLbl(), msg));
	}

	public String getMsgErrSrcPrm() {
		return msgErrSrcPrm;
	}

	public String getMsgInfGntrPsw() {
		return msgInfGntrPsw;
	}

	public String getMsgErrGntrPsw() {
		return msgErrGntrPsw;
	}

	public String getSMsgErrFrmPrsEml() {
		return SMsgErrFrmPrsEml;
	}

	public String getSMsgRqr() {
		return SMsgRqr;
	}

	public String getMsgWrnSrcEml() {
		return msgWrnSrcEml;
	}

	public String getMsgWrnSrcUsr() {
		return msgWrnSrcUsr;
	}

	public String getMsgInfSrcEml() {
		return msgInfSrcEml;
	}

	public String getMsgInfSrcUsr() {
		return msgInfSrcUsr;
	}

	public String getSMsgSveOk() {
		return SMsgSveOk;
	}

	public String getSMsgUpdOk() {
		return SMsgUpdOk;
	}

	public String getSMsgDltOk() {
		return SMsgDltOk;
	}

	public String getSMsgSveErr() {
		return SMsgSveErr;
	}

	public String getSMsgUpdErr() {
		return SMsgUpdErr;
	}

	public String getSMsgDltErr() {
		return SMsgDltErr;
	}

	public String getSMsgErrFleSize() {
		return SMsgErrFleSize;
	}

	public String getSMsgErrFleFmt() {
		return SMsgErrFleFmt;
	}

	public String getSMsgErrFleSizeInv() {
		return SMsgErrFleSizeInv;
	}

}
