package com.yaz;

public class HesapNotFoundException extends RuntimeException {

	public HesapNotFoundException() {
		
	}

	public HesapNotFoundException(String message) {
		super(message);
	}

	public HesapNotFoundException(Throwable cause) {
		super(cause);
	}

	public HesapNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public HesapNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
