package com.hardtask.com.kangaroo.ui.subcategory;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hardtask.com.kangaroo.POJO.subcategory.SubCategoriesModel;
import com.hardtask.com.kangaroo.retrofit.RequestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryViewModel extends ViewModel {

    MutableLiveData<List<SubCategoriesModel>> subCategoriesMutableData = new MutableLiveData<>();

    public void getSubCategoriesById(String Id){

        RequestClient.getINSTANCE().getAllSubCategories(Id).enqueue(new Callback<List<SubCategoriesModel>>() {
            @Override
            public void onResponse(Call<List<SubCategoriesModel>> call, Response<List<SubCategoriesModel>> response) {
                if(response.body()!=null) {
                    subCategoriesMutableData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<SubCategoriesModel>> call, Throwable t) {

            }
        });

    }

}
