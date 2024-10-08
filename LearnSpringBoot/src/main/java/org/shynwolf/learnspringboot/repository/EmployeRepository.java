package org.shynwolf.learnspringboot.repository;

import org.shynwolf.learnspringboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employee, Long> {
}
