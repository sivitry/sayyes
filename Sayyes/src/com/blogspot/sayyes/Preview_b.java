package com.blogspot.sayyes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

 

public class Preview_b extends Activity{
	
	private Button preview_b_discardbt;
	private Button preview_b_savebt;
	private Button preview_b_editbt;
	private ImageView preview_b_iv;
	private Bundle bd;
	private DBHelper dbh = null;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preview_b);
		
		//--Retrieve [photo], [text] from bundle 	
		bd = new Bundle();
		bd = this.getIntent().getExtras();
		
		preview_b_discardbt = (Button) findViewById(R.id.preview_b_discardbt);		
		preview_b_discardbt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(Preview_b.this, MainActivity.class);
				startActivity(it);			
			}
		});		
		
		
		preview_b_editbt = (Button) findViewById(R.id.preview_b_editbt);
		preview_b_editbt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(Preview_b.this, NewOne.class);				
				if(bd!=null){
					it.putExtras(bd);
				}				
				startActivity(it);			
			}
		});
		
		
		preview_b_savebt = (Button) findViewById(R.id.preview_b_savebt);
		preview_b_savebt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {				
				//--save & return to home
				openDB();
				add(bd.getString("context"),bd.getString("photouri"),bd.getString("photouri"));
				closeDB();
				
				Intent it = new Intent();
				it.setClass(Preview_b.this, MainActivity.class);			
				startActivity(it);			
			}
		});
		
		System.out.println("preview_b");
		System.out.println(bd.getString("photouri"));
		System.out.println(bd.getString("context"));
			
		preview_b_iv = (ImageView) findViewById(R.id.preview_b_iv);
		preview_b_iv.setImageURI(Uri.parse(bd.getString("photouri")));
		
		
	}
	
	private void openDB(){
		dbh = new DBHelper(this);
	}
	
	private void closeDB(){
		dbh = new DBHelper(this);
	}
	
	private void add(String content, String photouri, String audiouri){
		SQLiteDatabase db = dbh.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("_CONTENT", content.toString());
		cv.put("_PHOTOURI", photouri.toString());
		cv.put("_AUDIOURI", audiouri.toString());
		db.insert("ScriptTable", null, cv);		
	}
	
	
}
