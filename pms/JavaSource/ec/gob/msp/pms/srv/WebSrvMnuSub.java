package ec.gob.msp.pms.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.msp.pms.cmm.SrvDb;
import ec.gob.msp.pms.ent.WebTblMnu;
import ec.gob.msp.pms.ent.WebTblMnuSub;

@Stateless
public class WebSrvMnuSub extends SrvDb<WebTblMnuSub> {

	public WebSrvMnuSub() {
		super(WebTblMnuSub.class, WebSrvMnuSub.class);

	}

	public List<WebTblMnuSub> lstMnuSub(int IRolId) {
		try {
			String sql = "SELECT mnuSub FROM WebTblMnuSub mnuSub WHERE mnuSub.webTblMnu.iRolId = :param";
			Query q = em.createQuery(sql);
			q.setParameter("param", IRolId);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<WebTblMnuSub> lstMnuSubOpt(WebTblMnu mnu) {
		try {
			String sql = "SELECT mnuSub FROM WebTblMnuSub mnuSub WHERE mnuSub.webTblMnu=:param AND mnuSub.BMnuSubStt=TRUE ORDER BY mnuSub.iMnuSubCtg";
			Query q = em.createQuery(sql);
			q.setParameter("param", mnu);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
