package ec.gob.inspi.gidi.sit.srv;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Log;
import ec.gob.inspi.gidi.sit.cmm.SrvDb;
import ec.gob.inspi.gidi.sit.ent.InsTblEnt;

@Stateless
public class InsSrvEnt extends SrvDb<InsTblEnt> {
	protected Log log;
	protected Default dfl;

	public InsSrvEnt() {
		super(InsTblEnt.class, InsSrvEnt.class);
		log = new Log();
		dfl = new Default();
	}

	public boolean save(InsTblEnt ent, int ILvlId, int ITpeId, int ICnrId) {
		try {
			InsTblEnt aux = new InsTblEnt();
			aux.setSEntTmeRgs(dfl.currentTime());
			aux.setDEntDteRgs(dfl.dCurrentDate());
			aux.setSEntNme(ent.getSEntNme());
			aux.setSEntCde(ent.getSEntCde());
			aux.setSEntAcr(ent.getSEntAcr());
			aux.setITpeId(ITpeId);
			aux.setILvlId(ILvlId);
			aux.setICnrId(ICnrId);
			this.insert(aux);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(InsTblEnt ent, int ILvlId, int ITpeId, int ICnrId) {
		try {
			ent.setITpeId(ITpeId);
			ent.setILvlId(ILvlId);
			ent.setICnrId(ICnrId);
			this.update(ent);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<InsTblEnt> lstEnt(int iTpeId) {
		try {
			String sql = "SELECT ent FROM InsTblEnt ent WHERE ent.iTpeId = :param ORDER BY sEntNme ASC";
			Query q = em.createQuery(sql);
			q.setParameter("param", iTpeId);
			return q.getResultList();
		} catch (Exception e) {
			this.log.impSrv(1, InsTblEnt.class.getSimpleName(), List.class.getSimpleName(),
					InsTblEnt.class.getSimpleName(), e.getMessage());
			return null;
		}

	}

}
