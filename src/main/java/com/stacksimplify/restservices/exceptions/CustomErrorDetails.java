package com.stacksimplify.restservices.exceptions;

import java.util.Date;

// Simple custom error details bean
public class CustomErrorDetails {

	private Date timedtamp;
	private String message;
	private String errordetails;
	
	public CustomErrorDetails(Date timedtamp, String message, String errordetails) {
		super();
		this.timedtamp = timedtamp;
		this.message = message;
		this.errordetails = errordetails;
	}

	public Date getTimedtamp() {
		return timedtamp;
	}

	public void setTimedtamp(Date timedtamp) {
		this.timedtamp = timedtamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrordetails() {
		return errordetails;
	}

	public void setErrordetails(String errordetails) {
		this.errordetails = errordetails;
	}
	
}
