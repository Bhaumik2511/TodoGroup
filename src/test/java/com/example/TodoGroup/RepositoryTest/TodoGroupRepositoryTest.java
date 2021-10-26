package com.example.TodoGroup.RepositoryTest;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.TodoGroup.Dao.TodoGroupDao;
import com.example.TodoGroup.Entity.TodoGroup;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoGroupRepositoryTest {

	@Autowired
	TodoGroupDao dao;
	
	@Test
	@Order(1)
	@Rollback(value=false)
	public void saveTodoGroupTest() {
		TodoGroup todoGroup = new TodoGroup();
		todoGroup.setUserName("Bhaumik Desai");
		todoGroup.setTitle("Shopping Group");
		dao.save(todoGroup);
		
		Assertions.assertThat(todoGroup.getGroup_id()).isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	@Rollback(value=false)
	public void updateTodoGroupTest() {
		TodoGroup todoGroup = dao.findById(1L).get();
		todoGroup.setTitle("Movie Group");
		TodoGroup updated = dao.save(todoGroup);
		Assertions.assertThat(updated.getGroup_id()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	@Rollback(value=false)
	public void getAllTodoGroupTest() {
		Assertions.assertThat(dao.findAll().size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void deleteGroupTest() {
		TodoGroup todoGroup = dao.findById(1L).get();
		dao.delete(todoGroup);
		Assertions.assertThat(dao.findById(1L)).isEqualTo(Optional.empty());
	}
}
