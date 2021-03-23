package com.example.Authentication;


import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository;
import com.example.Authentication.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;



@DataJpaTest
@Transactional
public class AuthenticationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
	@Rollback(true)
    public void whenFindByName_thenReturnUser() {
        // given

        User dummyUser = new User();
        dummyUser.setName("Dummy");
        dummyUser.setEmail("test@test.com");
        dummyUser.setPassword("password");
        entityManager.persist(dummyUser);
        entityManager.flush();

        // when
        User found = userRepository.findByName(dummyUser.getName());

        // then

        assertEquals(found.getName(), dummyUser.getName());
    }



}