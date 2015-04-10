package org.strotmann.bic
import grails.rest.*
import grails.converters.JSON

class BankIdentCodeController extends RestfulController {
	
	static responseFormats = ['json', 'xml']
	BankIdentCodeController() {
		super(BankIdentCode)
	}
	//localhost:8080/Bic/bankIdentCode/get?bic=333
	def get(){
		def entry = params.find{ k, v -> BankIdentCode.metaClass.hasMetaProperty k }
		if( entry ) {
		  if (entry.key == 'id')
		  	entry.value = entry.value.toLong()	
		  if (entry.key == 'blz' || entry.key == 'plz')
			entry.value = entry.value.toInteger()
			
		  render (BankIdentCode.withCriteria() { eq (entry.key, entry.value) } as JSON)
		}
		 else
		  render text:'not found!'
	}
}
