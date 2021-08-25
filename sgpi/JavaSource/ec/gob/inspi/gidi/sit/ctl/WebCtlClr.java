package ec.gob.inspi.gidi.sit.ctl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.Name;
import ec.gob.inspi.gidi.sit.cmm.Page;
import ec.gob.inspi.gidi.sit.ent.WebTblClr;
import ec.gob.inspi.gidi.sit.srv.WebSrvClr;

@ManagedBean
public class WebCtlClr {

	protected Log log;
	protected Name nme;
	protected Page pge;

	public WebCtlClr() {
		log = new Log();
		nme = new Name();
		pge = new Page();
	}

	@EJB
	protected WebSrvClr sclr;

	public WebTblClr rtrClr(int IClrId) {
		try {
			return sclr.searchId(IClrId);
		} catch (Exception e) {
			this.log.impCtl(WebCtlClr.class.getSimpleName(), nme.evnInit(), nme.actSrc(),
					WebTblClr.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
