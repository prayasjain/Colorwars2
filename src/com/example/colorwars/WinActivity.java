package com.example.colorwars;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;


public class WinActivity extends Activity {
	public int c ;
	public TextView player ;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState) ;
		setContentView(R.layout.win) ;
		player=(TextView) findViewById(R.id.textView2) ;
		
		Intent intent=getIntent() ;
		c=intent.getIntExtra("wincolor", 1) ;
		if(c==1){
			player.setText("Player 1"+"\nCongratulations! You Win");
		}
		else {
			player.setText("Player 2"+"\nCongratulations! You Win");
		}
	}

}
