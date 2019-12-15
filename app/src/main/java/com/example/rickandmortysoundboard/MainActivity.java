package com.example.rickandmortysoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playLickMyBalls = this.findViewById(R.id.lickMyBalls);
        Button playWubbaLubbaDubDub = this.findViewById(R.id.wubbaLubbaDubDub);

        playLickMyBalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(getApplicationContext(), R.raw.lick_my_balls);
            }
        });

        playWubbaLubbaDubDub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(getApplicationContext(), R.raw.woo_vu_luvub_dub_dub);
            }
        });
    }

    /**
     * Stop old sound and start new one
     * @param context context of the media player
     * @param resource sound resource
     */
    public static void play(Context context, int resource)
    {
        stop(context);

        mp = MediaPlayer.create(context, resource);
        mp.setLooping(false);
        mp.start();
    }

    /**
     * Stop the music
     * @param context Context of the media player
     */
    public static void stop(Context context)
    {
        if (mp != null)
        {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
