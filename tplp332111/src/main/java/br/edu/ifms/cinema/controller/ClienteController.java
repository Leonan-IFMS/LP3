/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.controller;

import br.edu.ifms.cinema.dao.ClienteDAO;
import br.edu.ifms.cinema.dao.GenericDAO;
import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.dto.IngressoRequestDTO;
import br.edu.ifms.cinema.mapper.CartaoFidelidadeMap;
import br.edu.ifms.cinema.mapper.ClienteMap;
import br.edu.ifms.cinema.mapper.IngressoMap;
import br.edu.ifms.cinema.model.CartaoFidelidade;
import br.edu.ifms.cinema.model.Cliente;
import br.edu.ifms.cinema.model.Ingresso;

/**
 *
 * @author Leonan
 */
public class ClienteController {

    private GenericDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public ClienteResponseDTO add(ClienteRequestDTO dto) {
        ClienteResponseDTO response = new ClienteResponseDTO();

        if (dto != null) {
            Cliente cliente = ClienteMap.toCliente(dto);
            if (dto.getCartaoFidelidade() != null) {
                CartaoFidelidade cartao = CartaoFidelidadeMap.toCartao(dto.getCartaoFidelidade(), cliente);
                cliente.setCartaoFidelidade(cartao);
            }

            if (dto.getIngressos() != null && !dto.getIngressos().isEmpty()) {
                for (IngressoRequestDTO ingressoDto : dto.getIngressos()) {
                    Ingresso ingresso = IngressoMap.toIngresso(ingressoDto, cliente);
                    cliente.getIngressos().add(ingresso);
                }
            }

            try {
                if (clienteDAO.add(cliente)) {
                    response = ClienteMap.fromCliente(cliente);
                    response.setStatus(true);
                    response.setMessage("Cliente cadastrado com sucesso!");
                } else {
                    response.setStatus(false);
                    response.setMessage("Erro ao salvar no banco.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(false);
                response.setMessage("Erro: " + e.getMessage());
            }
        }
        return response;
    }
}
