package com.usuario.api.model.util;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Error implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int status;
	private String errorCode;
	private String userMessage;

	public Error() {

	}

	public Error(int status, String errorCode, String userMessage) {
		this.status = status;
		this.errorCode = errorCode;
		this.userMessage = userMessage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
}
