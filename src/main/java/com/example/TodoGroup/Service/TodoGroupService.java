package com.example.TodoGroup.Service;

import java.util.List;

import com.example.TodoGroup.Entity.TodoGroup;

public interface TodoGroupService {

	public TodoGroup saveTodoGroup(TodoGroup todoGroup);
	
	public List<TodoGroup> findAll();
	
	public TodoGroup updateTodoGroup(Long id,TodoGroup todoGroup);

	
}
