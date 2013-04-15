package com.github.naotoshimura.android.lovelycommune;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.media.MediaPlayer;
//import android.widget.TextView;

public class MainActivity extends Activity {

//	private TextView textView;	// debug用
	private ImageView changeImageView;
	private ImageView communeImageView;
	private MediaPlayer loverinkMedia;
	private boolean[] communeChangeFlg = {false,false,false,false,false};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// タイトルバーを隠す
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		
		changeImageView = (ImageView)findViewById(R.id.imageView_sharu);
		communeImageView = (ImageView)findViewById(R.id.imageView_commune_beads);
		loverinkMedia = MediaPlayer.create(this, R.raw.loverink);
//		textView = (TextView)findViewById(R.id.textView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    @Override
    public boolean onTouchEvent(MotionEvent e) {
     
    	int x = (int)e.getX();
    	int y = (int)e.getY();
//        textView.setText( "X:" + x + "\nY:" + y );
 
        Log.d("debug","X:" + x + "  Y:" + y);

        // シャルル
        if ((x >= 203 && x <= 224) 
         && (y >= 665 && y <= 682)) {
          	if(e.getAction() == MotionEvent.ACTION_DOWN) {
           		communeChangeFlg[0] = true;
           	}
           	if (e.getAction() == MotionEvent.ACTION_UP) {
           		if (checkCommuneChangeFlg(communeChangeFlg[0]) == true) {
	            	changeImageView.setImageResource(R.drawable.sharu);
	              	communeImageView.setVisibility(View.INVISIBLE);
           		}
           		communeChangeFlg[0] = false;
           	}
        }
       	// ラケル
        else if ((x >= 163 && x <= 189) 
           	  && (y >= 657 && y <= 673)) {
           	if(e.getAction() == MotionEvent.ACTION_DOWN) {
           		communeChangeFlg[1] = true;
           	}
           	if (e.getAction() == MotionEvent.ACTION_UP) {
           		if (checkCommuneChangeFlg(communeChangeFlg[1]) == true) {
		           	changeImageView.setImageResource(R.drawable.rakeru);
		           	communeImageView.setVisibility(View.INVISIBLE);
           		}
           		communeChangeFlg[1] = false;
           	}
        }
       	// ランス
        else if ((x >= 246 && x <= 273) 
              && (y >= 665 && y <= 682)) {
           	if(e.getAction() == MotionEvent.ACTION_DOWN) {
           		communeChangeFlg[2] = true;
           	}
           	if (e.getAction() == MotionEvent.ACTION_UP) {
           		if (checkCommuneChangeFlg(communeChangeFlg[2]) == true) {
		           	changeImageView.setImageResource(R.drawable.ransu);
		           	communeImageView.setVisibility(View.INVISIBLE);
           		}
           		communeChangeFlg[2] = false;
           	}
        }
       	// ダビィ
        else if ((x >= 285 && x <= 315) 
              && (y >= 657 && y <= 673)) {
           	if(e.getAction() == MotionEvent.ACTION_DOWN) {
           		communeChangeFlg[3] = true;
           	}
           	if (e.getAction() == MotionEvent.ACTION_UP) {
           		if (checkCommuneChangeFlg(communeChangeFlg[3]) == true) {
		           	changeImageView.setImageResource(R.drawable.davy);
		           	communeImageView.setVisibility(View.INVISIBLE);
           		}
           		communeChangeFlg[3] = false;
           	}
        }
        else if ((x >= 197 && x <= 273) 
              && (y >= 219 && y <= 275)) {
           	if(e.getAction() == MotionEvent.ACTION_DOWN) {
           		communeChangeFlg[4] = true;
           	}
           	if (e.getAction() == MotionEvent.ACTION_UP) {
           		if (checkCommuneChangeFlg(communeChangeFlg[4]) == true) {
           			communeImageView.setVisibility(View.VISIBLE);
           			loverinkMedia.start();
           		}
           		communeChangeFlg[4] = false;
           	}
        }

        return true;
    }
    
    private boolean checkCommuneChangeFlg(boolean flg) {
    	boolean ret = flg;
    	
    	if (ret != true) {
    		for(int i=0 ; i < communeChangeFlg.length ; i++) {
    			communeChangeFlg[i] = false;
    		}
    		if (loverinkMedia.isPlaying()) {
    			loverinkMedia.stop();
    		}
    		ret = false;
    	}
    	return ret;
    }

}
