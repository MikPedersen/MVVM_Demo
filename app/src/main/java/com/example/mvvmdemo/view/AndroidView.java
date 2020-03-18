package com.example.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.model.Model;

import java.util.Observable;

public class AndroidView extends AppCompatActivity {

    //private Model model = new Model();
    private AndroidLowerCaseViewModel lowerCaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observerViewModel();

//        TextView editedText = (TextView) findViewById(R.id.textView);
//        editedText.setText(model.getInput());

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
            }
        };
        lowerCaseViewModel.getPresentableInput().observe(this, stringObserver);
        }

//    private void observerModel(Model model){
//        model.addObserver(new Observer() {
//        @Override
//        public void update(Observable o, Object arg) {
//            if (o instanceof Model){
//                String input = ((Model) o).getInput();
//                TextView output = findViewById(R.id.textView);
//                output.setText(input);
//            }
//        }
//    });}

    public void setInput(View view){
        EditText inputText = (EditText) findViewById(R.id.editText);

        String input = inputText.getText().toString();
        lowerCaseViewModel.setInput(input);

    }
}