package br.com.store.gateways.repository;

import br.com.store.entities.Shirt;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ramon.cidade on 17/05/2017.
 */
public interface ShirtRepository extends CrudRepository<Shirt,String> {


}
