package com.example.myapplicationnewmix;

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

import static com.example.myapplicationnewmix.R.id.btn_pause;


public class MainActivity extends Activity implements View.OnClickListener{

    Button play, pause, stop;
    MediaPlayer mediaPlay;
    int pausecurrentepositin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play= (Button) findViewById(R.id.btn_play);
        pause= (Button) findViewById(R.id.btn_pause);
        stop= (Button) findViewById(R.id.btn_stop);


        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_play:
                if(mediaPlay==null){
                mediaPlay=MediaPlayer.create(getApplicationContext(),R.raw.music);
                mediaPlay.start();}

                else if(!mediaPlay.isPlaying()){
                    mediaPlay.seekTo(pausecurrentepositin);
                    mediaPlay.start();
                }

                break;

            case R.id.btn_pause:
                if (mediaPlay!=null){
                    mediaPlay.pause();
                    pausecurrentepositin=mediaPlay.getCurrentPosition();

                }

                break;

            case R.id.btn_stop:
                if(mediaPlay!=null){
                    mediaPlay.stop();
                    mediaPlay = null;
                }

                break;


        }

    }
}
