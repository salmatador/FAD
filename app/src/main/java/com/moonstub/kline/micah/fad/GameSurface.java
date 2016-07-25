package com.moonstub.kline.micah.fad;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Micah on 7/22/2016.
 */
public class GameSurface {

    Point mSize;
    Rect mBounds;
    Bitmap mSurface;
    Canvas mCanvas;
    Paint mPaint;
    private int x = 0;
    private int y = 0;
    //long mTimer - seperate object;

    public GameSurface(Point size){
        mSize = size;
        setBounds();
        createBitmapSurface();
        setDefaults();

    }

    private void setDefaults() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10.0f);
        mPaint.setTextSize(42f);
    }

    private void createBitmapSurface() {
        mSurface = Bitmap.createBitmap(mBounds.width(),mBounds.height(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mSurface);
    }

    private Rect setBounds() {
        mBounds = new Rect(x,y,mSize.x,mSize.y);
        return mBounds;
    }

//    public void render(GameSurface topRender){
//        bottomRender.drawSurface(this);
//    }

    public void drawSurface(GameSurface gameSurface) {
        getCanvas().drawBitmap(gameSurface.getSurface(), null, getBounds(), getPaint());
    }

    public void drawImage(GameObject gameObject){
        Bitmap temp = gameObject.getBitmap();
        getCanvas().drawBitmap(temp,gameObject.left, gameObject.top, getPaint());
    }
    public void drawRect(Rect bounds){
        getCanvas().drawRect(bounds, getPaint());
    }
    public void drawScaledImage(){}
    public void drawLine(){}
    public void drawText(){}
    public void drawCircle(){}

    public Rect getBounds() {
        return mBounds;
    }

    public Canvas getCanvas() {
        return mCanvas;
    }

    public Bitmap getSurface() {
        return mSurface;
    }

    public Paint getPaint() {
        return mPaint;
    }

    public void drawRect(Rect bounds, int color) {
        getPaint().setColor(color);
        drawRect(bounds);
    }
}
