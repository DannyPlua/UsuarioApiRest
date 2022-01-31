package com.usuario.api.model.util;

import java.io.Serializable;
import java.util.List;
import com.usuario.api.model.util.Error;


public class Response implements Serializable  {

private static final long serialVersionUID = 1L;
	
	private boolean success;
	private Error error;
	int count;
	private List<?> data;

	public Response() {

	}

	public Response(boolean success, Error error, int count, List<?> data) {
		this.success = success;
		this.error = error;
		this.count = count;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
