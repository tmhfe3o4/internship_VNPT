//package com.example.demo.controller;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.demo.exception.PersonNotFoundException;
//import com.example.demo.model.PersonUser;
//
//@RestController
//public class PersonControllerService {
//	// Constant
//	private static final String LOCALHOST = "http://localhost:9090/";
//	@Autowired
//	RestTemplate restTemplate;
//	private static Map<String, PersonUser> personRepo = new HashMap<>();
//	static {
//		for (int i = 0; i <= 9; i++) {
//			PersonUser user = new PersonUser();
//			user.setId("No." + i);
//			user.setName("Name no." + i);
//			user.setAddress("Address no." + i);
//			user.setPhone("Phone no." + i);
//			personRepo.put(user.getId(), user);
//		}
//	}
//
//	// Springboot rest template
//	@RequestMapping(value = "/template/persons")
//	public String getTemplatePerson() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		return restTemplate.exchange(LOCALHOST + "persons", HttpMethod.GET, entity, String.class).getBody();
//	}
//
//	@RequestMapping(value = "/template/persons", method = { RequestMethod.POST })
//	public String createTemplatePerson(@RequestBody PersonUser person) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		return restTemplate.exchange(LOCALHOST + "persons", HttpMethod.POST, entity, String.class).getBody();
//	}
//
//	@RequestMapping(value = "/template/persons/{id}", method = { RequestMethod.DELETE })
//	public String deleteTemplatePerson(@PathVariable("id") String id, @RequestBody PersonUser person) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		return restTemplate.exchange(LOCALHOST + "persons/" + id, HttpMethod.DELETE, entity, String.class).getBody();
//	}
//
//	@RequestMapping(value = "/template/persons/{id}", method = { RequestMethod.PUT })
//	public String updateTemplatePerson(@PathVariable("id") String id, @RequestBody PersonUser person) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		return restTemplate.exchange(LOCALHOST + "persons/" + id, HttpMethod.PUT, entity, String.class).getBody();
//	}
//
//	// Springboot restful
//	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
//		personRepo.remove(id);
//		return new ResponseEntity<>("Person is deleted successsfully", HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Object> updatePerson(@PathVariable("id") String id, @RequestBody PersonUser person) {
//		personRepo.remove(id);
//		person.setId(id);
//		personRepo.put(id, person);
//		return new ResponseEntity<>("Person is updated successsfully", HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/persons/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Object> updatePersons(@PathVariable("id") String id, @RequestBody PersonUser person) {
//		if (!personRepo.containsKey(id))
//			throw new PersonNotFoundException();
//		personRepo.remove(id);
//		person.setId(id);
//		personRepo.put(id, person);
//		return new ResponseEntity<>("Person is updated successfully", HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/persons", method = { RequestMethod.POST })
//	public ResponseEntity<Object> createPerson(@RequestBody PersonUser person) {
//		personRepo.put(person.getId(), person);
//		return new ResponseEntity<>("Person is created successfully", HttpStatus.CREATED);
//	}
//
//	@RequestMapping(value = "/persons")
//	public ResponseEntity<Object> getPerson() {
//		return new ResponseEntity<>(personRepo.values(), HttpStatus.OK);
//	}
//}
