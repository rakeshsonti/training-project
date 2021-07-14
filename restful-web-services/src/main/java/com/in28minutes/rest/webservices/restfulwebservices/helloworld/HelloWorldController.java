package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;

	// GET
	// URI /hello-world
	// method - "Hello World
//	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path = "/hello-world-internationalization")
//	public String helloWorldInternationalization(@RequestHeader(name = "Accept-Language") Locale locale) {
	public String helloWorldInternationalization() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	// return a bean instead of string
	// return a bean instead of string

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World team");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello Worlds,%s", name));
	}

}
