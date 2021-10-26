package com.example.TodoGroup.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class TodoGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupId;
	@JsonProperty("username")
	private String userName;
	@JsonProperty("group_title")
	private String title;
	private LocalDateTime createdDateTime = LocalDateTime.now();
	private LocalDateTime lastUpdatedTime;
	
	
	@Transient
	private List<TodoItem> todoItems;
	
	
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public List<TodoItem> getTodoItems() {
		return todoItems;
	}
	public void setTodoItems(List<TodoItem> todoItems) {
		this.todoItems = todoItems;
	}
	
	public Long getGroup_id() {
		return groupId;
	}
	public void setGroup_id(Long group_id) {
		this.groupId = group_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDateTime getCreatedDate() {
		return createdDateTime;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDateTime = createdDate;
	}
	public LocalDateTime getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	
	
}
