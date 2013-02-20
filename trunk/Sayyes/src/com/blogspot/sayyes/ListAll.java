package com.blogspot.sayyes;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListAll extends ListActivity {
	
	private DBHelper dbh = null;
	SQLiteDatabase db;
	Cursor cursor;
	String[] contentstr;
	
		

	
	public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
//	    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//	        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//	        "Linux", "OS/2" };	    
	    // Use your own layout
//	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//	        R.layout.listalllayout, R.id.label, values);
	    

	    
	    
	    
		openDB();
		
		loadAll();

		cursor.moveToFirst();
		contentstr = new String[cursor.getCount()];
		
		int i=0;
		while (!cursor.isAfterLast()) {
			contentstr[i] = cursor.getString(0);
//			System.out.println(cursor.getString(0));
//			System.out.println(cursor.getString(1));
//			System.out.println(cursor.getCount());
//			System.out.println(cursor.getColumnCount());			
			cursor.moveToNext();
			i++;
		}		
		
		closeDB();
		
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listalllayout, R.id.label, contentstr);
	    setListAdapter(adapter);
		
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
	    
	    
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String item = (String) getListAdapter().getItem(position);
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	}
} 

 
/*
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
*/

