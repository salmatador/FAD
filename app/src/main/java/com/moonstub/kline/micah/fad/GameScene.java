package com.moonstub.kline.micah.fad;

import android.graphics.Point;

/**
 * Created by Micah on 7/24/2016.
 */
public class GameScene {

    GameState mGameState;
    GameScreen mParent;
    GameSurface mSceneSurface;
    Point mScreenSize;

    GameBoard mGameBoard;


    public GameScene(GameScreen gameScreen, Point screenSize) {
        mParent = gameScreen;
        mScreenSize = screenSize;
        mGameBoard = new GameBoard();
        mSceneSurface = new GameSurface(mScreenSize);
        initScene();
    }

    public void initScene(){
        mGameBoard.setupBoard(mScreenSize);
    }

    public void renderScene(GameSurface screenSurface) {
        mGameBoard.renderBoard(screenSurface);
        screenSurface.drawSurface(mSceneSurface);
    }

    public void update(float delta) {
        mGameBoard.update(delta);
    }

    public void draw() {
        //update gameObjects and other items
        mGameBoard.draw();
    }
}
