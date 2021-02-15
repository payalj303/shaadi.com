package com.shaadi.data.remote.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Registered{
  @SerializedName("date")
  @Expose
  private String date;
  @SerializedName("age")
  @Expose
  private Integer age;
  public void setDate(String date){
   this.date=date;
  }
  public String getDate(){
   return date;
  }
  public void setAge(Integer age){
   this.age=age;
  }
  public Integer getAge(){
   return age;
  }
}