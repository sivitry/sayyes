package com.blogspot.sayyes;

import android.app.Activity;
import android.os.Bundle;

 

public class Play extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playlayout);
	}
	
	
	public void printall(){
		System.out.println("this is Play");	
	}

}
