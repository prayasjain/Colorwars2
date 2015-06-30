package com.example.colorwars;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	Button Play, About, Help;
	Typeface font, comic;
	TextView cw,h;
	ViewGroup ourView;
	float pos;
	long tdiff;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ourView = (ViewGroup) inflater.inflate(R.layout.activity_main, null);

		setContentView(R.layout.activity_main);

		Play = (Button) findViewById(R.id.Button02);
		Help = (Button) findViewById(R.id.button1);
		About = (Button) findViewById(R.id.Button01);
		h=(TextView)findViewById(R.id.tvmainbar) ;
		Play.setOnClickListener(this);
		Help.setOnClickListener(this);
		About.setOnClickListener(this);
		cw = (TextView) findViewById(R.id.tvcw);
		Context context = MainActivity.this;
		font = Typeface.createFromAsset(context.getAssets(), "font1.ttf");
		cw.setTypeface(font);
		comic = Typeface.createFromAsset(context.getAssets(), "comic.ttf");
		
		h.setTypeface(font);
		Play.setTypeface(comic);
		Help.setTypeface(comic);
		About.setTypeface(comic);
		
		float sts = h.getTextSize() ;
		h.setTextSize(sts/(getResources().getDisplayMetrics().density * (float) 1.5));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()) {

		case R.id.Button01:
			movebuttons(3);

			Thread timer2 = new Thread() {
				public void run() {
					try {

						sleep(tdiff + 250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						Intent About = new Intent(MainActivity.this,
								AboutActivity.class);
						startActivity(About);
					}
				}
			};
			timer2.start();

			break;
		case R.id.Button02:
			movebuttons(1);
			Thread timer = new Thread() {
				public void run() {
					try {

						sleep(tdiff + 250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						Intent open = new Intent(MainActivity.this,
								Cool_Settings.class);
						startActivity(open);
					}
				}
			};
			timer.start();
			break;
		case R.id.button1:
			movebuttons(2);

			Thread timer3 = new Thread() {
				public void run() {
					try {

						sleep(tdiff + 250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						Intent Help = new Intent(MainActivity.this,
								HelpActivity.class);
						startActivity(Help);
					}
				}
			};
			timer3.start();
			break;
		}
		// TODO Auto-generated method stub

	}

	private void movebuttons(int type) {
		// TODO Auto-generated method stub
		long time = SystemClock.currentThreadTimeMillis();
		if (type == 1) {

			for (int i = 0; i < 600; i++) {
				Play.animate().xBy(i);
				About.animate().xBy(-i);
				Help.animate().xBy(-i);
				cw.animate().xBy(-i);

			}

		} else if (type == 3) {
			for (int i = 0; i < 600; i++) {
				Play.animate().xBy(-i);
				About.animate().xBy(i);
				Help.animate().xBy(-i);
				cw.animate().xBy(-i);
			}
		} else if (type == 2) {
			for (int i = 0; i < 600; i++) {
				Play.animate().xBy(-i);
				About.animate().xBy(-i);
				Help.animate().xBy(i);
				cw.animate().xBy(-i);
			}
		}
		tdiff = SystemClock.currentThreadTimeMillis() - time;
	}
}
