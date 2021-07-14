package com.in28minutes.rest.webservices.restfulwebservices.virsioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVirsioningController {
	@GetMapping("/v1/person")
	public PersonV1 person1() {
		return new PersonV1("Bob ,charli");
	}
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 param1() {
		return new PersonV1("Bob ,charli");
	}
	@GetMapping(value="/person/header",headers="x-version=1")
	public PersonV1 header1() {
		return new PersonV1("Bob ,charli");
	}
	@GetMapping("/v2/person")
	public PersonV2 person2() {
		return new PersonV2(new Name("ram","sonti"));
	}
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 param2() {
		return new PersonV2(new Name("ram","sonti"));
	}
	@GetMapping(value="/person/header",headers="x-version=2")
	public PersonV2 header2() {
		return new PersonV2(new Name("ram","sonti"));
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1(("ram1-produces,sonti1-produces"));
	}
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("ram2-produces","sonti2-produces"));
	}
	
}
