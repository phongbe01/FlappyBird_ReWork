package com.example.another_falppybird;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;


public class Sound  {
    private SoundPool soundPool;
    private int  hit, point, wing;

    public Sound(Context context)
    {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
                        .setMaxStreams(3)
                        .setAudioAttributes(audioAttributes)
                        .build();
            hit = soundPool.load(context, R.raw.sfx_hit, 1);
            point = soundPool.load(context, R.raw.sfx_point, 1);
            wing = soundPool.load(context, R.raw.sfx_wing, 1);
    }

    public void getSoundWing()
    {
        soundPool.play(wing, 1, 1, 0, 0, 1);
    }

    public void getSoundHit()
    {
        soundPool.play(hit, 1, 1, 0, 0, 1);
    }

    public void getSoundPoint()
    {
        soundPool.play(point, 1, 1, 0, 0, 1);
    }
}
