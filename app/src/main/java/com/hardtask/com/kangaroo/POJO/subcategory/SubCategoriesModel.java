
package com.hardtask.com.kangaroo.POJO.subcategory;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategoriesModel implements Parcelable
{

    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("PhotoPath")
    @Expose
    private String photoPath;
    public final static Creator<SubCategoriesModel> CREATOR = new Creator<SubCategoriesModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SubCategoriesModel createFromParcel(Parcel in) {
            return new SubCategoriesModel(in);
        }

        public SubCategoriesModel[] newArray(int size) {
            return (new SubCategoriesModel[size]);
        }

    }
    ;

    protected SubCategoriesModel(Parcel in) {
        this.categoryId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.categoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.photoPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SubCategoriesModel() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(categoryId);
        dest.writeValue(categoryName);
        dest.writeValue(photoPath);
    }

    public int describeContents() {
        return  0;
    }

}
