package com.moonstub.kline.micah.fad;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.HashMap;

/**
 * Created by Micah on 7/24/2016.
 */
public class GameScreen {

    private final Game mGame;
    private final GameSurface mGameSurface;

    private GameScene mCurrentScene;
    private HashMap<String, GameScene> mSceneMap;

    public GameScreen(Game game, GameSurface gameSurface) {
        mGame = game;
        mGameSurface = gameSurface;
        mSceneMap = new HashMap<>();
        initScenes();
    }

    public void initScenes(){
        addScene("TAG", new GameScene(this, getScreenSize()));

        setGameScene("TAG");
    }

    private void addScene(String tag, GameScene gameScene) {
        mSceneMap.put(tag, gameScene);
    }

    public Bitmap renderSurfaces(){
        getCurrentScene().renderScene(getGameSurface());
        return mGameSurface.getSurface();
    }

    public void update(float delta) {
        getCurrentScene().update(delta);
    }

    public void draw() {
        getCurrentScene().draw();
    }

    public Game getGame() {
        return mGame;
    }

    public GameSurface getGameSurface() {
        return mGameSurface;
    }

    public void setGameScene(String tag){
        mCurrentScene = mSceneMap.get(tag);
    }

    public GameScene getCurrentScene() {
        return mCurrentScene;
    }

    public Point getScreenSize() {
        return mGame.mGameScreenSize;
    }

}
