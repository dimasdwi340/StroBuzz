package com.dimas.projectakhirku.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Berikut ini Merupakan Varietas Stroberi yang Cocok Ditanam di Indonesia");
    }

    public LiveData<String> getText() {
        return mText;
    }
}