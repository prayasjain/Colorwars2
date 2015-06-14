package com.example.colorwars;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends Activity implements OnClickListener {
	Button play,power,win,soon ;
	TextView head ;
	long tdiff ;
	Typeface font,comic;
	Context context ;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
	
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setContentView(R.layout.cool_help);
        context = HelpActivity.this;
        
        font = Typeface.createFromAsset(context.getAssets(), "font1.ttf");
        comic =Typeface.createFromAsset(context.getAssets(), "comic.ttf");

        
        
        play=(Button)findViewById(R.id.bhelpbasicplay) ;
        power=(Button)findViewById(R.id.bhelppowerups) ;
        win=(Button)findViewById(R.id.bhelpwin) ;
        soon=(Button)findViewById(R.id.bhelpsoon) ;
        head=(TextView)findViewById(R.id.tvcwhelp);
        head.setTypeface(font);
        
      
        play.setOnClickListener(this) ;
        play.setTypeface(comic);
        
        power.setOnClickListener(this) ;
       
        power.setTypeface(comic);
        
        win.setOnClickListener(this) ;
       
        win.setTypeface(comic);
        
        
        soon.setOnClickListener(this) ;
        
        soon.setTypeface(comic);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bhelpbasicplay :
			movebuttons(1) ;
			Thread timer1 = new Thread() {
				public void run() {
					try {

						sleep(tdiff+250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						Intent About = new Intent(context,
								Temp.class);
						startActivity(About);
					}
				}
			};
			timer1.start();
			//body.setText("In this logic-based game, one selects a ball as his/her avatar.\n The player has two options; either he can click on a cell which will cause capturing of that cell with your color's ball.\nOr, the player can select left/right button(for player 1) and up/down button(for player 2/computer in bot mode),which moves all the balls in that direction.\n This causes all the enemy balls encountered in our ball's way to change to our balls.\nBasic objective of the game is to eliminate other player's balls");
			break ;
		case R.id.bhelppowerups :
			movebuttons(2) ;
			Thread timer2 = new Thread() {
				public void run() {
					try {

						sleep(tdiff+250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						Intent About = new Intent(context,
								Temp.class);
						startActivity(About);
					}
				}
			};
			timer2.start();
			//body.setText("Their are two ways of winning the game\n1.  Eliminate all the enemy's balls\n\n2.  More No. of balls than the opponent    incase the Arena fills up Completely") ;
			break ;
		case R.id.bhelpwin :
			movebuttons(3) ;
			Thread timer3 = new Thread() {
				public void run() {
					try {

						sleep(tdiff+250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						Intent About = new Intent(context,
								Temp.class);
						startActivity(About);
					}
				}
			};
			timer3.start();
			//body.setText("Three power ups are available to the player.\n1.Power up 1 that changes the enemy's ball to our ball by losing 5 points.\n2. Power up 2 changes a complete row(for player 1) or a complete column(for player 2/bot) to our colour's ball by loss of 10 points.\n3.Power up 3 changes all the enemy's balls surrounding our ball that was clicked into our ball.\n");
			break ;
		case R.id.bhelpsoon :
			movebuttons(4) ;
			Thread timer4 = new Thread() {
				public void run() {
					try {

						sleep(tdiff+250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						Intent About = new Intent(context,
								Temp.class);
						startActivity(About);
					}
				}
			};
			timer4.start();
			//body.setText("1.Transition Colors-intermediate colors when   a ball is captured\n\n\n2.Various Levels of Difficulty\n\n\n3.Animation and a more interactive UI/UX\n") ;
			
			break ;
		}
		
	}
	private void movebuttons(int type) {
		// TODO Auto-generated method stub
		long time = SystemClock.currentThreadTimeMillis();
		if (type == 1) {
			
			for (int i = 0; i < 600; i++) {
				play.animate().xBy(i);
				power.animate().xBy(-i);
				win.animate().xBy(-i);
				soon.animate().xBy(-i);
				
				head.animate().xBy(-i);
				
				
			}

		} else if (type == 3) {
			for (int i = 0; i < 600; i++) {
				play.animate().xBy(-i);
				power.animate().xBy(i);
				win.animate().xBy(-i);
				soon.animate().xBy(-i);
				
				head.animate().xBy(-i);
			}
		} else if (type == 2) {
			for (int i = 0; i < 600; i++) {
				play.animate().xBy(-i);
				power.animate().xBy(-i);
				win.animate().xBy(i);
				soon.animate().xBy(-i);
				
				head.animate().xBy(-i);
			}
		}
		else if (type==4){
			for (int i = 0; i < 600; i++) {
				play.animate().xBy(-i);
				power.animate().xBy(-i);
				win.animate().xBy(-i);
				soon.animate().xBy(i);
				
				head.animate().xBy(-i);
			}
		}
		tdiff=SystemClock.currentThreadTimeMillis()-time ;
	}
}
