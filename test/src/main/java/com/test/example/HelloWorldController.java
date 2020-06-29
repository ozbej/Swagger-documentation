package com.test.example;


import java.util.List;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 *
 * @author manoj.bardhan
 *
 */
@EnableAutoConfiguration
@RestController 
@RequestMapping("/hello")
public class HelloWorldController {	
	/*@RequestMapping("/{name}")
	@ResponseBody
	public String sayHelloPath(@PathVariable("name") String name) {
		return "Hello " + name + "!!!";
	} */
	
	@RequestMapping(value= "", method = RequestMethod.GET)
	@ResponseBody
	public String sayHelloGet(
			@RequestParam(value = "name") String name) {
		return "Hello " + name + " from GET!!!";
	}
	
	@RequestMapping(value= "", method = RequestMethod.POST)
	@ResponseBody
	public String sayHelloPost(@RequestParam(value = "name") String name) {
		return "Hello " + name + " from POST!!!";
	}
	
	@RequestMapping(value= "", method = RequestMethod.PUT)
	@ResponseBody
	public String sayHelloPut(@RequestParam(value = "name") String name) {
		return "Hello " + name + " from PUT!!!";
	}
	
	@RequestMapping(value= "/test", method = RequestMethod.GET)
	@ResponseBody
	public String sayHelloGetTest(@RequestParam(value = "name") String name) {
		return "TTTTEEEEEEESTT";
	}
	
	/*@RequestMapping(value= "/person", method = RequestMethod.POST)
	@ResponseBody
	public String postPerson(@RequestParam String name, @RequestParam String lastname) {
		return String.format("Person is: %s %s.", name, lastname);
	} */
	
	/*@RequestMapping(value= "/person", method = RequestMethod.POST)
	@ResponseBody
	public String postPerson(@RequestParam String name, @RequestParam String lastname, @RequestParam double height, @RequestParam Double width) {
		Person person = new Person(name, lastname);
		return String.format("Person is: %s.", person.getPerson());
	} */
	@Operation(summary = "Print out a person")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Success", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Person.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid parameters", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Invalid parameters", 
	    content = @Content) })
	@RequestMapping(value= "/person", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public String postPerson(@Valid @RequestBody Person person) {
			return String.format("Person: %s %s, %.2f %.2f", person.getName(), person.getLastname(), person.getHeight(), person.getWeight());
	}
	@RequestMapping(value= "/person/list", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public List<String> personList(@RequestBody PersonWrapper wrapper) {
		List<String> response = new ArrayList<String>();
        for (PersonForList person: wrapper.getPersons()){
        	response.add("Saved person: " + person.getName());
        }
        return response;
	}
	@RequestMapping(value= "/person/child1", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public String postChild1(@Valid @RequestBody Child1 person) {
		return String.format("Person: %s %s %s, %.2f %.2f", person.getName(), person.getMiddlename(), person.getLastname(), person.getHeight(), person.getWeight());
	}
	
	/*@GetMapping(value= "/vehicle")
	public List<Person> findVehicles(@RequestParam("type") String type) {
        return new ArrayList<Person>();
    }*/
	
	@RequestMapping(
	         value="/listperson", 
	         method=RequestMethod.POST,
	         consumes="application/json",
	         produces="application/json")
	@ResponseBody
	public List<ListedPerson> savePerson(@RequestBody ListedPerson[] personArray) {
	    List<ListedPerson> response = new ArrayList<ListedPerson>();
	    for (ListedPerson person: personArray) {
	        response.add(person);
	    }
	    return response;
	}
	

	@RequestMapping(value = "/zoo", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public String zoo(@Valid @RequestBody Zoo animal) {
    	return "ZOO";
    }
	
	/*@RequestMapping(value = "/zoo/dog", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public String dog(@Valid @RequestBody Dog animal) {
    	return "DOG";
    }
	
	@RequestMapping(value = "/zoo/cat", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public String cat(@Valid @RequestBody Cat animal) {
    	return "cat";
    }
	 */
}