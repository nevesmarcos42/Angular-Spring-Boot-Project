package com.neves.api_records_crud.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neves.api_records_crud.model.UserModel;
import com.neves.api_records_crud.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@Service // Indica que esta classe é um serviço Spring
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class); // Logger adicionado 
    
    @Autowired // Injeta a dependência do repositório
    private UserRepository userRepository;

    // Método para criar um novo usuário
    public UserModel creatUserModel(@Valid UserModel userModel) {
        logger.info("Criando usuário com email: {}", userModel.getEmail()); // Log adicionado
        return userRepository.save(userModel);
    }
    
    // Método para listar todos os usuário
    public Page<UserModel> getAllUserModels( Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    
    // Método para obter um usuário por ID
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    // Método para atualizar um usuário
    public UserModel updateUserModel(Long id, UserModel userDetails) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    // Método para deletar um usuário
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
