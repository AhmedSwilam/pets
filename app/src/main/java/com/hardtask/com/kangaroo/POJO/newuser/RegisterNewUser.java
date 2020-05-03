
package com.hardtask.com.kangaroo.POJO.newuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterNewUser implements Parcelable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("UserCode")
    @Expose
    private String userCode;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("FullName")
    @Expose
    private Object fullName;
    @SerializedName("VerificationCode")
    @Expose
    private String verificationCode;
    @SerializedName("Createat")
    @Expose
    private String createat;
    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("UserPassword")
    @Expose
    private Object userPassword;
    @SerializedName("FcmToken")
    @Expose
    private String fcmToken;
    @SerializedName("Email")
    @Expose
    private Object email;
    @SerializedName("Active")
    @Expose
    private Boolean active;
    @SerializedName("Used")
    @Expose
    private Boolean used;
    public final static Creator<RegisterNewUser> CREATOR = new Creator<RegisterNewUser>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RegisterNewUser createFromParcel(Parcel in) {
            return new RegisterNewUser(in);
        }

        public RegisterNewUser[] newArray(int size) {
            return (new RegisterNewUser[size]);
        }

    }
    ;

    protected RegisterNewUser(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.userCode = ((String) in.readValue((String.class.getClassLoader())));
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.fullName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.verificationCode = ((String) in.readValue((String.class.getClassLoader())));
        this.createat = ((String) in.readValue((String.class.getClassLoader())));
        this.mobileNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.userPassword = ((Object) in.readValue((Object.class.getClassLoader())));
        this.fcmToken = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((Object) in.readValue((Object.class.getClassLoader())));
        this.active = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.used = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public RegisterNewUser(String userName, String verificationCode, String mobileNumber, Object userPassword, String fcmToken) {
        this.userName = userName;
        this.verificationCode = verificationCode;
        this.mobileNumber = mobileNumber;
        this.userPassword = userPassword;
        this.fcmToken = fcmToken;
    }

    public RegisterNewUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object getFullName() {
        return fullName;
    }

    public void setFullName(Object fullName) {
        this.fullName = fullName;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getCreateat() {
        return createat;
    }

    public void setCreateat(String createat) {
        this.createat = createat;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Object getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(Object userPassword) {
        this.userPassword = userPassword;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(userCode);
        dest.writeValue(userName);
        dest.writeValue(fullName);
        dest.writeValue(verificationCode);
        dest.writeValue(createat);
        dest.writeValue(mobileNumber);
        dest.writeValue(userPassword);
        dest.writeValue(fcmToken);
        dest.writeValue(email);
        dest.writeValue(active);
        dest.writeValue(used);
    }

    public int describeContents() {
        return  0;
    }

}
