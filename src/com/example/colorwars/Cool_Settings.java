package com.example.colorwars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Cool_Settings extends Activity implements OnClickListener {
	Button ballselect1, ballselect2,p1color,p2color,play;
	Button mode;
	int flagcolor,color1=2,color2=1;
	char ch='S';

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cool_settings);
		ballselect1 = (Button) findViewById(R.id.color1);
		ballselect2 = (Button) findViewById(R.id.color2);
		p1color=(Button) findViewById(R.id.p1color);
		p2color=(Button) findViewById(R.id.p2color);
		ballselect1.setOnClickListener(this);
		ballselect2.setOnClickListener(this);
		flagcolor = 0;
		mode=(Button)findViewById(R.id.mode);
		mode.setOnClickListener(this);
		p1color.setOnClickListener(this);
		p2color.setOnClickListener(this);
		play=(Button)findViewById(R.id.play);
		play.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == ballselect1.getId()) {
			Intent i = new Intent(Cool_Settings.this, ButtonSelector.class);
			flagcolor = 1;
			startActivityForResult(i, 0);

		} else if (v.getId() == ballselect2.getId()) {
			Intent p = new Intent(Cool_Settings.this, ButtonSelector.class);
			flagcolor = 2;
			startActivityForResult(p, 0);

		}
		else if(v.getId()==R.id.mode)
		{
			if(ch=='S')
			{
				ch='M';
				mode.setText("Mode : Multi Player (Vs. Player)");
			}
			else
			{
				ch='S';
				mode.setText("Mode : Single Player (Vs. Bot)");
			}
		}
		else if(v.getId()==R.id.p1color)
		{
			if(color1==1)
			{
				ballselect1.setBackgroundResource(R.drawable.blue);
				color1=2;
				p1color.setText("Color : Blue");
			}
			else if(color1==2)
			{
				ballselect1.setBackgroundResource(R.drawable.green);
				color1=3;
				p1color.setText("Color : Green");
			}
			else if(color1==3)
			{
				ballselect1.setBackgroundResource(R.drawable.yellow);
				color1=4;
				p1color.setText("Color : Yellow");
			}
			else
			{
				ballselect1.setBackgroundResource(R.drawable.red);
				color1=1;
				p1color.setText("Color : Red");
			}
		}
		else if(v.getId()==R.id.p2color)
		{
			if(color2==1)
			{
				ballselect2.setBackgroundResource(R.drawable.blue);
				color2=2;
				p2color.setText("Color : Blue");
			}
			else if(color2==2)
			{
				ballselect2.setBackgroundResource(R.drawable.green);
				color2=3;
				p2color.setText("Color : Green");
			}
			else if(color2==3)
			{
				ballselect2.setBackgroundResource(R.drawable.yellow);
				color2=4;
				p2color.setText("Color : Yellow");
			}
			else
			{
				ballselect2.setBackgroundResource(R.drawable.red);
				color2=1;
				p2color.setText("Color : Red");
			}
		}
		else if(v.getId()==R.id.play)
		{
			if(ch=='S')
			{Intent play=new Intent(Cool_Settings.this,comp3.class) ;
			play.putExtra("color1", color1);
			
			Cool_Settings.this.startActivity(play) ;
			}
		else if(ch=='M'&&color1!=color2){
			Intent play=new Intent(Cool_Settings.this,PlayActivity.class) ;
			play.putExtra("color1", color1);
			play.putExtra("color2", color2);
			Cool_Settings.this.startActivity(play) ;
		}
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle b = data.getExtras();
			String scolor = b.getString("selectedcolor");
			if (scolor.contentEquals("red")) {
				if (flagcolor == 1){
					ballselect1.setBackgroundResource(R.drawable.red);
					color1=1;
					p1color.setText("Color : Red");
					}
				else if (flagcolor == 2){
					ballselect2.setBackgroundResource(R.drawable.red);
					color2=1;
					p2color.setText("Color : Red");
				}

			} else if (scolor.contentEquals("blue")) {
				if (flagcolor == 1){
					ballselect1.setBackgroundResource(R.drawable.blue);
					color1=2;
					p1color.setText("Color : Blue");
					}
				else if (flagcolor == 2){
					ballselect2.setBackgroundResource(R.drawable.blue);
					color2=2;
					p2color.setText("Color : Blue");
				}

			} else if (scolor.contentEquals("green")) {
				if (flagcolor == 1){
					ballselect1.setBackgroundResource(R.drawable.green);
					color1=3;
					p1color.setText("Color : Green");
					}
				else if (flagcolor == 2){
					ballselect2.setBackgroundResource(R.drawable.green);
					color2=3;
					p2color.setText("Color : Green");
				}

			} else if (scolor.contentEquals("yellow")) {
				if (flagcolor == 1){
					ballselect1.setBackgroundResource(R.drawable.yellow);
					color1=4;
					p1color.setText("Color : Yellow");
					}
				else if (flagcolor == 2){
					ballselect2.setBackgroundResource(R.drawable.yellow);
					color2=4;
					p2color.setText("Color : Yellow");
				}

			}
		}
	}

}
