package egovframework.example.sevtest.board;

import org.springframework.web.multipart.MultipartFile;

public class boardVO  {
	private int INX;
	private String TITLE;
	private String CONTENT;
	private String ID;
	private String INXS[]; //여러개 삭제할 수 있도록
	private String NOTICE_DATE;
	private MultipartFile IMG1;
	private String IMG_1;
	private String INFO; //조회수
	
	
	public String getINFO() {
		return INFO;
	}
	public void setINFO(String iNFO) {
		INFO = iNFO;
	}
	public MultipartFile getIMG1() {
		return IMG1;
	}
	public void setIMG1(MultipartFile iMG1) {
		IMG1 = iMG1;
	}
	
	public String getIMG_1() {
		return IMG_1;
	}
	public void setIMG_1(String iMG_1) {
		IMG_1 = iMG_1;
	}
	public String getNOTICE_DATE() {
		return NOTICE_DATE;
	}
	public void setNOTICE_DATE(String nOTICE_DATE) {
		NOTICE_DATE = nOTICE_DATE;
	}
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
