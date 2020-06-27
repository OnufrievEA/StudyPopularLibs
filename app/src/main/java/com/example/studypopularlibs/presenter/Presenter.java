package com.example.studypopularlibs.presenter;

import android.util.Log;

import com.example.studypopularlibs.model.Model;
import com.example.studypopularlibs.view.IView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class Presenter extends MvpPresenter<IView> {

    Model model;
    private static final String TAG = "Presenter";

    public Presenter() {
        model = new Model();
    }

    public void onCardClicked() {
        int currentCounterVal = model.getCounter();
        model.setCounter(currentCounterVal + 1);
        Log.i(TAG, String.valueOf(model.getCounter()));
        getViewState().increaseCounter(model.getCounter());
    }
}
