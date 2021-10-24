package com.example.TodoGroup.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TodoGroup.Dao.TodoGroupDao;
import com.example.TodoGroup.Entity.TodoGroup;
import com.example.TodoGroup.Service.TodoGroupService;

@Service
public class TodoGroupServiceImpl implements TodoGroupService {

	@Autowired
	private TodoGroupDao todoGroupDao; 
	
	@Override
	public TodoGroup saveTodoGroup(TodoGroup todoGroup) {
		return todoGroupDao.save(todoGroup);
	}

	@Override
	public List<TodoGroup> findAll() {
		return todoGroupDao.findAll();
	}

	@Override
	public TodoGroup updateTodoGroup(Long id, TodoGroup newtodoGroup) {
		return todoGroupDao.findById(id).map(grp -> {
			grp.setTitle(newtodoGroup.getTitle());
			grp.setUserName(newtodoGroup.getUserName());
			grp.setLastUpdatedTime(LocalDateTime.now());
			return todoGroupDao.save(grp);
		}).orElseGet(() -> {
			newtodoGroup.setGroup_id(id);
			return todoGroupDao.save(newtodoGroup);
		});

	}
	

	
}
