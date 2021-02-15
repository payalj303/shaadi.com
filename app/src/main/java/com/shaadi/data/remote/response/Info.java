package com.shaadi.data.remote.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class Info{
  @SerializedName("seed")
  @Expose
  private String seed;
  @SerializedName("page")
  @Expose
  private Integer page;
  @SerializedName("results")
  @Expose
  private Integer results;
  @SerializedName("version")
  @Expose
  private Double version;
  public void setSeed(String seed){
   this.seed=seed;
  }
  public String getSeed(){
   return seed;
  }
  public void setPage(Integer page){
   this.page=page;
  }
  public Integer getPage(){
   return page;
  }
  public void setResults(Integer results){
   this.results=results;
  }
  public Integer getResults(){
   return results;
  }
  public void setVersion(Double version){
   this.version=version;
  }
  public Double getVersion(){
   return version;
  }
}