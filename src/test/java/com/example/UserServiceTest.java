package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;  

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();  // Garante que userService seja reconfigurado antes de cada teste
    }

    // 1 Teste de criação de usuário
    @Test
    public void createUser() {
        User user = new User("Nome", "12345678");
        List<User> users = userService.create(user);
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    // 2 Teste de exceção quando tenta criar um usuário com nome de usuário já existente
    @Test
    public void createUser_ThrowsException_UserAlreadyExists() {
        User user = new User("Nome", "12345678");
        userService.create(user);
        assertThrows(RuntimeException.class, () -> userService.create(user));  // Exceção esperada
    }

    // 3 Teste de exceção quando tenta criar um usuário com senha curta
    @Test
    public void createUser_ThrowsException_ShortPassword() {
        User user = new User("Nome", "123");
        assertThrows(RuntimeException.class, () -> userService.create(user));  // Exceção esperada
    }

    // 4 Teste de login com credenciais corretas
    @Test
    public void login_Success() {
        User user = new User("Nome", "12345678");
        userService.create(user);
        assertTrue(userService.login("Nome", "12345678"));
    }

    // 5 Teste de login com credenciais incorretas
    @Test
    public void login_Failure_IncorrectPassword() {
        User user = new User("Nome", "12345678");
        userService.create(user);
        assertFalse(userService.login("Nome", "wrongpassword"));
    }

    // 6 Teste de login com email não cadastrado
    @Test
    public void login_Failure_UserNotFound() {
        User user = new User("Nome", "12345678");
        userService.create(user);
        assertFalse(userService.login("NonExistentUser", "12345678"));
    }
}
