package com.example.TodoGroup.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.TodoGroup.Entity.TodoGroup;
import com.example.TodoGroup.Entity.TodoItem;
import com.example.TodoGroup.Service.TodoGroupService;

@RestController
public class TodoGroupController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private TodoGroupService service;
	
	
	private static final String BASE_URL ="http://localhost:8082/todoItems/";
	

	@PostMapping("/create-group")
	public ResponseEntity<TodoGroup> saveTodoGroup(@RequestBody TodoGroup todoGroup) {
		 TodoGroup obj = service.saveTodoGroup(todoGroup);
		 return new ResponseEntity<>(obj,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update-group/{id}")
	public ResponseEntity<TodoGroup> updateTodoGroup(@PathVariable Long id,@RequestBody TodoGroup todoGroup) {
	
		return new ResponseEntity<>(service.updateTodoGroup(id,todoGroup),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/groups")
	public ResponseEntity<List<TodoGroup>> getTodoGroup() {
		List<TodoGroup> todoGroupList = service.findAll().stream().map(grp -> getDateFromService(grp)).collect(Collectors.toList());
		return new ResponseEntity<>(todoGroupList,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete-group/{groupId}")
	public void deleteTodoGroup(@PathVariable Long groupId) {
		
		service.deleteById(groupId);
	}
	
	
	
	
	private TodoGroup getDateFromService(TodoGroup grp) {
		 ResponseEntity<TodoItem[]> responseEntity = 
				    restTemplate.getForEntity(BASE_URL+grp.getGroup_id(), TodoItem[].class);
		 TodoItem[] userArray = responseEntity.getBody();
		 List<TodoItem> list = Arrays.stream(userArray).collect(Collectors.toList());
		 grp.setTodoItems(list);
		
		 return grp;
	}
	
}
