package com.example.another_falppybird;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Score extends Paint {
    private Paint paint;
    static int FONT_SIZE = 120;
    public Score() {
        this.paint = new Paint();
        paint.setTextSize(FONT_SIZE);
        paint.setColor(Color.WHITE);
        Typeface typeface = paint.getTypeface();
        Typeface bold = Typeface.create(typeface, Typeface.BOLD);
        paint.setTypeface(bold);
    }

    public Paint getPaint() {
        return paint;
    }
}
