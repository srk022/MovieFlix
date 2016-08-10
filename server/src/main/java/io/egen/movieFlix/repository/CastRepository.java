package io.egen.movieFlix.repository;

import java.util.List;

import io.egen.movieFlix.entity.Cast;

public interface CastRepository {
	public void createCast(List<Cast> movieCast);
}
