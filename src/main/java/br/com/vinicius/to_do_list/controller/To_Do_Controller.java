//PORTA DE ENTRADA DO SISTEMA.
//Comunicação externa.
//Chamada de métodos do serviço.
//Retorno de dados para o cliente (API).

package br.com.vinicius.to_do_list.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.vinicius.to_do_list.entity.To_Do;
import br.com.vinicius.to_do_list.services.To_Do_Service;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/to_dos")
public class To_Do_Controller {

    private To_Do_Service to_do_service;

    
    public To_Do_Controller(To_Do_Service to_do_service) {
        this.to_do_service = to_do_service;
    }


    @PostMapping
    List<To_Do> create(@RequestBody @Valid To_Do to_do) {
        return to_do_service.create(to_do);
    }

    @GetMapping
    List<To_Do> list() {
        return to_do_service.list();
    }
    
    @PutMapping
    List<To_Do> update(@RequestBody To_Do to_do) {
        return to_do_service.update(to_do);
    }
    
    @DeleteMapping("/{id}")
    List<To_Do> delete(@PathVariable Long id) {
        return to_do_service.delete(id);
    }
}
