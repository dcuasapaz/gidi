package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.WebTblMnu;

@Stateless
public class WebSrvMnu extends SrvDb<WebTblMnu> {

	protected Log log;

	public WebSrvMnu() {
		super(WebTblMnu.class, WebSrvMnu.class);
		log = new Log();

	}

	/** 01. Menu por Rol **/
	public WebTblMnu mnuRol(int IRolId) {
		try {
			String sql = "SELECT mnu FROM WebTblMnu mnu WHERE mnu.iRolCde = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", IRolId);
			return (WebTblMnu) q.getSingleResult();
		} catch (Exception e) {
			this.log.impSrv(1, WebSrvMnu.class.getSimpleName(), Object.class.getSimpleName(),
					WebTblMnu.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
