package com.mikelau.zenith.models.warp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Pointer<T> implements Parcelable {

    private int id;
    private String type;
    private String className;

    @SerializedName("attributes")
    private T attribute;

    public Pointer(String className, int id) {
        this.id = id;
        this.type = "Pointer";
        this.className = className;
    }

    public Pointer() {
    }

    protected Pointer(Parcel in) {
        id = in.readInt();
        type = in.readString();
        className = in.readString();
    }

    public static final Creator<Pointer> CREATOR = new Creator<Pointer>() {
        @Override
        public Pointer createFromParcel(Parcel in) {
            return new Pointer(in);
        }

        @Override
        public Pointer[] newArray(int size) {
            return new Pointer[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        this.type = "Pointer";
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public T getAttribute() {
        return attribute;
    }

    public void setAttribute(T attribute) {
        this.attribute = attribute;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(type);
        parcel.writeString(className);
    }
}
