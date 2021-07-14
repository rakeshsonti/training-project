package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	@GetMapping("/filtering")
public MappingJacksonValue retreiveSomeBean() {
	SomeBean someBean= new SomeBean("value1","value2","value3");
	
	SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","filter2");
	FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	MappingJacksonValue mapping=new MappingJacksonValue(someBean);
	mapping.setFilters(filters);
	return mapping;
	}


}
