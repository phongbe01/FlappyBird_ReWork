package com.example.another_falppybird;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.Random;

class AppConstants {
    static BitmapBank bitmapBank; //Bitmap object reference
    static GameEngine gameEngine; // GameEngine object reference
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int VELOCITY_WHEN_JUMP;

    public static void initialization(Context context)
    {
        setScreenSize(context);
        bitmapBank = new BitmapBank(context.getResources());
        gameEngine = new GameEngine();
        AppConstants.gravity = 3;
        AppConstants.VELOCITY_WHEN_JUMP =-30;

    }

    public static  BitmapBank getBitmapBank()
    {
        return bitmapBank;
    }

    public static GameEngine getGameEngine() {
        return gameEngine;
    }

    public static void setScreenSize(Context context) {
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int heigth = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = heigth;
    }

    public static void reset(Context context, int score)
    {
        Intent intent = new Intent(context, GameMenu.class);
        intent.putExtra("SCORE", String.valueOf(score));
        context.startActivity(intent);

    }
}
