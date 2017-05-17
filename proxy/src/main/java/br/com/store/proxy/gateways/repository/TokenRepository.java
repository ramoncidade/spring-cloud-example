package br.com.store.proxy.gateways.repository;

import br.com.store.proxy.entities.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by ramon.cidade on 16/05/2017.
 */
@Component
public interface TokenRepository extends CrudRepository<Token,String>{

    public Optional<Token> findByEmail(String email);
    public Optional<Token> findByToken(String token);
}
