package com.example.another_falppybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameMenu extends AppCompatActivity {

    TextView etScore, etHighScore;
    String score;
    DBHelper dbHelper;
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHelper.closeDB();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        etScore = (TextView) findViewById(R.id.etScore);
        etHighScore = (TextView) findViewById(R.id.etHighScore);
        dbHelper = new DBHelper(this);
        dbHelper.openDB();
        Intent intent = getIntent();
        score = intent.getStringExtra("SCORE");
        if (score != null) {
            etScore.setText(score);
            etHighScore.setText(score);
        }
        addScore();
        getHighScore();
    }

    public void rePlay(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void addScore()
    {
        long insert = dbHelper.Insert(Integer.parseInt(score));
    }

    public void getHighScore()
    {
        Cursor cursor = dbHelper.getHighScore();
        if (cursor.moveToFirst())
        {
            etHighScore.setText(cursor.getString(0));
        }
    }
}
