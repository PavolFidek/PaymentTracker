package com.example.mmdb.movie;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mmdb", type = "movie")
public class Movie {

	@Id
	private String id;

	private String title;

	private String notes;

	private int year;

	private String key;

	private String director;

	private String cast;

	private String genre;

	public String getId() {
		return id;
	}

	public Movie setId(String id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Movie setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Movie setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public int getYear() {
		return year;
	}

	public Movie setYear(int year) {
		this.year = year;
		return this;
	}

	public String getKey() {
		return key;
	}

	public Movie setKey(String key) {
		this.key = key;
		return this;
	}

	public String getDirector() {
		return director;
	}

	public Movie setDirector(String director) {
		this.director = director;
		return this;
	}

	public String getCast() {
		return cast;
	}

	public Movie setCast(String cast) {
		this.cast = cast;
		return this;
	}

	public String getGenre() {
		return genre;
	}

	public Movie setGenre(String genre) {
		this.genre = genre;
		return this;
	}
}
