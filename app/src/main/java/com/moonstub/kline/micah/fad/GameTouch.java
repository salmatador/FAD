package com.moonstub.kline.micah.fad;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Micah on 7/24/2016.
 */
public class GameTouch implements View.OnTouchListener {
    Game mGame;
    GameRenderer mGameRenderer;
    public GameTouch(Game game, GameRenderer gameRenderer) {
        mGame = game;
        mGameRenderer = gameRenderer;
        gameRenderer.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("touch", event.toString());
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            return mGame.attachGameObject(event);
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            mGame.sendToGameObject(event);
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
//            mTracker.DisplayLog();
            mGame.detachGameObject(event);
        }
        return false;
    }
}
