package com.hardtask.com.kangaroo.retrofit;

import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AdvertiseType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.AgeType;
import com.hardtask.com.kangaroo.POJO.addadvertisemodel.Gender;
import com.hardtask.com.kangaroo.POJO.maincategory.MainCategory;
import com.hardtask.com.kangaroo.POJO.newuser.RegisterNewUser;
import com.hardtask.com.kangaroo.POJO.subcategory.SubCategoriesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestClient {

    private static final String BaseURl = "http://nahasass06-001-site1.btempurl.com/api/";
    private RequestInterface requestInterface;
    private static RequestClient INSTANCE;

    public RequestClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        requestInterface = retrofit.create(RequestInterface.class);

    }

    public static RequestClient getINSTANCE() {

        if (null == INSTANCE) {
            INSTANCE = new RequestClient();
        }

        return INSTANCE;
    }

    public Call<List<MainCategory>> getAllMainCategories(){
        return requestInterface.getAllMainCategories();
    }

    public Call<List<SubCategoriesModel>> getAllSubCategories(String Id){
        return requestInterface.getAllSubCategories(Id);
    }

    public Call<RegisterNewUser> registerNewUser(RegisterNewUser registerNewUser){
        return requestInterface.REGISTER_NEW_USER_CALL(registerNewUser);
    }

    public Call<List<AdvertiseType>> getAllAdvertiseTypes(){
        return requestInterface.getAdvertiseType();
    }

    public Call<List<AgeType>> getAllAgeType(){
        return requestInterface.getAgeType();
    }

    public Call<List<Gender>> getAllGenderType(){
        return requestInterface.getGenderType();
    }
}
