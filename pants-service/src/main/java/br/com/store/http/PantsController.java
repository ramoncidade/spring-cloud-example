package br.com.store.http;

import br.com.store.entities.Pants;
import br.com.store.gateways.repository.PantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ramon.cidade on 11/05/2017.
 */
@RestController
@RequestMapping("/pants")
public class PantsController{

    @Autowired
    PantsRepository repository;

    @GetMapping("/{id}")
    public Pants byId(@PathVariable String id){
        return repository.findOne(id);
    }

    @GetMapping("/")
    public Iterable<Pants> all(){
        return repository.findAll();
    }
}
