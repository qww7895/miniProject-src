package paris.member.db;

public class MemberBean {
	private String MID;
	private String MPW;
	private String MNAME;
	private String MHNUM;
	private String MTELL;
	private String MMAIL;
	private int ISADMIN;
	
	public String getMID() {
		return MID;
	}
	public void setMID(String mid) {
		MID = mid;
	}
	public String getMPW() {
		return MPW;
	}
	public void setMPW(String mpw) {
		MPW = mpw;
	}
	public String getMNAME() {
		return MNAME;
	}
	public void setMNAME(String mname) {
		MNAME = mname;
	}
	public String getMHNUM() {
		return MHNUM;
	}
	public void setMHNUM(String mhnum) {
		MHNUM = mhnum;
	}
	public String getMTELL() {
		return MTELL;
	}
	public void setMTELL(String mtell) {
		MTELL = mtell;
	}
	public int getISADMIN() {
		return ISADMIN;
	}
	public void setISADMIN(int isadmin) {
		ISADMIN = isadmin;
	}
	public String getMMAIL() {
		return MMAIL;
	}
	public void setMMAIL(String mmail) {
		MMAIL = mmail;
	}

	
	
}
