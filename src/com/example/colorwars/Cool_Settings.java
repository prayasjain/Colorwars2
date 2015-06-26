package com.example.colorwars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Cool_Settings extends Activity implements OnClickListener {
	Button ballselect1, ballselect2;
	int flagcolor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cool_settings);
		ballselect1 = (Button) findViewById(R.id.color1);
		ballselect2 = (Button) findViewById(R.id.color2);
		ballselect1.setOnClickListener(this);
		ballselect2.setOnClickListener(this);
		flagcolor = 0;
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

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle b = data.getExtras();
			String scolor = b.getString("selectedcolor");
			if (scolor.contentEquals("red")) {
				if (flagcolor == 1)
					ballselect1.setBackgroundResource(R.drawable.red);
				else if (flagcolor == 2)
					ballselect2.setBackgroundResource(R.drawable.red);

			} else if (scolor.contentEquals("blue")) {
				if (flagcolor == 1)
					ballselect1.setBackgroundResource(R.drawable.blue);
				else if (flagcolor == 2)
					ballselect2.setBackgroundResource(R.drawable.blue);

			} else if (scolor.contentEquals("green")) {
				if (flagcolor == 1)
					ballselect1.setBackgroundResource(R.drawable.green);
				else if (flagcolor == 2)
					ballselect2.setBackgroundResource(R.drawable.green);

			} else if (scolor.contentEquals("yellow")) {
				if (flagcolor == 1)
					ballselect1.setBackgroundResource(R.drawable.yellow);
				else if (flagcolor == 2)
					ballselect2.setBackgroundResource(R.drawable.yellow);

			}
		}
	}

}
