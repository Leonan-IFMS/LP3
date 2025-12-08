/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.IngressoRequestDTO;
import br.edu.ifms.cinema.dto.IngressoResponseDTO;
import br.edu.ifms.cinema.model.Cliente;
import br.edu.ifms.cinema.model.Ingresso;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author Leonan
 */
public class IngressoMap {
    public static Ingresso toIngresso(IngressoRequestDTO dto, Cliente cliente) {
        Ingresso ingresso = new Ingresso();
        ingresso.setId(dto.getId());
        ingresso.setCodigo(dto.getCodigo());
        ingresso.setValor(dto.getValor());
        ingresso.setCliente(cliente);


        if (dto.getSessaoId() != null) {
            Sessao sessao = new Sessao();
            sessao.setId(dto.getSessaoId());
            ingresso.setSessao(sessao);
        }

        return ingresso;
    }

    public static IngressoResponseDTO fromIngresso(Ingresso ingresso) {
        IngressoResponseDTO dto = new IngressoResponseDTO();
        dto.setId(ingresso.getId());
        dto.setCodigo(ingresso.getCodigo());
        dto.setValor(ingresso.getValor());
        return dto;
    }
}
