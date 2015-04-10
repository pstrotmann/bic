package org.strotmann.bic
import grails.plugins.rest.client.*

class BicClientController {

    def index() { 
		def RestBuilder rest = new RestBuilder()
		def RestResponse resp = rest.get("http://31.7.177.152:8080/Bic-0.1/bankIdentCode/get?blz=44010046")
		String responseString = resp.getJson().getAt("bic")
		//responseString = responseString.replace('{', '')
		//responseString = responseString.replace('}', '')
		render ("<p>"+responseString+"</p>")
	}
}
