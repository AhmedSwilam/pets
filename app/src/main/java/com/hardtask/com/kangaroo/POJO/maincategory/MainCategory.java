
package com.hardtask.com.kangaroo.POJO.maincategory;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainCategory implements Parcelable {

    @SerializedName("MainCategoryId")
    @Expose
    private Integer mainCategoryId;
    @SerializedName("ManinCategoryName")
    @Expose
    private String maninCategoryName;
    @SerializedName("PhotoPath")
    @Expose
    private String photoPath;
    public final static Creator<MainCategory> CREATOR = new Creator<MainCategory>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MainCategory createFromParcel(Parcel in) {
            return new MainCategory(in);
        }

        public MainCategory[] newArray(int size) {
            return (new MainCategory[size]);
        }

    };

    protected MainCategory(Parcel in) {
        this.mainCategoryId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.maninCategoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.photoPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MainCategory() {
    }

    public Integer getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(Integer mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public String getManinCategoryName() {
        return maninCategoryName;
    }

    public void setManinCategoryName(String maninCategoryName) {
        this.maninCategoryName = maninCategoryName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mainCategoryId);
        dest.writeValue(maninCategoryName);
        dest.writeValue(photoPath);
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return maninCategoryName;
    }
}
