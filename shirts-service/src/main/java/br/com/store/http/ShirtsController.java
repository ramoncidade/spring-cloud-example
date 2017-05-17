package br.com.store.http;

import br.com.store.entities.Shirt;
import br.com.store.gateways.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ramon.cidade on 11/05/2017.
 */
@RestController
@RequestMapping("/shirt")
public class ShirtsController{

    @Autowired
    ShirtRepository repository;

    @GetMapping("/{id}")
    public Shirt byId(@PathVariable String id){
        return repository.findOne(id);
    }

    @GetMapping("/")
    public Iterable<Shirt> all(){
        return repository.findAll();
    }
}
