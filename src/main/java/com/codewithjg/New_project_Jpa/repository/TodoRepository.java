package com.codewithjg.New_project_Jpa.repository;

import com.codewithjg.New_project_Jpa.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
