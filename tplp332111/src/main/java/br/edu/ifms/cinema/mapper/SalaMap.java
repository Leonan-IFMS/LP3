/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.SalaRequestDTO;
import br.edu.ifms.cinema.dto.SalaResponseDTO;
import br.edu.ifms.cinema.model.Sala;

/**
 *
 * @author Leonan
 */
public class SalaMap {
    public static Sala toSala(SalaRequestDTO dto) {
        Sala sala = new Sala();
        sala.setId(dto.getId());
        sala.setNome(dto.getNome());
        sala.setCapacidade(dto.getCapacidade());
        return sala;
    }

    public static SalaResponseDTO fromSala(Sala sala) {
        SalaResponseDTO dto = new SalaResponseDTO();
        dto.setId(sala.getId());
        dto.setNome(sala.getNome());
        dto.setCapacidade(sala.getCapacidade());
        return dto;
    }
}
