# HudlTakeHomeTest
This project was built using Java with Selenium, along with TestNG for test suite management. I took a POM (Page object model)
approach, where each web page is its own class, containing locators and helper methods. This structure promotes efficient
code management and helps to prevent repetition. TestNG allows the tests to be organized and called from an XML file, which 
is organized by the login and logout actions. I decided to automate the paths I found critical, including
test cases that cover happy path, unhappy path, and auxiliary functionality found on the login page.  

Before starting the tests found in LoginTestSuite.xml and LogoutTestSuite.xml you will need to input credentials in the 
following locations:

LoginTestSuite.xml:

Line 6 needs to be updated to contain a valid email address.

Line 7 needs to be updated to contain a valid password.

Line 18 needs to be updated to contain an invalid email address.

Line 19 needs to be updated to contain a valid password.

Line 30 needs to be updated to contain a valid email address.

Line 31 needs to be updated to contain an invalid password. 

LogoutTestSuite.xml:

Line 6 needs to be updated to contain a valid email address.

Line 7 needs to be updated to contain a valid password.

Once the parameter values have been updated to include proper credentials, the tests can be executed by right-clicking 
on the XML file and selecting 'Run'.