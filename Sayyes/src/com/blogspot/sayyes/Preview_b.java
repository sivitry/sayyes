package com.blogspot.sayyes;

import android.app.Activity;
import android.content.Intent;
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
		
		System.out.println("preview_b");
		System.out.println(bd.getString("photouri"));
		System.out.println(bd.getString("context"));
			
		preview_b_iv = (ImageView) findViewById(R.id.preview_b_iv);
		preview_b_iv.setImageURI(Uri.parse(bd.getString("photouri")));
	}
}
