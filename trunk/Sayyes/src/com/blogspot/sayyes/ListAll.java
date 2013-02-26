package com.blogspot.sayyes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blogspot.sayyes.NewOne.PickPhotoOnClickListener;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListAll extends ListActivity {
	
	private DBHelper dbh = null;
	SQLiteDatabase db;
	Cursor cursor;
	
	private Bundle bd;
	
	private List<Map<String, Object>> mData;
		
	String tempphoto = "";
	String tempcontext = "";
	
	
	public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
//	    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//	        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//	        "Linux", "OS/2" };	    
	    // Use your own layout
//	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//	        R.layout.listalllayout, R.id.label, values);
	    

		openDB();
		
		loadAll();
		
		closeDB();
		
		
		mData = getData();
		MyAdapter adapter = new MyAdapter(this);
//	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listalllayout, R.id.listalltv, contentstr);
	    setListAdapter(adapter);
		
	}	
	
	public class MyAdapter extends BaseAdapter {
		
		private LayoutInflater mInflater;
		
		public MyAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			if (convertView == null) {
				// 初始化holder的text與icon
				holder = new ViewHolder();
				// 使用自定義的Layout
				convertView = mInflater.inflate(R.layout.listalllayout, null);
				holder.listalliv = (ImageView) convertView.findViewById(R.id.listalliv);
				holder.listalltv = (TextView) convertView.findViewById(R.id.listalltv);
				holder.listallplayib = (ImageButton) convertView.findViewById(R.id.listallplayib);
				holder.listalleditib = (ImageButton) convertView.findViewById(R.id.listalleditib);
				holder.listalldelib = (ImageButton) convertView.findViewById(R.id.listalldelib);
				
				convertView.setTag(holder);

			} else {

				holder = (ViewHolder) convertView.getTag();
			}

			// 設定要顯示的資訊
			tempphoto = (String) mData.get(position).get("pickedphoto");
			tempcontext = (String) mData.get(position).get("context");
			holder.listalliv.setImageURI(Uri.parse(tempphoto));
			holder.listalltv.setText(tempcontext);
			holder.listallplayib.setOnClickListener(new PlayOnClickListener());
			holder.listalleditib.setOnClickListener(new EditOnClickListener());
			holder.listalldelib.setOnClickListener(new DeleteOnClickListener());
						
			return convertView;
		}		
	}
	
	public final class ViewHolder {
		public ImageView listalliv;
		public TextView listalltv;	
		public ImageButton listallplayib;
		public ImageButton listalleditib;
		public ImageButton listalldelib;
	}
	
	
    class EditOnClickListener implements OnClickListener {

    	public void onClick(View v) {
			
			Intent it = new Intent();
			it.setClass(ListAll.this, NewOne.class);		
			
			System.out.println("tempphoto="+tempphoto);
			System.out.println("tempcontext="+tempcontext);
			
			openDB();
			SQLiteDatabase db = dbh.getWritableDatabase();
			System.out.println("EditOnClickListener--"+tempcontext);
			db.execSQL("DELETE FROM ScriptTable WHERE _CONTENT='"+tempcontext+"';");
			closeDB();
			
			bd = new Bundle();
			bd.putString("photouri", tempphoto);
			bd.putString("context", tempcontext);
			it.putExtras(bd);					
			startActivity(it);
		}
    }	
    
    
    class PlayOnClickListener implements OnClickListener {
    	public void onClick(View v) {			
			Intent it = new Intent();
			it.setClass(ListAll.this, Play_a.class);
			bd = new Bundle();
			bd.putString("photouri", tempphoto);
			bd.putString("context", tempcontext);
			it.putExtras(bd);					
			startActivity(it);
		}
    }	
	
    
    class DeleteOnClickListener implements OnClickListener {

    	public void onClick(View v) {
			openDB();
			SQLiteDatabase db = dbh.getWritableDatabase();
			System.out.println("DeleteOnClickListener--"+tempcontext);
			db.execSQL("DELETE FROM ScriptTable WHERE _CONTENT='"+tempcontext+"';");
			closeDB();
			
			//--Reload activity after delete.
			Intent it = getIntent();
			finish();
			startActivity(it);
		}
    }
	
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map;
		
		
		cursor.moveToFirst();
		
		
		int i=0;
		while (!cursor.isAfterLast()) {
			
			map = new HashMap<String, Object>();
			map.put("context", cursor.getString(0));		
			map.put("pickedphoto", cursor.getString(1));
			list.add(map);			
			
//			System.out.println("0="+cursor.getString(0));
//			System.out.println("1="+cursor.getString(1));
//			System.out.println(cursor.getCount());
//			System.out.println(cursor.getColumnCount());	
			
			
			cursor.moveToNext();
			i++;
		}	
		return list;
	}
	
	
	
	
	
	private void loadAll() {
		db = dbh.getWritableDatabase();
		cursor = db.query("ScriptTable", new String[] { "_CONTENT", "_PHOTOURI", "_AUDIOURI" }, null, null, null, null, null);		
	}
	
	private void openDB(){
		dbh = new DBHelper(this);
	}
	
	private void closeDB(){
		dbh = new DBHelper(this);
	}		
	
	
	//-- For delete some entry in DB. 
	private void deleteSomeDB(){		
		db = dbh.getWritableDatabase();
		int i;
		for(i=0;i<55;i++)
			db.delete("ScriptTable", "_id" +"=" + i, null);		
	}
	    
//	    
//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//		String item = (String) getListAdapter().getItem(position);
//		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
//	}
} 

