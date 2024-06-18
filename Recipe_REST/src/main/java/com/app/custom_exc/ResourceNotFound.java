package com.app.custom_exc;

public class ResourceNotFound  extends RuntimeException{
	public ResourceNotFound(String message) {
		super(message);
	}

}
