package com.example.colorwars;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class BPlay extends Activity implements OnClickListener {
	Typeface font, fontbd;
	int page;
	Button next, prev, exit;
	Context context = BPlay.this;
	TextView h;
	TextView[] t = new TextView[4];
	ViewFlipper flips ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.help_bplay);
		page = 1;
		flips =(ViewFlipper)findViewById(R.id.flips);
		fontbd = Typeface.createFromAsset(context.getAssets(), "comicbd.ttf");
		font = Typeface.createFromAsset(context.getAssets(), "comic.ttf");
		t[0] = (TextView) findViewById(R.id.tvbp1);
		t[1] = (TextView) findViewById(R.id.tvbp2);
		t[2] = (TextView) findViewById(R.id.tvbp3);
		t[3] = (TextView) findViewById(R.id.tvbp4);

		h = (TextView) findViewById(R.id.tvbph);
		h.setTypeface(fontbd);
		float sts = h.getTextSize();
		h.setTextSize(sts / (getResources().getDisplayMetrics().density * 2));

		for (int i = 0; i < 4; i++) {
			t[i].setTypeface(font);
		}
		next = (Button) findViewById(R.id.bbplaynext);
		prev = (Button) findViewById(R.id.bbplayprev);
		exit = (Button) findViewById(R.id.bbplayexit);
		next.setTypeface(font);
		prev.setTypeface(font);
		exit.setTypeface(font);
		next.setOnClickListener(this) ;
		prev.setOnClickListener(this);
		exit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bbplaynext:
			
			if (page == 1) {
				flips.showNext();
				page=2 ;
			} else {
				Intent r = new Intent(context, PUps.class);
				startActivity(r);

			}

			break;

		case R.id.bbplayprev:
		
			if (page == 2) {
				flips.showPrevious();
				page=1 ;
			} else {
				Intent r2 = new Intent(context, CSoon.class);
				startActivity(r2);

			}

			break;

		case R.id.bbplayexit:
			
			Intent r3 = new Intent(context, HelpActivity.class);
			startActivity(r3);

			break;

		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish() ;
	}

	
}
