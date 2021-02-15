package com.shaadi.data.remote.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Street{
  @SerializedName("number")
  @Expose
  private Long number;
  @SerializedName("name")
  @Expose
  private String name;
  public void setNumber(Long number){
   this.number=number;
  }
  public Long getNumber(){
   return number;
  }
  public void setName(String name){
   this.name=name;
  }
  public String getName(){
   return name;
  }
}