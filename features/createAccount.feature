Feature: Login into the Salesforce app and create a new account 

Scenario: Successful Login and Account creation 

	Given Launch the browser 
	And Load the 'https://login.salesforce.com' 
	And Enter the username as 'vidyar@testleaf.com' 
	And Enter the password as 'Sales@123' 
	And Click on the Login button 
	And Toggle the main menu 
	And Click view All and click Sales from App Launcher 
	And Click on Accounts tab 
	And Click on New button 
	And Enter 'Bavithra' as account name 
	And Select Ownership as Public 
	When Click save and verify Account name 
	Then  New account should be created
	Then Quit the browser