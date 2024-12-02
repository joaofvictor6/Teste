package com.example;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public List<User> create(User user) {
        // Verifica se o usuário já existe na lista com base no username e password
        if (users.stream().anyMatch(u -> u.username().equals(user.username()) && u.password().equals(user.password()))) {
            throw new RuntimeException("Usuário já existe!");
        }
        users.add(user);
        return users;
    }
}
