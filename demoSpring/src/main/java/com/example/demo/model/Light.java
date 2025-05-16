package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("LightBean")
public class Light implements ApplianceControlStatus{
	
	private boolean isOn;
	
	public Light() {
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
