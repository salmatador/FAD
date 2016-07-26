package com.moonstub.kline.micah.fad;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Micah on 7/24/2016.
 */
public class GameBoard {

    GameSurface mBoardSurface;
    Random mRndColor;

    ArrayList<GameObject> mGameObjects = Game.sGameObjects;
    GameObject mObject = Game.sCurrentGameObject;

    public GameBoard(){
        mRndColor = new Random();
    }

    public void setupBoard(Point p) {
        mBoardSurface = new GameSurface(p);

        //Temporary Grid creation to test Input Handling
        int TILE_X = p.x / 5;//200;
        int TILE_Y = p.y / 9;//200;
        for(int y = 0; y < 9; y++){
            for(int x = 0; x< 5; x++){
                addObjects(new GameObject(new Rect(
                        (x*TILE_X),
                        (y*TILE_Y),
                        (x*TILE_X) + TILE_X,
                        (y * TILE_Y + TILE_Y))));
            }
        }
    }

    public void addObjects(GameObject object){
        mGameObjects.add(object);
    }

    public void renderBoard(GameSurface sceneSurface){
        sceneSurface.drawSurface(mBoardSurface);
    }

    public void draw(){
        for(GameObject obj : mGameObjects){
            obj.draw(mBoardSurface);
        }
        if(Game.sCurrentGameObject != null) {
            Game.sCurrentGameObject.setColor(Color.rgb(mRndColor.nextInt(255),mRndColor.nextInt(255),mRndColor.nextInt(255)));
            Game.sCurrentGameObject.draw(mBoardSurface);
        }
    }

    public void update(float delta){

    }
}
