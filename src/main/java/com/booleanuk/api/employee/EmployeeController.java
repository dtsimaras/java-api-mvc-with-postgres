package com.booleanuk.api.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    private EmployeeRepository employees;

    public EmployeeController() throws SQLException {
        this.employees = new EmployeeRepository();
    }
    @GetMapping
    public List<Employee> getAll() throws SQLException {
        return this.employees.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable long id) throws SQLException {
        return Optional.ofNullable(this.employees.get(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable long id, @RequestBody Employee customer) throws SQLException {
        Employee toBeUpdated = this.employees.get(id);
        if (toBeUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.employees.update(id, customer));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Employee> create(@RequestBody Employee customer) throws SQLException {
        return Optional.ofNullable(this.employees.add(customer))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable long id) throws SQLException {
        return Optional.ofNullable(this.employees.delete(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
