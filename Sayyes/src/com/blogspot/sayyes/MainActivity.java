package com.blogspot.sayyes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //--set tab, including tab name and icon
        final TabHost host = (TabHost) findViewById(R.id.tabhost);
        host.setup();
        
        //--LayoutInflater (view)
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.newonelayout, host.getTabContentView());
        inflater.inflate(R.layout.listallllayout, host.getTabContentView());
                
        //--add 4 tabs
        TabHost.TabSpec newOneSpec = host.newTabSpec("NewOne");
        newOneSpec.setIndicator("", getResources().getDrawable(R.drawable.newone2));        
        newOneSpec.setContent(R.id.tab1);
        host.addTab(newOneSpec);
        
        TabHost.TabSpec listAllSpec = host.newTabSpec("ListAll");
        listAllSpec.setIndicator(null, getResources().getDrawable(R.drawable.listall));
        listAllSpec.setContent(R.id.tab2);
        host.addTab(listAllSpec);
        
        TabHost.TabSpec playSayyesSpec = host.newTabSpec("PlaySayyes");
        playSayyesSpec.setIndicator(null, getResources().getDrawable(R.drawable.play2));
        playSayyesSpec.setContent(R.id.tab3);
        host.addTab(playSayyesSpec);
        
        TabHost.TabSpec settingsSpec = host.newTabSpec("Settings");
        settingsSpec.setIndicator(null, getResources().getDrawable(R.drawable.settings));
        settingsSpec.setContent(R.id.tab4);
        host.addTab(settingsSpec);
        
        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {			
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				Toast toast = Toast.makeText(MainActivity.this, tabId, Toast.LENGTH_SHORT);
		        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 50);
		        toast.show();
			}
		});
                          
        //--set tab background color
//        host.getTabWidget().getChildAt(0).setBackgroundColor(Color.BLACK);
//        host.getTabWidget().getChildAt(1).setBackgroundColor(Color.BLACK);
//        host.getTabWidget().getChildAt(2).setBackgroundColor(Color.BLACK);
//        host.getTabWidget().getChildAt(3).setBackgroundColor(Color.BLACK);
        
        
//        host.setCurrentTab(0);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
