package com.booleanuk.api.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

public class EmployeeRepositoryTest {

    @Test
    public void getAll() throws SQLException {
        EmployeeRepository repo = null;
        repo = new EmployeeRepository();
        Assertions.assertNotNull(repo.getAll());
        Assertions.assertDoesNotThrow(EmployeeRepository::new);
        Assertions.assertDoesNotThrow(repo::getAll);
    }
}