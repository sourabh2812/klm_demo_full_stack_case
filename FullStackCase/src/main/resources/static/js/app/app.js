// Angular application instance
var app = angular.module('app', [ 'ui.router', 'ngStorage', 'autoCompleteDirective' ]);

// Application wide API end-points 
app.constant('api', {
	LOCATION_SEVICE_API : 'http://localhost:9000/travel/airports',
	FARE_SERVICE_API : 'http://localhost:9000/travel/fares',
	METRICS_SERVICE_API : 'http://localhost:9000/travel/custom-metrics'
});

// Configuration for providing routes
app.config([
		'$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {

			$stateProvider.state('home', {
				url : '/',
				templateUrl : 'partials/list',
				controller : 'SearchController',
				controllerAs : 'ctrl',
				resolve : {
					users : function($q, SearchService) {
						var deferred = $q.defer();
						SearchService.loadServiceLocations().then(
								deferred.resolve, deferred.resolve);
						
						SearchService.fetchServerMetrics().then(
								deferred.resolve, deferred.resolve);
						
						return deferred.promise;
					}
				}
			});
			
			$urlRouterProvider.otherwise('/');
		} ]);
