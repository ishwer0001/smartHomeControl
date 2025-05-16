package com.example.demo.model;

public enum StatusValue {
	ON("on"),OFF("off");

	public final String value;
	StatusValue(String status) {
		this.value = status;
	}
}
