package com.blogspot.sayyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

 

public class Play_b extends Activity{
	
	private Button play_b_backbt;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_b);
		
		play_b_backbt = (Button) findViewById(R.id.play_b_backbt);	
		
		play_b_backbt.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent it = new Intent();
				it.setClass(Play_b.this, MainActivity.class);
				startActivity(it);			
			}
		});
		
	}
}
