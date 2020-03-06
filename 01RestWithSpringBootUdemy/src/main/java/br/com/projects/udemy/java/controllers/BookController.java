package br.com.projects.udemy.java.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.udemy.java.data.vo.v1.BookVO;
import br.com.projects.udemy.java.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Book endpoint", description = "API BOOK", tags = {"BookEndpoint"})
@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() {
		List<BookVO> persons = service.findAll();
		persons.stream().forEach( p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}	
	
	@ApiOperation(value = "busca de book por id")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id) {		
		BookVO personVO = service.findById(id);
		personVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel()); 
		return personVO;
	}	
	
	@PostMapping(produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO create(@RequestBody BookVO person) {
		BookVO personVO = service.create(person);
		personVO.add(linkTo(methodOn(BookController.class).findById(person.getKey())).withSelfRel()); 
		return personVO;
	}
	
	@PutMapping(produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO update(@RequestBody BookVO person) {
		BookVO personVO = service.create(person);
		personVO.add(linkTo(methodOn(BookController.class).findById(person.getKey())).withSelfRel()); 
		return personVO;
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}