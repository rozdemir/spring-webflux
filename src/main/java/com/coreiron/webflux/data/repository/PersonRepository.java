package com.coreiron.webflux.data.repository;

import com.coreiron.webflux.data.entity.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public interface PersonRepository extends BaseRepository<Person, String>{

    Flux<Person> findByName(String name);
}
