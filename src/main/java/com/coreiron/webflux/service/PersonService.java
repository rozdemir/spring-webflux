package com.coreiron.webflux.service;

import com.coreiron.webflux.data.entity.Person;
import com.coreiron.webflux.data.repository.BaseRepository;
import com.coreiron.webflux.data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * Created by ramazan on 03.01.2018
 */
@Service
public class PersonService extends AbstractService<Person, String>{

    @Autowired
    private PersonRepository personRepository;

    @Override
    BaseRepository<Person, String> getRepository() {
        return personRepository;
    }

    public Flux<Person> getByName(String name)
    {
        return personRepository.findByName(name);
    }
}
