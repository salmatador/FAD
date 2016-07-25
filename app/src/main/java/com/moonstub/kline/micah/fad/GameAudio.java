package com.moonstub.kline.micah.fad;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.ArrayList;

/**
 * Created by mkline on 7/25/2016.
 */
public class GameAudio {

    MediaPlayer mMediaPlayer = null;
    Game mGame;
    SoundPool mSoundPool;

    int mSoundId[] = new int[10];

    public GameAudio(Game game) {
        mGame = game;
        //mSoundEffectsList = new ArrayList<>();
        AudioAttributes attrs = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setMaxStreams(10)
                .setAudioAttributes(attrs)
                .build();
    }

    public void loadAudio(int[] files){
        for(int i = 0; i< files.length; i++) {
            mSoundId[i] = mSoundPool.load(mGame, files[i], 1);
        }
    }

    public void play(AudioAsset asset){

    }
}
