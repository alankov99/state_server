package com.state.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.state.service.StateService;

@RestController
@RequestMapping(value = "/")
public class StateController {

	@Autowired
	private StateService stateService;

	@RequestMapping(value = "/{longitude}/{latitude}/", method = RequestMethod.GET)
	public ResponseEntity<String> getState (@PathVariable("longitude") Double longitude, @PathVariable("latitude") Double  latitude) {
		
		String state = stateService.getState(longitude, latitude);
		if (state == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<String>(state, HttpStatus.OK);
	}
	
}
	
	