package com.blogspot.sayyes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

 

public class NewOne extends Activity{
	
	private Button pickbt;
	private ImageView iv;
	private Uri postPhotoUri;
	private Button newonepreviewbt;
	private TextView tv;
	private Bundle bd;
	
	
	private void newOneInit(){
		pickbt = (Button) findViewById(R.id.pickPhotoButton);
		iv = (ImageView) findViewById(R.id.pickedPhoto);
		newonepreviewbt = (Button) findViewById(R.id.newonepreviewbt);
		tv = (TextView) findViewById(R.id.context);
		
		postPhotoUri = Uri.parse("android.resource://com.blogspot.sayyes/"+R.drawable.camera);		
		tv.setText("");
		
		bd = this.getIntent().getExtras();
		if(bd==null){		
			bd = new Bundle();
		}		
		if(bd.getString("photouri") != null){	
			postPhotoUri = Uri.parse(bd.getString("photouri"));
		}		
		iv.setImageURI(postPhotoUri);
		if(bd.getString("context") != null){
			tv.setText(bd.getString("context"));
		}
	}
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newonelayout);
	
		newOneInit();
	
		pickbt.setOnClickListener(new PickPhotoOnClickListener());		
		newonepreviewbt.setOnClickListener(new PreviewOnClickListener());
	}
	
	
    class PickPhotoOnClickListener implements OnClickListener {
    	public void onClick(View v) {
    		Intent it = new Intent();
    		it.setType("image/*");
    		it.setAction(Intent.ACTION_GET_CONTENT);
    		startActivityForResult(it, 1);    		
		}
    }
    
    class PreviewOnClickListener implements OnClickListener{
		public void onClick(View v) {
			Intent it = new Intent();
			it.setClass(NewOne.this, Preview_a.class);
			
			//--Transmit the value of [photo], [text] using bundle
			bd.putString("photouri", postPhotoUri.toString());
			bd.putString("context", tv.getText().toString());
			it.putExtras(bd);
			startActivity(it);
		}      	
    }
    
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
	        postPhotoUri = data.getData();      
	        iv.setImageURI(postPhotoUri);
        }
    }

}
