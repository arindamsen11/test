Feature: Ios_Poc

	@Test1
	Scenario: Test web apps on real device
		Given Navigate to the url
		Then  Login and check Sign out link
		Then  Click on Sign out link and validate it is successful
	
	
		
		
	@Test2
	Scenario Outline: To test the Job Titles functionality
		Given The user is on the home page <url>
		When The user logs in with the credentials<username>,<password>
		And The Job Titles link is clicked
		Then The list of the Job Titles is displayed

	Examples:
	| url 										  |username |password|
	| "http://opensource.demo.orangehrmlive.com/" |"Admin"	|"admin" |


	@Test3
	Scenario: Simulator
	Given Launch Url and Sign in
	Then Select Flight Details and Continue
	Then Select Flights and Continue
	Then Fill passenger details and book flight



	