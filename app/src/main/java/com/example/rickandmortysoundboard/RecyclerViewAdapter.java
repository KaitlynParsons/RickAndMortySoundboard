package com.example.rickandmortysoundboard;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import models.ButtonModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static MediaPlayer mp;
    private ArrayList<ButtonModel> buttons = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<ButtonModel> buttons, Context context) {
        this.buttons = buttons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_button, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.soundButton.setText(buttons.get(position).getName());
        holder.soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(context, buttons.get(position).getResource());
            }
        });
    }

    @Override
    public int getItemCount() {
        return buttons.size();
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
            afd = context.getAssets().openFd(resource);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button soundButton;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            soundButton = itemView.findViewById(R.id.button);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
