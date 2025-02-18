Feature: Login functionality of Leaptaps application 

Scenario: Login with valid credentials 

	Given Launch the browser 
	And Load the URL 
	And Enter the Username as 'DemoSalesManager' 
	And Enter the Password as crmsfa 
	
	When click on the Login button 
	Then It should navigate to the next page 
	
Scenario: Login with invalid username 

	Given Launch the browser 
	And Load the URL 
	And Enter the Username as 'DemoSales'
	And Enter the Password as crmsfa 
	
	When click on the Login button 
	But It throws a validation