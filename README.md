# Flight & Fare search utility

Technologies used:-

	1. SpringBoot
	2. Angular 1.5
	3. FreeMarker Template
	4. Maven - for build & dependency management
	5. Rest API
  	6. Spring Oauth 2.0
	7. RestAssured Test Runner
	7. Bootstrap CSS

Steps to run the application:-

	1. Import both 'FullStackCase' and 'simple-travel-api-mock' project into your favourite IDE (Eclipse preferred)
	2. Update project with maven/gradle to download all application level depencies.
	3. Start 'simple-travel-api-mock' first so that the API's boots up at port 8080.
	4. Now start 'FullStackCase' and navigate to http://localhost:9090/travel to view the application.
	
Steps to run the test scripts:-

	1. Just run 'mvn test' on top of 'FullStackCase' project.
	2. Test execution results will be displayed in the console.
	
	
Note: You can change the default port by updating the port number present in application.yml and configure in app.js

Project description:

	1. The homepage will have 2 tabs - Home and Admin Console.
	2. Home tab will be selected, by default. It will have 2 textboxes (Source and Destination) with autocomplete feature.
	3. After selecting the Source and Destination locations, the use can click on 'Search Fares' button to check for fares.
	4. An available flight will be displayed in tabular fashion.
	5. To see server related statistics, user can click on 'Admin Console' tab to check for the request hit metrics.
	

@Author:
Sourabh Suman
