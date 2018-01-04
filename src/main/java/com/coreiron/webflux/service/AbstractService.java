package com.coreiron.webflux.service;

import com.coreiron.webflux.data.repository.BaseRepository;
import org.reactivestreams.Publisher;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Created by ramazan on 03.01.2018
 */
public abstract class AbstractService<Entity,PK> {

    abstract BaseRepository<Entity, PK> getRepository();

    public Flux<Entity> getAll(){
        return getRepository().findAll();
    }
    public  Mono<Entity> add(Entity var1){
        return getRepository().insert(var1);
    }

    public Flux<Entity> addAll(Iterable<Entity> var1)
    {
        return getRepository().saveAll(var1);
    }
    public Flux<Entity> add(Publisher<Entity> var1)
    {
        return getRepository().saveAll(var1);
    }
    public Mono<Entity> getById(PK pk)
    {
        return getRepository().findById(pk);
    }

    public Mono<Entity> getEntity(PK pk)
    {
        Mono<Entity> entityMono = getRepository().findById(pk);
        if(entityMono == null) {
            throw new RuntimeException();
        } else
            return entityMono;
    }

    public  void delete(PK pk){
        getRepository().deleteById(pk);
    }


}
