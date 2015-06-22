package com.example.colorwars;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class CSoon extends Activity implements android.view.View.OnClickListener{
	Typeface font,fontbd ;
	Button next , prev ,exit ;
	Context context = CSoon.this ;
	TextView h ;
	TextView[] t = new TextView[8] ; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE) ;
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN) ;
		setContentView(R.layout.help_csoon);
		fontbd =Typeface.createFromAsset(context.getAssets(), "comicbd.ttf");
		font =Typeface.createFromAsset(context.getAssets(), "comic.ttf");
		t[0] = (TextView)findViewById(R.id.tvcs1) ;
		t[1] = (TextView)findViewById(R.id.tvcs2) ;
		t[2] = (TextView)findViewById(R.id.tvcs3) ;
		t[3] = (TextView)findViewById(R.id.tvcs4) ;
		t[4] = (TextView)findViewById(R.id.tvcsh1) ;
		t[5] = (TextView)findViewById(R.id.tvcsh2) ;
		t[6] = (TextView)findViewById(R.id.tvcsh3) ;
		t[7] = (TextView)findViewById(R.id.tvcsh4) ;
		h =(TextView)findViewById(R.id.tvcsoon);
		h.setTypeface(fontbd) ;
		for(int i =0 ;i<8;i++){
			t[i].setTypeface(font);
		}
		next = (Button) findViewById(R.id.bcsnext) ;
		prev = (Button)findViewById(R.id.bcsprev);
		exit =(Button)findViewById(R.id.bcsexit) ;
		next.setTypeface(font);
		prev.setTypeface(font);
		exit.setTypeface(font);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bcsnext :
			Intent r = new Intent(context,Temp.class) ;
			startActivity(r) ;
			
			break ;
			
		case R.id.bcsprev :
			Intent r2 = new Intent(context,Temp.class) ;
			startActivity(r2) ;
			
			break ;
			
			
		case R.id.bcsexit :
			
			Intent r3 = new Intent(context,Temp.class) ;
			startActivity(r3) ;
			
			break ;
			
		}
	}

	

}
