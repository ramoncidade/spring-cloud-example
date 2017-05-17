package br.com.store;

import br.com.store.entities.Pants;
import br.com.store.gateways.repository.PantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
public class PantsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PantsServiceApplication.class, args);
	}

	@Component
	class SampleDataCLR implements CommandLineRunner{

		@Autowired
		PantsRepository repository;

		@Override
		public void run(String... strings) throws Exception {
			repository.deleteAll();
			Pants formal = new Pants();
			formal.setId("2");
			formal.setName("Calca Formal");
			formal.setColor("Preta");
			formal.setSize("40");
			repository.save(formal);
			Pants casual = new Pants();
			casual.setId("1");
			casual.setName("Calca Jeans");
			casual.setColor("Azul");
			casual.setSize("40");
			repository.save(casual);
		}
	}
}
