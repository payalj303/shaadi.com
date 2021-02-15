package com.shaadi.data.remote.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Coordinates{
  @SerializedName("latitude")
  @Expose
  private Double latitude;
  @SerializedName("longitude")
  @Expose
  private Double longitude;
  public void setLatitude(Double latitude){
   this.latitude=latitude;
  }
  public Double getLatitude(){
   return latitude;
  }
  public void setLongitude(Double longitude){
   this.longitude=longitude;
  }
  public Double getLongitude(){
   return longitude;
  }
}