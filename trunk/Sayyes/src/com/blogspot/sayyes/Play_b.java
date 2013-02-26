package com.blogspot.sayyes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

 

public class Play_b extends Activity{
	
	private Button play_b_homebt;
	private ImageView play_b_iv;
	private Bundle bd;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_b);
		
		//--Retrieve [photo], [text] from bundle 	
		bd = new Bundle();
		bd = this.getIntent().getExtras();
		
		//--find view & set iv
		play_b_homebt = (Button) findViewById(R.id.play_b_homebt);	
		play_b_iv = (ImageView) findViewById(R.id.play_b_iv);
		play_b_iv.setImageURI(Uri.parse(bd.getString("photouri")));
				
		//--handle home button
		play_b_homebt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(Play_b.this, MainActivity.class);
				startActivity(it);			
			}
		});
		
	}
}
