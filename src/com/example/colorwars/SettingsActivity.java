package com.example.colorwars;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class SettingsActivity extends Activity implements OnItemSelectedListener,OnClickListener {
	int type=0,tim=0,move=0,c1=0,c2=0,c3=0,c4=0;
	Spinner modesel,col1,col2,col3,col4;
	TextView t1,t2,t3,t4,t5,t6;
	EditText time,moves;
	String col[];
	Button Play;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		modesel=(Spinner)findViewById(R.id.mode);
		modesel.setOnItemSelectedListener(this);
		col1=(Spinner)findViewById(R.id.Col1);
		col2=(Spinner)findViewById(R.id.Col2);
		col3=(Spinner)findViewById(R.id.Col3);
		col4=(Spinner)findViewById(R.id.Col4);
		col1.setOnItemSelectedListener(this);
		col2.setOnItemSelectedListener(this);
		col3.setOnItemSelectedListener(this);
		col4.setOnItemSelectedListener(this);
		moves=(EditText)findViewById(R.id.textView3);
		time=(EditText)findViewById(R.id.textView2);
		t1=(TextView)findViewById(R.id.TimeLimit);
		t2=(TextView)findViewById(R.id.MoveLimit);
		t3=(TextView)findViewById(R.id.textView4);
		t4=(TextView)findViewById(R.id.textView5);
		t5=(TextView)findViewById(R.id.textView6);
	    t6=(TextView)findViewById(R.id.textView7);
	    Play=(Button)findViewById(R.id.play);
	    Play.setOnClickListener(this);
		String[] items=new String[]{"Select Mode","Elimination","tick-tick","count_your_moves","tournament(4 players)","Bluetooth","global competition","custom"};
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
		modesel.setAdapter(adapter);
		col=new String[]{"Choose Color","Red","Blue","Green","Yellow"};
		ArrayAdapter<String>coloradap=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,col);
		col1.setAdapter(coloradap);

		ArrayAdapter<String>coloradap1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,col);
		col2.setAdapter(coloradap1);

		ArrayAdapter<String>coloradap2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,col);
		col3.setAdapter(coloradap2);

		ArrayAdapter<String>coloradap3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,col);
		col4.setAdapter(coloradap3);
		t3.setVisibility(android.view.View.INVISIBLE);
		col1.setVisibility(android.view.View.INVISIBLE);
		col2.setVisibility(android.view.View.INVISIBLE);
		col3.setVisibility(android.view.View.INVISIBLE);
		col4.setVisibility(android.view.View.INVISIBLE);
		moves.setVisibility(android.view.View.INVISIBLE);
		time.setVisibility(View.INVISIBLE);
		t1.setVisibility(android.view.View.INVISIBLE);
		t2.setVisibility(android.view.View.INVISIBLE);
		t4.setVisibility(android.view.View.INVISIBLE);
		t5.setVisibility(android.view.View.INVISIBLE);
		t6.setVisibility(android.view.View.INVISIBLE);
		
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		switch(arg0.getId())
		{case R.id.mode:
		        int position=modesel.getSelectedItemPosition();
		        if(position==0)
		        	{type=0;
		        	t3.setVisibility(android.view.View.INVISIBLE);
		    		col1.setVisibility(android.view.View.INVISIBLE);
		    		col2.setVisibility(android.view.View.INVISIBLE);
		    		col3.setVisibility(android.view.View.INVISIBLE);
		    		col4.setVisibility(android.view.View.INVISIBLE);
		    		moves.setVisibility(android.view.View.INVISIBLE);
		    		time.setVisibility(View.INVISIBLE);
		    		t1.setVisibility(android.view.View.INVISIBLE);
		    		t2.setVisibility(android.view.View.INVISIBLE);
		    		t4.setVisibility(android.view.View.INVISIBLE);
		    		t5.setVisibility(android.view.View.INVISIBLE);
		    		t6.setVisibility(android.view.View.INVISIBLE);
		    		
		        	}
		        
			    if(position==1)
				{
				t3.setVisibility(android.view.View.VISIBLE);
				col1.setVisibility(android.view.View.VISIBLE);
				col2.setVisibility(android.view.View.INVISIBLE);
				col3.setVisibility(android.view.View.INVISIBLE);
				col4.setVisibility(android.view.View.INVISIBLE);
				moves.setVisibility(android.view.View.INVISIBLE);
				time.setVisibility(View.INVISIBLE);
				t1.setVisibility(android.view.View.INVISIBLE);
				t2.setVisibility(android.view.View.INVISIBLE);
				t4.setVisibility(android.view.View.INVISIBLE);
				t5.setVisibility(android.view.View.INVISIBLE);
				t6.setVisibility(android.view.View.INVISIBLE);
				type=1;
				}
			if(position==2)
				{t3.setVisibility(android.view.View.VISIBLE);
				col1.setVisibility(android.view.View.VISIBLE);
				col2.setVisibility(android.view.View.INVISIBLE);
				col3.setVisibility(android.view.View.INVISIBLE);
				col4.setVisibility(android.view.View.INVISIBLE);
				moves.setVisibility(android.view.View.INVISIBLE);
				time.setVisibility(View.VISIBLE);
				t1.setVisibility(android.view.View.VISIBLE);
				String A=time.getText().toString();
				tim=Integer.parseInt(A);
				t2.setVisibility(android.view.View.INVISIBLE);
				t4.setVisibility(android.view.View.INVISIBLE);
				t5.setVisibility(android.view.View.INVISIBLE);
				t6.setVisibility(android.view.View.INVISIBLE);
				type=2;}
			if(position==3)
				{t3.setVisibility(android.view.View.VISIBLE);
				col1.setVisibility(android.view.View.VISIBLE);
				col2.setVisibility(android.view.View.INVISIBLE);
				col3.setVisibility(android.view.View.INVISIBLE);
				col4.setVisibility(android.view.View.INVISIBLE);
				moves.setVisibility(android.view.View.VISIBLE);
				time.setVisibility(View.INVISIBLE);
				t1.setVisibility(android.view.View.INVISIBLE);
				t2.setVisibility(android.view.View.VISIBLE);
				t4.setVisibility(android.view.View.INVISIBLE);
				t5.setVisibility(android.view.View.INVISIBLE);
				t6.setVisibility(android.view.View.INVISIBLE);
				type=3;}
			if(position==4)
				{type=4;
				t3.setVisibility(android.view.View.VISIBLE);
				col1.setVisibility(android.view.View.VISIBLE);
				col2.setVisibility(android.view.View.INVISIBLE);
				col3.setVisibility(android.view.View.INVISIBLE);
				col4.setVisibility(android.view.View.INVISIBLE);
				moves.setVisibility(android.view.View.VISIBLE);
				time.setVisibility(View.VISIBLE);
				t1.setVisibility(android.view.View.VISIBLE);
				t2.setVisibility(android.view.View.VISIBLE);
				t4.setVisibility(android.view.View.INVISIBLE);
				t5.setVisibility(android.view.View.INVISIBLE);
				t6.setVisibility(android.view.View.INVISIBLE);
				}
			if(position==5)
				{t3.setVisibility(android.view.View.VISIBLE);
				col1.setVisibility(android.view.View.VISIBLE);
				col2.setVisibility(android.view.View.INVISIBLE);
				col3.setVisibility(android.view.View.INVISIBLE);
				col4.setVisibility(android.view.View.INVISIBLE);
				moves.setVisibility(android.view.View.INVISIBLE);
				time.setVisibility(View.INVISIBLE);
				t1.setVisibility(android.view.View.INVISIBLE);
				t2.setVisibility(android.view.View.INVISIBLE);
				t4.setVisibility(android.view.View.INVISIBLE);
				t5.setVisibility(android.view.View.INVISIBLE);
				t6.setVisibility(android.view.View.INVISIBLE);
				type=5;}
			if(position==6)
				{t3.setVisibility(android.view.View.VISIBLE);
				col1.setVisibility(android.view.View.VISIBLE);
				col2.setVisibility(android.view.View.INVISIBLE);
				col3.setVisibility(android.view.View.INVISIBLE);
				col4.setVisibility(android.view.View.INVISIBLE);
				moves.setVisibility(android.view.View.INVISIBLE);
				time.setVisibility(View.INVISIBLE);
				t1.setVisibility(android.view.View.INVISIBLE);
				t2.setVisibility(android.view.View.INVISIBLE);
				t4.setVisibility(android.view.View.INVISIBLE);
				t5.setVisibility(android.view.View.INVISIBLE);
				t6.setVisibility(android.view.View.INVISIBLE);
				type=6;}
			if(position==7)
				{t3.setVisibility(android.view.View.VISIBLE);
				col1.setVisibility(android.view.View.VISIBLE);
				col2.setVisibility(android.view.View.INVISIBLE);
				col3.setVisibility(android.view.View.INVISIBLE);
				col4.setVisibility(android.view.View.INVISIBLE);
				moves.setVisibility(android.view.View.VISIBLE);
				time.setVisibility(View.VISIBLE);
				t1.setVisibility(android.view.View.VISIBLE);
				t2.setVisibility(android.view.View.VISIBLE);
				t4.setVisibility(android.view.View.INVISIBLE);
				t5.setVisibility(android.view.View.INVISIBLE);
				t6.setVisibility(android.view.View.INVISIBLE);
				type=7;}
			break;
		case R.id.Col1:
			int pos=col1.getSelectedItemPosition();
			if(pos!=0){
			c1=pos;
			if(type!=5&&type!=6){
			col2.setVisibility(View.VISIBLE);
			t4.setVisibility(View.VISIBLE);}}
			break;
		case R.id.Col2:
			int posi=col2.getSelectedItemPosition();
			if(posi!=0){
				c2=posi;
				if(type==4)
				{col3.setVisibility(View.VISIBLE);
				t5.setVisibility(View.VISIBLE);}
			}
			break;
		case R.id.Col3:
			int posit=col3.getSelectedItemPosition();
			if(posit!=0)
			{
				c3=posit;
				col4.setVisibility(View.VISIBLE);
				t6.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.Col4:
			int positi=col4.getSelectedItemPosition();
			if(positi!=0)
				c4=positi;
			break;
			
			
		}
		
		// TODO Auto-generated method stub
			
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.play)
		{ try{
            tim=  Integer.parseInt(time.getText().toString());}
            catch (NumberFormatException e){
                // this is not a number. tell the user something here or do something
                Log.e("yourAppTag", Log.getStackTraceString(e));
            }
		try{
            move=  Integer.parseInt(moves.getText().toString());}
            catch (NumberFormatException e){
                // this is not a number. tell the user something here or do something
                Log.e("yourAppTag", Log.getStackTraceString(e));
            } 
		
			if((type==1&&c1!=0&&c2!=0&&c1!=c2)||(type==2&&c1!=0&&c2!=0&&c1!=c2&&tim>0&&tim<10)||(type==3&&c1!=0&&c2!=0&&c1!=c2&&move>10&&move<100)||(type==4&&c1!=0&&c2!=0&&c3!=0&&c4!=0&&tim>0&&tim<10&&c1!=c3&&c1!=c4&&c2!=c3&&c2!=c4&&c3!=c4&&c1!=c2&&move>10&&move<100)||(type==5&&c1!=0)||(type==6&&c1!=0)||(type==7&&c1!=0&&c2!=0&&c1!=c2&&move>10&&move<100&&tim<10&&tim>0))
			{
			Intent Play = new Intent(SettingsActivity.this,compActivity.class);
            
            Play.putExtra("type", type);
            Play.putExtra("color1", c1);
            Play.putExtra("color2", c2);
            Play.putExtra("color3", c3);
            Play.putExtra("color4", c4);
            Play.putExtra("timelimit", tim);
            Play.putExtra("movelimit", move);
            SettingsActivity.this.startActivity(Play);
		
			}
			
            
		}
		
		// TODO Auto-generated method stub
		
	}
}
