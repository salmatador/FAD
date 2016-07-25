package com.moonstub.kline.micah.fad;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Micah on 7/22/2016.
 */
public class GameIO {

    public static GameIO sMGameIO = null;
    private final Game mFad;

    public GameIO(Game fad){
        mFad = fad;
        sMGameIO = this;
    }

    public Bitmap loadImage(String fileName){

        AssetManager assetManager = mFad.getAssets();
        Bitmap temp = null;
        InputStream is = null;

        try {

            is = assetManager.open(fileName);
            temp = BitmapFactory.decodeStream(is);

        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }

        return temp;

    }


}
