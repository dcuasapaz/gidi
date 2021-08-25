package ec.gob.inspi.gidi.sit.cmm;

public class Page {

	public Page() {

	}

	public String acr() {
		return "sgi";
	}

	/** Error: En sesi�n */
	public String urlErrorSss() {
		return "/" + this.acr() + "/account/account_sss.jsf";
	}

	/** Url: Login */
	public String urlLgn() {
		return "/" + this.acr() + "/login.jsf";
	}

	/** Url: Login */
	public String urlTsk() {
		return "/" + this.acr() + "/prf/task.jsf";
	}

	public String urlPfl() {
		return "/" + this.acr() + "/prf/profile.jsf";
	}

	public String urlMng() {
		return "/" + this.acr() + "/adm/admin.jsf";
	}

	public String urlEvn() {
		return "/" + this.acr() + "/prf/events.jsf";
	}

	/** Url: Register good */
	public String urlRgsGood() {
		return "/" + this.acr() + "/account/account_rgs.jsf";
	}

	/** Url: Register error */
	public String urlRgsError() {
		return "/" + this.acr() + "/account/account_error.jsf";
	}

}
