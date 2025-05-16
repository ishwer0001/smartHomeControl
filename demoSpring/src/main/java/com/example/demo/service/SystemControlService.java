package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AirConditioner;
import com.example.demo.model.Fan;
import com.example.demo.model.Light;


@Service
public class SystemControlService {
	
	@Autowired
	Light light;
	
	@Autowired
	AirConditioner ac;
	
	@Autowired
	Fan fan;
	
	public void updateLight(Boolean status) {
		if(status) {
			light.turnOn();	
		}else {
			light.turnOff();	
		}
	}
	public void updateFanSpeed(Integer speed) {
		if(speed >= 0) {
			fan.setSpeed(speed);
		}
	}
	
	public void updateAirConditioner(Boolean status) {
		if(status) {
			ac.turnOn();	
		}else {
			ac.turnOff();	
		}
	}

}
