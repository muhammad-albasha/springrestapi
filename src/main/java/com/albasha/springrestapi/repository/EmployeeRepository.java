package com.albasha.springrestapi.repository;

import com.albasha.springrestapi.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    List<Employee> findByName(String name);

    List<Employee> findByNameAndLocation(String name, String location);
}
