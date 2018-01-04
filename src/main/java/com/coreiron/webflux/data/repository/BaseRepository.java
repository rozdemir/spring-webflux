package com.coreiron.webflux.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<Entity, PK> extends ReactiveMongoRepository<Entity, PK> {
}
