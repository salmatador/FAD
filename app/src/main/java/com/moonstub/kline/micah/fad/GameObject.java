package com.moonstub.kline.micah.fad;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

/**
 * Created by Micah on 7/22/2016.
 */
public class GameObject implements View.OnTouchListener{
    private final Rect mRect;
    private GameImage mImage;
    public float left;
    public float top;
    private boolean mActive;
    private int mColor;
    private TestTracker mTracker = new TestTracker();
    private RectF mTouchRect = null;


    public GameObject(GameImage gameImage, Rect bounds){
        mImage = gameImage;
        mRect = bounds;
        setDefaults();
    }

    public GameObject(Rect bounds){
        mImage = null;
        mRect = bounds;
        setDefaults();
    }

    private void setDefaults() {
        mColor = Color.WHITE;
        top = mRect.top;
        left = mRect.left;
        //
    }

    public void loadImage(GameImage image){
        mImage = image;
    }

    public Rect getBounds(){
        return mRect;
    }

    public GameImage getImage(){
        return mImage;
    }

    public Bitmap getBitmap() {
        return mImage.getImage();
    }

    public void update(float delta){

    }

    public void draw(GameSurface surface){
        if(mImage != null) {
            surface.drawImage(this);
        }
        drawBounds(surface);
        drawTouch(surface);
    }

    private void drawTouch(GameSurface surface) {
        if(mActive){
            surface.drawCircle(mTouchRect, Color.GREEN);
        }
    }

    private void drawBounds(GameSurface surface) {
        if(mActive){
            surface.drawRect(getBounds(), mColor);
        } else {
            surface.drawRect(getBounds(), Color.WHITE);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //mTracker.Count();
        //mTracker.LogEvent(event);
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case ACTION_DOWN:
                if (getBounds().contains((int) x, (int) y)) {
                    setActive(true);
                    return true;
                } else {
                    return false;
                }
            case ACTION_UP:
                setActive(false);
               // mTracker.DisplayLog();
            default:
                return false;
        }

    }

    public void setActive(boolean active) {
        mActive = active;
    }

    public void setColor(int color){
        mColor = color;
    }

    public void processEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        mTouchRect = new RectF(x-50,y-50,x+100,y+100);
    }
}
