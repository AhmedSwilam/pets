package com.hardtask.com.kangaroo.retrofit;

import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AdvertiseType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AgeType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.Gender;
import com.hardtask.com.kangaroo.POJO.maincategory.MainCategory;
import com.hardtask.com.kangaroo.POJO.newuser.RegisterNewUser;
import com.hardtask.com.kangaroo.POJO.subcategory.SubCategoriesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestInterface {


    @GET("Category/GetMainCategories")
    public Call<List<MainCategory>> getAllMainCategories();

    @GET("Category/GetCategories")
    public Call<List<SubCategoriesModel>> getAllSubCategories(@Query("MainCategoryId") String Id);

    @POST("Users/AddUser")
    public Call<RegisterNewUser> REGISTER_NEW_USER_CALL(@Body RegisterNewUser registerNewUser);

    @GET("AdvertiseConfiguration/GetAdvertiseTypes")
    public Call<List<AdvertiseType>> getAdvertiseType();

    @GET("AdvertiseConfiguration/GetAgeTypes")
    public Call<List<AgeType>> getAgeType();

    @GET("AdvertiseConfiguration/GetGenders")
    public Call<List<Gender>> getGenderType();

}
