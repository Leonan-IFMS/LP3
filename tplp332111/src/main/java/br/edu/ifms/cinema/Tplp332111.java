/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifms.cinema;

import br.edu.ifms.cinema.controller.FilmeController;
import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;
import java.time.LocalDateTime;

/**
 *
 * @author Estudante
 */
public class Tplp332111 {

    public static void main(String[] args) {
        FilmeRequestDTO request = new FilmeRequestDTO();
        request.setTitulo("Efeito borboleta");
        request.setGenero("Suspense");
        request.setDuracaoMinutos(148);
        request.setClassificacao("16");
        
        SessaoRequestDTO sessao = new SessaoRequestDTO();
        sessao.setFilme(request);
        sessao.setHorario(LocalDateTime.of(2025,11,18,14,30));
        request.getSessoes().add(sessao);
        
        SessaoRequestDTO sessao2 = new SessaoRequestDTO();
        sessao2.setFilme(request);
        sessao2.setHorario(LocalDateTime.of(2025,11,18,17,00));
        request.getSessoes().add(sessao2);
        
        SessaoRequestDTO sessao3 = new SessaoRequestDTO();
        sessao3.setFilme(request);
        sessao3.setHorario(LocalDateTime.of(2025,11,18,20,45));
        request.getSessoes().add(sessao3);
        
        FilmeController controle = new FilmeController();
        FilmeResponseDTO response = controle.add(request);
        
        System.out.println(response.getMessage());
    }
}
