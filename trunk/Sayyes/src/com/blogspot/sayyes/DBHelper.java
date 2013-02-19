package com.blogspot.sayyes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	private final static int _DBVersion = 1;
	private final static String _DBName = "SayyesDB.db";	
	private final static String _TableName = "ScriptTable";
	public DBHelper(Context context) {
		super(context, _DBName, null, _DBVersion);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		final String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
		                       "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +				               
		                       "_CONTENT TEXT," +
		                       "_PHOTOURI VARCHAR(200), " +
				               "_AUDIOURI VARCHAR(200)" +
				           ");";
        db.execSQL(SQL);
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		final String SQL = "DROP TABLE " + _TableName;
        db.execSQL(SQL);		
	}

}

