package com.example.mvvmdemo.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvmdemo.model.Model;
import java.util.Observable;
import java.util.Observer;

public class LowerCasePresenter extends Observable {

    private Model model = new Model();
    private String presentableInput;

    private void observermodel(Model model){
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model){
                    String input = ((Model) o).getInput();
                    presentableInput = getTransformedInput(input);

                    LowerCasePresenter.super.setChanged();
                    LowerCasePresenter.super.notifyObservers();
            }}
        });
    }

    public LowerCasePresenter(){
        observermodel(model);
        presentableInput = getTransformedInput(model.getInput());
    }

    public String getPresentableInput() {
        return presentableInput;
    }

    private String getTransformedInput(String input){
        return input.toLowerCase();
    }
    public void setInput (String input){
        model.setInput(input);
    }
}
