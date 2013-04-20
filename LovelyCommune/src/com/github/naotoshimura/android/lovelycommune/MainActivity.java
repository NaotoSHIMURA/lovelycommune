package com.github.naotoshimura.android.lovelycommune;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.media.MediaPlayer;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView;	// debug用
	private ImageView changeImageView;
	private ImageView communeImageView;
	private MediaPlayer loverinkMediaH;
	private MediaPlayer loverinkMediaHL;
	private MediaPlayer loverinkMediaHO;
	private MediaPlayer loverinkMediaHV;
	private MediaPlayer loverinkMediaHE;
	private MediaPlayer loverinkMediaD;
	private MediaPlayer loverinkMediaDL;
	private MediaPlayer loverinkMediaDO;
	private MediaPlayer loverinkMediaDV;
	private MediaPlayer loverinkMediaDE;
	private MediaPlayer loverinkMediaR;
	private MediaPlayer loverinkMediaRL;
	private MediaPlayer loverinkMediaRO;
	private MediaPlayer loverinkMediaRV;
	private MediaPlayer loverinkMediaRE;
	private MediaPlayer loverinkMediaS;
	private MediaPlayer loverinkMediaSL;
	private MediaPlayer loverinkMediaSO;
	private MediaPlayer loverinkMediaSV;
	private MediaPlayer loverinkMediaSE;
	private MediaPlayer loverinkMedia;
	private MediaPlayer loverinkMediaL;
	private MediaPlayer loverinkMediaO;
	private MediaPlayer loverinkMediaV;
	private MediaPlayer loverinkMediaE;
	private static int loverinkCount = 0;
	private boolean[] communeChangeFlg = {false,false,false,false,false};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// タイトルバーを隠す
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		
		changeImageView = (ImageView)findViewById(R.id.imageView_sharu);
		communeImageView = (ImageView)findViewById(R.id.imageView_commune_beads);
		loverinkMedia = MediaPlayer.create(this, R.raw.loverink_h); // ダミーで作る
		loverinkMediaL = MediaPlayer.create(this, R.raw.loverink_h_l); // ダミーで作る
		loverinkMediaO = MediaPlayer.create(this, R.raw.loverink_h_o); // ダミーで作る
		loverinkMediaV = MediaPlayer.create(this, R.raw.loverink_h_v); // ダミーで作る
		loverinkMediaE = MediaPlayer.create(this, R.raw.loverink_h_e); // ダミーで作る
		loverinkMediaH = MediaPlayer.create(this, R.raw.loverink_h);
		loverinkMediaHL = MediaPlayer.create(this, R.raw.loverink_h_l);
		loverinkMediaHO = MediaPlayer.create(this, R.raw.loverink_h_o);
		loverinkMediaHV = MediaPlayer.create(this, R.raw.loverink_h_v);
		loverinkMediaHE = MediaPlayer.create(this, R.raw.loverink_h_e);
		loverinkMediaD = MediaPlayer.create(this, R.raw.loverink_d);
		loverinkMediaDL = MediaPlayer.create(this, R.raw.loverink_d_l);
		loverinkMediaDO = MediaPlayer.create(this, R.raw.loverink_d_o);
		loverinkMediaDV = MediaPlayer.create(this, R.raw.loverink_d_v);
		loverinkMediaDE = MediaPlayer.create(this, R.raw.loverink_d_e);
		loverinkMediaR = MediaPlayer.create(this, R.raw.loverink_r);
		loverinkMediaRL = MediaPlayer.create(this, R.raw.loverink_r_l);
		loverinkMediaRO = MediaPlayer.create(this, R.raw.loverink_r_o);
		loverinkMediaRV = MediaPlayer.create(this, R.raw.loverink_r_v);
		loverinkMediaRE = MediaPlayer.create(this, R.raw.loverink_r_e);
		loverinkMediaS = MediaPlayer.create(this, R.raw.loverink_s);
		loverinkMediaSL = MediaPlayer.create(this, R.raw.loverink_s_l);
		loverinkMediaSO = MediaPlayer.create(this, R.raw.loverink_s_o);
		loverinkMediaSV = MediaPlayer.create(this, R.raw.loverink_s_v);
		loverinkMediaSE = MediaPlayer.create(this, R.raw.loverink_s_e);
		textView = (TextView)findViewById(R.id.textView1);
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
		MediaPlayer m = new MediaPlayer();

