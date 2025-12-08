/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.CartaoFidelidadeRequestDTO;
import br.edu.ifms.cinema.dto.CartaoFidelidadeResponseDTO;
import br.edu.ifms.cinema.model.CartaoFidelidade;
import br.edu.ifms.cinema.model.Cliente;

/**
 *
 * @author Leonan
 */
public class CartaoFidelidadeMap {

    public static CartaoFidelidade toCartao(CartaoFidelidadeRequestDTO dto, Cliente cliente) {
        CartaoFidelidade cartao = new CartaoFidelidade();
        cartao.setId(dto.getId());
        cartao.setPontos(dto.getPontos());
        cartao.setNivel(dto.getNivel());
        cartao.setCliente(cliente);
        return cartao;
    }

    public static CartaoFidelidadeResponseDTO fromCartao(CartaoFidelidade cartao) {
        CartaoFidelidadeResponseDTO dto = new CartaoFidelidadeResponseDTO();
        dto.setId(cartao.getId());
        dto.setPontos(cartao.getPontos());
        dto.setNivel(cartao.getNivel());
        return dto;
    }
}
