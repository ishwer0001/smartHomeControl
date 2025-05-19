package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component("FanBean")
public class Fan implements ApplianceControlStatus {
	
	private int speed;
	
	public Fan() {
		speed = 1;
	}

	public synchronized void setSpeed(Integer speed) {
		this.speed = speed;
		
	}

	@Override
	public synchronized  void turnOn() {
		this.speed = 1;
		
	}

	@Override
	public synchronized void turnOff() {
		this.speed = 0;
		
	}
	
	public Integer getSpeed() {
		return speed;
	}


}
