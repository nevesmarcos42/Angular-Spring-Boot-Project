package com.neves.api_records_crud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neves.api_records_crud.model.UserModel;
import com.neves.api_records_crud.repository.UserRepository;

@Service // Indica que esta classe é um serviço Spring
public class UserService {
    
    @Autowired // Injeta a dependência do repositório
    private UserRepository userRepository;

    // Método para criar um novo usuário
    public UserModel creatUserModel(UserModel userModel) {
        return userRepository.save(userModel);
    }
    
    // Método para listar todos os usuário
    public List<UserModel> getAllUserModels() {
        return userRepository.findAll();
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
