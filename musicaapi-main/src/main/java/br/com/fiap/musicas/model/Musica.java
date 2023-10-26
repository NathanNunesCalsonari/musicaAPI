package br.com.fiap.musicas.model;

public record Musica(
		int id,
		String nomeDaMusica,
		String banda,
		String album
	) {}
