package com.blogspot.sayyes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
    
	Button newonebt, listallbt, playbt, settingsbt;
	
    private void loadbt(){
    	newonebt = (Button)findViewById(R.id.newonebt);
    	listallbt = (Button)findViewById(R.id.listallbt);
    	playbt = (Button)findViewById(R.id.playbt);
    	settingsbt = (Button)findViewById(R.id.settingsbt);
    }
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
        
        loadbt();
        
        
        newonebt.setOnClickListener(new NewOneOnclickListener());        
        listallbt.setOnClickListener(new ListAllOnclickListener());
        playbt.setOnClickListener(new PlayOnclickListener());
        settingsbt.setOnClickListener(new SettingsOnclickListener());        
    }
        
    
    class NewOneOnclickListener implements OnClickListener{
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(MainActivity.this, NewOne.class);
			startActivity(it);
		}    	
    }
    
    class ListAllOnclickListener implements OnClickListener{
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(MainActivity.this, ListAll.class);
			startActivity(it);
		}    	
    }
    
    class PlayOnclickListener implements OnClickListener{
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(MainActivity.this, Play.class);
			startActivity(it);
		}    	
    }
    
    class SettingsOnclickListener implements OnClickListener{
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(MainActivity.this, Settings.class);
			startActivity(it);
		}    	
    } 
    
    



}
