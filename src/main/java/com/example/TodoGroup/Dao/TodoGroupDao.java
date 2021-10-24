package com.example.TodoGroup.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoGroup.Entity.TodoGroup;

public interface TodoGroupDao extends JpaRepository<TodoGroup,Long>{

}
