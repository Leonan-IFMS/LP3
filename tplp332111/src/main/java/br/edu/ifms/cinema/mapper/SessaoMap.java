/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.mapper;

import br.edu.ifms.cinema.dto.SessaoRequestDTO;
import br.edu.ifms.cinema.model.Sessao;

/**
 *
 * @author Estudante
 */
public class SessaoMap {
    // mapeia um objeto SessaorequestDTO para um obj Sessao  
    // falta entidade filme
    public static Sessao toSessao(SessaoRequestDTO dto,Filme filme) {
      Sessao sessao = new Sessao();
      sessao.setId(dto.getId());
      sessao.setHorario(dto.getHorario());
      sessao.setFilme(filme);
      return sessao;
    }
    //mapeia um objeto SessaoResponseDTO a partir (from) de um objeto de sessao
    // ou seja mapeia um objeto de sessao para um objeto SessaoResponseDTO
    
    //falta sessaoResponseDTO
    public static SessaoResponseDTO fromSessao(Sessao sessao) {
        return null
    }
}
