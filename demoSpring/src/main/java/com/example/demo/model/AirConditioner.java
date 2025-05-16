package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("AirConditionerBean")
public class AirConditioner implements ApplianceControlStatus{
	
	private boolean isOn;
	
	public AirConditioner() {
		isOn = false;
	}

	@Override
	public void turnOn() {
		this.isOn = true;
		
	}

	@Override
	public void turnOff() {
		this.isOn = false;
		
	}

}
