package com.zensar.poc.exceptions;

public class InvalidBookException extends Exception {
	
	private String msg ;
	public InvalidBookException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return msg+super.toString();
	}

}
