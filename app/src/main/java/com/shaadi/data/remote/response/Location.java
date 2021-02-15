package com.shaadi.data.remote.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Location{
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("street")
  @Expose
  private Street street;
  @SerializedName("timezone")
  @Expose
  private Timezone timezone;

  @SerializedName("coordinates")
  @Expose
  private Coordinates coordinates;
  @SerializedName("state")
  @Expose
  private String state;
  public void setCountry(String country){
   this.country=country;
  }
  public String getCountry(){
   return country;
  }
  public void setCity(String city){
   this.city=city;
  }
  public String getCity(){
   return city;
  }
  public void setStreet(Street street){
   this.street=street;
  }
  public Street getStreet(){
   return street;
  }
  public void setTimezone(Timezone timezone){
   this.timezone=timezone;
  }
  public Timezone getTimezone(){
   return timezone;
  }

  public void setCoordinates(Coordinates coordinates){
   this.coordinates=coordinates;
  }
  public Coordinates getCoordinates(){
   return coordinates;
  }
  public void setState(String state){
   this.state=state;
  }
  public String getState(){
   return state;
  }

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }
}