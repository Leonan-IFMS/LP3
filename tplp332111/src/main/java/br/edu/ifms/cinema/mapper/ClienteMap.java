package br.edu.ifms.cinema.mapper;


import br.edu.ifms.cinema.dto.ClienteRequestDTO;
import br.edu.ifms.cinema.dto.ClienteResponseDTO;
import br.edu.ifms.cinema.dto.IngressoResponseDTO;
import br.edu.ifms.cinema.model.Cliente;
import br.edu.ifms.cinema.model.Ingresso;
import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonan
 */
public class ClienteMap {

    public static Cliente toCliente(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        return cliente;
    }

    public static ClienteResponseDTO fromCliente(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setTelefone(cliente.getTelefone());
        
        if (cliente.getCartaoFidelidade() != null) {
            dto.setCartaoFidelidade(CartaoFidelidadeMap.fromCartao(cliente.getCartaoFidelidade()));
        }

        List<IngressoResponseDTO> ingressosResponse = new LinkedList<>();
        if (cliente.getIngressos() != null) {
            for (Ingresso ingresso : cliente.getIngressos()) {
                ingressosResponse.add(IngressoMap.fromIngresso(ingresso));
            }
        }
        dto.setIngressos(ingressosResponse);
        return dto;
    }
}
