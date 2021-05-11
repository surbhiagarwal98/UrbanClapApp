package com.nagarro.Order.exceptions;

/**
 * custom exception
 * 
 * @author surbhiagarwal
 *
 */
@SuppressWarnings("serial")
public class ServiceNotAvailableException extends Exception {

	public ServiceNotAvailableException(String s) {
		super(s);
	}
}
