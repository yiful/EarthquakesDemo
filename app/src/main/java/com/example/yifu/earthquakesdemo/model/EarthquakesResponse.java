package com.example.yifu.earthquakesdemo.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EarthquakesResponse {

	@SerializedName("features")
	private List<FeaturesItem> features;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("bbox")
	private List<Double> bbox;

	@SerializedName("type")
	private String type;

	public void setFeatures(List<FeaturesItem> features){
		this.features = features;
	}

	public List<FeaturesItem> getFeatures(){
		return features;
	}

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setBbox(List<Double> bbox){
		this.bbox = bbox;
	}

	public List<Double> getBbox(){
		return bbox;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"EarthquakesResponse{" +
			"features = '" + features + '\'' + 
			",metadata = '" + metadata + '\'' + 
			",bbox = '" + bbox + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}