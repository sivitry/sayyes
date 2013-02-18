package com.blogspot.sayyes;

import android.app.Activity;
import android.os.Bundle;

 

public class NewOne extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layoutnewone);
	}
	
	
	public void printall(){
		System.out.println("this is NewOne");	
	}

}
