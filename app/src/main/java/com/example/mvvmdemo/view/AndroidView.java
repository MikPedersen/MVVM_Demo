package com.example.mvvmdemo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmdemo.R;

public class AndroidView extends AppCompatActivity {

    private AndroidLowerCaseViewModel lowerCaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observerViewModel();

        EditText inputText = findViewById(R.id.editText);
        inputText.setText(lowerCaseViewModel.getPresentableInput().getValue());
    }

    private void observerViewModel(){
        lowerCaseViewModel = new ViewModelProvider(this).get(AndroidLowerCaseViewModel.class);

        final androidx.lifecycle.Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView editedText = findViewById(R.id.editText);
                editedText.setText(s);
            }};
        lowerCaseViewModel.getPresentableInput().observe(this, stringObserver);
        }

    public void setInput(View view){
        EditText inputText = findViewById(R.id.editText);

        String input = inputText.getText().toString();
        lowerCaseViewModel.setInput(input);
    }


}