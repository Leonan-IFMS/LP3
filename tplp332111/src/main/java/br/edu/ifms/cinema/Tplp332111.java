/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifms.cinema;

import br.edu.ifms.cinema.controller.FilmeController;
import br.edu.ifms.cinema.dao.ClienteDAO;
import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.dto.SessaoResponseDTO;
import br.edu.ifms.cinema.model.Cliente;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudante
 */
public class Tplp332111 {

    public static void main(String[] args) {
        FilmeRequestDTO request = new FilmeRequestDTO();
        request.setId(1L);
        request.setTitulo("Efeito Borboleta 5");
        request.setGenero("Suspense");
        request.setDuracaoMinutos(155);
        request.setClassificacao("16");
        
//        SessaoRequestDTO sessao = new SessaoRequestDTO();
//        sessao.setFilme(request);
//        sessao.setHorario(LocalDateTime.of(2025,11,18,15,30));
//        request.getSessoes().add(sessao);
//        
//        SessaoRequestDTO sessao2 = new SessaoRequestDTO();
//        sessao2.setFilme(request);
//        sessao2.setHorario(LocalDateTime.of(2025,11,18,18,50));
//        request.getSessoes().add(sessao2);
        
//        SessaoRequestDTO sessao3 = new SessaoRequestDTO();
//        sessao3.setFilme(request);
//        sessao3.setHorario(LocalDateTime.of(2025,11,18,20,45));
//        request.getSessoes().add(sessao3);     
        
        FilmeController controle = new FilmeController();
        
        FilmeResponseDTO response = controle.update(request);
        if(response.isStatus()){
            JOptionPane.showMessageDialog(null, response.getMessage(),
                    "Cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Filme");
            System.out.println("Id:    " + response.getId());
            System.out.println("Título: " + response.getTitulo());
            System.out.println("Gênero: " + response.getGenero());
            System.out.println("Duração (min.): " + response.getDuracaoMinutos());
            System.out.println("Classificação: " + response.getClassificacao());
            System.out.println("Sessões: ");
            for(SessaoResponseDTO sessaoResp : response.getSessoes()){
                System.out.println("Id: " + sessaoResp.getId());
                System.out.println("Horário: " + sessaoResp.getHorario());
                System.out.println("---------------------------");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, response.getMessage(),
                    "Falha no cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
}