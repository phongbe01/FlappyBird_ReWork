package com.example.another_falppybird;

import java.util.Random;

public class Tube {
    private int gap,minTubeOffset, maxTubeOffset,tubeX, topTubeY, tubeVelocity, distance;
    private Random random;
    public Tube()
    {
        this.gap = 400;
        random = new Random();
        this.minTubeOffset = this.gap/2;
        this.maxTubeOffset = AppConstants.SCREEN_HEIGHT - this.minTubeOffset - this.gap;
        this.tubeX = AppConstants.SCREEN_WIDTH;
        this.topTubeY = this.minTubeOffset + random.nextInt(this.maxTubeOffset - this.minTubeOffset + 1);
        this.tubeVelocity = 15;
        this.distance = AppConstants.SCREEN_WIDTH * 3/4;
    }

    public int getMinTubeOffset() {
        return minTubeOffset;
    }

    public int getMaxTubeOffset() {
        return maxTubeOffset;
    }

    public int getTubeX() {
        return tubeX;
    }

    public int getTopTubeY() {
        return topTubeY;
    }

    public void setTubeX(int tubeX) {
        this.tubeX = tubeX;
    }

    public void setTopTubeY() {
        this.topTubeY = this.minTubeOffset + random.nextInt(this.maxTubeOffset - this.minTubeOffset + 1);
    }

    public int getGap() {
        return gap;
    }

    public int getTubeVelocity() {
        return tubeVelocity;
    }

    public int getDistance() {
        return distance;
    }

    public void setTubeVelocity(int tubeVelocity) {
        this.tubeVelocity = tubeVelocity;
    }

    public void makeRandomDisplay()
    {
        if (tubeX < -AppConstants.getBitmapBank().getTopTubeWidth() )
        {
            tubeX = AppConstants.SCREEN_WIDTH;
            this.topTubeY = this.minTubeOffset + random.nextInt(this.maxTubeOffset - this.minTubeOffset + 1);
        }
    }
}
