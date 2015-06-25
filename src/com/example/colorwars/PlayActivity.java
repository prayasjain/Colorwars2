package com.example.colorwars;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends Activity implements OnClickListener,
		OnTouchListener {
	// Variable declarations
	// =====================================================================================
	float sx = 0, fx = 0;
	float sy = 0;
	float fy = 0;
	public Button B[][] = new Button[5][5];
	public Button Left, Right, Top, Bottom, rpower1, rpower2, rpower3, bpower1,
			bpower2, bpower3, undo, set, over;
	public int A[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
	public int b[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
	public int mid[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
	public int i, j, l, k = 0, rmoves = 0, bmoves = 0, totscore = 0,
			totscore1 = 0;
	public char t = 'R';
	public int c = 0;
	public int doneundo = 1;
	public int urmoves, ubmoves, utotscore, utotscore1;
	public int brmoves, bbmoves, btotscore, btotscore1;
	public TextView chotu, bscore, rscore, redmoves, bluemoves, name1, name2,
			movec1, movec2;
	public int c1 = 0, c2 = 0, c3 = 0, c4 = 0, time, move, type;

	// =====================================================================================

	// Function for Undo
	// =====================================================================================
	public int checkarr() {
		int flag = 0;
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				if (mid[i][j] != A[i][j]) {
					flag++;
					break;

				}
			}
		}
		return flag;
	}

	public void color() {

		switch (c1) {
		case 1:
			name1.setTextColor(Color.rgb(255, 0, 0));
			movec1.setTextColor(Color.rgb(255, 0, 0));
			rscore.setTextColor(Color.rgb(255, 0, 0));
			redmoves.setTextColor(Color.rgb(255, 0, 0));
			break;
		case 2:
			name1.setTextColor(Color.rgb(0, 0, 255));
			movec1.setTextColor(Color.rgb(0, 0, 255));
			rscore.setTextColor(Color.rgb(0, 0, 255));
			redmoves.setTextColor(Color.rgb(0, 0, 255));
			break;
		case 3:
			name1.setTextColor(Color.rgb(0, 255, 0));
			movec1.setTextColor(Color.rgb(0, 255, 0));
			rscore.setTextColor(Color.rgb(0, 255, 0));
			redmoves.setTextColor(Color.rgb(0, 255, 0));
			break;
		case 4:
			name1.setTextColor(Color.rgb(255, 255, 0));
			movec1.setTextColor(Color.rgb(255, 255, 0));
			rscore.setTextColor(Color.rgb(255, 255, 0));
			redmoves.setTextColor(Color.rgb(255, 255, 0));
			break;
		}

		switch (c2) {
		case 1:
			name2.setTextColor(Color.rgb(255, 0, 0));
			movec2.setTextColor(Color.rgb(255, 0, 0));
			bscore.setTextColor(Color.rgb(255, 0, 0));
			bluemoves.setTextColor(Color.rgb(255, 0, 0));
			break;
		case 2:
			name2.setTextColor(Color.rgb(0, 0, 255));
			movec2.setTextColor(Color.rgb(0, 0, 255));
			bscore.setTextColor(Color.rgb(0, 0, 255));
			bluemoves.setTextColor(Color.rgb(0, 0, 255));
			break;
		case 3:
			name2.setTextColor(Color.rgb(0, 255, 0));
			movec2.setTextColor(Color.rgb(0, 255, 0));
			bscore.setTextColor(Color.rgb(0, 255, 0));
			bluemoves.setTextColor(Color.rgb(0, 255, 0));
			break;
		case 4:
			name2.setTextColor(Color.rgb(255, 255, 0));
			movec2.setTextColor(Color.rgb(255, 255, 0));
			bscore.setTextColor(Color.rgb(255, 255, 0));
			bluemoves.setTextColor(Color.rgb(255, 255, 0));
			break;
		}

	}

	public void undo() {
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++)
				A[i][j] = b[i][j];
		}
		totscore = utotscore;
		totscore1 = utotscore1;
		bmoves = ubmoves;
		rmoves = urmoves;
		if (t == 'R') {
			t = 'B';
		} else
			t = 'R';

		display();
		doneundo = 1;
	}

	// ======================================================================================

	// Function to count both player's balls
	// =====================================================================================
	public int countplayer1() {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (A[i][j] == 1)
					count++;
			}
		}
		return count;
	}

	public int countplayer2() {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (A[i][j] == 2)
					count++;
			}
		}
		return count;
	}

	// ======================================================================================

	// Function to call winning Screen
	// ======================================================================================
	public void winScreen(int c) {
		Intent win = new Intent(PlayActivity.this, WinActivity.class);
		win.putExtra("wincolor", c);
		PlayActivity.this.startActivity(win);

	}

	// ======================================================================================

	// Function to check winning condition
	// ======================================================================================
	public void wincall() {
		if (countplayer1() == 0 && rmoves > 0) {
			winScreen(2);
		}
		if (countplayer2() == 0 && bmoves > 0)
			winScreen(1);
		if ((type == 3 || type == 7) && rmoves == move && bmoves == move) {
			if (countplayer1() > countplayer2())
				winScreen(1);
			else if (countplayer2() > countplayer1())
				winScreen(2);
		}

	}

	// ======================================================================================

	// Function to start the game over
	// =======================================================================================
	public void startover() {
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				A[i][j] = 0;
				b[i][j] = 0;
			}
		}
		bmoves = 0;
		rmoves = 0;
		totscore = 0;
		totscore1 = 0;
		t = 'R';
		display();
	}

	// Function to display next screen
	// ======================================================================================
	public void display() {

		if (t == 'R') {
			switch (c1) {
			case 1:
				chotu.setBackgroundResource(R.drawable.red);
				break;
			case 2:
				chotu.setBackgroundResource(R.drawable.blue);
				break;
			case 3:
				chotu.setBackgroundResource(R.drawable.green);
				break;
			case 4:
				chotu.setBackgroundResource(R.drawable.yellow);
				break;

			}
		} else if (t == 'B') {
			switch (c2) {
			case 1:
				chotu.setBackgroundResource(R.drawable.red);
				break;
			case 2:
				chotu.setBackgroundResource(R.drawable.blue);
				break;
			case 3:
				chotu.setBackgroundResource(R.drawable.green);
				break;
			case 4:
				chotu.setBackgroundResource(R.drawable.yellow);
				break;

			}
		}

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				switch (A[i][j]) {
				case 0:
					B[i][j].setBackgroundResource(R.drawable.white);
					break;
				case 1:
					switch (c1) {
					case 1:
						B[i][j].setBackgroundResource(R.drawable.red);
						break;
					case 2:
						B[i][j].setBackgroundResource(R.drawable.blue);
						break;
					case 3:
						B[i][j].setBackgroundResource(R.drawable.green);
						break;
					case 4:
						B[i][j].setBackgroundResource(R.drawable.yellow);
						break;
					}
					break;
				case 2:
					switch (c2) {
					case 1:
						B[i][j].setBackgroundResource(R.drawable.red);
						break;
					case 2:
						B[i][j].setBackgroundResource(R.drawable.blue);
						break;
					case 3:
						B[i][j].setBackgroundResource(R.drawable.green);
						break;
					case 4:
						B[i][j].setBackgroundResource(R.drawable.yellow);
						break;
					}
					break;

				}
			}
		}
		rscore.setText(Integer.toString(totscore1));
		bscore.setText(Integer.toString(totscore));
		redmoves.setText(Integer.toString(rmoves));
		bluemoves.setText(Integer.toString(bmoves));
		wincall();
		doneundo = 0;

	}

	// ==================================================================================================

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Getting values from previous activity
		// ==================================================================================================
		Intent intent = getIntent();
		// type=intent.getIntExtra("type", 0);
		c1 = intent.getIntExtra("color1", 0);
		c2 = intent.getIntExtra("color2", 0);
		// c3=intent.getIntExtra("color3", 0);
		// c4=intent.getIntExtra("color4", 0);

		// time=intent.getIntExtra("timelimit", 0);
		// move=intent.getIntExtra("movelimit", 0);
		// ==================================================================================================

		super.onCreate(savedInstanceState);
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewGroup ourView = (ViewGroup) inflater.inflate(R.layout.play2, null);

		setContentView(ourView);

		ourView.setOnTouchListener(this);

		// References to XML file
		// ==================================================================================================
		name1 = (TextView) findViewById(R.id.textView2);
		name2 = (TextView) findViewById(R.id.textView1);
		movec1 = (TextView) findViewById(R.id.textView5);
		movec2 = (TextView) findViewById(R.id.textView6);
		chotu = (TextView) findViewById(R.id.turn);
		bscore = (TextView) findViewById(R.id.bscore);
		rscore = (TextView) findViewById(R.id.rscore);
		redmoves = (TextView) findViewById(R.id.redmoves);
		bluemoves = (TextView) findViewById(R.id.bluemoves);
		undo = (Button) findViewById(R.id.button9);
		set = (Button) findViewById(R.id.button26);
		over = (Button) findViewById(R.id.button25);
		B[0][0] = (Button) findViewById(R.id.Button05);
		B[0][1] = (Button) findViewById(R.id.button1);
		B[0][2] = (Button) findViewById(R.id.Button04);
		B[0][3] = (Button) findViewById(R.id.Button09);
		B[0][4] = (Button) findViewById(R.id.Button10);
		B[1][0] = (Button) findViewById(R.id.Button03);
		B[1][1] = (Button) findViewById(R.id.Button02);
		B[1][2] = (Button) findViewById(R.id.Button01);
		B[1][3] = (Button) findViewById(R.id.Button11);
		B[1][4] = (Button) findViewById(R.id.Button13);
		B[2][0] = (Button) findViewById(R.id.Button06);
		B[2][1] = (Button) findViewById(R.id.Button07);
		B[2][2] = (Button) findViewById(R.id.Button08);
		B[2][3] = (Button) findViewById(R.id.Button12);
		B[2][4] = (Button) findViewById(R.id.Button17);
		B[3][0] = (Button) findViewById(R.id.Button19);
		B[3][1] = (Button) findViewById(R.id.Button14);
		B[3][2] = (Button) findViewById(R.id.Button16);
		B[3][3] = (Button) findViewById(R.id.Button18);
		B[3][4] = (Button) findViewById(R.id.Button15);
		B[4][0] = (Button) findViewById(R.id.Button24);
		B[4][1] = (Button) findViewById(R.id.Button20);
		B[4][2] = (Button) findViewById(R.id.Button22);
		B[4][3] = (Button) findViewById(R.id.Button23);
		B[4][4] = (Button) findViewById(R.id.Button21);
		Left = (Button) findViewById(R.id.Left);
		Right = (Button) findViewById(R.id.Right);
		Top = (Button) findViewById(R.id.Top);
		Bottom = (Button) findViewById(R.id.Bottom);
		rpower1 = (Button) findViewById(R.id.redpower1);
		rpower2 = (Button) findViewById(R.id.redpower2);
		rpower3 = (Button) findViewById(R.id.redpower3);
		bpower1 = (Button) findViewById(R.id.bluepower1);
		bpower2 = (Button) findViewById(R.id.bluepower2);
		bpower3 = (Button) findViewById(R.id.bluepower3);
		// ================================================================================================================================

		// Setting buttons clickable
		// ================================================================================================================================
		rpower1.setOnClickListener(this);
		rpower2.setOnClickListener(this);
		rpower3.setOnClickListener(this);
		bpower1.setOnClickListener(this);
		bpower2.setOnClickListener(this);
		bpower3.setOnClickListener(this);
		over.setOnClickListener(this);
		undo.setOnClickListener(this);
		set.setOnClickListener(this);
		B[0][0].setOnClickListener(this);
		B[0][1].setOnClickListener(this);
		B[0][2].setOnClickListener(this);
		B[0][3].setOnClickListener(this);
		B[0][4].setOnClickListener(this);

		B[1][0].setOnClickListener(this);
		B[1][1].setOnClickListener(this);
		B[1][2].setOnClickListener(this);
		B[1][3].setOnClickListener(this);
		B[1][4].setOnClickListener(this);

		B[2][0].setOnClickListener(this);
		B[2][1].setOnClickListener(this);
		B[2][2].setOnClickListener(this);
		B[2][3].setOnClickListener(this);
		B[2][4].setOnClickListener(this);

		B[3][0].setOnClickListener(this);
		B[3][1].setOnClickListener(this);
		B[3][2].setOnClickListener(this);
		B[3][3].setOnClickListener(this);
		B[3][4].setOnClickListener(this);

		B[4][0].setOnClickListener(this);
		B[4][1].setOnClickListener(this);
		B[4][2].setOnClickListener(this);
		B[4][3].setOnClickListener(this);
		B[4][4].setOnClickListener(this);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				B[i][j].setOnTouchListener(this);
			}
		}
		Left.setOnClickListener(this);
		Right.setOnClickListener(this);
		Top.setOnClickListener(this);
		Bottom.setOnClickListener(this);
		color();
		// =========================================================================================================================

		// Display initial game screen
		// =========================================================================================================================
		display();
		doneundo = 1;
		// =========================================================================================================================
	}

	// Preparatory function for undo
	// =========================================================================================================================
	public void copy() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				b[i][j] = A[i][j];
		}
		ubmoves = bmoves;
		urmoves = rmoves;
		utotscore = totscore;
		utotscore1 = totscore1;
	}

	// =========================================================================================================================

	// Function to check if a change is made
	// =========================================================================================================================
	public int checkchange() {
		int flag = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (A[i][j] != b[i][j])
					flag = 1;
			}
		}
		return flag;
	}

	// ==========================================================================================================================

	// Power ups
	// ==========================================================================================================================

	// Player 1 Power 1
	void p1power1(int m, int n) {
		if (A[m][n] == 2) {
			A[m][n] = 1;
			k = 0;
			t = 'B';
			rmoves++;
			totscore1 -= 10;
			display();
		} else
			k = 0;
	}

	// Player 2 Power 1
	void p2power1(int m, int n) {
		if (A[m][n] == 1) {
			A[m][n] = 2;
			k = 0;
			t = 'R';
			bmoves++;
			totscore -= 10;
			display();
		} else
			k = 0;
	}

	// Player 1 Power 2
	void p1power2(int j) {
		if (t == 'R') {
			for (i = 0; i < 5; i++) {
				if (A[j][i] == 2)
					A[j][i] = 1;
			}
			t = 'B';
			k = 0;
			rmoves++;
			totscore1 -= 15;
			display();
		}
	}

	// Player 2 Power 2
	void p2power2(int i) {
		if (t == 'B') {
			for (j = 0; j < 5; j++) {
				if (A[j][i] == 1)
					A[j][i] = 2;
			}
			t = 'R';
			k = 0;
			bmoves++;
			totscore -= 15;
			display();
		}
	}

	// =================================================================================================================
	void p1power3(int m, int n) {
		for (int i = m - 1; i <= m + 1; i++) {
			for (int j = n - 1; j <= n + 1; j++) {
				if (i >= 0 && j >= 0 && i < 5 && j < 5) {
					if (A[i][j] == 2) {
						A[i][j] = 1;
					}

				}
			}
		}
		t = 'B';
		k = 0;
		rmoves++;
		totscore1 -= 5;
		display();

	}

	void p2power3(int m, int n) {
		for (int i = m - 1; i <= m + 1; i++) {
			for (int j = n - 1; j <= n + 1; j++) {
				if (i >= 0 && j >= 0 && i < 5 && j < 5) {
					if (A[i][j] == 1) {
						A[i][j] = 2;
					}

				}

			}
		}
		t = 'R';
		k = 0;
		bmoves++;
		totscore -= 5;
		display();

	}

	// Eliminate other balls functions
	// Moving Left
	public void moveleft() {
		if (t == 'R') {

			for (i = 0; i < 5; i++) {
				for (j = 0, c = 0; j < 5; j++) {
					if (A[i][j] != 0) {
						A[i][c] = A[i][j];
						c++;
					}
				}
				for (; c < 5; c++) {
					A[i][c] = 0;
				}
				for (l = 1; l < 5; l++) {
					if (A[i][l - 1] == 2 && A[i][l] == 1) {
						A[i][l - 1] = 1;
						totscore1++;
					}
				}
			}
			// display score }

		}
	}

	// Move Right
	public void moveright() {
		if (t == 'R') {

			for (i = 4; i >= 0; i--) {
				for (j = 4, c = 4; j >= 0; j--) {
					if (A[i][j] != 0) {
						A[i][c] = A[i][j];
						c--;
					}
				}
				for (; c >= 0; c--) {
					A[i][c] = 0;
				}
				for (l = 3; l >= 0; l--) {
					if (A[i][l + 1] == 2 && A[i][l] == 1) {
						A[i][l + 1] = 1;
						totscore1++;
					}
				}
			}
			// display score }

		}
	}

	// Move Up
	public void moveup() {
		if (t == 'B') {

			for (i = 0; i < 5; i++) {
				for (j = 0, c = 0; j < 5; j++) {
					if (A[j][i] != 0) {
						A[c][i] = A[j][i];
						c++;
					}
				}
				for (; c < 5; c++) {
					A[c][i] = 0;
				}
				for (l = 1; l < 5; l++) {
					if (A[l - 1][i] == 1 && A[l][i] == 2) {
						A[l - 1][i] = 2;
						totscore++;
					}
				}
			}
			// display score }

		}
	}

	// Move down
	public void movedown() {
		if (t == 'B') {

			for (i = 4; i >= 0; i--) {
				for (j = 4, c = 4; j >= 0; j--) {
					if (A[j][i] != 0) {
						A[c][i] = A[j][i];
						c--;
					}
				}
				for (; c >= 0; c--) {
					A[c][i] = 0;
				}
				for (l = 3; l >= 0; l--) {
					if (A[l + 1][i] == 1 && A[l][i] == 2) {
						A[l + 1][i] = 2;
						totscore++;
					}
				}
			}
			// display score }

		}
	}

	// =================================================================================================================================================

	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()) {
		// Undo
		// =================================================================================================================================================
		case R.id.button9:
			if (doneundo == 0)
				undo();
			break;
		// ================================================================================================================================

		// Setting Over
		// ================================================================================================================================
		case R.id.button25:
			startover();
			break;
		// ================================================================================================================================

		case R.id.button26:
			Intent Settings = new Intent(PlayActivity.this,
					SettingsActivity.class);
			PlayActivity.this.startActivity(Settings);
			break;
		// Calling power functions
		// ================================================================================================================================
		case R.id.bluepower3:
			if (t == 'B') {
				if (totscore >= 5) {
					k = 6;
				}

			}
			break;
		case R.id.redpower3:
			if (t == 'R') {
				if (totscore1 >= 5) {
					k = 5;
				}

			}
			break;
		case R.id.redpower2:
			if (t == 'R') {
				if (totscore1 >= 15) {
					k = 3;
				}
			}
			break;
		case R.id.bluepower2:
			if (t == 'B') {
				if (totscore >= 15) {
					k = 4;
				}
			}
			break;
		case R.id.redpower1:
			if (t == 'R') {
				if (totscore1 >= 10) {
					k = 1;
				}
			}
			break;

		case R.id.bluepower1:
			if (t == 'B') {
				if (totscore >= 10) {
					k = 2;
				}
			}
			break;
		// ====================================================================================================================================================

		// Elimination function calls
		// =====================================================================================================================================================
		case R.id.Right:
			for (i = 0; i < 5; i++) {
				for (j = 0; j < 5; j++)
					mid[i][j] = A[i][j];
			}
			brmoves = rmoves;
			bbmoves = bmoves;
			btotscore = totscore;
			btotscore1 = totscore1;
			moveright();
			if (checkarr() != 0) {
				ubmoves = bbmoves;
				urmoves = brmoves;
				utotscore = btotscore;
				utotscore1 = btotscore1;
				for (i = 0; i < 5; i++) {
					for (j = 0; j < 5; j++)
						b[i][j] = mid[i][j];
				}
				t = 'B';
				rmoves++;
			}
			if (checkchange() != 0) {

			}
			display();

			break;
		case R.id.Left:
			for (i = 0; i < 5; i++) {
				for (j = 0; j < 5; j++)
					mid[i][j] = A[i][j];
			}
			brmoves = rmoves;
			bbmoves = bmoves;
			btotscore = totscore;
			btotscore1 = totscore1;
			moveleft();
			if (checkarr() != 0) {
				for (i = 0; i < 5; i++) {
					for (j = 0; j < 5; j++)
						b[i][j] = mid[i][j];
				}
				ubmoves = bbmoves;
				urmoves = brmoves;
				utotscore = btotscore;
				utotscore1 = btotscore1;
				t = 'B';
				rmoves++;
			}
			if (checkchange() != 0) {

			}
			display();

			break;
		case R.id.Top:
			for (i = 0; i < 5; i++) {
				for (j = 0; j < 5; j++)
					mid[i][j] = A[i][j];
			}
			brmoves = rmoves;
			bbmoves = bmoves;
			btotscore = totscore;
			btotscore1 = totscore1;
			moveup();
			if (checkarr() != 0) {
				for (i = 0; i < 5; i++) {
					for (j = 0; j < 5; j++)
						b[i][j] = mid[i][j];
				}
				ubmoves = bbmoves;
				urmoves = brmoves;
				utotscore = btotscore;
				utotscore1 = btotscore1;
				bmoves++;
				t = 'R';
			}

			display();
			break;
		case R.id.Bottom:
			for (i = 0; i < 5; i++) {
				for (j = 0; j < 5; j++)
					mid[i][j] = A[i][j];
			}
			brmoves = rmoves;
			bbmoves = bmoves;
			btotscore = totscore;
			btotscore1 = totscore1;
			movedown();
			if (checkarr() != 0) {
				for (i = 0; i < 5; i++) {
					for (j = 0; j < 5; j++)
						b[i][j] = mid[i][j];
				}
				ubmoves = bbmoves;
				urmoves = brmoves;
				utotscore = btotscore;
				utotscore1 = btotscore1;
				bmoves++;
				t = 'R';

			}

			display();
			break;
		// =====================================================================================================================================================

		// TODO Auto-generated method stub

		}
		// On Game button clicks
		// =====================================================================================================================================================

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (B[i][j].getId() == arg0.getId()) {

					if (k == 6) {
						if (A[i][j] == 2) {
							p2power3(i, j);
						}
					}
					if (k == 5) {
						if (A[i][j] == 1) {
							p1power3(i, j);
						}
					}
					if (k == 3) {
						if (A[i][j] != 0) {
							p1power2(i);
						} else
							k = 0;
					} else if (k == 4) {
						if (A[i][j] != 0) {
							p2power2(j);
						} else
							k = 0;
					}

					else if (k == 1) {
						p1power1(i, j);
					} else if (k == 2) {
						p2power1(i, j);

					} else if (A[i][j] == 0) {
						{
							copy();
							if (t == 'R') {
								rmoves++;
								B[i][j].setBackgroundResource(R.drawable.red);
								t = 'B';
								A[i][j] = 1;
							} else {
								bmoves++;
								B[i][j].setBackgroundResource(R.drawable.blue);
								A[i][j] = 2;
								t = 'R';
							}
							display();
						}

					}
				}
			}
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent arg1) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// TODO Auto-generated method stub

		TextView debug = (TextView) findViewById(R.id.tvdebug2);

		switch (arg1.getAction()) {

		case MotionEvent.ACTION_DOWN:
			sx = arg1.getX();
			sy = arg1.getY();
			String y = Float.toString(sx);

			debug.setText("in" + y);
			break;

		case MotionEvent.ACTION_UP:
			fx = arg1.getX();
			fy = arg1.getY();

			// /////////////////////////////////////////////////////////////

			int stx = (int) sx;
			int finx = (int) fx;
			int sty = (int) sy;
			int finy = (int) fy;
			int diff = finx - stx;
			int diff2 = finy - sty;
			if (Math.abs(diff2) > Math.abs(diff)) {
				diff = diff2;
			}
			if (Math.abs(diff) < 20) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (B[i][j].getId() == v.getId()) {

							if (k == 6) {
								if (A[i][j] == 2) {
									p2power3(i, j);
								}
							}
							if (k == 5) {
								if (A[i][j] == 1) {
									p1power3(i, j);
								}
							}
							if (k == 3) {
								if (A[i][j] != 0) {
									p1power2(i);
								} else
									k = 0;
							} else if (k == 4) {
								if (A[i][j] != 0) {
									p2power2(j);
								} else
									k = 0;
							}

							else if (k == 1) {
								p1power1(i, j);
							} else if (k == 2) {
								p2power1(i, j);

							} else if (A[i][j] == 0) {
								{
									copy();
									if (t == 'R') {
										rmoves++;
										B[i][j].setBackgroundResource(R.drawable.red);
										t = 'B';
										A[i][j] = 1;
									} else {
										bmoves++;
										B[i][j].setBackgroundResource(R.drawable.blue);
										A[i][j] = 2;
										t = 'R';
									}
									display();
								}

							}
						}
					}
				}
				return false;
			}
			if (t == 'R') {
				int diffx = finx - stx;
				if (Math.abs(diffx) < 20) {
					return false;
				} else {

					if (diffx > 0) {
						for (i = 0; i < 5; i++) {
							for (j = 0; j < 5; j++)
								mid[i][j] = A[i][j];
						}
						brmoves = rmoves;
						bbmoves = bmoves;
						btotscore = totscore;
						btotscore1 = totscore1;
						moveright();
						if (checkarr() != 0) {
							ubmoves = bbmoves;
							urmoves = brmoves;
							utotscore = btotscore;
							utotscore1 = btotscore1;
							for (i = 0; i < 5; i++) {
								for (j = 0; j < 5; j++)
									b[i][j] = mid[i][j];
							}
							t = 'B';
							rmoves++;
						}
						if (checkchange() != 0) {

						}
						display();

					} else {
						for (i = 0; i < 5; i++) {
							for (j = 0; j < 5; j++)
								mid[i][j] = A[i][j];
						}
						brmoves = rmoves;
						bbmoves = bmoves;
						btotscore = totscore;
						btotscore1 = totscore1;
						moveleft();
						if (checkarr() != 0) {
							for (i = 0; i < 5; i++) {
								for (j = 0; j < 5; j++)
									b[i][j] = mid[i][j];
							}
							ubmoves = bbmoves;
							urmoves = brmoves;
							utotscore = btotscore;
							utotscore1 = btotscore1;
							t = 'B';
							rmoves++;
						}
						if (checkchange() != 0) {

						}
						display();

					}
				}

			} else if (t == 'B') {
				int diffy = finy - sty;
				if (Math.abs(diffy) < 20) {
					return false;
				} else {
					if (diffy > 0) {

						for (i = 0; i < 5; i++) {
							for (j = 0; j < 5; j++)
								mid[i][j] = A[i][j];
						}
						brmoves = rmoves;
						bbmoves = bmoves;
						btotscore = totscore;
						btotscore1 = totscore1;
						movedown();
						if (checkarr() != 0) {
							for (i = 0; i < 5; i++) {
								for (j = 0; j < 5; j++)
									b[i][j] = mid[i][j];
							}
							ubmoves = bbmoves;
							urmoves = brmoves;
							utotscore = btotscore;
							utotscore1 = btotscore1;
							bmoves++;
							t = 'R';

						}

						display();

					} else {

						for (i = 0; i < 5; i++) {
							for (j = 0; j < 5; j++)
								mid[i][j] = A[i][j];
						}
						brmoves = rmoves;
						bbmoves = bmoves;
						btotscore = totscore;
						btotscore1 = totscore1;
						moveup();
						if (checkarr() != 0) {
							for (i = 0; i < 5; i++) {
								for (j = 0; j < 5; j++)
									b[i][j] = mid[i][j];
							}
							ubmoves = bbmoves;
							urmoves = brmoves;
							utotscore = btotscore;
							utotscore1 = btotscore1;
							bmoves++;
							t = 'R';
						}

						display();

					}
				}
			}
			// ////////////////////////////////////////////////////////////////////
			sx = 0;
			fx = 0;
			sy = 0;
			fy = 0;
			sty = 0;
			finy = 0;

			stx = 0;
			finx = 0;
			break;
		}

		return true;
	}

}
