package com.example.quiz;

public class Question {
	private int ID;
	private int LVL;
	private String QUESTION;
	private String OPTA;
	private String OPTB;
	private String OPTC;
	private String ANSWER;

	public Question()
	{
		ID=0;
		LVL=0;
		QUESTION="";
		OPTA="";
		OPTB="";
		OPTC="";
		ANSWER="";
	}

	public Question(int lvl, String question, String oPTA, String oPTB, String oPTC,
			String answer) {
		LVL = lvl;
		QUESTION = question;
		OPTA = oPTA;
		OPTB = oPTB;
		OPTC = oPTC;
		ANSWER = answer;
	}

	public int getID() { return ID; }
	public int getLVL() { return LVL; }
	public String getQUESTION() {
		return QUESTION;
	}
	public String getOPTA() {
		return OPTA;
	}
	public String getOPTB() {
		return OPTB;
	}
	public String getOPTC() {
		return OPTC;
	}
	public String getANSWER() {
		return ANSWER;
	}

	public void setID(int id)
	{
		ID=id;
	}
	public void setLVL(int lvl) { LVL=lvl; }
	public void setQUESTION(String question) {
		QUESTION = question;
	}
	public void setOPTA(String oPTA) {
		OPTA = oPTA;
	}
	public void setOPTB(String oPTB) {
		OPTB = oPTB;
	}
	public void setOPTC(String oPTC) {
		OPTC = oPTC;
	}
	public void setANSWER(String answer) {
		ANSWER = answer;
	}

}
