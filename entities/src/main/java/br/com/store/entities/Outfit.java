package br.com.store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ramon.cidade on 17/05/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Outfit {
    private String name;
    private Shirt shirt;
    private Pants pants;
}
