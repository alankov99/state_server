package com.state.model;

import java.util.List;

public class States {

	private String state;
	private List<List<Double>> border;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<List<Double>> getBorder() {
		return border;
	}

	public void setBorder(List<List<Double>> border) {
		this.border = border;
	}

	@Override
	public String toString() {
		return "[" + state + "]";
	}
	
	

	

	
}
