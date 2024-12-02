package com.example;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    // Função de criar usuário
    public List<User> create(User user) {
        // Verifica se o nome de usuário já existe
        if (users.stream().anyMatch(u -> u.username().equals(user.username()))) {
            throw new RuntimeException("Usuário já existe!");
        }
        // Verifica se a senha tem menos de 8 caracteres
        if (user.password().length() < 8) {
            throw new RuntimeException("A senha deve ter pelo menos 8 caracteres!");
        }
        users.add(user);
        return users;
    }

    // Função de login
    public boolean login(String username, String password) {
        return users.stream().anyMatch(u -> u.username().equals(username) && u.password().equals(password));
    }
}
