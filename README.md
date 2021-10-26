# TodoGroup

# Swagger-UI  URL
http://localhost:8081/swagger-ui/index.html

# H2 Database url
 	-URL		:http://localhost:8081/h2-console
 	-Username 	:Bhaumik23
 	-Password 	:pass123
 
 

# Create Todo Group endpoint
	-http://localhost:8081/create-group
	-Accept Request body as name adn group_title
	-For example :
				{
    			"username":"Viki",
   				 "group_title":"Clothes List"
    
				}
	  
	  - Response :
	  	{
    		"createdDateTime": "2021-10-25T18:57:19.748",
    		"lastUpdatedTime": null,
    		"todoItems": null,
    		"group_id": 1,
   			"createdDate": "2021-10-25T18:57:19.748",
   			"username": "Hitesh",
    		"group_title": "Clothes List"
		}
		
	- In the response, along with the name and group_title createdDateTime is initialized. However, lastUpdatedTime is set to null since it will be initialized when
	  update functionality performed. 
	-todoItems is null since there is no items for Todo group for group_id": 1
	
	
	
# Update Todo Group endpoint
	-http://localhost:8081/update-group/{groupId}
	-For example : http://localhost:8081/update-group/1
	-It can modify name and group title

# Delete Todo Group endpoint
	-http://localhost:8081/delete-group/{groupId}
	-Example : http://localhost:8081/delete-group/3
	
# Get all the Todo Group
	-http://localhost:8081/groups
	
