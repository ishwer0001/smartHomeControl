package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("AirConditionerBean")
public class AirConditioner implements ApplianceControlStatus{
	
	private boolean isOn;
	
	public AirConditioner() {
		isOn = false;
	}

	@Override
	public synchronized void turnOn() {
		this.isOn = true;
		
	}

	@Override
	public synchronized void turnOff() {
		this.isOn = false;
		
	}
	
	public boolean getStatus() {
		return isOn;
	}

}
