package com.example.tictactoes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buffer extends AppCompatActivity {

    private Button sbtn,mbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer);
        sbtn=(Button)findViewById(R.id.sButton);
        sbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openCPUGame();
            }
        });

        mbtn=(Button)findViewById(R.id.mButton);
        mbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGame();
            }
        });
    }
    public void openGame(){
        Intent intent = new Intent(this,Game.class);
        startActivity(intent);
    }

    public void openCPUGame(){
        Intent intent = new Intent(this,versusCPU.class);
        startActivity(intent);
    }
}