Feature: Login into Application
Background:

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "https://www.primevideo.com/" Site
And Click on login link in home page to land on Secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close the browsers
Examples:

|username				|password	|
|ajfjim@gmail.com		|aacuamazon	|   
|prashanth@gmail.com	|123456		|