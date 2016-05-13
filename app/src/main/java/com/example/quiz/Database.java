package com.example.quiz;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "questionsDb";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_LVL = "lvl";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c

	private SQLiteDatabase dbase;

	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_LVL+" INTEGER, "+ KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		db.execSQL(sql);		
		addQuestions();
	}

	private void addQuestions()
	{
		Question q1=new Question(1,"Which of the following device" +
				" is using for typing?", "Keyboard", "Monitor", "Mouse",  "Keyboard");
		this.addQuestion(q1);

		Question q2=new Question(1,"Which of the following is NOT " +
				"an operating system?", "SuSe", "BIOS", "DOS", "BIOS");
		this.addQuestion(q2);

		Question q3=new Question(1,"Which of the following is the fastest" +
				" writable memory?","RAM", "FLASH","Register", "Register");
		this.addQuestion(q3);

		Question q4=new Question(1,"Which of the following device" +
				" regulates internet traffic?",	"Router", "Bridge", "Hub",  "Router");
		this.addQuestion(q4);

		Question q5=new Question(1,"Which of the following is NOT an" +
				" interpreted language?", "Ruby", "Python", "BASIC", "BASIC");
		this.addQuestion(q5);

		Question q6=new Question(1,"Which of the following is NOT an" +
				" object-oriented language?","HTML", "Java", "C#", "HTML");
		this.addQuestion(q6);

		Question q7=new Question(1,"Which of the following is NOT " +
				"loop?", "FOR", "WHILE", "IF", "IF");
		this.addQuestion(q7);

		Question q8=new Question(1,"Which of the following is mobile" +
				"devices operating system ?","LINUX", "DOS", "Android", "Android");
		this.addQuestion(q8);

		Question q9=new Question(1,"Which company is the largest manufacturer" +
				" of network equipment?","HP", "IBM", "CISCO", "CISCO");
		this.addQuestion(q9);

		Question q10=new Question(1,"When was internet invented" +
				"?", "1948", "2000", "1960", "1960");
		this.addQuestion(q10);

		Question q11=new Question(2,"The other name for a Hard disk is" +
				"?", "Floppy Disk", "Hard Drive Disk", "Compact Disk", "Hard Drive Disk");
		this.addQuestion(q11);

		Question q12=new Question(2,"What is the meaning of CPU" +
				"?", "Central Processing Unit", "Critical Processing Unit", "Crucial Processing Unit", "Central Processing Unit");
		this.addQuestion(q12);

		Question q13=new Question(2,"The process of starting the computer is called" +
				"?", "Connecting", "Booting", "Start Up point", "Booting");
		this.addQuestion(q13);

		Question q14=new Question(2,"Which one is the first word processor application" +
				"?", "MS Word", "Sun StarOffice", "WordStar", "WordStar");
		this.addQuestion(q14);

		Question q15=new Question(2,"Which operating system is used by Apple Inc" +
				"?", "Windows", "Android", "iOS", "iOS");
		this.addQuestion(q15);

		Question q16=new Question(2,"Where is the headquter of Microsoft" +
				"office located ?", "New York", "Washington", "California", "Washington");
		this.addQuestion(q16);

		Question q17=new Question(2,"GIF is an extension of" +
				"?", "Image File", "Video File", "Audio File", "Image File");
		this.addQuestion(q17);

		Question q18=new Question(2,"Mac operating system is developed by" +
				"which company?", "IBM", "Microsoft", "Apple", "Apple");
		this.addQuestion(q18);

		Question q19=new Question(2,"Which of the following is NOT" +
				"a database software?", "COBOL", "Oracle", "Sybase", "COBOL");
		this.addQuestion(q19);

		Question q20=new Question(2,"Which of the following is NOT" +
				"an operating system?", "DOS", "Mac", "C", "C");
		this.addQuestion(q20);

		Question q21=new Question(3,"In computer world, Trojan refer to" +
				"?", "Spyware", "Malware", "Virus", "Malware");
		this.addQuestion(q21);

		Question q22=new Question(3,"Which protocol is used to receive e-mail" +
				"?", "POP3", "FTP", "HTTP", "POP3");
		this.addQuestion(q22);

		Question q23=new Question(3,"Which of the following is NOT" +
				"web browser?", "Facebook", "WWW", "MOSAIC", "Facebook");
		this.addQuestion(q23);

		Question q24=new Question(3,"What is the extension type of the" +
				"excel 2007 files?", ".xls", ".xsl", ".xlsx", ".xlsx");
		this.addQuestion(q24);

		Question q25=new Question(3,"A folder in windows computer cant be made" +
				"with the name?", "con", "make", "can", "con");
		this.addQuestion(q25);

		Question q26=new Question(3,"Total number of function keys in a" +
				"computer keyboard?", "10", "12", "14", "12");
		this.addQuestion(q26);

		Question q27=new Question(3,"Which one is text editor for MS Windows" +
				"?", "WordPad", "MS Word", "Notepad", "Notepad");
		this.addQuestion(q27);

		Question q28=new Question(3,"The basic units of a excel spreedsheet where we" +
				"enter data is called?", "Box", "Cell", "Tab", "Cell");
		this.addQuestion(q28);

		Question q29=new Question(3,"Linux is an example of" +
				"?", "Software", "Operating System", "Application", "Operating System");
		this.addQuestion(q29);

		Question q30=new Question(3,"A common boundary between two computers is" +
				"known as?", "Interface", "Surface", "Intradiction", "Interface");
		this.addQuestion(q30);

		//Hardcore level

		Question q31=new Question(4,"Who created the C programming language" +
				"?", "Robin Milner", "Ken Thompson", "Dennis Ritchie", "Dennis Ritchie");
		this.addQuestion(q31);

		Question q32=new Question(4,"India first super computer PARAM 8000 was" +
				"installed in?", "1991", "1995", "1988", "1991");
		this.addQuestion(q32);

		Question q33=new Question(4,"Who developed Java programming language" +
				"?", "James D. Foley", "Douglas Engelbart", "James Gosling", "James Gosling");
		this.addQuestion(q33);

		Question q34=new Question(4,"Number of bit used by the IPv6 address" +
				"?", "128 bit", "64 bit", "32 bit", "128 bit");
		this.addQuestion(q34);

		Question q35=new Question(4,"Who is known as the founder of IBM company" +
				"?", "Steve Jobs", "Thomas J. Watson", "Alan Turing", "Thomas J. Watson");
		this.addQuestion(q35);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}

	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_LVL, quest.getLVL());
		values.put(KEY_QUES, quest.getQUESTION()); 
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setLVL(cursor.getInt(1));
				quest.setQUESTION(cursor.getString(2));
				quest.setANSWER(cursor.getString(3));
				quest.setOPTA(cursor.getString(4));
				quest.setOPTB(cursor.getString(5));
				quest.setOPTC(cursor.getString(6));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
}
