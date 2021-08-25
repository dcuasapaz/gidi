package ec.gob.inspi.gidi.sit.cmm;

public class Log {
	public Log() {

	}

	public void impSrv(int nmr, String srv, String obj, String ent, String err) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++ Number: " + nmr);
		System.out.println("++++ Entity: " + ent);
		System.out.println("++++ Class: " + srv);
		System.out.println("++++ Object: " + obj);
		System.out.println("++++ Error: " + err);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	public void impCtl(String cls, String evn, String act, String ent, String err) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++ Class: " + cls);
		System.out.println("++++ Entity: " + ent);
		System.out.println("++++ Event: " + evn);
		System.out.println("++++ Action: " + act);
		System.out.println("++++ Error: " + err);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	public void impMsg(String ttl, String msg) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++ Title: " + ttl);
		System.out.println("++++ Message: " + msg);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	public void impErr(String err) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++ Error: " + err);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
