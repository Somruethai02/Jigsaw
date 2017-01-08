package com.example.rtc.somruethaianusa.jigsaw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;

public class medium_mode extends AppCompatActivity {

    private ArrayList<Integer> randomSmallJigsawPic = new ArrayList<Integer>();
    private ArrayList<Integer> ANS;
    private Integer resource;
    private ArrayList<Integer> BtBigJigsaw_arr = new ArrayList<Integer>();
    private ArrayList<Integer> BtSmallJigsaw_arr =new ArrayList<Integer>();
    private int counter = 0;
    private int numberJigsaw = 8;
    private ImageButton BigJigsaw[] = new ImageButton[numberJigsaw];
    private ImageButton SmallJigsaw[] = new ImageButton[numberJigsaw];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_mode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        BtBigJigsaw_arr.add(R.id.BtBigJigsaw1_id);
        BtBigJigsaw_arr.add(R.id.BtBigJigsaw2_id);
        BtBigJigsaw_arr.add(R.id.BtBigJigsaw3_id);
        BtBigJigsaw_arr.add(R.id.BtBigJigsaw4_id);


        for (int i = 0; i < BtBigJigsaw_arr.size(); i++) {
            BigJigsaw[i] = (ImageButton) findViewById(BtBigJigsaw_arr.get(i));
            BigJigsaw[i].setTag(R.drawable.www);
        }
        randomSmallJigsawPic.add(R.drawable.image_001);
        randomSmallJigsawPic.add(R.drawable.image_002);
        randomSmallJigsawPic.add(R.drawable.image_003);
        randomSmallJigsawPic.add(R.drawable.image_004);

        ANS = new ArrayList<Integer>(randomSmallJigsawPic);

        Collections.shuffle(randomSmallJigsawPic);

        BtSmallJigsaw_arr.add(R.id.BtSmallJigsaw1_id);
        BtSmallJigsaw_arr.add(R.id.BtSmallJigsaw2_id);
        BtSmallJigsaw_arr.add(R.id.BtSmallJigsaw3_id);
        BtSmallJigsaw_arr.add(R.id.BtSmallJigsaw4_id);

        for (int i = 0; i < BtSmallJigsaw_arr.size(); i++) {
            SmallJigsaw[i] = (ImageButton) findViewById(BtSmallJigsaw_arr.get(i));
            SmallJigsaw[i].setImageResource(randomSmallJigsawPic.get(0));
            SmallJigsaw[i].setTag(randomSmallJigsawPic.remove(0));
        }
    }
    public void SmallJigsawClicked(View v) {
        ImageButton b = (ImageButton) v;
        resource = (Integer) b.getTag();
    }
    public void BigJigsawClick(View v) {
        ImageButton p = (ImageButton) v;
        p.setImageResource(resource);
        p.setTag(resource);
    }
    public void checkClicked(View v){
        for (int i = 0; i < BigJigsaw.length; i++){
            if ((int) BigJigsaw[i].getTag() == ANS.get(i)){
                counter++;
            }
        }
        if (counter == numberJigsaw){
            DialogBox("ถูกต้อง!!");
            counter = 0;
        }else {
            Toast.makeText(getApplicationContext(), "ผิด!!",Toast.LENGTH_SHORT).show();
            counter = 0;
        }
    }

    private void DialogBox(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("แจ้งเตือน");
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Exit",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("REPLAY", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
