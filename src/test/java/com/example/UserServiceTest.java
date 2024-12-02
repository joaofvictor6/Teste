package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private UserService userService = new UserService();

    // Primeiro teste: Criação de um usuário com sucesso
    @Test
    public void createUser() {
        User user = new User("Nome", "123456");
        List<User> users = userService.create(user);
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    // Segundo teste: Tentativa de criar o mesmo usuário gera uma exceção
    @Test
    public void createUser_ThrowsException() {
        User user = new User("Nome", "123456");
        userService.create(user);
        assertThrows(RuntimeException.class, () -> userService.create(user));
    }
}
