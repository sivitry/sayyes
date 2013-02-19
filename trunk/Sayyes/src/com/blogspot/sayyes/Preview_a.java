package com.blogspot.sayyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

 

public class Preview_a extends Activity{
	
	private Button preview_a_yesbt; 
	private Button preview_a_nobt;
	private TextView preview_a_context;
	private Bundle bd;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preview_a);
		
		preview_a_yesbt = (Button)findViewById(R.id.preview_a_yesbt);
		preview_a_nobt = (Button)findViewById(R.id.preview_a_nobt);
		preview_a_context = (TextView)findViewById(R.id.preview_a_context);
		
		preview_a_yesbt.setOnClickListener(new Preview_a_OnClickListener());
		
		//--Retrieve [photo], [text] from bundle 
		bd = new Bundle();
		bd = this.getIntent().getExtras();
		System.out.println("preview_b");
		System.out.println(bd.getString("photouri"));
		System.out.println(bd.getString("context"));
		
		preview_a_context.setText(bd.getString("context"));
	}
	
	
	class Preview_a_OnClickListener implements OnClickListener{
		public void onClick(View v) {			
			Intent it = new Intent();
			it.setClass(Preview_a.this, Preview_b.class);	
			if(bd!=null){
				it.putExtras(bd);
			}
			startActivity(it);			
		}
	}

}
