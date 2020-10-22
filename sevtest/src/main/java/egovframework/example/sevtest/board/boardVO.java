package egovframework.example.sevtest.board;

public class boardVO {
	private int INX;
	private String TITLE;
	private String CONTENT;
	private String ID;
	private String INXS[]; //여러개 삭제할 수 있도록
	
	
	public String[] getINXS() {
		return INXS;
	}
	public void setINXS(String[] iNXS) {
		INXS = iNXS;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getINX() {
		return INX;
	}
	public void setINX(int iNX) {
		INX = iNX;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	
	
}
