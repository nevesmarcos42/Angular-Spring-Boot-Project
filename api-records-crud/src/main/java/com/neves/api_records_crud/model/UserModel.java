package com.neves.api_records_crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import javax.validation.constraints.*;

@Entity // Indica que esta classe é uma entidade JPA
@Data // Gera getters, setters e outros métodos úteis automaticamente
@NoArgsConstructor // Gera um construtor sem argumentos
@AllArgsConstructor // Gera um construtor com todos os argumentos
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define a estratégia de geração de ID
    private Long id;

    @NotNull(message ="O nome não pode ser nulo")
    @Size(min = 0, max = 50, message = "O nome deve ter entre 1 e 50 caracteres")
    private String name;
    
    @NotNull(message ="O email não pode ser nulo")
    @Email(message = "O e-mail deve ser válido") // Adicionada validação de formato de email
    @Column(unique = true) // Campo único
    private String email;

}
