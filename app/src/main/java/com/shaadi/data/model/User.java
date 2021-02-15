package com.shaadi.data.model;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * @author Payal Jian
 * @version 1.0
 * @since 14/Feb/21
 */
@Entity
public class User extends BaseObservable implements Serializable {


    @ColumnInfo(name = "fName")
    public String fName;

    @ColumnInfo(name = "lName")
    public String lName;

    @ColumnInfo(name = "age")
    public int age;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "accept")
    public boolean accept;

    @ColumnInfo(name = "decline")
    public boolean decline;

    @ColumnInfo(name = "_id")
    @PrimaryKey
    @NonNull
    public String _id;


    public User(String id, String fName, String lName, int age, String country, String city, String image, boolean accept, boolean decline) {
        this._id=id;
        this.fName =fName;
        this.lName=lName;
        this.age = age;
        this.country = country;
        this.city = city;
        this.image = image;
        this.accept = accept;
        this.decline = decline;
    }
}
