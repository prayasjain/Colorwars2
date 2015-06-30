package com.example.colorwars;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonSelector extends Activity implements
		android.view.View.OnClickListener {
	Button r, g, b, y;
	Bundle sbundle;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.btnselect);
		
		r = (Button) findViewById(R.id.bselectred);
		g = (Button) findViewById(R.id.bselectgreen);
		b = (Button) findViewById(R.id.bselectblue);
		y = (Button) findViewById(R.id.bselectyellow);
		r.setOnClickListener(this);
		g.setOnClickListener(this);
		b.setOnClickListener(this);
		y.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == r.getId()) {
			sbundle = new Bundle();
			intent = new Intent();
			sbundle.putString("selectedcolor", "red");
			intent.putExtras( sbundle);
			setResult(RESULT_OK, intent);
			finish() ;

		} else if (v.getId() == g.getId()) {
			sbundle = new Bundle();
			intent = new Intent();
			sbundle.putString("selectedcolor", "green");
			intent.putExtras( sbundle);
			setResult(RESULT_OK, intent);
			finish() ;

		} else if (v.getId() == b.getId()) {
			sbundle = new Bundle();
			intent = new Intent();
			sbundle.putString("selectedcolor", "blue");
			intent.putExtras( sbundle);
			setResult(RESULT_OK, intent);
			finish() ;
		} else if (v.getId() == y.getId()) {
			sbundle = new Bundle();
			intent = new Intent();
			sbundle.putString("selectedcolor", "yellow");
			intent.putExtras( sbundle);
			setResult(RESULT_OK, intent);
			finish() ;
		}
	}

}
