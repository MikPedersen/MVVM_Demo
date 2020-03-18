package com.example.mvvmdemo.model;

import java.util.Observable;

public class Model extends Observable {
     private String input;

    public void setInput(String input){
        this.input = input;
        setChanged();
        setTextAndNotifyObservers();
    }

    private void setTextAndNotifyObservers(){
        super.setChanged();
        super.notifyObservers();
    }

    public String getInput() {
        return input;
    }
}
