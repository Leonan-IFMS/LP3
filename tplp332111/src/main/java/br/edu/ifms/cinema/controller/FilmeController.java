/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author Estudante
 */
public class FilmeController {
    private static GenericDAO filmeDAO;
    
    public FilmeResponseDTO add(FilmeRequestDTO dto) {
        FilmeResponseDTO response = new FilmeResponseDTO();
        if(dto != null){
            
            // uma serie de validaçoes
            if (dto.getId() != null) {
                response.setStatus(false);
                response.setMessage("Transaçao invalida");
                return response;
            }
            
            // depois das validaçoes
            Filme filme = new Filme();
            filme.setTitulo(dto.getTitulo());
            filme.setGenero(dto.getGenero());
            filme.setClassificacao(dto.getClassificacao());
            filme.setDuracaoMinutos(dto.getDuracaoMinutos());
            filme.setDuracaoMinutos(dto.getDuracaoMinutos());
            for (SessaoRequestDTO sessaoDTO : dto.getSessoes()) {
                Sessao sessao = new Sessao();
                sessao.setId(sessaoDTO.getId());
                sessao.setHorario(sessaoDTO.getHorario);
                //sessao.setFilme(sessaoDTO.getIdFilme());  
            }
            filmeDAO = new FilmeDAO();
            filmeDAO.add(filme);
            // mapeamento de filme, para filmeResponseDTO e
            // SessaoResponseDTO
            response.setStatus(true);
            response.setMessage("Filme cadastrado");
        }

        
        
        return response;
    }
}
