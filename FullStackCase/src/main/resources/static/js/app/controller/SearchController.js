'use strict';

app.controller('SearchController', [ 'SearchService', '$scope', '$localStorage',
		function(SearchService, $scope, $localStorage) {

			var self = this;

			self.searchFare = searchFareDetails;
			
			self.fetchMetrics = fetchMetricsData;
			
			self.reset = reset;
			
			$scope.errorMessage = '';

			$scope.selectedSource = '';
			
			$scope.selectedDest = '';

			// Setting the fetched locations into scope model
			$scope.locations = SearchService.getAllLocations();
			
			// Default dashboard values
			$scope.metrics = $localStorage.metrics;


			// Model data for setting the json array received against the selected flights
			$scope.fareData = [];
			
			function searchFareDetails() {
				
				var source = $scope.selectedSource.originalObject.code;
				var dest = $scope.selectedDest.originalObject.code;
				
				SearchService.searchFareDetails(source, dest).then(function() {
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
				document.getElementById('sourceLoc_value').value = '';
				document.getElementById('destLoc_value').value = '';
				$scope.selectedSource = '';
				$scope.selectedDest = '';
				$scope.fareData = [];
			}

		}

]);