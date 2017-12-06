<!DOCTYPE html>

<html lang="en" ng-app="app">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
    </head>
    <body>
    
    	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  			<ul class="nav navbar-nav">
	  			<li class="nav-item">
	        		<a class="nav-link" href="#/"><strong>HOME</strong></a>
	      		</li>
	      		<li class="nav-item">
	        		<a class="nav-link" href="#/dashboard"><strong>ADMIN CONSOLE</strong></a>
	      		</li>
        	</ul>
		</nav>
    	
        <div ui-view></div>
        
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/local-storage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        
        <script src="js/app/app.js"></script>
        <script src="js/app/controller/SearchController.js"></script>
        <script src="js/app/service/SearchService.js"></script>
        <script src="js/app/directive/AutoCompleteDirective.js"></script>
        
    	<script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.3.0.min.js"></script>
        
    </body>
</html>