package com.example.colorwars;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class Splash extends Activity implements OnTouchListener {
	SplashView ourSurfaceView;
	float x, y;
	Bitmap blue, lblue, lgreen, yellow, red,bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		ourSurfaceView = new SplashView(this);
		ourSurfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;

		blue = BitmapFactory.decodeResource(getResources(),
				R.drawable.bluesplash);
		lblue = BitmapFactory.decodeResource(getResources(),
				R.drawable.lbluesplash);
		lgreen = BitmapFactory.decodeResource(getResources(),
				R.drawable.lgreensplash);
		red = BitmapFactory
				.decodeResource(getResources(), R.drawable.redsplash);
		yellow = BitmapFactory.decodeResource(getResources(),
				R.drawable.yellowsplash);
		setContentView(ourSurfaceView);
		Thread timer = new Thread(){
			public void run(){
				try {
					sleep(2000) ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					Intent i = new Intent(Splash.this,MainActivity.class) ;
					startActivity(i);
				}
				
				
			}
		};
		timer.start();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random r = new Random() ;
		int t = r.nextInt(5) ;
		
		if(t==1)
			bmp = blue ;
		else if(t==2)
			bmp = lblue ;
		else if(t==3)
			bmp = red ;
		else if (t==4)
			bmp=yellow ;
		else if(t==0)
			bmp=lgreen ;
		
		
		x = event.getX();
		y = event.getY();
		
		switch (event.getAction()) {

		case MotionEvent.ACTION_UP:

			break;
		}
		return true;
	}

	public class SplashView extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;

		public SplashView(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			ourHolder = getHolder();

		}

		public void pause() {
			isRunning = false;
			try {
				ourThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		@Override
		public void run() {

			// TODO Auto-generated method stub
			while (isRunning) {
				if (!ourHolder.getSurface().isValid())
					continue;
				Canvas canvas = ourHolder.lockCanvas();
				if(x!=0 ||y!=0)
				canvas.drawBitmap(bmp, x - bmp.getWidth() / 2,
						y - bmp.getHeight() / 2, null);

				ourHolder.unlockCanvasAndPost(canvas);
			}

		}

	}

}
