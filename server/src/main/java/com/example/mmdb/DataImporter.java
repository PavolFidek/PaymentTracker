package com.example.mmdb;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.List;

import com.example.mmdb.movie.Movie;
import com.example.mmdb.movie.MovieRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DataImporter {

	private static final Logger log = LoggerFactory.getLogger(DataImporter.class);

	private final MovieRepository movieRepository;
	private final ObjectMapper objectMapper;

	public DataImporter(MovieRepository movieRepository, ObjectMapper objectMapper) {
		this.movieRepository = movieRepository;
		this.objectMapper = objectMapper;
	}

	@PostConstruct
	public void init() {
		Page<Movie> page = movieRepository.findAll(PageRequest.of(0, 1));
		if (page.getTotalElements() > 0) {
			log.info("Skipping data import");
			return;
		}
		log.info("Importing data.");
		List<Movie> movies = loadMoviesFromFile();
		log.info("Movies found: {}", movies.size());
		movies.stream().forEach((m) -> movieRepository.save(m));
		log.info("Import finished.");
	}

	private List<Movie> loadMoviesFromFile() {
		try {
			String content = IOUtils.toString(new ClassPathResource("/movies.json").getInputStream());
			return objectMapper.readValue(content, new TypeReference<List<Movie>>() {});
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

}


