package br.com.tmsfasdom.services;

import javax.jws.WebService;

@WebService(
        portName = "ServiceSOAPPort",
        serviceName = "ServiceSOAP",
        targetNamespace = "http://tmsfasdom.com.br/",
        endpointInterface = "br.com.tmsfasdom.services.ServiceSOAP")
public class ServiceSOAP {

	public String sayHello(String str) {
		String hello = "Ola Mundo";
		return hello;
	}

	public int somar(int a, int b) {
		return a + b;
	}

}
