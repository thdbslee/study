package egovframework.example.sevtest;

public class sevVO {
	private int INX;
	private String[] INXS; //삭제할때 여러개 할수있도록
	private String NAME;
	private String PHONE;
	private String LEVEL;
	private String AGE;
	private String STWORK;
	public int getINX() {
		return INX;
	}
	public void setINX(int iNX) {
		INX = iNX;
	}
	public String getNAME() {
		return NAME;
	}
	
	public String[] getINXS() {
		return INXS;
	}
	public void setINXS(String[] iNXS) {
		INXS = iNXS;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public String getSTWORK() {
		return STWORK;
	}
	public void setSTWORK(String sTWORK) {
		STWORK = sTWORK;
	}
	
	
	
	
}
