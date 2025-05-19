package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StatusRef;
import com.example.demo.model.StatusValue;
import com.example.demo.service.SystemControlService;

@RestController
@RequestMapping("/homeSystemControl")
public class SystemControlController {
	@Autowired
	SystemControlService service;
	
	/**
	 * 
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "light", method = RequestMethod.GET)
	public ResponseEntity<String> getLight(@RequestParam String status) {
		Boolean workingStatus = false;
		if(status.equalsIgnoreCase(StatusValue.ON.value)) {
			workingStatus = true;
		}		
		service.updateLight(workingStatus);

		ResponseEntity<String> res = new ResponseEntity<String>(workingStatus.toString(), HttpStatus.OK);

		return res;
	}

	/**
	 * 
	 * @param speed
	 * @return
	 */
	@RequestMapping(value = "fan", method = RequestMethod.GET)
	public ResponseEntity<String> controlFan(@RequestParam String speed) {
		int speedVal = Integer.valueOf(speed);
		service.updateFanSpeed(speedVal);

		ResponseEntity<String> en = new ResponseEntity<String>(speed, HttpStatus.OK);

		return en;
	}

	/**
	 * 
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "airConditioner", method = RequestMethod.GET)
	public ResponseEntity<String> controlAirConditioner(@RequestParam String status) {
		
		Boolean workingStatus = false;
		if(status.equalsIgnoreCase(StatusValue.ON.value)) {
			workingStatus = true;
		}
		service.updateAirConditioner(workingStatus);
		ResponseEntity<String> en = new ResponseEntity<String>(workingStatus.toString(), HttpStatus.OK);

		return en;
	}
	
	

	@RequestMapping(value = "lightStatus", method = RequestMethod.GET)
	public ResponseEntity<Boolean> getLightStatus() {
	
		boolean status = service.getLightStatus();
		ResponseEntity<Boolean> res = new ResponseEntity<Boolean>(status, HttpStatus.OK);

		return res;
	}


	@RequestMapping(value = "fanStatus", method = RequestMethod.GET)
	public ResponseEntity<Integer> fanStatus() {
		int speed = service.getFanSpeed();

		ResponseEntity<Integer> res = new ResponseEntity<Integer>(speed, HttpStatus.OK);

		return res;
	}


	@RequestMapping(value = "airConditionerStatus", method = RequestMethod.GET)
	public ResponseEntity<Boolean> airConditionerStatus() {
		
		boolean status = service.getAirConditionerStatus();
		ResponseEntity<Boolean> res = new ResponseEntity<Boolean>(status, HttpStatus.OK);

		return res;
	}
}
