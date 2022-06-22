package com.Task.ENUM;

public enum Gender 
{
	
	   MALE(0),
	   FEMALE(1),
	   OTHER(2);

	 public final int label;
	 
	Gender(int i) {
		this.label=i;
	}

	public int getLabel() {
		return label;
	}

	
	   
	  
}
