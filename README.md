# OlympicPlanner

API in Java using SpringBoot that can be used to plan and manage sporting 
events.

The database of the API will be managed and created using SpringBoot's H2 
dependency.

Create an RESTful API using Springboot as a framework. The API has to manage 
sporting events, it will allow user controll, reservations for events and 
venues. It will also implement complex relationships between the entities.

API Entities
	Users
		Atributes
			id
			name
			email
		Relationship - One user can participate in many events.
	
	SportingEvents
		Atributes
			id
			name
			description
			date
			time
			duration
		Relationship - One event can have many participants.
			
	Reservations
		Atributes
			id
			date
			hourInterval
			venue
		Relationship - One event can have only one venue reserved.
	
	Venues
		Atributes
			id
			name
			type
			location
		Relationship - One venue can have many reservations.

API endpoints
	Users
		Sign up.
		List all users.
		Modify user data.
		Delete user.
		
	SportingEvents
		Create an event.
		List all events.
		Modify an event.
		Delete an event.
		
	Reservations
		Create a new reservations.
		Eliminate reservations based on venue.
		Eliminate a reservations.
		
	Venues
		Sign new venues up.
		List all venues.
		Delete a venue.
		
Authentication and security
	implement authentication JWT in order to protect sensible routes.
	
Advanced queries
	Find events by date, location or sport.
	Find the available venues on one specific date.