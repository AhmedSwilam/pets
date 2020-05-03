package com.hardtask.com.kangaroo.ui.mainscreen;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hardtask.com.kangaroo.POJO.maincategory.MainCategory;
import com.hardtask.com.kangaroo.retrofit.RequestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainCategoryViewModel extends ViewModel {

    MutableLiveData<List<MainCategory>> mainCategoriesMutableLiveData = new MutableLiveData<>();

    public void getCategories() {
        RequestClient.getINSTANCE().getAllMainCategories().enqueue(new Callback<List<MainCategory>>() {
            @Override
            public void onResponse(Call<List<MainCategory>> call, Response<List<MainCategory>> response) {
                if(response.body()!=null) {
                    mainCategoriesMutableLiveData.setValue(response.body());
                }

            }
            @Override
            public void onFailure(Call<List<MainCategory>> call, Throwable t) {

            }
        });
    }
}