//        textView.setText( "X:" + x + "\nY:" + y );
 
    	switch(e.getAction()){
    	case MotionEvent.ACTION_DOWN:
    		Log.d("ACTION_DOWN","X:" + x + "  Y:" + y);
    		break;
    	case MotionEvent.ACTION_UP:
    		Log.d("ACTION_UP","X:" + x + "  Y:" + y);
    		break;
    	case MotionEvent.ACTION_MOVE:
    		Log.d("ACTION_MOVE","X:" + x + "  Y:" + y);
    		break;
    	}
        

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
           		setLoverinkMedia(loverinkMediaH);
           		loverinkMediaL = loverinkMediaHL;
           		loverinkMediaO = loverinkMediaHO;
           		loverinkMediaV = loverinkMediaHV;
           		loverinkMediaE = loverinkMediaHE;
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
           		setLoverinkMedia(loverinkMediaD);
           		loverinkMediaL = loverinkMediaDL;
           		loverinkMediaO = loverinkMediaDO;
           		loverinkMediaV = loverinkMediaDV;
           		loverinkMediaE = loverinkMediaDE;
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
           		setLoverinkMedia(loverinkMediaR);
           		loverinkMediaL = loverinkMediaRL;
           		loverinkMediaO = loverinkMediaRO;
           		loverinkMediaV = loverinkMediaRV;
           		loverinkMediaE = loverinkMediaRE;
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
           		setLoverinkMedia(loverinkMediaS);
           		loverinkMediaL = loverinkMediaSL;
           		loverinkMediaO = loverinkMediaSO;
           		loverinkMediaV = loverinkMediaSV;
           		loverinkMediaE = loverinkMediaSE;
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
           			communeImageView.setImageResource(R.drawable.commune_beads);
           			loverinkCount = 0;
           			m = getLoverinkMedia();
           			m.start();
           		}
//           		communeChangeFlg[4] = false;
           	}
        }
        
        // L O V E
        if (communeChangeFlg[4] == true) {
        	Log.d("debug", "loverinkCount = " + loverinkCount);
        	if (getLoverinkMedia().isPlaying()) {
        		return true;
        	}

        	if ((x >= 166 && x <= 189) 
	         && (y >= 452 && y <= 534)) {
	        	if (loverinkCount == 0) {
	            	if(e.getAction() == MotionEvent.ACTION_DOWN) {
		        		communeImageView.setImageResource(R.drawable.commune_beads_l);
		        		setLoverinkMedia(loverinkMediaL);
		        		getLoverinkMedia().start();
	           			loverinkCount=1;
	            	}
	        	} else if (loverinkCount == 1) {
	            	if(e.getAction() == MotionEvent.ACTION_DOWN) {
		        		communeImageView.setImageResource(R.drawable.commune_beads_o);
		        		setLoverinkMedia(loverinkMediaO);
		        		getLoverinkMedia().start();
	           			loverinkCount=2;
	            	}
	        	} else if (loverinkCount == 2) {
	            	if(e.getAction() == MotionEvent.ACTION_DOWN) {
		        		communeImageView.setImageResource(R.drawable.commune_beads_v);
		        		setLoverinkMedia(loverinkMediaV);
		        		getLoverinkMedia().start();
	           			loverinkCount=3;
	            	}
	        	}
	        }
	        else if ((x >= 183 && x <= 286) 
	   	         && (y >= 438 && y <= 457)) {
	        	if (loverinkCount == 3) {
	        		if(e.getAction() == MotionEvent.ACTION_DOWN) {
		        		communeImageView.setImageResource(R.drawable.commune_beads_e);
		        		setLoverinkMedia(loverinkMediaE);
		        		getLoverinkMedia().start();
			        	// TODO ここにどくんどくん用メソッド入れる。
		        		loverinkCount=0;
	        		}
	        	}
	        }
        }
        return true;
    }
    
    private boolean checkCommuneChangeFlg(boolean flg) {
    	boolean ret = flg;
    	
		if (isLoverinkMedia(getLoverinkMedia())) {
			getLoverinkMedia().stop();
		}
    	if (ret != true) {
    		for(int i=0 ; i < communeChangeFlg.length ; i++) {
    			communeChangeFlg[i] = false;
    		}
    		ret = false;
    	}
    	return ret;
    }
    
    private void setLoverinkMedia(MediaPlayer m) {
    	loverinkMedia = m;
    }
    
    private MediaPlayer getLoverinkMedia() {
    	return loverinkMedia;
    }
    
    private boolean isLoverinkMedia(MediaPlayer m) {
    	return m.isPlaying();
    }

}
