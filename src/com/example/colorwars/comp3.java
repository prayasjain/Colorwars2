package com.example.colorwars;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import android.widget.TextView;

public class comp3 extends Activity implements OnClickListener, OnTouchListener {
	// Variable declarations
	// =====================================================================================
	public Button B[][] = new Button[5][5];
	/*
	 * Color Mappings : 1- red 2- blue 3- green 4- yellow
	 */
	ArrayList<Integer> transi, transj;
	float sx = 0, fx = 0,sy=0,fy=0;

	public Button Left, Right, Top, Bottom, rpower1, rpower2, rpower3, bpower1,
			bpower2, bpower3, undo, set, over;
	public int A[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
	public int b[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
	public int mid[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
	public int chotu2[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
	public int i, j, l, k = 0, rmoves = 0, bmoves = 0, totscore = 0,
			totscore1 = 0, scorecheck;
	public char t = 'R';
	public int c = 0;
	public int doneundo = 1;
	public int urmoves, ubmoves, utotscore, utotscore1;
	public int brmoves, bbmoves, btotscore, btotscore1;
	public TextView chotu, bscore, rscore, redmoves, bluemoves, name1, name2,
			movec1, movec2;
	public int c1 = 0, c2 = 0, c3 = 0, c4 = 0, time, move, type;
	public int upstrength, downstrength, buttonstrength, gbutton[] = { 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0 };

	// =====================================================================================
	// function for single player
	public int bup() {
		scorecheck = 0;

		for (i = 0; i < 5; i++) {
			for (j = 0, c = 0; j < 5; j++) {
				if (chotu2[j][i] != 0) {
					chotu2[c][i] = chotu2[j][i];
					c++;
				}
			}
			for (; c < 5; c++) {
				chotu2[c][i] = 0;
			}
			for (l = 1; l < 5; l++) {
				if (chotu2[l - 1][i] == 1 && chotu2[l][i] == 2) {
					chotu2[l - 1][i] = 2;
					scorecheck++;
				}
			}
		}

		return scorecheck;
	}

	public int bdown() {
		scorecheck = 0;

		for (i = 4; i >= 0; i--) {
			for (j = 4, c = 4; j >= 0; j--) {
				if (chotu2[j][i] != 0) {
					chotu2[c][i] = chotu2[j][i];
					c--;
				}
			}
			for (; c >= 0; c--) {
				chotu2[c][i] = 0;
			}
			for (l = 3; l >= 0; l--) {
				if (chotu2[l + 1][i] == 1 && chotu2[l][i] == 2) {
					chotu2[l + 1][i] = 2;
					scorecheck++;
				}
			}
		}

		return scorecheck;
	}

	public int lleft() {
		scorecheck = 0;

		for (i = 0; i < 5; i++) {
			for (j = 0, c = 0; j < 5; j++) {
				if (chotu2[i][j] != 0) {
					chotu2[i][c] = chotu2[i][j];
					c++;
				}
			}
			for (; c < 5; c++) {
				chotu2[i][c] = 0;
			}
			for (l = 1; l < 5; l++) {
				if (chotu2[i][l - 1] == 2 && chotu2[i][l] == 1) {
					chotu2[i][l - 1] = 1;
					scorecheck++;
				}
			}
		}

		return scorecheck;
	}

	public int lright() {
		scorecheck = 0;

		for (i = 4; i >= 0; i--) {
			for (j = 4, c = 4; j >= 0; j--) {
				if (chotu2[i][j] != 0) {
					chotu2[i][c] = chotu2[i][j];
					c--;
				}
			}
			for (; c >= 0; c--) {
				chotu2[i][c] = 0;
			}
			for (l = 3; l >= 0; l--) {
				if (chotu2[i][l + 1] == 2 && chotu2[i][l] == 1) {
					chotu2[i][l + 1] = 1;
					scorecheck++;
				}
			}
		}

		return scorecheck;
	}

	// ===================================================================================

	// Function to know benefit of our move
	// =====================================================================================
	public int bupnextbutton(int u, int v) {
		scorecheck = 0;

		chotu2[u][v] = 2;
		for (i = 0; i < 5; i++) {
			for (j = 0, c = 0; j < 5; j++) {
				if (chotu2[j][i] != 0) {
					chotu2[c][i] = chotu2[j][i];
					c++;
				}
			}
			for (; c < 5; c++) {
				chotu2[c][i] = 0;
			}
			for (l = 1; l < 5; l++) {
				if (chotu2[l - 1][i] == 1 && chotu2[l][i] == 2) {
					chotu2[l - 1][i] = 2;
					scorecheck++;
				}
			}
		}

		return scorecheck;
	}

	public int bdownnextbutton(int u, int v) {
		scorecheck = 0;

		chotu2[u][v] = 2;
		for (i = 4; i >= 0; i--) {
			for (j = 4, c = 4; j >= 0; j--) {
				if (chotu2[j][i] != 0) {
					chotu2[c][i] = chotu2[j][i];
					c--;
				}
			}
			for (; c >= 0; c--) {
				chotu2[c][i] = 0;
			}
			for (l = 3; l >= 0; l--) {
				if (chotu2[l + 1][i] == 1 && chotu2[l][i] == 2) {
					chotu2[l + 1][i] = 2;
					scorecheck++;
				}
			}
		}

		return scorecheck;
	}

	public int lrightnext(int u, int v) {
		scorecheck = 0;

		chotu2[u][v] = 2;
		for (i = 4; i >= 0; i--) {
			for (j = 4, c = 4; j >= 0; j--) {
				if (chotu2[i][j] != 0) {
					chotu2[i][c] = chotu2[i][j];
					c--;
				}
			}
			for (; c >= 0; c--) {
				chotu2[i][c] = 0;
			}
			for (l = 3; l >= 0; l--) {
				if (chotu2[i][l + 1] == 2 && chotu2[i][l] == 1) {
					chotu2[i][l + 1] = 1;
					scorecheck++;
				}
			}
		}

		return scorecheck;
	}

	public int lleftnext(int u, int v) {
		scorecheck = 0;

		chotu2[u][v] = 2;
		for (i = 0; i < 5; i++) {
			for (j = 0, c = 0; j < 5; j++) {
				if (chotu2[i][j] != 0) {
					chotu2[i][c] = chotu2[i][j];
					c++;
				}
			}
			for (; c < 5; c++) {
				chotu2[i][c] = 0;
			}
			for (l = 1; l < 5; l++) {
				if (chotu2[i][l - 1] == 2 && chotu2[i][l] == 1) {
					chotu2[i][l - 1] = 1;
					scorecheck++;
				}
			}
		}
		return scorecheck;
	}

	public void formchotu2() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				chotu2[i][j] = A[i][j];
			}
		}
	}

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
			t = 'R';
		} else
			t = 'B';

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
		Intent win = new Intent(comp3.this, WinActivity.class);
		win.putExtra("wincolor", c);

