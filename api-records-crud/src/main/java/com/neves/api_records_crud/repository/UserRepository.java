package com.neves.api_records_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neves.api_records_crud.model.UserModel;

@Repository // Indica que esta interface é um repositório Spring
public interface UserRepository extends JpaRepository<UserModel, Long>{
    // JpaRepository fornece métodos CRUD prontos para a entidade User
    // Não é necessário adicionar código adicional para operações básicas
}
