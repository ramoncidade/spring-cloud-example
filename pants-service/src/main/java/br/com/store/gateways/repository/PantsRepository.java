package br.com.store.gateways.repository;

import br.com.store.entities.Pants;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ramon.cidade on 17/05/2017.
 */
public interface PantsRepository extends CrudRepository<Pants,String> {
}
