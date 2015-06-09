package com.example.colorwars;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {
 Button Play,About,Help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Play=(Button)findViewById(R.id.Button02);
        Help=(Button)findViewById(R.id.button1);
        About=(Button)findViewById(R.id.Button01);
        Play.setOnClickListener(this);
        Help.setOnClickListener(this);
        About.setOnClickListener(this);
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
		switch(arg0.getId()){
		
		case R.id.Button01: Intent About= new Intent(MainActivity.this,AboutActivity.class);
		MainActivity.this.startActivity(About);
			break;                    
		case R.id.Button02: Intent Settings = new Intent(MainActivity.this,settings2Activity.class);
		                    MainActivity.this.startActivity(Settings);
		                    break;
		case R.id.button1 : Intent Help = new Intent(MainActivity.this,HelpActivity.class) ;
							MainActivity.this.startActivity(Help) ;
							break ;
		}
		// TODO Auto-generated method stub
		
	}
}
