package ec.gob.msp.pms.srv;

import javax.ejb.Stateless;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.WebTblClr;


@Stateless
public class WebSrvClr extends SrvDb<WebTblClr> {

	public WebSrvClr() {
		super(WebTblClr.class, WebSrvClr.class);
	}
	
	

}
