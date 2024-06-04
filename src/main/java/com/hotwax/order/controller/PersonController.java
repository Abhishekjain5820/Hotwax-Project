package com.hotwax.order.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotwax.order.entities.PersonEntity;
import com.hotwax.order.exception.ServiceException;
import com.hotwax.order.model.ApiResponse;
import com.hotwax.order.model.Person;
import com.hotwax.order.model.ServiceResponse;
import com.hotwax.order.services.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping
	public ResponseEntity<ApiResponse> getAllPersons() throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<List<Person>> serviceResponse = personService.getAllPersons();
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getPersonById(@PathVariable String id) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Person> serviceResponse = personService.getPersonById(id);
		return prepareResponse(serviceResponse, startApiDateTime);

	}

	@PostMapping
	public ResponseEntity<ApiResponse> createPerson(@RequestBody Person person) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Person> serviceResponse = personService.savePerson(person);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updatePerson(@PathVariable String id, @RequestBody Person personDetails)
			throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Person> serviceResponse = personService.updatePersonById(id, personDetails);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletePerson(@PathVariable String id) throws ServiceException {
		LocalDateTime startApiDateTime = LocalDateTime.now();
		ServiceResponse<Person> serviceResponse = personService.deletePerson(id);
		return prepareResponse(serviceResponse, startApiDateTime);
	}

	private ResponseEntity<ApiResponse> prepareResponse(ServiceResponse<?> serviceResponse,
			LocalDateTime startApiDateTime) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStartDateTime(startApiDateTime);
		apiResponse.setBody(serviceResponse.getBody());
		apiResponse.setMessage(serviceResponse.getMessage());
		apiResponse.setEndDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatusCode.valueOf(serviceResponse.getCode())).body(apiResponse);
	}
}
