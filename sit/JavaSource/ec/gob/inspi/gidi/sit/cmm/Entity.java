package ec.gob.inspi.gidi.sit.cmm;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.ent.InsTblApn;
import ec.gob.inspi.gidi.sit.ent.InsTblEnt;
import ec.gob.inspi.gidi.sit.ent.InsTblUnt;
import ec.gob.inspi.gidi.sit.srv.InsSrvApn;
import ec.gob.inspi.gidi.sit.srv.InsSrvEnt;
import ec.gob.inspi.gidi.sit.srv.InsSrvUnt;

@ManagedBean
@ViewScoped
public class Entity {

	protected Code cde;
	protected Log log;
	protected Name nme;
	protected Method mth;
	protected Default dfl;
	protected Message msg;

	@EJB
	public InsSrvEnt sent;

	@EJB
	public InsSrvUnt sunt;

	@EJB
	public InsSrvApn sapn;

	public Entity() {
		cde = new Code();
		log = new Log();
		nme = new Name();
		mth = new Method();
		dfl = new Default();
		msg = new Message();
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/* PAGE: crt_account, MODULE: INS */
	/*---------------------------------------------------------------------------------------------------------*/
	public boolean saveScrEnt(int ITpeId, int ICnrId, InsTblEnt insEnt) {
		try {
			insEnt.setDEntDteRgs(dfl.dCurrentDate());
			insEnt.setSEntTmeRgs(dfl.currentTime());
			insEnt.setSEntCde(dfl.cmpStr());
			insEnt.setSEntNme(mth.mtdStrNmb(insEnt.getSEntNme()));
			insEnt.setSEntAcr(dfl.cmpStr());
			insEnt.setITpeId(ITpeId);
			insEnt.setICnrId(ICnrId);
			insEnt.setILvlId(dfl.cmpInt());
			sent.insert(insEnt);
			this.log.impMsg(msg.msgSaveInf(), InsTblEnt.class.getSimpleName());
			return true;
		} catch (Exception e) {
			this.log.impCtl(Entity.class.getSimpleName(), nme.evnSlc(), nme.actSave(), InsTblEnt.class.getSimpleName(),
					e.getMessage());
			e.printStackTrace();
			this.log.impMsg(msg.msgSaveErr(), InsTblEnt.class.getSimpleName());
			return false;
		}
	}

	public boolean saveScrUnt(InsTblEnt insEnt, InsTblUnt unt) {
		try {
			unt.setDUntDteRgs(dfl.dCurrentDate());
			unt.setSUntTmeRgs(dfl.currentTime());
			unt.setSUntNme(mth.mtdStrNmb(unt.getSUntNme()));
			unt.setSUntAcr(dfl.cmpStr());
			unt.setInsTblEnt(insEnt);
			unt.setILvlId(dfl.cmpInt());
			sunt.insert(unt);
			this.log.impMsg(msg.msgSaveInf(), InsTblUnt.class.getSimpleName());
			return true;
		} catch (Exception e) {
			this.log.impCtl(Entity.class.getSimpleName(), nme.evnSlc(), nme.actSave(), InsTblUnt.class.getSimpleName(),
					e.getMessage());
			e.printStackTrace();
			this.log.impMsg(msg.msgSaveErr(), InsTblUnt.class.getSimpleName());
			return false;
		}
	}

	public boolean saveScrApn(InsTblUnt unt, InsTblApn apn) {
		try {
			apn.setDApnDteRgs(dfl.dCurrentDate());
			apn.setSApnTmeRgs(dfl.currentTime());
			apn.setSApnNme(mth.mtdStrNmb(apn.getSApnNme()));
			sapn.insert(apn);
			this.log.impMsg(msg.msgSaveInf(), InsTblApn.class.getSimpleName());
			return true;
		} catch (Exception e) {
			this.log.impCtl(Entity.class.getSimpleName(), nme.evnSlc(), nme.actSave(), InsTblApn.class.getSimpleName(),
					e.getMessage());
			e.printStackTrace();
			this.log.impMsg(msg.msgSaveErr(), InsTblApn.class.getSimpleName());
			return false;
		}
	}

}
