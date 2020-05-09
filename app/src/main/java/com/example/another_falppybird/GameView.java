package com.example.another_falppybird;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;
    long timeEnd;
    boolean gameOver;
    public GameView(Context context) {
        super(context);
        initView();

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (!gameThread.isRunning())
        {
            gameThread = new GameThread(holder);
            gameThread.start();
        } else {
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (gameThread.isRunning())
        {
            gameThread.setIsRunning(false);
            boolean retry = true;
            while (retry)
            {
                try {
                    gameThread.join();
                    retry = false;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private void initView()
    {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
        gameOver = false;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN)
        {
            AppConstants.getGameEngine().gameState = 1;
            AppConstants.getGameEngine().bird.setVelocity(AppConstants.VELOCITY_WHEN_JUMP);
             if (gameThread.isCol())
            {
                gameOver = true;
                AppConstants.getGameEngine().gameState = 2;
                update();

            } else {
                Toast.makeText(getContext(), String.valueOf(AppConstants.getGameEngine().getScore()), Toast.LENGTH_SHORT).show();
            }

        }
        return true;
    }

    public void update()
    {
        if (gameThread.isCol())
        {
            AppConstants.reset(getContext(), AppConstants.getGameEngine().getScore());
        }
    }


}