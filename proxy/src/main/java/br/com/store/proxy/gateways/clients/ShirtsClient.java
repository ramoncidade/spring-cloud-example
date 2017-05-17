package br.com.store.proxy.gateways.clients;

import br.com.store.entities.Shirt;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ramon.cidade on 17/05/2017.
 */
@FeignClient("shirts-service")
public interface ShirtsClient {

    @RequestMapping(method = RequestMethod.GET,path = "/shirt/{id}")
    public Shirt findById(@PathVariable("id") String id);
}
