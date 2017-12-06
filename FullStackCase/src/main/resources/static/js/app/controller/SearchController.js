'use strict';

app.controller('SearchController', [ 'SearchService', '$scope', '$localStorage',
		function(SearchService, $scope, $localStorage) {

			var self = this;

			self.searchFlights = searchFlightDetails;
			
			self.fetchMetrics = fetchMetricsData;
			
			self.reset = reset;
			
			$scope.errorMessage = '';

			$scope.selectedData = null;

			// Setting the fetched locations into scope model
			$scope.locations = SearchService.getAllLocations();
			
			// Default dashboard values
			$scope.metrics = $localStorage.metrics;

			$scope.onSelect = function(selection) {
				$scope.selectedData = selection;
			};

			// Model data for setting the json array received against the selected flights
			$scope.fareData = [];

			function searchFlightDetails() {
				SearchService.searchFlightDetails().then(function() {
					$scope.fareData = SearchService.getAllFlights();
					
					if($scope.fareData.length == 0) {
						$scope.errorMessage = 'No records found for the selected locations.';
					}
					
				}, function(errResponse) {
					$scope.errorMessage = 'Failure in retriving data from the server. Please try again later.';
				});
			}
			
			function fetchMetricsData() {
				SearchService.fetchServerMetrics().then(function() {
					$scope.metrics = $localStorage.metrics;
				}, function(errResponse) {
					$scope.errorMessage = 'Failure in retriving data from the server. Please try again later.';
				});
			}

			function reset() {
				$scope.$broadcast('autoCompleteDirective:clearInput');
				$scope.fareData = [];
			}

		}

]);