		comp3.this.startActivity(win);
		startover();

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
		if (countplayer1() + countplayer2() == 25) {
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
		transi.clear();
		transj.clear();
		display();
	}

	// Function to display next screen
	// ======================================================================================
	public void slow() {
		try {
			Thread.sleep(100);
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void display() {

		wincall();

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

		griddisplay();
		rscore.setText(Integer.toString(totscore1));
		bscore.setText(Integer.toString(totscore));
		redmoves.setText(Integer.toString(rmoves));
		bluemoves.setText(Integer.toString(bmoves));

		doneundo = 0;
		try {
			Thread.sleep(100);
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!transi.isEmpty())
			transition();

	}

	// ==================================================================================================

	private void transition() {
		// TODO Auto-generated method stub

		for (i = 0; i < transi.size(); i++) {
			checktranscolor(B[transi.get(i)][transj.get(i)]);
			// B[transi.get(i)][transj.get(i)].setBackgroundResource(R.drawable.yellowgreen);
		}
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				griddisplay();
			}

		}, 500);

	}

	private void griddisplay() {
		// TODO Auto-generated method stub
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
	}

	// Single Player Game
	// ==================================================================================================
	public void singleplayer() {

		wincall();
		int cp2 = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (A[i][j] == 2) {
					gbutton[cp2] = i * 10 + j;
					cp2++;

				}
			}
		}
		if (cp2 != 0 || bmoves == 0) {
			int k = 0;
			formchotu2();
			int upbenefit = bup();
			formchotu2();
			int downbenefit = bdown();
			if (upbenefit == 5) {
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

					bmoves++;
					t = 'R';
				}

				display();
			} else if (downbenefit == 5) {
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

					bmoves++;
					t = 'R';

				}

				display();
			} else {
				buttonstrength = -999;
				formchotu2();
				int leftloss = lleft();
				formchotu2();
				int rightloss = lright();
				// To calculate benefit of up
				formchotu2();
				int temp = bup();
				temp = lleft() - leftloss;
				formchotu2();
				int temp1 = bup();
				temp1 = lright() - rightloss;
				if (temp > temp1)
					upstrength = upbenefit - temp;
				else
					upstrength = upbenefit - temp1;
				// To calculate benefit of down
				formchotu2();
				temp = bdown();
				temp = lleft() - leftloss;
				formchotu2();
				temp1 = bdown();
				temp1 = lright() - rightloss;
				if (temp > temp1)
					downstrength = downbenefit - temp;
				else
					downstrength = downbenefit - temp1;
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (A[i][j] == 0) {
							formchotu2();
							int up2 = bupnextbutton(i, j);
							formchotu2();
							int down2 = bdownnextbutton(i, j);
							formchotu2();
							int left2 = lleftnext(i, j);
							formchotu2();
							int right2 = lrightnext(i, j);
							int bstrength;
							if (left2 - leftloss > right2 - rightloss)
								bstrength = up2 - upbenefit - downbenefit
										+ down2 - left2 + leftloss;
							else
								bstrength = up2 - upbenefit - downbenefit
										+ down2 - right2 + rightloss;
							if (buttonstrength < bstrength) {
								buttonstrength = bstrength;
								k = 0;
								gbutton[k] = i * 10 + j;
							} else if (buttonstrength == bstrength) {
								k++;
								gbutton[k] = i * 10 + j;
							}

						}
					}
				}

				int value = rand(k);

				j = (gbutton[value]) % 10;
				i = (int) (gbutton[value]) / 10;

				if (buttonstrength > 0 && upstrength > 0 && downstrength > 0) {
					upstrength++;
					downstrength++;
					value = rand(buttonstrength + upstrength + downstrength);
					if (value < buttonstrength) {

						A[i][j] = 2;
						t = 'R';
						bmoves++;

						display();

					} else if (value >= buttonstrength
							&& value < (buttonstrength + upstrength)) {
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

							bmoves++;
							t = 'R';
						}

						display();
					}
				} else {
					int count = 0;
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							if (A[i][j] == 0)
								count++;
						}
					}
					if (count != 0) {

						A[i][j] = 2;
						t = 'R';
						bmoves++;
						display();

					} else {
						if (upstrength >= downstrength) {
							for (int i = 0; i < 5; i++) {
								for (int j = 0; j < 5; j++)
									mid[i][j] = A[i][j];
							}
							brmoves = rmoves;
							bbmoves = bmoves;
							btotscore = totscore;
							btotscore1 = totscore1;
							moveup();
							if (checkarr() != 0) {

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

								bmoves++;
								t = 'R';
							}

							display();
						}
					}
				}
			}
		}

	}

	// =================================================================================================

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		transi = new ArrayList<Integer>();
		transj = new ArrayList<Integer>();
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewGroup ourView = (ViewGroup) inflater.inflate(R.layout.play, null);

		setContentView(ourView);

		ourView.setOnTouchListener(this);
		// Getting values from previous activity
		// ==================================================================================================
		Intent intent = getIntent();
		// type=intent.getIntExtra("type", 0);
		c1 = intent.getIntExtra("color1", 0);
		c2 = c1;
		while (c2 == c1) {
			c2 = rand(4);
			c2++;
		}
		bridgeview();

		clickable();

		color();

		display();
		doneundo = 1;

	}

	private void clickable() {
		// TODO Auto-generated method stub
		rpower1.setOnClickListener(this);
		rpower2.setOnClickListener(this);
		rpower3.setOnClickListener(this);

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

		// Top.setOnClickListener(this);
		// Bottom.setOnClickListener(this);
	}

	private void bridgeview() {
		// TODO Auto-generated method stub
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

	public int rand(int possibility) {
		return ((int) (Math.random() * possibility));
	}

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
		transi.clear();
		transj.clear();
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
						transi.add(i);
						transj.add(l - 1);
					}
				}
			}
			// display score }

		}

	}

	// Move Right
	public void moveright() {
		transi.clear();
		transj.clear();
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
						transi.add(i);
						transj.add(l + 1);

					}
				}
			}

		}
	}

	// Move Up
	public void moveup() {
		if (t == 'B') {
			transi.clear();
			transj.clear();

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
						transi.add(l - 1);
						transj.add(i);
					}
				}
			}
			// display score }

		}
	}

	// Move down
	public void movedown() {
		if (t == 'B') {
			transi.clear();
			transj.clear();

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
						transi.add(l + 1);
						transj.add(i);
					}
				}
			}
			// display score }

		}
	}

	public void checktranscolor(Button b) {
		TextView debug = (TextView) findViewById(R.id.tvdebug);
		debug.setText(String.valueOf(c1) + " " + String.valueOf(c2));
		if (c1 == 1) {
			if (c2 == 1) {

				b.setBackgroundResource(R.drawable.red);

			} else if (c2 == 2) {
				b.setBackgroundResource(R.drawable.purple);

			} else if (c2 == 3) {
				b.setBackgroundResource(R.drawable.redgreen);

			} else if (c2 == 4) {
				b.setBackgroundResource(R.drawable.redyellow);

			}
		} else if (c1 == 2) {
			if (c2 == 1) {
				b.setBackgroundResource(R.drawable.purple);

			} else if (c2 == 2) {
				b.setBackgroundResource(R.drawable.blue);

			} else if (c2 == 3) {
				b.setBackgroundResource(R.drawable.bluegreen);

			} else if (c2 == 4) {
				b.setBackgroundResource(R.drawable.blueyellow);

			}
		} else if (c1 == 3) {

			if (c2 == 1) {
				b.setBackgroundResource(R.drawable.redgreen);

			} else if (c2 == 2) {
				b.setBackgroundResource(R.drawable.bluegreen);

			} else if (c2 == 3) {
				b.setBackgroundResource(R.drawable.green);

			} else if (c2 == 4) {
				b.setBackgroundResource(R.drawable.yellowgreen);

			}
		} else if (c1 == 4) {
			if (c2 == 1) {
				b.setBackgroundResource(R.drawable.redyellow);

			} else if (c2 == 2) {
				b.setBackgroundResource(R.drawable.blueyellow);

			} else if (c2 == 3) {
				b.setBackgroundResource(R.drawable.yellowgreen);

			} else if (c2 == 4) {
				b.setBackgroundResource(R.drawable.yellow);

			}
		}

	}


	// =================================================================================================================================================

	@Override
	public void onClick(View arg0) {
		transi.clear();
		transj.clear();
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
			Intent Settings = new Intent(comp3.this, SettingsActivity.class);
			comp3.this.startActivity(Settings);
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

			display();
			singleplayer();

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

			display();
			singleplayer();

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
							singleplayer();
						}
					}
					if (k == 1) {
						p1power1(i, j);
						singleplayer();
					} else if (k == 2) {
						p2power1(i, j);

					} else if (k == 3) {
						if (A[i][j] != 0) {
							p1power2(i);
							singleplayer();
						} else
							k = 0;
					} else if (k == 4) {
						if (A[i][j] != 0) {
							p2power2(j);
						} else
							k = 0;
					}

					else if (A[i][j] == 0) {
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
							singleplayer();
						}

					}
				}
			}
		}

	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// TODO Auto-generated method stub
		

		transi.clear();
		transj.clear();
		TextView debug = (TextView) findViewById(R.id.tvdebug);

		switch (arg1.getAction()) {

		case MotionEvent.ACTION_DOWN:
			sx = arg1.getX();
			sy=arg1.getY();
			String y = Float.toString(sx);

			debug.setText("in" + y);
			return true;

		case MotionEvent.ACTION_UP:
			fx = arg1.getX();
			fy=arg1.getY();
			String x = Float.toString(fx);

			// /////////////////////////////////////////////////////////////

			int st = (int) sx;
			int fin = (int) fx;
			int sty = (int)sy;
			int finy = (int) fy ;
			int diff = fin - st;
			int diff2 = finy-sty ;
			if(Math.abs(diff)<Math.abs(diff2)){
				return false ;
			}
			debug.setText("st" + st + "fin" + fin + "diff" + diff);
			if (Math.abs(diff) < 20) {
				for (i = 0; i < 5; i++) {
					for (j = 0; j < 5; j++) {
						if (arg0.getId() == B[i][j].getId()) {
							if (k == 6) {
								if (A[i][j] == 2) {
									p2power3(i, j);
								}
							}
							if (k == 5) {
								if (A[i][j] == 1) {
									p1power3(i, j);
									singleplayer();
								}
							}
							if (k == 1) {
								p1power1(i, j);
								singleplayer();
							} else if (k == 2) {
								p2power1(i, j);

							} else if (k == 3) {
								if (A[i][j] != 0) {
									p1power2(i);
									singleplayer();
								} else
									k = 0;
							} else if (k == 4) {
								if (A[i][j] != 0) {
									p2power2(j);
								} else
									k = 0;
							}

							else if (A[i][j] == 0) {
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
									singleplayer();
								}

							}
							Toast.makeText(getApplicationContext(),
									i + " " + j, Toast.LENGTH_SHORT).show();
						}
					}
				}
				return false;
			}
			if (fin != 0) {

				if (fin > st) {
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 5; j++)
							mid[i][j] = A[i][j];
					}
					brmoves = rmoves;
					bbmoves = bmoves;
					btotscore = totscore;
					btotscore1 = totscore1;
					moveright();
					debug.setTextColor(Color.GREEN);
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

					display();
					singleplayer();

				} else if (fin < st) {
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

					display();

					singleplayer();

				}
			}

			// ////////////////////////////////////////////////////////////////////
			sx = 0;
			fx = 0;
			st = 0;
			sty=0;
			fin = 0;
			finy=0 ;
			sy = 0;
			fy = 0;
			
			return true;
		}
		return true;
	}
}
