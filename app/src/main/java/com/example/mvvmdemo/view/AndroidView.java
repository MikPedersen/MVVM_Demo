package com.example.mvvmdemo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mvvmdemo.R;

import java.util.Observable;

public class AndroidView extends AppCompatActivity {

    private LowerCasePresenter lowerCasePresenter = new LowerCasePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        observerViewModel();

        TextView editedText = findViewById(R.id.textView);
        editedText.setText(lowerCasePresenter.getPresentableInput());
        EditText inputText = findViewById(R.id.editText);
        inputText.setText(lowerCasePresenter.getPresentableInput());
    }

    private void observerViewModel(){
        lowerCasePresenter.addObserver(new java.util.Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof LowerCasePresenter){
                    String input = ((LowerCasePresenter) o).getPresentableInput();
                    TextView editedText = findViewById(R.id.textView);
                    editedText.setText(input);
            }
        }});
        }


    public void setInput(View view){
        EditText inputText = findViewById(R.id.editText);

        String input = inputText.getText().toString();
        lowerCasePresenter.setInput(input);
    }


}