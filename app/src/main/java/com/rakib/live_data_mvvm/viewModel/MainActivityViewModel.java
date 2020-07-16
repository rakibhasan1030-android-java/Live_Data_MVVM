package com.rakib.live_data_mvvm.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<String> resultLiveData;

    public MutableLiveData<String> getResult(String value1, String value2) {

        int first_value = Integer.parseInt(value1);
        int second_value = Integer.parseInt(value2);
        int result = first_value + second_value;

        if (resultLiveData == null) {
            resultLiveData = new MutableLiveData<String>();
        }
        resultLiveData.setValue(String.valueOf(result));
        return resultLiveData;
    }

}
