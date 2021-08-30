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
	public String msgInfGntrPsw = "Contraseña generada exitosamente";
	public String msgErrGntrPsw = "Error al generar la contraseña";
	public String SMsgErrFrmPrsEml = "!Formato de Email incorrecto!";
	public String SMsgRqr = "!Campo obligatorio!";

	public String SMsgSveOk = "!Información almacenada correctamente!";
	public String SMsgUpdOk = "!Información actualizada correctamente!";
	public String SMsgDltOk = "!Información eliminada correctamente!";

	public String SMsgSveErr = "!Ocurrió un error al almacenar la información !";
	public String SMsgUpdErr = "!Ocurrió un error al actualizar la información !";
	public String SMsgDltErr = "!Ocurrió un error al eliminar la información !";

	public String SMsgErrFleSize = "! El archivo seleccionado ha superado el tamaño máximo !";
	public String SMsgErrFleFmt = "! El formato del archivo seleccionado es invalido !";
	public String SMsgErrFleSizeInv = "! Tamaño de archivo invalido !";

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
