package com.example.tictactoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btnplay);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openModes();
            }
        });
        Button quit=findViewById(R.id.btnquit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });
    }
    public void openModes(){
        Intent intent = new Intent(this,Buffer.class);
        startActivity(intent);
    }
}