package com.example.tictactoes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class versusCPU extends AppCompatActivity implements View.OnClickListener {

    private TextView p1s,cs,res;
    private Button[] btn = new Button[9];
    private int p1sc,csc,turns;
    boolean playerChance,repeat;

    int gameState [] = {2,2,2,2,2,2,2,2,2};
    ArrayList <Integer> checkGameState = new ArrayList<Integer>();


    int [][] winCond = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versus_cpu);
        p1s = (TextView) findViewById(R.id.cplayerOneScore);
        cs = (TextView) findViewById(R.id.cCpuScore);
        res = (TextView) findViewById(R.id.cresult);
        System.out.println("Reached before for loop");

        for(int i=0;i<btn.length;i++){
            String btnID = "btn"+i;
            int resourceID = getResources().getIdentifier(btnID,"id",getPackageName());
            btn[i]=(Button)findViewById(resourceID);
            btn[i].setOnClickListener(this);
        }

        turns=0;
        p1sc=0;
        csc=0;
        playerChance =true;


    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        String btnID= v.getResources().getResourceEntryName(v.getId());
        int position=Integer.parseInt(btnID.substring(btnID.length()-1, btnID.length())) ;
        if(playerChance){
                ((Button) v).setText("X");
            System.out.println(gameState);
                ((Button) v).setTextColor(Color.parseColor("#48B618"));
                gameState[position] = 0;
                Random random = new Random();
                for(int i=0;i<9;i++){
                    if(gameState[i]==2){
                        checkGameState.add(i);
                        System.out.println(gameState);
                    }
                }
                int b= getRandom(checkGameState);
                int s = getResources().getIdentifier("btn"+b, "id", getPackageName());
                Button c = findViewById(s);
                c.setText("O");
                c.setTextColor(Color.parseColor("#FFFFFFFF"));
                gameState[b] = 1;
                turns++;
                System.out.println(gameState);



        }


        if (refree()){
            if(playerChance){
                p1sc++;
                update();
                Toast.makeText(this,"Player 1 won!",Toast.LENGTH_SHORT).show();
                res.setText("Player 1 Wins!");
                playAgain();
            }else{
                csc++;
                update();
                Toast.makeText(this,"Player 2 won!",Toast.LENGTH_SHORT).show();
                res.setText("Player 2 Wins!");
                playAgain();
            }

        }else if(turns==9){
            Toast.makeText(this,"DRAW",Toast.LENGTH_SHORT).show();
            res.setText("DRAW!");
            playAgain();

        }else{
          //  playerChance=!playerChance;
        }

    }
    public boolean refree(){
        boolean result=false;
        for(int [] pos: winCond){
            if(gameState[pos[0]]==gameState[pos[1]]&&
                    gameState[pos[1]]==gameState[pos[2]] && gameState[pos[0]] !=2) {
                result = true;
            }

        }
        return result;
    }
    public void update(){
        p1s.setText(Integer.toString(p1sc));
        cs.setText(Integer.toString(csc));
    }

    public void playAgain(){
        turns=0;
        playerChance=true;
        res.setText("     ");

        for(int i=0;i<btn.length;i++){
            gameState[i]=2;
            btn[i].setText("");
        }
    }

    public static int getRandom(ArrayList<Integer> a ){
        int rnd = new Random().nextInt(a.size());
        int b = a.get(rnd);
        return b;
    }

}
