package com.example.rickandmortysoundboard;

import androidx.appcompat.app.AppCompatActivity;
import models.ButtonResource;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static MediaPlayer mp;

    private ButtonResource[] sounds = {
            new ButtonResource(R.id.lickMyBalls, "lick_my_balls.mp3"),
            new ButtonResource(R.id.wubbaLubbaDubDub, "woo_vu_luvub_dub_dub.wav"),
            new ButtonResource(R.id.getSchwifty, "get_schwifty_in_here.wav"),
            new ButtonResource(R.id.mrPoopybutthole, "mr_poopybutwhole.mp3"),
            new ButtonResource(R.id.riggityWrecked, "riggity_wrecked.wav"),
            new ButtonResource(R.id.tinyRick, "tiny_rick.wav")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (ButtonResource sound : sounds) {
            final String resource = sound.getResource();
            Button soundButton = this.findViewById(sound.getId());
            soundButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    play(getApplicationContext(), resource);
                }
            });
        }
    }

    /**
     * Stop old sound and start new one
     * @param context context of the media player
     * @param resource sound resource
     */
    public void play(Context context, String resource)
    {
        // stop any media before trying to play another one
        stop(context);
        AssetFileDescriptor afd;
        try {
            mp = new MediaPlayer();
            afd = getAssets().openFd(resource);
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mp.prepare();
            mp.start();
        } catch(IOException e) {
            e.printStackTrace();
        }

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
