package com.example.another_falppybird;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    ImageView imageView;
    EditText highScore;
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
        setContentView(R.layout.activity_main);
        AppConstants.initialization(this.getApplicationContext());
        imageView = (ImageView) findViewById(R.id.iv_background);
        highScore = (EditText) findViewById(R.id.edScore);
        dbHelper = new DBHelper(this);
        dbHelper.openDB();
        Cursor cursor = dbHelper.getHighScore();
        if (cursor.moveToFirst())
        {
            int count = cursor.getCount();
            Log.i("setDefault: count", cursor.getString(0));
            highScore.setText(cursor.getString(0));
        }

        //setDefault();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }



    public void getHighScore()
    {

    }

    public void setDefault()
    {
        Cursor cursor = dbHelper.getHighScore();
//        highScore.setText(cursor.getString(cursor.getColumnIndex(DBHelper.getSCORE())));
        int count = cursor.getCount();
        Log.i("setDefault: error", String.valueOf(count));

    }
}
