package com.forsfortis.rims.shared;
/*
import java.util.ArrayList;
import java.util.List;

public class FolderDto extends BaseDto {

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	private List<BaseDto> children=new ArrayList<BaseDto>();
	
	public List<BaseDto> getChildren() {
		return children;
	}

	public void setChildren(List<BaseDto> children) {
		this.children = children;
	}
	public FolderDto(){
	}
	public FolderDto(Integer id,String name){
		super(id,name);
	}
	public void addChild(BaseDto child){
		getChildren().add(child);
	}
	
}
*/

import java.util.List;

@SuppressWarnings("serial")
public class FolderDto extends BaseDto {
	private List<BaseDto> children;

	protected FolderDto() {
	}

	public FolderDto(Integer id, String name) {
		super(id, name);
	}

	public List<BaseDto> getChildren() {
		return children;
	}

	public void setChildren(List<BaseDto> children) {
		this.children = children;
	}

	public void addChild(BaseDto child) {
		getChildren().add(child);
	}
} 