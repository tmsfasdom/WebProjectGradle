package br.com.tmsfasdom.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.tmsfasdom.modelo.Student;

@WebService(portName = "soap/ServiceSOAPPort", serviceName = "soap/ServiceSOAP", targetNamespace = "http://localhost:8080", endpointInterface = "br.com.tmsfasdom.services.ServiceSOAP")
public class ServiceSOAP extends SpringBeanAutowiringSupport{

	@Autowired
	private StudentService studentService;

	@WebMethod(operationName = "sayHello")
	public String sayHello(String str) {
		String hello = "Ola Mundo";
		return hello;
	}

	@WebMethod(operationName = "somar")
	public Student somar() {
		Student stud = studentService.getStudent(28);
		return stud;
	}

}
