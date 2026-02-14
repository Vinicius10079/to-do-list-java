package br.com.vinicius.to_do_list.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.vinicius.to_do_list.entity.To_Do;
import br.com.vinicius.to_do_list.repository.To_Do_Repository;

@Service
public class To_Do_Service {

    private To_Do_Repository to_do_repository;


    public To_Do_Service(To_Do_Repository to_do_repository) {
        this.to_do_repository = to_do_repository;
    }


    public List<To_Do> create(To_Do to_do){
        to_do_repository.save(to_do);

        return list();
    }

    public List<To_Do> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );

        return to_do_repository.findAll(sort);
    }

    public List<To_Do> update(To_Do to_do){
        to_do_repository.save(to_do);
        return list();

    }

    public List<To_Do> delete(Long id){
        to_do_repository.deleteById(id);
        return list();
    }
}
