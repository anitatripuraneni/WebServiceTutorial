package com.java.webservices.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
 
	private String errorMessage;
	private int errorCode;
	private String docs;
	public ErrorMessage() {
		
	}
	public ErrorMessage(String errorMessage, int errorCode, String docs) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.docs = docs;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocs() {
		return docs;
	}
	public void setDocs(String docs) {
		this.docs = docs;
	}
	
}
