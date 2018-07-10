package com.yaz;

public class KampanyaNotFoundException extends RuntimeException {

	public KampanyaNotFoundException() {
		
	}

	public KampanyaNotFoundException(String message) {
		super(message);
	}

	public KampanyaNotFoundException(Throwable cause) {
		super(cause);
	}

	public KampanyaNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public KampanyaNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
