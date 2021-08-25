package ec.gob.inspi.gidi.sit.cmm;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	protected Log log;
	protected Name nme;

	public Email() {
		log = new Log();
		nme = new Name();
	}

	public boolean sndEmlUsr(String to, String psw, String usr, String ttl, String grt, String nmes, String lstNme,
			String apn, String unt, String ent, String lnk, String emlSpr, String eml, String msg, String sbj) {
		boolean enviado = false;
		try {
			this.log.impMsg("Email - " + to, "Credenciales");
			String emlFrm = "<div style='width: 100%; text-align: center; font-weight: bold; font-size: 16px;'>" + ttl
					+ "</div> <br/>" + "Estimado(a): <br/>" + grt + " " + nmes + " " + lstNme + "<br/>" + apn + "<br/>"
					+ unt + "<br/>" + ent + "<br/>" + "<br/>" + msg + "<br/>" + "<br/>" + "Para mayor informaci�n: "
					+ lnk + "<br/>" + "<br/>" + "<br/>" +

					"<div style='font-size: 12px; width: 100%; text-align: justify;'>Saludos Cordiales<br/>"
					+ "Soporte SGI - EpiSIG<br/>"
					+ "<b>Nota:</b> Este mensaje fue enviado autom�ticamente por el sistema, por favor no lo responda.<br/>"
					+ "Si tiene alguna inquietud respecto a este mensaje, comun�quese a " + emlSpr + "<br/> </div>";

			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", to);
			prop.put("mail.smtp.password", psw);
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to, usr));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(eml, nmes + " " + lstNme));
			message.setSubject(sbj);
			message.setContent(emlFrm, "text/html");
			this.log.impMsg("Enviando...", message + "");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, to, psw);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			this.log.impMsg("Mensaje Enviado", enviado + "");
		} catch (Exception e) {
			e.printStackTrace();
			this.log.impMsg("Mensaje Enviado", enviado + "");

		}
		return enviado;
	}

	public boolean sndEmlPrt(String to, String psw, String usr, String grt, String nmes, String lstNme, String apn,
			String unt, String ent, String img, String lnk, String emlSpr, String eml, String crs, String sbj) {
		boolean enviado = false;
		try {
			String emlFrm = "<div style='width: 100%; text-align: center; font-weight: bold; font-size: 16px;'> "
					+ "</div> <br/>" + "Estimado(a): <br/>" + grt + " " + nmes + " " + lstNme + "<br/>" + apn + "<br/>"
					+ unt + "<br/>" + ent + "<br/>" + "<br/>" + "La inscripci�n al Curso de Capacitaci�n Continua <b>"
					+ crs + " </b> se ha registrado con �xito.<br/>" + "<br/>" + "Para mayor informaci�n: " + lnk
					+ "<br/>" + "<br/>" + "<br/>" +

					"<div style='font-size: 12px; width: 100%; text-align: justify;'>Saludos Cordiales<br/>"
					+ "Soporte SGI - EpiSIG<br/>"
					+ "<b>Nota:</b> Este mensaje fue enviado autom�ticamente por el sistema, por favor no lo responda.<br/>"
					+ "Si tiene alguna inquietud respecto a este mensaje, comun�quese a " + emlSpr + "<br/> </div>";

			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", to);
			prop.put("mail.smtp.password", psw);
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to, usr));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(eml, nmes + " " + lstNme));
			message.setSubject(sbj);
			message.setContent(emlFrm, "text/html");
			this.log.impMsg("Enviando...", message + "");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, to, psw);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			this.log.impMsg("Mensaje Enviado", enviado + "");
		} catch (Exception e) {
			e.printStackTrace();
			this.log.impMsg("Mensaje Enviado", enviado + "");

		}
		return enviado;
	}

	public boolean sndEmlRgsUsrSGI(String to, String psw, String usr, String SAdmNme, String SAdmEml, String DPrsDteRgs,
			String SPrsTmeRgs, int IPrsId, int IPrsRolId, String nmes, String lstNme, String eml, String sbj) {
		boolean enviado = false;
		try {

			String msg = "----------------------------------------------------------------------------<br/>"
					+ "<b>USUARIO REGISTRADO EN EL SISTEMA - EpiSIG</b><br/>"
					+ "----------------------------------------------------------------------------<br/>"
					+ "<b>Fecha registro: </b>" + DPrsDteRgs + "<br/>" + "<b>Hora registro:</b> " + SPrsTmeRgs + "<br/>"
					+ "<b>C�digo Persona:</b> " + IPrsId + "<br/>" + "<b>C�digo Usuario:</b> " + IPrsRolId + "<br/>"
					+ "<b>Nombres: </b>" + nmes + "<br/>" + "<b>Apellidos: </b>" + lstNme + "<br/>"
					+ "<b>Correo electr�nico: </b>" + eml + "<br/>"
					+ "----------------------------------------------------------------------------<br/>";
			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", to);
			prop.put("mail.smtp.password", psw);
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to, usr));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(SAdmEml, SAdmNme));
			message.setSubject(sbj);
			message.setContent(msg, "text/html");
			this.log.impMsg("Enviando...", message + "");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, to, psw);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			this.log.impMsg("Mensaje Enviado", enviado + "");
		} catch (Exception e) {
			this.log.impCtl(Email.class.getSimpleName(), this.nme.evnLoad(), this.nme.actSnd(),
					Email.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			this.log.impMsg("Mensaje Enviado", enviado + "");
		}
		return enviado;
	}

	public boolean sndChgEmlUsr(String to, String psw, String usr, String ttl, String grt, String nmes, String lstNme,
			String emlNew, String emlSpr, String emlAnt, String sbj) {
		boolean enviado = false;
		try {
			String emlFrm = "<div style='width: 100%; text-align: center; font-weight: bold; font-size: 16px;'>" + ttl
					+ "</div> <br/>" + "Estimado(a): <br/>" + grt + " " + nmes + " " + lstNme + "<br/>" + "<br/>"
					+ "<br/>" + "El cambio de correo electr�nico " + emlAnt + " por " + emlNew
					+ ", se ha completado con �xito. " + "<br/>" + "<br/>" + "<br/>" +

					"<div style='font-size: 12px; width: 100%; text-align: justify;'>Saludos Cordiales<br/>"
					+ "Soporte SGI - EpiSIG<br/>"
					+ "<b>Nota:</b> Este mensaje fue enviado autom�ticamente por el sistema, por favor no lo responda.<br/>"
					+ "Si tiene alguna inquietud respecto a este mensaje, comun�quese a " + emlSpr + "<br/> </div>";

			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", to);
			prop.put("mail.smtp.password", psw);
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to, usr));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(emlAnt, nmes + " " + lstNme));
			message.setSubject(sbj);
			message.setContent(emlFrm, "text/html");
			this.log.impMsg("Enviando...", message + "");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, to, psw);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			this.log.impMsg("Mensaje Enviado", enviado + "");
		} catch (Exception e) {
			e.printStackTrace();
			this.log.impMsg("Mensaje Enviado", enviado + "");

		}
		return enviado;
	}
	
	public boolean sndChgUsr(String to, String psw, String usr, String ttl, String grt, String nmes, String lstNme,
			String usrNew, String emlSpr, String usrAnt, String sbj) {
		boolean enviado = false;
		try {
			String emlFrm = "<div style='width: 100%; text-align: center; font-weight: bold; font-size: 16px;'>" + ttl
					+ "</div> <br/>" + "Estimado(a): <br/>" + grt + " " + nmes + " " + lstNme + "<br/>" + "<br/>"
					+ "<br/>" + "El cambio de usuario " + usrAnt + " por " + usrNew
					+ ", se ha completado con �xito. " + "<br/>" + "<br/>" + "<br/>" +

					"<div style='font-size: 12px; width: 100%; text-align: justify;'>Saludos Cordiales<br/>"
					+ "Soporte SGI - EpiSIG<br/>"
					+ "<b>Nota:</b> Este mensaje fue enviado autom�ticamente por el sistema, por favor no lo responda.<br/>"
					+ "Si tiene alguna inquietud respecto a este mensaje, comun�quese a " + emlSpr + "<br/> </div>";

			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", to);
			prop.put("mail.smtp.password", psw);
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to, usr));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to, nmes + " " + lstNme));
			message.setSubject(sbj);
			message.setContent(emlFrm, "text/html");
			this.log.impMsg("Enviando...", message + "");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, to, psw);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			this.log.impMsg("Mensaje Enviado", enviado + "");
		} catch (Exception e) {
			e.printStackTrace();
			this.log.impMsg("Mensaje Enviado", enviado + "");
		}
		return enviado;
	}

	public boolean sndRcvEml(String grt, String nmes, String lstNme, String eml, String pswNew) {
		boolean enviado = false;

		String sbj = "SGI | Recuperar contrase�a";
		String ttl = "EpiSIG | Sistema de Gesti�n Interna";
		String to = "episig.inspi@gmail.com";
		String psw = "20SIG16Epi";
		String nme = "INSPI - EpiSIG";

		try {
			String emlFrm = "<div style='width: 100%; text-align: center; font-weight: bold; font-size: 16px;'>" + ttl
					+ "</div> <br/>" + "Estimado(a): <br/>" + grt + " " + nmes + " " + lstNme + "<br/>" + "<br/>"
					+ "<br/>"
					+ "Usted est� recibiendo este correo electr�nico porque ha solicitado recuperar la contrase�a para el usuario: "
					+ eml + ". " + "<br/>" + "<br/>"
					+ "A continuaci�n, encontrar� el usuario y contrase�a nueva: <br/> <br/>" + "<b>Email: </b>" + eml
					+ "<br/>" + "<b>Contrase�a: </b>" + pswNew + "<br/><br/><br/>"
					+ "<b>Nota: </b> Es recomendable cambiar la contrase�a para que pueda recordarla."
					+ "<br/><br/><br/>"
					+ "<div style='font-size: 12px; width: 100%; text-align: justify;'>Saludos Cordiales<br/>"
					+ "Soporte SGI - EpiSIG<br/>"
					+ "<b>Nota:</b> Este mensaje fue enviado autom�ticamente por el sistema, por favor no lo responda.<br/>"
					+ "Si tiene alguna inquietud respecto a este mensaje, comun�quese a " + to + "<br/> </div>";
			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", to);
			prop.put("mail.smtp.password", psw);
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to, nme));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(eml, nmes + " " + lstNme));
			message.setSubject(sbj);
			message.setContent(emlFrm, "text/html");
			this.log.impMsg("Enviando...", message + "");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, to, psw);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			this.log.impMsg("Mensaje Enviado", enviado + "");
		} catch (Exception e) {
			e.printStackTrace();
			this.log.impMsg("Mensaje Enviado", enviado + "");

		}
		return enviado;
	}

}