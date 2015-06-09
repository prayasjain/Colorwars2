package com.example.colorwars;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class settings2Activity extends Activity implements OnClickListener{
	public TextView av1,av2,player1,player2;
	public Button human,bot,play;
	public Button p1[]=new Button[4];
	public Button p2[]=new Button[4];
	char type;
	int pl1,pl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting2);
        human=(Button)findViewById(R.id.button1);
        play=(Button)findViewById(R.id.button11);
        bot=(Button)findViewById(R.id.button2);
        p1[0]=(Button)findViewById(R.id.button4);
        p1[1]=(Button)findViewById(R.id.button3);
        p1[2]=(Button)findViewById(R.id.button5);
        p1[3]=(Button)findViewById(R.id.button6);
        p2[0]=(Button)findViewById(R.id.button7);
        p2[1]=(Button)findViewById(R.id.button8);
        p2[2]=(Button)findViewById(R.id.button9);
        p2[3]=(Button)findViewById(R.id.button10);
        human.setOnClickListener(this);
        bot.setOnClickListener(this);
        p1[0].setOnClickListener(this);
        p1[1].setOnClickListener(this);
        p1[2].setOnClickListener(this);
        p1[3].setOnClickListener(this);
        p2[0].setOnClickListener(this);
        p2[1].setOnClickListener(this);
        p2[2].setOnClickListener(this);
        p2[3].setOnClickListener(this);
        av1=(TextView)findViewById(R.id.textView3);
        av2=(TextView)findViewById(R.id.textView5);
        player1=(TextView)findViewById(R.id.textView2);
        player2=(TextView)findViewById(R.id.textView4);
        player1.setVisibility(android.view.View.INVISIBLE);
        player2.setVisibility(android.view.View.INVISIBLE);
        av1.setVisibility(android.view.View.INVISIBLE);
        av2.setVisibility(android.view.View.INVISIBLE);
        p1[0].setVisibility(android.view.View.INVISIBLE);
        p1[1].setVisibility(android.view.View.INVISIBLE);
        p1[2].setVisibility(android.view.View.INVISIBLE);
        p1[3].setVisibility(android.view.View.INVISIBLE);
        p2[0].setVisibility(android.view.View.INVISIBLE);
        p2[1].setVisibility(android.view.View.INVISIBLE);
        p2[2].setVisibility(android.view.View.INVISIBLE);
        p2[3].setVisibility(android.view.View.INVISIBLE);
        play.setOnClickListener(this);
        play.setOnClickListener(this);
	    human.setBackgroundResource(R.drawable.white2);
	    human.setTextColor(Color.rgb(0, 0, 0)) ;     
	    bot.setBackgroundResource(R.drawable.white2);
	    bot.setTextColor(Color.rgb(0, 0, 0)) ;
	    play.setBackgroundResource(R.drawable.white2);
	    play.setTextColor(Color.rgb(0, 0, 0)) ;
    }

 


	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		case R.id.button2:
		    player1.setVisibility(android.view.View.VISIBLE);
	        player2.setVisibility(android.view.View.INVISIBLE);
	        av1.setVisibility(android.view.View.VISIBLE);
	        av2.setVisibility(android.view.View.INVISIBLE);
	        p1[0].setVisibility(android.view.View.VISIBLE);
	        p1[1].setVisibility(android.view.View.VISIBLE);
	        p1[2].setVisibility(android.view.View.VISIBLE);
	        p1[3].setVisibility(android.view.View.VISIBLE);
	        p2[0].setVisibility(android.view.View.INVISIBLE);
	        p2[1].setVisibility(android.view.View.INVISIBLE);
	        p2[2].setVisibility(android.view.View.INVISIBLE);
	        p2[3].setVisibility(android.view.View.INVISIBLE);
		    bot.setBackgroundResource(R.drawable.white2s);
		    human.setBackgroundResource(R.drawable.white2);
		    type='b';
		    break;
		case R.id.button1:
	        player1.setVisibility(android.view.View.VISIBLE);
	        player2.setVisibility(android.view.View.VISIBLE);
	        av1.setVisibility(android.view.View.VISIBLE);
	        av2.setVisibility(android.view.View.VISIBLE);
	        p1[0].setVisibility(android.view.View.VISIBLE);
	        p1[1].setVisibility(android.view.View.VISIBLE);
	        p1[2].setVisibility(android.view.View.VISIBLE);
	        p1[3].setVisibility(android.view.View.VISIBLE);
	        p2[0].setVisibility(android.view.View.VISIBLE);
	        p2[1].setVisibility(android.view.View.VISIBLE);
	        p2[2].setVisibility(android.view.View.VISIBLE);
	        p2[3].setVisibility(android.view.View.VISIBLE);
	        bot.setBackgroundResource(R.drawable.white2);
	        human.setBackgroundResource(R.drawable.white2s);
	        type='h';
	        break;
		case R.id.button4:
			p1[0].setBackgroundResource(R.drawable.blues);
			p1[1].setBackgroundResource(R.drawable.green);
			p1[2].setBackgroundResource(R.drawable.red);
			p1[3].setBackgroundResource(R.drawable.yellow);
			pl1=2;
			break;
		case R.id.button3:
			p1[0].setBackgroundResource(R.drawable.blue);
			p1[1].setBackgroundResource(R.drawable.greens);
			p1[2].setBackgroundResource(R.drawable.red);
			p1[3].setBackgroundResource(R.drawable.yellow);
			pl1=3;
			break;
		case R.id.button5:
			p1[0].setBackgroundResource(R.drawable.blue);
			p1[1].setBackgroundResource(R.drawable.green);
			p1[2].setBackgroundResource(R.drawable.reds);
			p1[3].setBackgroundResource(R.drawable.yellow);
			pl1=1;
			break;
		case R.id.button6:
			p1[0].setBackgroundResource(R.drawable.blue);
			p1[1].setBackgroundResource(R.drawable.green);
			p1[2].setBackgroundResource(R.drawable.red);
			p1[3].setBackgroundResource(R.drawable.yellows);
			pl1=4;
			break;
		case R.id.button7:
			p2[0].setBackgroundResource(R.drawable.blues);
			p2[1].setBackgroundResource(R.drawable.green);
			p2[2].setBackgroundResource(R.drawable.red);
			p2[3].setBackgroundResource(R.drawable.yellow);
			pl2=2;
			break;
		case R.id.button8:
			p2[0].setBackgroundResource(R.drawable.blue);
			p2[1].setBackgroundResource(R.drawable.greens);
			p2[2].setBackgroundResource(R.drawable.red);
			p2[3].setBackgroundResource(R.drawable.yellow);
			pl2=3;
			break;
		case R.id.button9:
			p2[0].setBackgroundResource(R.drawable.blue);
			p2[1].setBackgroundResource(R.drawable.green);
			p2[2].setBackgroundResource(R.drawable.reds);
			p2[3].setBackgroundResource(R.drawable.yellow);
			pl2=1;
			break;
		case R.id.button10:
			p2[0].setBackgroundResource(R.drawable.blue);
			p2[1].setBackgroundResource(R.drawable.green);
			p2[2].setBackgroundResource(R.drawable.red);
			p2[3].setBackgroundResource(R.drawable.yellows);
			pl2=4;
			break;
		case R.id.button11 :
			if(type=='b')
				{Intent play=new Intent(settings2Activity.this,comp3.class) ;
				play.putExtra("color1", pl1);
				
				settings2Activity.this.startActivity(play) ;
				}
			else if(type=='h'&&pl1!=pl2){
				Intent play=new Intent(settings2Activity.this,PlayActivity.class) ;
				play.putExtra("color1", pl1);
				play.putExtra("color2", pl2);
				settings2Activity.this.startActivity(play) ;
			}
				break ;
		}
		// TODO Auto-generated method stub
		
	}


	
}