/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifms.cinema;

import br.edu.ifms.cinema.dao.FilmeDAO;
import br.edu.ifms.cinema.model.Filme;
import br.edu.ifms.cinema.model.Sessao;
import java.time.LocalDateTime;

/**
 *
 * @author Estudante
 */
public class Tplp332111 {

    public static void main(String[] args) {
        Filme f1 = new Filme();
        Filme f2 = new Filme();
        Filme f3 = new Filme();
        f1.setTitulo("O Quarteto Fantastico");
        f1.setGenero("Açao");
        f1.setDuracaoMinutos(140);
        f1.setClassificacao("14");
        f2.setTitulo("Divertidamente");
        f2.setGenero("Animaçao");
        f2.setDuracaoMinutos(180);
        f2.setClassificacao("Livre");
        f3.setTitulo("Walle");
        f3.setGenero("Animaçao");
        f3.setDuracaoMinutos(180);
        f3.setClassificacao("Livre");
        Sessao s1 = new Sessao();
        Sessao s2 = new Sessao();
        Sessao s3 = new Sessao();
        Sessao s4 = new Sessao();
        s1.setHorario(LocalDateTime.of(2025,11,11,14,00));
        s1.setFilme(f2);
        s2.setHorario(LocalDateTime.of(2025,11,11,19,00));
        s2.setFilme(f3);
        s3.setHorario(LocalDateTime.of(2025,11,11,22,00));
        s3.setFilme(f3);
        s4.setHorario(LocalDateTime.of(2025,11,12,16,30));
        s4.setFilme(f1);
        f1.getSessoes().add(s4);
        f2.getSessoes().add(s1);
        f3.getSessoes().add(s2);
        f3.getSessoes().add(s3);
        FilmeDAO fdao= new FilmeDAO();
        fdao.add(f1);
        fdao.add(f2);
        fdao.add(f3);
       
    }
}
