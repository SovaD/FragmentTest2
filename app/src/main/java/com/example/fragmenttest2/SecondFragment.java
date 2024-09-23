package com.example.fragmenttest2;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class SecondFragment extends Fragment {

    MediaPlayer mediaPlayer;
    ImageButton imageButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_second, container, false);

       imageButton = view.findViewById(R.id.btndog);
       mediaPlayer = MediaPlayer.create(getContext(),R.raw.dog_bark);

       imageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (mediaPlayer.isPlaying()){
                   mediaPlayer.pause();
                   mediaPlayer.seekTo(0);
               }
               else {
                   mediaPlayer.start();
                   mediaPlayer.setLooping(true);
               }
           }
       });
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}