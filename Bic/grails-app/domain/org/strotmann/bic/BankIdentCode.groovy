package org.strotmann.bic
import grails.rest.*
@Resource(uri='/bic')

class BankIdentCode {
	
	int blz
	String bankname
	int plz
	String ort
	String bic	
	
	
	static mapping = {
		blz column: "blz", index: "blz"
	}
	
}
