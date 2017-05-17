package br.com.store.proxy.http;

import br.com.store.proxy.entities.Token;
import br.com.store.proxy.gateways.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by ramon.cidade on 16/05/2017.
 */
@RestController

public class AuthenticationController{

    private TokenRepository repository;

    @Autowired
    public AuthenticationController(TokenRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/authenticate/token")
    public ResponseEntity<Token> getToken(@RequestParam("email")String email, @RequestParam("password")String password){
        Optional<Token> tokenOptional = this.repository.findByEmail(email);
        ResponseEntity<Token> response = null;
        if(tokenOptional.isPresent()){
            if(password.equals(tokenOptional.get().getPassword())){
                tokenOptional.get().setPassword(null);
                response = new ResponseEntity<Token>(tokenOptional.get(),HttpStatus.OK);
            }else{
                response =new ResponseEntity<Token>(HttpStatus.BAD_REQUEST);
            }
        }else{
            response = new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @GetMapping("/token")
    public Iterable<Token> tokens(){
        return repository.findAll();
    }
}
