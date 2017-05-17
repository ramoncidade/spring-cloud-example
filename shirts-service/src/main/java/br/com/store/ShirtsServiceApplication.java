package br.com.store;

import br.com.store.entities.Shirt;
import br.com.store.gateways.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
public class ShirtsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirtsServiceApplication.class, args);
	}

	@Component
	class SampleDataCLR implements CommandLineRunner {

		@Autowired
		ShirtRepository repository;

		@Override
		public void run(String... strings) throws Exception {
			repository.deleteAll();
			Shirt formal = new Shirt();
			formal.setName("Camisa Social");
			formal.setColor("Cinza");
			formal.setSize("2");
			formal.setId("2");
			repository.save(formal);
			Shirt casual = new Shirt();
			casual.setId("1");
			casual.setName("Camiseta Grafismo");
			casual.setColor("Preta");
			casual.setSize("G");
			repository.save(casual);
		}
	}
}
