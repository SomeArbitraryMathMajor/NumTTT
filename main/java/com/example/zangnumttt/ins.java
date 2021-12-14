package com.example.zangnumttt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

// Name: Bryan Zang
// Date: March 23 2020
// Purpose: Unit 2 project: numerical tictactoe

public class ins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins);

    }

    //creating the game board
    int board[][] = new int[3][3];
    int turn = 1, sel = 0;//turn will be 1/2 deciding who goes
    //sel is the selection in each turn

    public void win() {
        int winner = 0;
        //idk why but 14 works as if it is 15 but 15 however works as 14
        if ((board[0][0] + board[0][1] + board[0][2] == 14) && board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0)//horizontal
            winner = turn;
        else if ((board[1][0] + board[1][1] + board[1][2] == 14) && board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0)
            winner = turn;
        else if ((board[2][0] + board[2][1] + board[2][2] == 14) && board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0)
            winner = turn;
        else if ((board[0][0] + board[1][0] + board[2][0] == 14) && board[0][0] != 0 && board[1][0] != 0 && board[2][0] != 0)//vertical
            winner = turn;
        else if ((board[0][1] + board[1][1] + board[2][1] == 14) && board[0][1] != 0 && board[1][1] != 0 && board[2][1] != 0)
            winner = turn;
        else if ((board[0][2] + board[1][2] + board[2][2] == 14) && board[0][2] != 0 && board[1][2] != 0 && board[2][2] != 0)
            winner = turn;
        else if ((board[0][0] + board[1][1] + board[2][2] == 14) && board[0][0] != 0 && board[1][1] != 0 && board[2][2] != 0)//diagonal
            winner = turn;
        else if ((board[2][0] + board[1][1] + board[0][2] == 14) && board[2][0] != 0 && board[1][1] != 0 && board[0][2] != 0)
            winner = turn;
        else if (board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0 && board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0 && board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0)
            winner = 3;

        //if red wins
        if (winner == 1) {
            //dialog box with pic
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("OK", null);

            ImageView i = new ImageView(this);
            i.setImageResource(R.drawable.winnerrr);
            builder.setView(i);

            builder.setTitle("Red Is The Winner !");
            builder.setMessage("You have shown yourself " +
                    "to be a mighty wizard. " +
                    "If you want to rematch simply click the reset button");

            builder.show();
        } else if (winner == 2) {//green win
            //dialog box with pic
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("OK", null);

            ImageView i = new ImageView(this);
            i.setImageResource(R.drawable.winnerrr);
            builder.setView(i);

            builder.setTitle("Green Is The Winner !");
            builder.setMessage("You have shown yourself " +
                    "to be a mighty wizard. " +
                    "If you want to rematch simply click the reset button");

            builder.show();
        } else if (winner == 3) {//tie game
            //dialog box with pic
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("OK", null);

            ImageView i = new ImageView(this);
            i.setImageResource(R.drawable.tie);
            builder.setView(i);

            builder.setTitle("Tie Game !");
            builder.setMessage("You both have disappointed me. Go strengthen your skills and prove yourself worthy ! " +
                    "If you want to rematch simply click the reset button");

            builder.show();
        }
    }

    //to continue the game until win() occurs
    public void flip(ImageView i) {
        ImageView turnpic = (ImageView) findViewById(R.id.turn);
        ImageView s1 = (ImageView) findViewById(R.id.s1);
        ImageView s2 = (ImageView) findViewById(R.id.s2);
        ImageView s3 = (ImageView) findViewById(R.id.s3);
        ImageView s4 = (ImageView) findViewById(R.id.s4);
        ImageView s5 = (ImageView) findViewById(R.id.s5);

        if (turn == 1) {//placing the correct images for the selection - green
            if (sel == 1)
                i.setImageResource(R.drawable.g1);
            else if (sel == 2)
                i.setImageResource(R.drawable.g3);
            else if (sel == 3)
                i.setImageResource(R.drawable.g5);
            else if (sel == 4)
                i.setImageResource(R.drawable.g7);
            else
                i.setImageResource(R.drawable.g9);

            turn = 2;//turnover to continue the game
            turnpic.setImageResource(R.drawable.r);//turn pic
            //selection icons
            s1.setImageResource(R.drawable.r2i);
            s2.setImageResource(R.drawable.r4i);
            s3.setImageResource(R.drawable.r6i);
            s4.setImageResource(R.drawable.r8i);
            s5.setImageResource(R.drawable.r0i);
        } else {//red images
            if (sel == 1)
                i.setImageResource(R.drawable.r2);
            else if (sel == 2)
                i.setImageResource(R.drawable.r4);
            else if (sel == 3)
                i.setImageResource(R.drawable.r6);
            else if (sel == 4)
                i.setImageResource(R.drawable.r8);
            else
                i.setImageResource(R.drawable.r0);
            turn = 1;//continuing game
            turnpic.setImageResource(R.drawable.g);//turn
            //choices
            s1.setImageResource(R.drawable.g1i);
            s2.setImageResource(R.drawable.g3i);
            s3.setImageResource(R.drawable.g5i);
            s4.setImageResource(R.drawable.g7i);
            s5.setImageResource(R.drawable.g9i);
        }
    }

    //reset button
    public void reset(View view) {
        turn = 1;//reset turn back to green

        //resetting each grid pic to neutral
        ImageView a = (ImageView) findViewById(R.id.a);
        a.setImageResource(R.drawable.bob2);
        ImageView b = (ImageView) findViewById(R.id.b);
        b.setImageResource(R.drawable.bob2);
        ImageView c = (ImageView) findViewById(R.id.c);
        c.setImageResource(R.drawable.bob2);
        ImageView d = (ImageView) findViewById(R.id.d);
        d.setImageResource(R.drawable.bob2);
        ImageView e = (ImageView) findViewById(R.id.e);
        e.setImageResource(R.drawable.bob2);
        ImageView f = (ImageView) findViewById(R.id.f);
        f.setImageResource(R.drawable.bob2);
        ImageView g = (ImageView) findViewById(R.id.g);
        g.setImageResource(R.drawable.bob2);
        ImageView h = (ImageView) findViewById(R.id.h);
        h.setImageResource(R.drawable.bob2);
        ImageView i = (ImageView) findViewById(R.id.i);
        i.setImageResource(R.drawable.bob2);
        ImageView t = (ImageView) findViewById(R.id.turn);
        t.setImageResource(R.drawable.g);

        //resetting selection icons
        ImageView s1 = (ImageView) findViewById(R.id.s1);
        ImageView s2 = (ImageView) findViewById(R.id.s2);
        ImageView s3 = (ImageView) findViewById(R.id.s3);
        ImageView s4 = (ImageView) findViewById(R.id.s4);
        ImageView s5 = (ImageView) findViewById(R.id.s5);
        s1.setImageResource(R.drawable.g1i);
        s2.setImageResource(R.drawable.g3i);
        s3.setImageResource(R.drawable.g5i);
        s4.setImageResource(R.drawable.g7i);
        s5.setImageResource(R.drawable.g9i);

        //clearing array values
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                board[k][j] = 0;
            }
        }
    }

    //each button on the grid
    public void aClick(View view) {
        if (board[0][0] == 0) {//checking if place empty
            ImageView i = (ImageView) findViewById(R.id.a);
            flip(i);
            if (turn == 1) {//setting values based on selection - green
                if (sel == 1)
                    board[0][0] = 1;
                else if (sel == 2)
                    board[0][0] = 3;
                else if (sel == 3)
                    board[0][0] = 5;
                else if (sel == 4)
                    board[0][0] = 7;
                else
                    board[0][0] = 9;
            } else {//settigng values - red
                if (sel == 1)
                    board[0][0] = 2;
                else if (sel == 2)
                    board[0][0] = 4;
                else if (sel == 3)
                    board[0][0] = 6;
                else if (sel == 4)
                    board[0][0] = 8;
                else
                    board[0][0] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void bClick(View view) {
        if (board[0][1] == 0) {
            ImageView i = (ImageView) findViewById(R.id.b);
            flip(i);
            if (turn == 1) {
                if (sel == 1)
                    board[0][1] = 1;
                else if (sel == 2)
                    board[0][1] = 3;
                else if (sel == 3)
                    board[0][1] = 5;
                else if (sel == 4)
                    board[0][1] = 7;
                else
                    board[0][1] = 9;
            } else {
                if (sel == 1)
                    board[0][1] = 2;
                else if (sel == 2)
                    board[0][1] = 4;
                else if (sel == 3)
                    board[0][1] = 6;
                else if (sel == 4)
                    board[0][1] = 8;
                else
                    board[0][1] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void cClick(View view) {
        if (board[0][2] == 0) {
            ImageView i = (ImageView) findViewById(R.id.c);
            flip(i);
            if (turn == 1) {
                if (sel == 1)
                    board[0][2] = 1;
                else if (sel == 2)
                    board[0][2] = 3;
                else if (sel == 3)
                    board[0][2] = 5;
                else if (sel == 4)
                    board[0][2] = 7;
                else
                    board[0][2] = 9;
            } else {
                if (sel == 1)
                    board[0][2] = 2;
                else if (sel == 2)
                    board[0][2] = 4;
                else if (sel == 3)
                    board[0][2] = 6;
                else if (sel == 4)
                    board[0][2] = 8;
                else
                    board[0][2] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void dClick(View view) {
        if (board[1][0] == 0) {
            ImageView i = (ImageView) findViewById(R.id.d);
            flip(i);
            if (turn == 1) {
                if (sel == 1)
                    board[1][0] = 1;
                else if (sel == 2)
                    board[1][0] = 3;
                else if (sel == 3)
                    board[1][0] = 5;
                else if (sel == 4)
                    board[1][0] = 7;
                else
                    board[1][0] = 9;
            } else {
                if (sel == 1)
                    board[1][0] = 2;
                else if (sel == 2)
                    board[1][0] = 4;
                else if (sel == 3)
                    board[1][0] = 6;
                else if (sel == 4)
                    board[1][0] = 8;
                else
                    board[1][0] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void eClick(View view) {
        if (board[1][1] == 0) {
            ImageView i = (ImageView) findViewById(R.id.e);
            flip(i);
            if (turn == 1) {
                if (sel == 1)
                    board[1][1] = 1;
                else if (sel == 2)
                    board[1][1] = 3;
                else if (sel == 3)
                    board[1][1] = 5;
                else if (sel == 4)
                    board[1][1] = 7;
                else
                    board[1][1] = 9;
            } else {
                if (sel == 1)
                    board[1][1] = 2;
                else if (sel == 2)
                    board[1][1] = 4;
                else if (sel == 3)
                    board[1][1] = 6;
                else if (sel == 4)
                    board[1][1] = 8;
                else
                    board[1][1] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void fClick(View view) {
        if (board[1][2] == 0) {
            ImageView i = (ImageView) findViewById(R.id.f);
            flip(i);
            if (turn == 1) {
                if (sel == 1)
                    board[1][2] = 1;
                else if (sel == 2)
                    board[1][2] = 3;
                else if (sel == 3)
                    board[1][2] = 5;
                else if (sel == 4)
                    board[1][2] = 7;
                else
                    board[1][2] = 9;
            } else {
                if (sel == 1)
                    board[1][2] = 2;
                else if (sel == 2)
                    board[1][2] = 4;
                else if (sel == 3)
                    board[1][2] = 6;
                else if (sel == 4)
                    board[1][2] = 8;
                else
                    board[1][2] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void gClick(View view) {
        if (board[2][0] == 0) {
            ImageView i = (ImageView) findViewById(R.id.g);
            flip(i);
            if (turn == 1) {
                if (sel == 1)
                    board[2][0] = 1;
                else if (sel == 2)
                    board[2][0] = 3;
                else if (sel == 3)
                    board[2][0] = 5;
                else if (sel == 4)
                    board[2][0] = 7;
                else
                    board[2][0] = 9;
            } else {
                if (sel == 1)
                    board[2][0] = 2;
                else if (sel == 2)
                    board[2][0] = 4;
                else if (sel == 3)
                    board[2][0] = 6;
                else if (sel == 4)
                    board[2][0] = 8;
                else
                    board[2][0] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void hClick(View view) {
        if (board[2][1] == 0) {
            ImageView i = (ImageView) findViewById(R.id.h);
            flip(i);
            if (turn == 1) {
                if (sel == 1)
                    board[2][1] = 1;
                else if (sel == 2)
                    board[2][1] = 3;
                else if (sel == 3)
                    board[2][1] = 5;
                else if (sel == 4)
                    board[2][1] = 7;
                else
                    board[2][1] = 9;
            } else {
                if (sel == 1)
                    board[2][1] = 2;
                else if (sel == 2)
                    board[2][1] = 4;
                else if (sel == 3)
                    board[2][1] = 6;
                else if (sel == 4)
                    board[2][1] = 8;
                else
                    board[2][1] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    public void iClick(View view) {
        if (board[2][2] == 0) {
            ImageView im = (ImageView) findViewById(R.id.i);
            flip(im);
            if (turn == 1) {
                if (sel == 1)
                    board[2][2] = 1;
                else if (sel == 2)
                    board[2][2] = 3;
                else if (sel == 3)
                    board[2][2] = 5;
                else if (sel == 4)
                    board[2][2] = 7;
                else
                    board[2][2] = 9;
            } else {
                if (sel == 1)
                    board[2][2] = 2;
                else if (sel == 2)
                    board[2][2] = 4;
                else if (sel == 3)
                    board[2][2] = 6;
                else if (sel == 4)
                    board[2][2] = 8;
                else
                    board[2][2] = 10;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Place already taken", Toast.LENGTH_SHORT).show();
        }
        win();
    }

    //selecting choices
    public void s1(View view) {
        sel = 1;
    }

    public void s2(View view) {
        sel = 2;
    }

    public void s3(View view) {
        sel = 3;
    }

    public void s4(View view) {
        sel = 4;
    }

    public void s5(View view) {
        sel = 5;
    }
}
