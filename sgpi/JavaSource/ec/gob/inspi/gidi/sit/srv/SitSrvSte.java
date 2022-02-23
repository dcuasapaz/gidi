package ec.gob.inspi.gidi.sit.srv;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.SitTblSte;

@Stateless
public class SitSrvSte extends SrvDb<SitTblSte> {
	private static Logger LOG;

	public SitSrvSte() {
		super(SitTblSte.class, SitSrvSte.class);
		LOG = Logger.getLogger(this.getClass().getName());
	}

	public List<SitTblSte> lstSte(int IPrjId, boolean bSteStt) {
		try {
			String sql = "SELECT ste FROM SitTblSte ste WHERE ste.iPrjId = :param1 AND  ste.bSteStt = :param2";
			Query q = em.createQuery(sql);
			q.setParameter("param1", IPrjId);
			q.setParameter("param2", bSteStt);
			return q.getResultList();
		} catch (Exception e) {
			LOG.log(Level.WARNING, Message.S_LOG_NME_SRV + e.getMessage());
			return null;
		}

	}
}
