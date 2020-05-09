package com.example.another_falppybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    private Bitmap background;
    private Bitmap[] bird;
    private Bitmap topTube, bottomTube;
    public BitmapBank(Resources res) {
        this.background = BitmapFactory.decodeResource(res, R.drawable.bk1);
        bird = new Bitmap[2];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.bee_up_40);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.bee_down_40);
        this.topTube = BitmapFactory.decodeResource(res, R.drawable.top_tube);
        this.bottomTube = BitmapFactory.decodeResource(res, R.drawable.bottom_tube);
    }

    public Bitmap getBird(int frame) {
        return bird[frame];
    }

    public int getBirdWidth()
    {
        return bird[0].getWidth();
    }

    public int getBirdHeight()
    {
        return bird[0].getHeight();
    }

    public Bitmap getBackground()
    {
        return this.background;
    }

    public int getBackgroundWidth()
    {
        return this.background.getWidth();
    }

    public int getBackgroundHeight()
    {
        return this.background.getHeight();
    }

    public Bitmap getTopTube() {
        return topTube;
    }

    public int getTopTubeWidth()
    {
        return this.topTube.getWidth();
    }

    public int getTopTubeHeight()
    {
        return this.topTube.getHeight();
    }

    public Bitmap getBottomTube() {
        return bottomTube;
    }
}
