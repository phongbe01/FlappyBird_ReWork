package com.example.another_falppybird;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Toast;

class GameThread extends Thread {
    SurfaceHolder surfaceHolder;
    boolean isRunning, is_col;
    long startTime, loopTime;
    long DELAY = 30;
    Context context;
    public GameThread(SurfaceHolder surfaceHolder, Context context)
    {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
        is_col = false;
        this.context = context;
    }

    @Override
    public void run() {
        //looping until the boolean is false
        while (isRunning){
            startTime = SystemClock.uptimeMillis();
            //locking the canvas
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null)
            {
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().drawTube(canvas);
                    AppConstants.getGameEngine().drawBird(canvas);
                    AppConstants.getGameEngine().countScore();
                    AppConstants.getGameEngine().drawScore(canvas);
                    if (AppConstants.getGameEngine().isCollision())
                    {
                        is_col = true;
                        AppConstants.getGameEngine().gameState = 2;
                        AppConstants.sound.getSoundHit();
                        int score =  AppConstants.getGameEngine().getScore();
                        AppConstants.reset(context, score);
                    }
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            //loop time
            loopTime = SystemClock.uptimeMillis() - startTime;
            //pause here to make sure we update the right amount per seconds
            if (loopTime < DELAY)
            {
                try {
                    Thread.sleep(DELAY - loopTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.i("error","loi");
                    isRunning = false;
                }
            }
        }
    }

    //return whether the thread is running
    public boolean isRunning() {
        return isRunning;
    }

    //set the thread state, false = stopped, true = running
    public void setIsRunning(boolean state)
    {
        isRunning = state;
    }

    public boolean isCol()
    {
        return is_col;
    }


}
