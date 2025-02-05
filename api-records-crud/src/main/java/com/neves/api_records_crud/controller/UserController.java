package com.neves.api_records_crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neves.api_records_crud.Service.UserService;
import com.neves.api_records_crud.model.UserModel;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/users") // Mapeia a URL base para todos os endpoints deste controlador
public class UserController {

    // Injeta a dependência do serviço
    @Autowired 
    private UserService userService;

    // Endpoint para criar um novo usuário
    @PostMapping
    public UserModel createUserModel(@Valid @RequestBody UserModel userModel) { // @Valid Adicionada validação do corpo da requisição
        return userService.creatUserModel(userModel);
    }

    // Endpoint para listar todos os usuários
    @GetMapping
    public Page<UserModel> getAllUserModels(Pageable pageable) {
        return userService.getAllUserModels(pageable);
    }

    // Endpoint para obter um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity <UserModel> getUserModelById(@PathVariable Long id) { 
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar um usuário
    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUserModel(@PathVariable Long id, @RequestBody UserModel userDetails) {
        return ResponseEntity.ok(userService.updateUserModel(id, userDetails));
    } 
    
    // Endpoint para deletar um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> deleteUserModel(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    } 

}
