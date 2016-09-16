package com.forsfortis.rims.shared;

import java.io.Serializable;

//import com.google.gwt.user.cellview.client.TreeNode;

/*public class BaseDto implements Serializable,TreeNode{

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
	public BaseDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseDto(Integer id,String name) {
		this.setId(id);
		this.setName(name);
	}
	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getChildValue(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isChildLeaf(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildOpen(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode setChildOpen(int index, boolean open) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeNode setChildOpen(int index, boolean open, boolean fireEvents) {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

*/

import java.io.Serializable;
import java.util.List;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.TreeStore.TreeNode;

public class BaseDto implements Serializable, TreeStore.TreeNode<BaseDto> {
	private Integer id;
	private String name;

	protected BaseDto() {
	}

	public BaseDto(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public BaseDto getData() {
		return this;
	}

	@Override
	public List<? extends TreeNode<BaseDto>> getChildren() {
		return null;
	}

	@Override
	public String toString() {
		return name != null ? name : super.toString();
	}
}
