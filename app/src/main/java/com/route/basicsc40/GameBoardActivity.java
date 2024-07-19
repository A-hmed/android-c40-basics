package com.route.basicsc40;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Objects;

public class GameBoardActivity extends AppCompatActivity {
    int counter = 0;
    int player1Score = 0;
    int player2Score = 0;
    TextView player1ScoreTv;
    TextView player2ScoreTv;
    String[] board = {"", "", "",
            "", "", "",
            "", "", ""};
    ConstraintLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        mainView = findViewById(R.id.main);
        player1ScoreTv = findViewById(R.id.player1Score);
        player2ScoreTv = findViewById(R.id.player2Score);

    }

    public void onClick(View view) {
        Button clickedBtn = (Button) view;
        if (!clickedBtn.getText().toString().isEmpty()) return;
        int index = Integer.parseInt((String) view.getTag());
        String symbol = counter % 2 == 0 ? "o" : "x";
        clickedBtn.setText(symbol);
        board[index] = symbol;
        if (checkWinner(symbol)) {
            if (symbol.equals("o")) {
                player1ScoreTv.setText(++player1Score + "");
            } else {
                player2ScoreTv.setText(++player2Score + "");
            }
            clearBoard();
            return;
        }
        if (counter == 8) {
            clearBoard();
            return;
        }
        counter++;


    }

    private void clearBoard() {
        board = new String[]{"", "", "",
                "", "", "",
                "", "", ""};
        for (int i = 0; i < mainView.getChildCount(); i++) {
            if (mainView.getChildAt(i) instanceof Button) {
                Button button = (Button) mainView.getChildAt(i);
                button.setText("");
            }
            counter = 0;
        }

    }

    private boolean checkWinner(String symbol) {
        ///Rows
        if (Objects.equals(board[0], symbol) &&
                Objects.equals(board[1], symbol) &&
                Objects.equals(board[2], symbol)) {
            return true;
        }
        if (Objects.equals(board[3], symbol) &&
                Objects.equals(board[4], symbol)
                && Objects.equals(board[5], symbol)) {
            return true;
        }
        if (Objects.equals(board[6], symbol) &&
                Objects.equals(board[7], symbol) &&
                Objects.equals(board[8], symbol)) {
            return true;
        }
        ///Columns
        if (Objects.equals(board[0], symbol) &&
                Objects.equals(board[3], symbol) &&
                Objects.equals(board[6], symbol)) {
            return true;
        }
        if (Objects.equals(board[1], symbol) &&
                Objects.equals(board[4], symbol)
                && Objects.equals(board[7], symbol)) {
            return true;
        }
        if (Objects.equals(board[2], symbol) &&
                Objects.equals(board[5], symbol)
                && Objects.equals(board[8], symbol)) {
            return true;
        }
        if (Objects.equals(board[0], symbol) &&
                Objects.equals(board[4], symbol)
                && Objects.equals(board[8], symbol)) {
            return true;
        }
        return Objects.equals(board[2], symbol) &&
                Objects.equals(board[4], symbol)
                && Objects.equals(board[6], symbol);


    }
}