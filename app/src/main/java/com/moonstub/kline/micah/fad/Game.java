package com.moonstub.kline.micah.fad;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    GameIO mGameIo;
    GameSurface mGameSurface;
    Point mGameScreenSize = new Point();
    GameScreen mGameScreen;
    TestTracker mTracker = new TestTracker();
    public static ArrayList<GameObject> sGameObjects = new ArrayList<>();
    public static GameObject sCurrentGameObject = null;
    private GameRenderer mGameRenderer;
    private GameTouch mGameTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameScreenSize = getGameScreenSize();
        mGameIo = new GameIO(this);

        mGameSurface = new GameSurface(mGameScreenSize);
        mGameScreen = new GameScreen(this, mGameSurface);

        mGameRenderer = new GameRenderer(this);
        mGameTouch = new GameTouch(this, mGameRenderer);

        setContentView(mGameRenderer);
    }

    @Override
    protected void onStart(){
        mGameRenderer.start();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGameRenderer.join();
        super.onStop();
    }

    public Point getGameScreenSize() {
        WindowManager manager = getWindowManager();
        manager.getDefaultDisplay().getRealSize(mGameScreenSize);
        return mGameScreenSize;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        mTracker.Count();
//        mTracker.LogEvent(event);

        return super.onTouchEvent(event);
    }

    public void sendToGameObject(MotionEvent event) {
        if(sCurrentGameObject != null) {
            sCurrentGameObject.processEvent(event);
        }
    }

    public void detachGameObject(MotionEvent event) {
        if(sCurrentGameObject != null){
            sCurrentGameObject.processEvent(event);
            sCurrentGameObject.setActive(false);
            sCurrentGameObject = null;
        }
    }

    public boolean attachGameObject(MotionEvent event) {
        for(GameObject obj : sGameObjects){
            if(obj.getBounds().contains((int)event.getX(), (int)event.getY())){
                sCurrentGameObject = obj;
                sCurrentGameObject.setActive(true);
                sCurrentGameObject.setColor(Color.GREEN);
                sCurrentGameObject.processEvent(event);
                return true;
            }
        }
        return false;
    }

    public GameScreen getScreen() {
        return mGameScreen;
    }
}
