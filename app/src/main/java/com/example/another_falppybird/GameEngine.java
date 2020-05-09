package com.example.another_falppybird;

import android.graphics.Canvas;

import java.util.ArrayList;

public class GameEngine {
    BackgroundImage backgroundImage;
    Bird bird;
    Score scorePaint;
    ArrayList<Tube> tubes;
    Tube tube, tubeOne;
    int numberOfTubes;
    static int gameState;
    long timeEnd;
    private int score;

    public GameEngine()
    {
        backgroundImage =  new BackgroundImage();
        bird = new Bird();
        tube = new Tube();
        scorePaint = new Score();
        //setTubes();
        gameState = 0;
        numberOfTubes = 2;
        score = 0;
    }

    public void updateAndDrawBackgroundImage(Canvas canvas)
    {
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getX(), null);

    }

    public void drawBird(Canvas canvas)
    {
        if (gameState == 1) {
            if (bird.getBirdY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight()*2) || bird.getVelocity() < 0) {
                bird.setVelocity(bird.getVelocity() + AppConstants.gravity);
                bird.setBirdY(bird.getBirdY() + bird.getVelocity());
            }
        }
        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getBird(currentFrame), bird.getBirdX(), bird.getBirdY(), null );
        currentFrame++;
        if (currentFrame > bird.getMaxFrame())
        {
            currentFrame = 0;
        }
        bird.setCurrentFrame(currentFrame);
        if (gameState == 2)
        {
            bird.setVelocity(0);
        }
    }

    public void drawTube(Canvas canvas)
    {
        if (gameState == 1)
        {
                tube.setTubeX(tube.getTubeX() - tube.getTubeVelocity());
                tube.makeRandomDisplay();
                canvas.drawBitmap(AppConstants.getBitmapBank().getTopTube(), tube.getTubeX(), tube.getTopTubeY() - AppConstants.getBitmapBank().getTopTubeHeight(), null);
                canvas.drawBitmap(AppConstants.getBitmapBank().getBottomTube(), tube.getTubeX(), tube.getTopTubeY() + tube.getGap(), null);
        }
        if (gameState == 2)
        {
            tube.setTubeVelocity(0);
            tube.setTubeX(AppConstants.SCREEN_WIDTH);
        }

    }

    public void drawScore(Canvas canvas)
    {
       if (gameState == 1)
       {
           canvas.drawText(score + "", AppConstants.SCREEN_WIDTH/2, 200, scorePaint.getPaint());
       }
    }

    public boolean isCollision()
    {
        int left_a =  bird.getBirdX();
        int right_a = AppConstants.getBitmapBank().getBirdWidth() + left_a;
        int top_a = bird.getBirdY();
        int bottom_a = AppConstants.getBitmapBank().getBirdHeight() + top_a;

        int left_b = tube.getTubeX();
        int right_b = AppConstants.getBitmapBank().getTopTubeWidth() + left_b;
        int top_b = tube.getTopTubeY();
        int bottom_b = tube.getGap() + top_b;

        if (left_a > left_b && right_a < right_b)
        {
            if (top_a < top_b && bottom_a > bottom_b)
            {
                return true;
            }
        }

        if (top_a  > bottom_b)
        {
            if (left_a > left_b && right_a < right_b)
            {
                return true;
            }
        }

        if (bottom_a < top_b)
        {
            if (left_a < left_b && right_a > left_b)
            {
                return true;
            }
        }
        if (left_a < right_b && right_a > right_b)
        {
            if (top_a < top_b || bottom_a > bottom_b)
            {
                return true;
            }
        }
        if (left_a < left_b && right_a > left_b)
        {
            if (top_a < top_b || bottom_a > bottom_b)
            {
                return true;
            }
        }
        return false;
    }

    public void countScore()
    {
        int left_a =  bird.getBirdX();
        int right_a = AppConstants.getBitmapBank().getBirdWidth() + left_a;
        int top_a = bird.getBirdY();
        int bottom_a = AppConstants.getBitmapBank().getBirdHeight() + top_a;

        int left_b = tube.getTubeX();
        int right_b = AppConstants.getBitmapBank().getTopTubeWidth() + left_b;
        int top_b = tube.getTopTubeY();
        int bottom_b = tube.getGap() + top_b;

        if (right_b == right_a + 1)
        {
            score++;
        }

    }

    public int getScore() {
        return score;
    }


}
