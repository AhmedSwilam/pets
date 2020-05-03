package com.hardtask.com.kangaroo.ui.addadvertise;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AdvertiseType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AgeType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.Gender;
import com.hardtask.com.kangaroo.POJO.maincategory.MainCategory;
import com.hardtask.com.kangaroo.POJO.subcategory.SubCategoriesModel;
import com.hardtask.com.kangaroo.retrofit.RequestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAdvertiseViewModel extends ViewModel {

    MutableLiveData<List<AdvertiseType>> advertiseTypeMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<AgeType>> ageTypeMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<Gender>> genderMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<MainCategory>> mainCategoriesMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<SubCategoriesModel>> subCategoriesMutableData = new MutableLiveData<>();

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

    public void getAdvTypes(){
        RequestClient.getINSTANCE().getAllAdvertiseTypes().enqueue(new Callback<List<AdvertiseType>>() {
            @Override
            public void onResponse(Call<List<AdvertiseType>> call, Response<List<AdvertiseType>> response) {
                if (response.body()!=null){
                    advertiseTypeMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<AdvertiseType>> call, Throwable t) {

            }
        });
    }

    public void getAgeType(){
        RequestClient.getINSTANCE().getAllAgeType().enqueue(new Callback<List<AgeType>>() {
            @Override
            public void onResponse(Call<List<AgeType>> call, Response<List<AgeType>> response) {
                if (response.body()!=null){
                    ageTypeMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<AgeType>> call, Throwable t) {

            }
        });
    }

    public void getGender(){
        RequestClient.getINSTANCE().getAllGenderType().enqueue(new Callback<List<Gender>>() {
            @Override
            public void onResponse(Call<List<Gender>> call, Response<List<Gender>> response) {
                if (response.body()!=null){
                    genderMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Gender>> call, Throwable t) {

            }
        });
    }
}
