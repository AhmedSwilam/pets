
package com.hardtask.com.kangaroo.POJO.addadvertisemodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgeType implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("AgeTypeName")
    @Expose
    private String ageTypeName;
    public final static Creator<AgeType> CREATOR = new Creator<AgeType>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AgeType createFromParcel(Parcel in) {
            return new AgeType(in);
        }

        public AgeType[] newArray(int size) {
            return (new AgeType[size]);
        }

    }
    ;

    protected AgeType(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ageTypeName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AgeType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgeTypeName() {
        return ageTypeName;
    }

    public void setAgeTypeName(String ageTypeName) {
        this.ageTypeName = ageTypeName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(ageTypeName);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return ageTypeName;
    }
}
