package com.example.yifu.earthquakesdemo.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Metadata{

	@SerializedName("generated")
	private long generated;

	@SerializedName("count")
	private int count;

	@SerializedName("api")
	private String api;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("status")
	private int status;

	public void setGenerated(long generated){
		this.generated = generated;
	}

	public long getGenerated(){
		return generated;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setApi(String api){
		this.api = api;
	}

	public String getApi(){
		return api;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"generated = '" + generated + '\'' + 
			",count = '" + count + '\'' + 
			",api = '" + api + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}