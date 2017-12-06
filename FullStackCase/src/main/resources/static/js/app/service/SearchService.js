'use strict';

angular.module('app').factory('SearchService', ['$localStorage', '$http', '$q', 'api', 
        function ($localStorage, $http, $q, api) {

            var factory = {
        		loadServiceLocations: loadServiceLocations,
        		getAllLocations: getAllLocations,
        		searchFlightDetails: searchFlightDetails,
        		getAllFlights: getAllFlights,
        		fetchServerMetrics: fetchServerMetrics
            };

            return factory;
            
            // API to load lacation information
            function loadServiceLocations() {
                var deferred = $q.defer();
                $http.get(api.LOCATION_SEVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all locations');
                            $localStorage.locs = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading locations');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllLocations() {
                return $localStorage.locs;
            }

            // API to search flights and fares related information
            function searchFlightDetails(source, dest) {
            	
            	var srcLoc = document.getElementById('sourceLoc').children[0].value; 
            	var destLoc = document.getElementById('destLoc').children[0].value; 
                var deferred = $q.defer();
                $http.get(api.FARE_SERVICE_API + '/' + srcLoc + '/' + destLoc)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all flights');
                            $localStorage.flightList = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function getAllFlights() {
                return $localStorage.flightList;
            }
            
            // API to fetch metrics records from the server
            function fetchServerMetrics() {
            	
                var deferred = $q.defer();
                $http.get(api.METRICS_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Metrics fetched successfully from server');
                            $localStorage.metrics = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while fetching Metrics data');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            

        }
    ]);