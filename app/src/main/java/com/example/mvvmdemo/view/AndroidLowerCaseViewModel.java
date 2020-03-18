package com.example.mvvmdemo.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvmdemo.model.Model;
import java.util.Observable;
import java.util.Observer;

public class AndroidLowerCaseViewModel extends ViewModel {

    private Model model = new Model();
    private MutableLiveData<String> presentableInput  = new MutableLiveData<>();

    private void observermodel(Model model){
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model){
                    String input = ((Model) o).getInput();
                    presentableInput.setValue(getTransformedInput(input));
            }}
        });
    }

    public AndroidLowerCaseViewModel(){
        observermodel(model);
        presentableInput.setValue(getTransformedInput(model.getInput()));
    }

    public MutableLiveData<String> getPresentableInput() {
        return presentableInput;
    }

    private String getTransformedInput(String input){
        return input.toLowerCase();
    }
    public void setInput (String input){
        model.setInput(input);
    }
}
