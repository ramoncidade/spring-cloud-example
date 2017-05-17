package br.com.store.proxy;

import br.com.store.proxy.entities.Token;
import br.com.store.proxy.gateways.repository.TokenRepository;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableZuulProxy
//@EnableEurekaClient
@EnableFeignClients
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Component
	class SampleDataCLR implements CommandLineRunner {

		private final TokenRepository tokenRepository;

		@Autowired
		public SampleDataCLR(TokenRepository tokenRepository) {
			this.tokenRepository = tokenRepository;
		}

		@Override
		public void run(String... strings) throws Exception {
			tokenRepository.deleteAll();
			Token token = new Token();
			token.setPassword(Md5Crypt.md5Crypt("123456".getBytes()));
			token.setEmail("ramon.cidade@gmail.com");
			token = tokenRepository.save(token);
		}
	}
}
