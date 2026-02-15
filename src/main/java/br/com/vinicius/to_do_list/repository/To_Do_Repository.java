//COMUNICAÇÃO COM O BANCO DE DADOS
//Salva, busca e deleta.

package br.com.vinicius.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.vinicius.to_do_list.entity.To_Do;


public interface To_Do_Repository extends JpaRepository<To_Do, Long> { }
