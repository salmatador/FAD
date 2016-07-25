package com.moonstub.kline.micah.fad;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Created by Micah on 7/22/2016.
 */
public class GameImage {

    private final String mFileName;
    private Bitmap mImage;

    public GameImage(String fileName){
        mFileName = fileName;
    }

    public void load(){
        GameIO fad = GameIO.sMGameIO;
        mImage = fad.loadImage(mFileName);
    }

    public Bitmap getImage() {
        return mImage;
    }

    public Rect getBounds(){
        return new Rect(0,0,mImage.getWidth(),mImage.getHeight());
    }
}
