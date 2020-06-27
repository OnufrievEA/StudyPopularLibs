package com.example.studypopularlibs.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface IView extends MvpView {
    @StateStrategyType(value = AddToEndStrategy.class)
    void increaseCounter(int counter);
}
