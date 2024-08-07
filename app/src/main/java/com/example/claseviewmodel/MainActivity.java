package com.example.claseviewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private miViewModel miViewModel;
    private TextView counterTextView;
    private Button counterIncrement;
    private Button counterDecrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miViewModel = new ViewModelProvider(this).get(miViewModel.class);

        counterIncrement = findViewById(R.id.increment_button);
        counterDecrement = findViewById(R.id.decrement_button);
        counterTextView = findViewById(R.id.counter_text_view);

        counterTextView.setText(String.valueOf(miViewModel.getCounter()));

        counterIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarContador();
            }
        });

        counterDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disminuirContador();
            }
        });

    }
    private void incrementarContador () {
        miViewModel.incrementCounter();
        counterTextView.setText(String.valueOf(miViewModel.getCounter()));
    }
    private void disminuirContador(){
        miViewModel.decrementCounter();
        counterTextView.setText(String.valueOf(miViewModel.getCounter()));
    }
}
