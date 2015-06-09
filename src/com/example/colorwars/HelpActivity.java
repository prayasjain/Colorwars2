package com.example.colorwars;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends Activity implements OnClickListener {
	Button b1,b2,b3,b4 ;
	TextView head ,body ;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        b1=(Button)findViewById(R.id.button1) ;
        b2=(Button)findViewById(R.id.button2) ;
        b3=(Button)findViewById(R.id.button3) ;
        b4=(Button)findViewById(R.id.button4) ;
        head=(TextView)findViewById(R.id.textView2);
        body=(TextView)findViewById(R.id.textView3);
        b1.setOnClickListener(this) ;
        b2.setOnClickListener(this) ;
        b3.setOnClickListener(this) ;
        b4.setOnClickListener(this) ;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.button1 :
			head.setText("BASICS") ; 
			body.setText("In this logic-based game, one selects a ball as his/her avatar.\n The player has two options; either he can click on a cell which will cause capturing of that cell with your color's ball.\nOr, the player can select left/right button(for player 1) and up/down button(for player 2/computer in bot mode),which moves all the balls in that direction.\n This causes all the enemy balls encountered in our ball's way to change to our balls.\nBasic objective of the game is to eliminate other player's balls");
			break ;
		case R.id.button2 :
			head.setText("How To Win\n\n") ;
			body.setText("Their are two ways of winning the game\n1.  Eliminate all the enemy's balls\n\n2.  More No. of balls than the opponent    incase the Arena fills up Completely") ;
			break ;
		case R.id.button3 :
			head.setText("POWERUPS") ;
			body.setText("Three power ups are available to the player.\n1.Power up 1 that changes the enemy's ball to our ball by losing 5 points.\n2. Power up 2 changes a complete row(for player 1) or a complete column(for player 2/bot) to our colour's ball by loss of 10 points.\n3.Power up 3 changes all the enemy's balls surrounding our ball that was clicked into our ball.\n");
			break ;
		case R.id.button4 :
			head.setText("COMING SOON!\n\n") ;
			body.setText("1.Transition Colors-intermediate colors when   a ball is captured\n\n\n2.Various Levels of Difficulty\n\n\n3.Animation and a more interactive UI/UX\n") ;
			
			break ;
		}
		
	}

}
