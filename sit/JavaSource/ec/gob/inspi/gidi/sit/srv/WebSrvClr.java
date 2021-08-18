package ec.gob.inspi.gidi.sit.srv;

import javax.ejb.Stateless;

import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.WebTblClr;

@Stateless
public class WebSrvClr extends SrvDb<WebTblClr> {

	public WebSrvClr() {
		super(WebTblClr.class, WebSrvClr.class);

	}

}
