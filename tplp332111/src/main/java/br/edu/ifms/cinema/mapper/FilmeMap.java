/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Estudante
 */
public class FilmeMap {
    public static Filme toFilme(FilmeRequestDTO dto) {
        Filme filme = new Filme();
        filme.setId(dto.getId());
        filme.setTitulo(dto.getTitulo());
        filme.setGenero(dto.getGenero());
        filme.setDuracaoMinutos(dto.getDuracaoMinutos());
        filme.setClassificacao(dto.getClassificacao());
        return filme;  
    }
    
    public static FilmeResponseDTO fromFilme(Filme filme) {
        FilmeResponseDTO response = new FilmeResponseDTO();
        response.setId(filme.getId());
        response.setTitulo(filme.getTitulo());
        response.setGenero(filme.getGenero());
        response.setDuracaoMinutos(filme.getDuracaoMinutos());
        response.setClassificacao(filme.getClassificacao());
        
        List<SessaoResponseDTO> sessoesResponse = new LinkedList<>();
        if (filme.getSessoes() != null) {
            for (Sessao sessao : filme.getSessoes()) {
                sessoesResponse.add(SessaoMap.fromSessao(sessao, null));
            }
        }
        response.setSessoes(sessoesResponse);
        return response;
    }
}
