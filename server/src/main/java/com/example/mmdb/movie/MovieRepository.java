package com.example.mmdb.movie;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

}
