package com.state.service;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.state.model.States;

@Service
public class StateServiceImpl implements StateService {

	@Override
	public String getState(Double longitude, Double latitude) {
		String state = null;
		try {
			List<States> states = pupulateStates();
			state = findMatch(states, longitude, latitude);
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	private List<States> pupulateStates() throws JsonProcessingException, IOException {
		List<States> allStates = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper().setVisibility(FIELD, ANY);
		File file = new ClassPathResource("states.json").getFile();
		Iterator<States> statesIterator = mapper.reader(States.class).readValues(file);
		while (statesIterator.hasNext()) {
			allStates.add(statesIterator.next());
		}
		return allStates;
	}
	
	public String findMatch(List<States> allData, Double longitude, Double latitude) {
		for (States states : allData) {
			List<List<Double>> listOuter = states.getBorder();
			for (int i = 0; i < listOuter.size(); i++) {
				List<Double> listInner = listOuter.get(i);

				if ((listInner.get(0).equals(longitude)) &&
					(listInner.get(1).equals(latitude))) {
				 return "[" + states.getState() + "]";
				 
				}
			}
		}
		return null;
	}

	@Override
	public Collection<States> getAll() {
		return null;
	}

}
