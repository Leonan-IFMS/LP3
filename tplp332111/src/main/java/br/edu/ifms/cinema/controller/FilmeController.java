/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.mapper.SessaoMap;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author Estudante
 */
public class FilmeController {
    private static GenericDAO filmeDAO;
    
    public FilmeController(){
        filmeDAO = new FilmeDAO();
    }
    
    public FilmeResponseDTO add(FilmeRequestDTO dto){
        FilmeResponseDTO response = new FilmeResponseDTO();
        if(dto != null){
            // um série de validações
            
            if(dto.getId() != null){
                response.setStatus(false);
                response.setMessage("Transação Inválida");
                return response;
            }
             // depois das validações
            Filme filme = new Filme();
            filme.setTitulo(dto.getTitulo());
            filme.setGenero(dto.getGenero());
            filme.setClassificacao(dto.getClassificacao());
            filme.setDuracaoMinutos(dto.getDuracaoMinutos());
            for (SessaoRequestDTO sessaoDTO : dto.getSessoes()) {
                Sessao sessao = SessaoMap.toSessao(sessaoDTO, filme);
                filme.getSessoes().add(sessao);
            }
            filmeDAO.add(filme);
            
            boolean retorno = filmeDAO.add(filme);
            
            response.setId(filme.getId());
            response.setTitulo(filme.getTitulo());
            response.setGenero(filme.getGenero());
            response.setDuracaoMinutos(filme.getDuracaoMinutos());
            response.setClassificacao(filme.getClassificacao());
            for (Sessao sessao : filme.getSessoes()) {
                SessaoResponseDTO sessaoDTO = SessaoMap.fromSessao(sessao, response);
                response.getSessoes().add(sessaoDTO);
            }
            
            if(retorno){
                response.setStatus(true);
                response.setMessage("Filme Cadastrado");
            }else{
                response.setStatus(false);
                response.setMessage("Transação Inválida");
            }
            
            // mapeamento de filme, para FilmeResponseDTO e
            // SessaoResponseDTO
        }
        
        
        return response;
    }
    
    
    public FilmeResponseDTO update(FilmeRequestDTO dto){
        FilmeResponseDTO response = new FilmeResponseDTO();
        if(dto != null){
            // um série de validações
            
            if(dto.getId() == null){
                response.setStatus(false);
                response.setMessage("Transação Inválida");
                return response;
            }
             // depois das validações
            Filme filme = new Filme();
            filme.setId(dto.getId());
            filme.setTitulo(dto.getTitulo());
            filme.setGenero(dto.getGenero());
            filme.setClassificacao(dto.getClassificacao());
            filme.setDuracaoMinutos(dto.getDuracaoMinutos());
            for (SessaoRequestDTO sessaoDTO : dto.getSessoes()) {
                Sessao sessao = new Sessao();
                sessao.setId(sessaoDTO.getId());
                sessao.setHorario(sessaoDTO.getHorario());
                sessao.setFilme(filme);
                filme.getSessoes().add(sessao);
            }
            
            filmeDAO.update(filme);
            
            response.setId(filme.getId());
            response.setTitulo(filme.getTitulo());
            response.setGenero(filme.getGenero());
            response.setDuracaoMinutos(filme.getDuracaoMinutos());
            response.setClassificacao(filme.getClassificacao());
            for (Sessao sessao : filme.getSessoes()) {
                SessaoResponseDTO sessaoDTO = new SessaoResponseDTO();
                sessaoDTO.setId(sessao.getId());
                sessaoDTO.setHorario(sessao.getHorario());
                sessaoDTO.setFilme(response);
                response.getSessoes().add(sessaoDTO);
            }
            
//            if(retorno){
//                response.setStatus(true);
//                response.setMessage("Filme Cadastrado");
//            }else{
//                response.setStatus(false);
//                response.setMessage("Transação Inválida");
//            }
            
            // mapeamento de filme, para FilmeResponseDTO e
            // SessaoResponseDTO
        }
        
        
        return response;
    }
    
}
