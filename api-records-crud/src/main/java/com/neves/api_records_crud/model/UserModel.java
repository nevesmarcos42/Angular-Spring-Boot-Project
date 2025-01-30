package com.neves.api_records_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que esta classe é uma entidade JPA
@Data // Gera getters, setters e outros métodos úteis automaticamente
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define a estratégia de geração de ID
    private Long id;

    @Column(nullable = false) // Campo não nulo
    private String name;
    
    @Column(nullable = false, unique = true) // Campo não nulo e único
    private String email;

}
