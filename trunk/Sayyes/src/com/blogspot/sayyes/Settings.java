package com.blogspot.sayyes;

import android.app.Activity;
import android.os.Bundle;

 

public class Settings extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingslayout);
	}
	
	
	public void printall(){
		System.out.println("this is Settings");	
	}

}
