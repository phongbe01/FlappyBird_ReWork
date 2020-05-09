package com.example.another_falppybird;

import android.graphics.Bitmap;

public class BackgroundImage {

    private int backgroundimageX, getBackgroundimageY, getBackgroundimageVelocity;
    public BackgroundImage()
    {
        this.backgroundimageX = 0;
        this.getBackgroundimageY = 0;
        this.getBackgroundimageVelocity = 3;
    }

    public int getX() {
        return backgroundimageX;
    }

    public int getY() {
        return getBackgroundimageY;
    }

    public int getGetBackgroundimageVelocity() {
        return getBackgroundimageVelocity;
    }

    public void setX(int backgroundimageX) {
        this.backgroundimageX = backgroundimageX + 100;
    }

    public void setY(int getBackgroundimageY) {
        this.getBackgroundimageY = getBackgroundimageY;
    }

    public void setGetBackgroundimageVelocity(int getBackgroundimageVelocity) {
        this.getBackgroundimageVelocity = getBackgroundimageVelocity;
    }


}
