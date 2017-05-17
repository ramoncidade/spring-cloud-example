package br.com.store.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * Created by ramon.cidade on 10/05/2017.
 */
@RedisHash("products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String color;
    private String size;
}
