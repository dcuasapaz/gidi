package ec.gob.inspi.gidi.sit.ctl;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.gob.inspi.gidi.sit.cmm.Code;
import ec.gob.inspi.gidi.sit.cmm.Default;
import ec.gob.inspi.gidi.sit.cmm.Email;
import ec.gob.inspi.gidi.sit.cmm.Message;
import ec.gob.inspi.gidi.sit.cmm.Method;
import ec.gob.inspi.gidi.sit.ent.DtaTblPr;
import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;
import ec.gob.inspi.gidi.sit.srv.DtaSrvOpt;
import ec.gob.inspi.gidi.sit.srv.DtaSrvPrs;
import ec.gob.inspi.gidi.sit.srv.ScrSrvPrsRol;


@ManagedBean
@ViewScoped
public class ScrCtlPss {

	protected Code cde;
	protected Message msg;
	protected Email eml;
	protected Default dfl;
	protected Method mth;

	protected ScrTblPrsRol prl;
	private DtaTblPr prs;
	@EJB
	protected DtaSrvPrs sprs;
	@EJB
	protected ScrSrvPrsRol sprl;
	@EJB
	protected DtaSrvOpt sDtaOpt;

	private boolean vsbPngDta;
	private boolean vsbPngInf;

	private void actPng(boolean dta, boolean inf) {
		vsbPngDta = dta;
		vsbPngInf = inf;
	}

	public ScrCtlPss() {
		prs = new DtaTblPr();
		cde = new Code();
		msg = new Message();
		eml = new Email();
		dfl = new Default();
		mth = new Method();
		prl = new ScrTblPrsRol();
	}

	@PostConstruct
	public void init() {
		this.actPng(true, false);
	}

	public void next() {
		boolean bemail = false;
		try {
			for (ScrTblPrsRol auxPrl : sprl.lstPrsRol(cde.scrRolMng(), cde.scrRolUsr())) {
				if (auxPrl.getDtaTblPr().getSPrsEml().trim().compareToIgnoreCase(prs.getSPrsEml()) == 0) {
					bemail = true;
					prl = auxPrl;
					break;
				}
			}
			if (bemail == false) {
				this.msg.msgWrn(msg.msgWrnEml);
			} else {
				DtaTblPr prsAux = new DtaTblPr();
				prsAux = prl.getDtaTblPr();
				prsAux.setSPrsPsw(dfl.sCurrentDateFile() + "_" + prsAux.getIPrsId());
				sprs.update(prsAux);
				if (eml.sndRcvEml(sDtaOpt.searchId(prsAux.getIGrtId()).getSOptAcr(), prsAux.getSPrsNme(),
						prsAux.getSPrsLstNme(), prsAux.getSPrsEml(), prsAux.getSPrsPsw())) {
					this.actPng(false, true);
				} else {
					this.msg.msgErr(msg.msgErrSndEml);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.msg.msgErr(msg.msgErrSndEml);
		}
	}

	public DtaTblPr getPrs() {
		return prs;
	}

	public void setPrs(DtaTblPr prs) {
		this.prs = prs;
	}

	public boolean isVsbPngDta() {
		return vsbPngDta;
	}

	public void setVsbPngDta(boolean vsbPngDta) {
		this.vsbPngDta = vsbPngDta;
	}

	public boolean isVsbPngInf() {
		return vsbPngInf;
	}

	public void setVsbPngInf(boolean vsbPngInf) {
		this.vsbPngInf = vsbPngInf;
	}

}
