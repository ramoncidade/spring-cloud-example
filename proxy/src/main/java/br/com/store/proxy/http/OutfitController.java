package br.com.store.proxy.http;

import br.com.store.entities.Outfit;
import br.com.store.entities.Pants;
import br.com.store.entities.Shirt;
import br.com.store.proxy.gateways.clients.PantsClient;
import br.com.store.proxy.gateways.clients.ShirtsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ramon.cidade on 17/05/2017.
 */
@RestController
@RequestMapping("/outfit")
public class OutfitController {

    PantsClient pants;
    ShirtsClient shirts;

    @Autowired
    public OutfitController(PantsClient pants, ShirtsClient shirts) {
        this.pants = pants;
        this.shirts = shirts;
    }

    @RequestMapping(value="/{name}",method = RequestMethod.GET)
    public ResponseEntity<Outfit> getOutfitByName(@PathVariable String name){
        Shirt shirt = null;
        Pants pants = null;
        switch (name){
            case "casual":
                pants = this.pants.findById("1");
                shirt = shirts.findById("1");
                break;
            case "formal":
                pants = this.pants.findById("2");
                shirt = shirts.findById("2");
                break;
            default:
                break;

        }
        Outfit outfit = new Outfit();
        outfit.setName(name);
        outfit.setPants(pants);
        outfit.setShirt(shirt);
        return new ResponseEntity<>(outfit, HttpStatus.OK);
    }
}
