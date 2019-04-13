package com.example.mmdb.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/movies")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Movie> listMovies(@RequestParam(required = false, defaultValue = "0") Integer page,
								  @RequestParam(required = false, defaultValue = "10") Integer size) {
		return movieService.listMovies(PageRequest.of(page, size)).getContent();
	}

	@GetMapping("/search/{searchTerm}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Movie> search(@PathVariable String searchTerm,
							  @RequestParam(required = false, defaultValue = "0") Integer page,
							  @RequestParam(required = false, defaultValue = "10") Integer size) {
		return movieService.fullTextSearch(searchTerm, PageRequest.of(page, size)).getContent();
	}

}
