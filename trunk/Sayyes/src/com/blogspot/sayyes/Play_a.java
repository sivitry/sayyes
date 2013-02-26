package com.blogspot.sayyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

 

public class Play_a extends Activity{
	
	private Button play_a_yesbt; 
	private Button play_a_nobt;
	private TextView play_a_context;
	
	private Bundle bd;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_a);
		
		play_a_yesbt = (Button)findViewById(R.id.play_a_yesbt);
		play_a_nobt = (Button)findViewById(R.id.play_a_nobt);
		play_a_context = (TextView)findViewById(R.id.play_a_context);
		
		play_a_yesbt.setOnClickListener(new Play_a_OnClickListener());
		
		//--Retrieve [photo], [text] from bundle 
		bd = new Bundle();
		bd = this.getIntent().getExtras();
		System.out.println("play_b");
		System.out.println(bd.getString("photouri"));
		System.out.println(bd.getString("context"));
		
		play_a_context.setText(bd.getString("context"));
		
	}
	
	
	class Play_a_OnClickListener implements OnClickListener{
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(Play_a.this, Play_b.class);
			if(bd!=null){
				it.putExtras(bd);
			}
			startActivity(it);	
		}
	}

}
