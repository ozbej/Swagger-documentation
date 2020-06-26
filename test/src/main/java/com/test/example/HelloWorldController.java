package com.test.example;


import javax.validation.Valid;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
			return String.format("Person: %s %s, %.2f %.2f", person.getName(), person.getLastname(), person.getHeight(), person.getWidth());
	}
	@RequestMapping(value= "/person/list", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public String personList(@Valid @RequestBody Person person) {
			return String.format("Person: %s %s, %.2f %.2f", person.getName(), person.getLastname(), person.getHeight(), person.getWidth());
	}
	@RequestMapping(value= "/person/child1", headers="Accept=application/json", method = RequestMethod.POST)
	@ResponseBody
	public String postChild1(@Valid @RequestBody Child1 person) {
		return String.format("Person: %s %s %s, %.2f %.2f", person.getName(), person.getMiddlename(), person.getLastname(), person.getHeight(), person.getWidth());
	}
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
	    return "Nobody";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String valdiationFail(MethodArgumentNotValidException ex) {
	    return "Validation failed";
	}
}