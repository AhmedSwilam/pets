
package com.hardtask.com.kangaroo.POJO.addadvertisemodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gender implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("GenderName")
    @Expose
    private String genderName;
    public final static Creator<Gender> CREATOR = new Creator<Gender>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Gender createFromParcel(Parcel in) {
            return new Gender(in);
        }

        public Gender[] newArray(int size) {
            return (new Gender[size]);
        }

    }
    ;

    protected Gender(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.genderName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Gender() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(genderName);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return genderName;
    }
}
