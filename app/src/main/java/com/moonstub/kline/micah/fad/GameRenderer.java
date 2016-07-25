package com.moonstub.kline.micah.fad;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Micah on 7/24/2016.
 */
public class GameRenderer extends SurfaceView implements Runnable{

    Game mGame;
    boolean isRunning;
    Thread mRenderThread;
    SurfaceHolder mHolder;

    public GameRenderer(Game game) {
        super(game);
        mGame = game;
        mHolder = getHolder();
    }

    public void start(){
        if(!isRunning){
            isRunning = true;
            mRenderThread = new Thread(this);
            mRenderThread.start();
        }
    }

    public void join(){
        if(isRunning){
            try {
                mRenderThread.join();
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public void run() {
        Rect r = new Rect();
        Thread currentThread = Thread.currentThread();
        //Implement Delta
        while (isRunning && mRenderThread == currentThread){
            if(!mHolder.getSurface().isValid()){continue;}

            mGame.getScreen().update(0.0f);

            mGame.getScreen().draw();

            Bitmap b = mGame.getScreen().renderSurfaces();

            Canvas c = mHolder.lockCanvas();
            c.getClipBounds(r);
            c.drawColor(Color.BLACK);
            c.drawBitmap(b,null,r,new Paint());

            mHolder.unlockCanvasAndPost(c);

        }
    }
}
