package com.example.another_falppybird;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

public class Score extends Paint {
    private Paint paint;
    static int FONT_SIZE = 120;
    public Score() {
        this.paint = new Paint();
        this.paint.setTextSize(FONT_SIZE);
        this.paint.setColor(Color.WHITE);
        this.paint.setTypeface(AppConstants.font);
    }

    public Paint getPaint() {
        return this.paint;
    }
}
