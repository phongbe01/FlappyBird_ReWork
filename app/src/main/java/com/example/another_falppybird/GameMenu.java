package com.example.another_falppybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameMenu extends AppCompatActivity {

    TextView etScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        etScore = (TextView) findViewById(R.id.etScore);
        setContentView(R.layout.activity_game_menu);
        Intent intent = getIntent();
        String score = intent.getStringExtra("SCORE");

        if (score != null) {
           // etScore.setText(score);
            Toast.makeText(this, score, Toast.LENGTH_SHORT).show();
        }
    }

    public void rePlay(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
