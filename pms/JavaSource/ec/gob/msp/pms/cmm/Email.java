package ec.gob.msp.pms.cmm;

import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ec.gob.msp.pms.ent.DtaTblPr;
import ec.gob.msp.pms.srv.ScrSrvOpt;

@ViewScoped
@ManagedBean
public class Email {

	protected PMS pms;
	@EJB
	protected ScrSrvOpt SScrOpt;

	public Email() {
		pms = new PMS();
	}

	public boolean enviarcorreo(String from, String psw, String to, String msg, String sbj) {
		boolean enviado = false;
		try {
			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", from);
			prop.put("mail.smtp.password", psw);
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from, "INSPI - EpiSIG"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sbj);
			message.setText(msg);
			System.out.print(message);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, psw);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;
			System.out.print(enviado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enviado;
	}

	public boolean sndEmlPrf(DtaTblPr prs, String prl, String ent) {
		boolean enviado = false;
		try {

			String emlFrm = "<div style='font-size: 11px; width: 100%; text-align: justify;'>" + "Estimad@: <br/>"
					+ prs.getSPrsNme() + " " + prs.getSPrsLstNme() + "<br/><br/>" + "El registro en la <b>'"
					+ pms.getNme() + "'</b> se realizó con éxito.<br/><br/>"
					+ "Para acceder a la aplicación utilizar los siguientes datos: <br/><br/>" + "<b>- Enlace:</b> "
					+ pms.getLnk() + "<br/>" + "<b>- Correo electrónico:</b> " + prs.getSPrsEml() + "<br/>"
					+ "<b>- Usuario:</b> " + prs.getSPrsUsr() + "<br/>" + "<b>- Contraseña:</b> " + prs.getSPrsPsw()
					+ "<br/>" + "<b>- Perfiles asignados:</b> " + prl + "<br/>" + "<b>- Municipio/Institución: </b> "
					+ ent + "<br/><br/><br/></div>" + "<div style='font-size: 10px; width: 100%; text-align: justify;'>"
					+ "<b>Recomendaciones:</b><br/>"
					+ "  -  Para acceder a la herramienta informática puede usar el correo electrónico o usuario con la contraseña asignada. <br/>"
					+ "  -  Si tiene alguna inquietud respecto a este mensaje comunicarse al correo electrónico "
					+ pms.getEml() + ". <br/>"
					+ "  -  No difundir este mensaje ya que posee información relevante del profesional."
					+ "<br/><br/><br/></div>" + "<div style='font-size: 10px; width: 100%; text-align: justify;'>"
					+ "Saludos Cordiales,<br/>" + "Soporte " + pms.getToEml() + "<br/>"
					+ "<b>Nota:</b> Este mensaje fue enviado automáticamente por el sistema, por favor no lo responda.<br/>"
					+ "</div>";
			String host = "smtp.gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.user", "app.pms.msp@gmail.com");
			prop.put("mail.smtp.password", "Msp!*20Pms");
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			Session session = Session.getDefaultInstance(prop, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("app.pms.msp@gmail.com", "MSP-PMS"));
			message.setRecipient(Message.RecipientType.TO,
					new InternetAddress(prs.getSPrsEml(), prs.getSPrsNme() + " " + prs.getSPrsLstNme()));
			message.setSubject("Profesional registrado correctamente ");
			message.setContent(emlFrm, "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, "app.pms.msp@gmail.com", "Msp!*20Pms");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return enviado;
	}

}