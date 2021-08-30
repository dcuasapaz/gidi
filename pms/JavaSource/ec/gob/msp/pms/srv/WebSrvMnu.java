package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.WebTblMnu;

@Stateless
public class WebSrvMnu extends SrvDb<WebTblMnu> {

	public WebSrvMnu() {
		super(WebTblMnu.class, WebSrvMnu.class);

	}

	public List<WebTblMnu> lstMnuRol(int IRolId) {
		try {
			String sql = "SELECT mnu FROM WebTblMnu mnu WHERE mnu.iRolId=:param AND mnu.bMnuStt = TRUE";
			Query q = em.createQuery(sql);
			q.setParameter("param", IRolId);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
