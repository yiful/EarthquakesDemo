package com.example.yifu.earthquakesdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class FeaturesItem implements Parcelable{

	@SerializedName("geometry")
	private Geometry geometry;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("properties")
	private Properties properties;

	public FeaturesItem(Parcel in) {
		// this.geometry = in.readParcelable(Geometry.class);
		this.id = id;
		this.type = type;
		this.properties = properties;
	}

	public void setGeometry(Geometry geometry){
		this.geometry = geometry;
	}

	public Geometry getGeometry(){
		return geometry;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setProperties(Properties properties){
		this.properties = properties;
	}

	public Properties getProperties(){
		return properties;
	}

	@Override
 	public String toString(){
		return 
			"FeaturesItem{" + 
			"geometry = '" + geometry + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",properties = '" + properties + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(getGeometry().toString());
		parcel.writeString(getProperties().toString());
	}
}