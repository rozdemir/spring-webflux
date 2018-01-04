package com.coreiron.webflux.controller;

import com.coreiron.webflux.data.entity.Person;
import com.coreiron.webflux.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public Flux<Person> all() {
        return personService.getAll();
    }

    @PostMapping(value = "")
    public Mono<Person> add(@RequestBody @Valid Person person) {
        return personService.add(person);
    }
    @GetMapping(value = "/{id}")
    public Mono<Person> get(@PathVariable(value = "id") String  id) {
        return personService.getById(id);
    }
    @GetMapping(value = "/search")
    public Flux<Person> getByName(@RequestParam(value = "name") String  name) {
        return personService.getByName(name);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") String  id) {
        personService.delete(id);
    }

}