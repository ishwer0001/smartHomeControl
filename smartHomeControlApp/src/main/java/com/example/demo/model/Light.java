package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("LightBean")
public class Light implements ApplianceControlStatus{
	
	private boolean isOn;
	
	public Light() {
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
