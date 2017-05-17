package com.state.service;

import java.util.Collection;

import com.state.model.States;

public interface StateService {

	public String getState(Double longitude, Double latitude);

	public Collection<States> getAll();

}
