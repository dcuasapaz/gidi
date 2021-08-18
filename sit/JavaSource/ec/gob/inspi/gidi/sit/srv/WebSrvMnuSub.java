package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.WebTblMnuSub;

@Stateless
public class WebSrvMnuSub extends SrvDb<WebTblMnuSub> {

	protected Log log;

	public WebSrvMnuSub() {
		super(WebTblMnuSub.class, WebSrvMnuSub.class);
		log = new Log();

	}

	/** 01. SubMenu por Menu **/
	public List<WebTblMnuSub> lstMnuSub(int IMnuId) {
		try {
			String sql = "SELECT mnusub FROM WebTblMnuSub mnusub WHERE mnusub.iMnuId = :param ORDER BY iMdlId, iMnuSubCtg";
			Query q = em.createQuery(sql);
			q.setParameter("param", IMnuId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, WebSrvMnuSub.class.getSimpleName(), List.class.getSimpleName(),
					WebTblMnuSub.class.getSimpleName(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
