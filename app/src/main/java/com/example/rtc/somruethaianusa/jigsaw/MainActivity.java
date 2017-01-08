package com.example.rtc.somruethaianusa.jigsaw;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        player = MediaPlayer.create(getApplicationContext(), R.raw.effect_btn_long);
        player.setLooping(true);
        player.start();
    }

    public void easyClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), EasyActivity.class);
        startActivity(intent);
    }

    public void mediumClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), medium_mode.class);
        startActivity(intent);
    }

    public void hardClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), hard_mode.class);
        startActivity(intent);
    }
    protected void onDestroy(){
        super .onDestroy();
        player.stop();
    }
}