/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifms.cinema;

import br.edu.ifms.cinema.controller.ClienteController;
import br.edu.ifms.cinema.controller.FilmeController;
import br.edu.ifms.cinema.dto.CartaoFidelidadeRequestDTO;
import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.dto.FilmeRequestDTO;
import br.edu.ifms.cinema.dto.FilmeResponseDTO;
import br.edu.ifms.cinema.dto.IngressoRequestDTO;
import br.edu.ifms.cinema.dto.SalaRequestDTO;
import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import java.time.LocalDateTime;

/**
 *
 * @author Estudante
 */
public class Tplp332111 {

    public static void main(String[] args) {
        SalaRequestDTO salaDTO = new SalaRequestDTO();
        salaDTO.setNome("Sala 1");
        salaDTO.setCapacidade(50);

        FilmeRequestDTO filmeDTO = new FilmeRequestDTO();
        filmeDTO.setTitulo("Wall-e");
        filmeDTO.setGenero("Animação");
        filmeDTO.setDuracaoMinutos(120);
        filmeDTO.setClassificacao("10");

        SessaoRequestDTO sessaoDTO = new SessaoRequestDTO();
        sessaoDTO.setFilme(filmeDTO);
        sessaoDTO.setSala(salaDTO);
        sessaoDTO.setHorario(LocalDateTime.of(2025, 11, 18, 14, 30));

        filmeDTO.getSessoes().add(sessaoDTO);

        FilmeController fc = new FilmeController();
        FilmeResponseDTO fr = fc.add(filmeDTO);

        System.out.println("Filme Status: " + fr.getMessage());

        Long idSessao = fr.getSessoes().get(0).getId();

        ClienteRequestDTO clienteDTO = new ClienteRequestDTO();
        clienteDTO.setNome("Leonan");
        clienteDTO.setEmail("Leonan@gmail.com");
        clienteDTO.setTelefone("9999-9999");

        CartaoFidelidadeRequestDTO cartao = new CartaoFidelidadeRequestDTO();
        cartao.setNivel("Ouro");
        cartao.setPontos(50);
        clienteDTO.setCartaoFidelidade(cartao);

        IngressoRequestDTO ingresso = new IngressoRequestDTO();
        ingresso.setCodigo("1234");
        ingresso.setValor(20.00);
        ingresso.setSessaoId(idSessao);

        clienteDTO.getIngressos().add(ingresso);

        ClienteController cc = new ClienteController();
        ClienteResponseDTO cr = cc.add(clienteDTO);

        System.out.println("Cliente Status: " + cr.getMessage());

//        FilmeRequestDTO request = new FilmeRequestDTO();
//        request.setTitulo("Efeito borboleta");
//        request.setGenero("Suspense");
//        request.setDuracaoMinutos(148);
//        request.setClassificacao("16");
//        
//        SessaoRequestDTO sessao = new SessaoRequestDTO();
//        sessao.setFilme(request);
//        sessao.setHorario(LocalDateTime.of(2025,11,18,14,30));
//        request.getSessoes().add(sessao);
//        
//        SessaoRequestDTO sessao2 = new SessaoRequestDTO();
//        sessao2.setFilme(request);
//        sessao2.setHorario(LocalDateTime.of(2025,11,18,17,00));
//        request.getSessoes().add(sessao2);
//        
//        SessaoRequestDTO sessao3 = new SessaoRequestDTO();
//        sessao3.setFilme(request);
//        sessao3.setHorario(LocalDateTime.of(2025,11,18,20,45));
//        request.getSessoes().add(sessao3);
//        
//        FilmeController controle = new FilmeController();
//        FilmeResponseDTO response = controle.add(request);
//        
//        System.out.println(response.getMessage());
    }
}
