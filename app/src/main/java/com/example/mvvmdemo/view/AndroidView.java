package com.example.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.model.Model;

import java.util.Observable;
import java.util.Observer;

public class AndroidView extends AppCompatActivity {

    private Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observerModel(model);

        TextView editedText = (TextView) findViewById(R.id.textView);
        editedText.setText(model.getInput());

        EditText inputText = (EditText) findViewById(R.id.editText);
        inputText.setText(model.getInput());


    }
    private void observerModel(Model model){
        model.addObserver(new Observer() {
        @Override
        public void update(Observable o, Object arg) {
            if (o instanceof Model){
                String input = ((Model) o).getInput();
                TextView output = findViewById(R.id.textView);
                output.setText(input);
            }
        }
    });}

    public void setInput(View view){
        EditText inputText = (EditText) findViewById(R.id.editText);

        String input = inputText.getText().toString();
        model.setInput(input);

    }
}