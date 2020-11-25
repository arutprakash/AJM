package com.aamjantamedia.ajm.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText1,mText2;

    public GalleryViewModel() {
        mText1 = new MutableLiveData<>();
        mText1.setValue("About");
    }

    public LiveData<String> getText() {
        return mText1;
    }
}