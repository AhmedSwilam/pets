
package com.hardtask.com.kangaroo.POJO.addadvertisemodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdvertiseType implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("TypeName")
    @Expose
    private String typeName;
    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    public final static Creator<AdvertiseType> CREATOR = new Creator<AdvertiseType>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AdvertiseType createFromParcel(Parcel in) {
            return new AdvertiseType(in);
        }

        public AdvertiseType[] newArray(int size) {
            return (new AdvertiseType[size]);
        }

    }
    ;

    protected AdvertiseType(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.typeName = ((String) in.readValue((String.class.getClassLoader())));
        this.categoryId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public AdvertiseType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(typeName);
        dest.writeValue(categoryId);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return typeName;
    }
}
