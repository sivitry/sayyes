package com.blogspot.sayyes;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

 

public class ListAll extends Activity{
	
	private DBHelper dbh = null;
	SQLiteDatabase db;
	Cursor cursor;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listalllayout);
		
		openDB();
		
		loadAll();

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			System.out.println(cursor.getString(0));
			System.out.println(cursor.getString(1));
			cursor.moveToNext();
		}
		
		closeDB();
		
	}	
	
	private void loadAll() {
		db = dbh.getWritableDatabase();
		cursor = db.query("ScriptTable", new String[] { "_CONTENT", "_PHOTOURI", "_AUDIOURI" }, null, null, null, null, null);		
	}
	
	private void openDB(){
		dbh = new DBHelper(this);
	}
	
	private void closeDB(){
		dbh = new DBHelper(this);
	}

}

