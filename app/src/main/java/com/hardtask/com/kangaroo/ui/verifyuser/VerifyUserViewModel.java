package com.hardtask.com.kangaroo.ui.verifyuser;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hardtask.com.kangaroo.POJO.newuser.RegisterNewUser;
import com.hardtask.com.kangaroo.retrofit.RequestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyUserViewModel extends ViewModel {

    MutableLiveData<RegisterNewUser> newUserMutableLiveData = new MutableLiveData<>();

    public void postNewUser(RegisterNewUser registerNewUser) {
        RequestClient.getINSTANCE().registerNewUser(registerNewUser).enqueue(new Callback<RegisterNewUser>() {
            @Override
            public void onResponse(Call<RegisterNewUser> call, Response<RegisterNewUser> response) {
                if (response.body() != null) {
                    newUserMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RegisterNewUser> call, Throwable t) {

            }
        });
    }

}
