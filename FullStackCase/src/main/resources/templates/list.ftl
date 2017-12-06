<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">KLM Flight Search</span></div>
		<div class="panel-body">
		
	        <div class="formcontainer">
	        
                <div class="alert alert-info" role="alert" ng-if="errorMessage">{{errorMessage}}</div>
	                
	                <input type="hidden" ng-model="ctrl.user.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="source">Source Location</label>
	                        
	                        <div class="col-md-7">
	                        	<ng-auto-complete id="sourceLoc" options="locations" place-holder="Enter source location" on-select="onSelect" display-property="title" input-class="form-control" clear-input="false"></ng-auto-complete>
							</div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="destination">Destination Location</label>
	                        
	                        <div class="col-md-7">
	                        	<ng-auto-complete id="destLoc" options="locations" place-holder="Enter destination location" on-select="onSelect" display-property="title" input-class="form-control" clear-input="false"></ng-auto-complete>
							</div>
							
	                    </div>
	                </div>
	

	                <div class="row">
	                    <div class="form-actions floatRight">
	                    	<button type="button" ng-click="ctrl.searchFlights()" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">Search Best Fare</button>
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Search</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Available Flight List</span></div>
        
		<div class="panel-body">
		
			<div class="table-responsive">
		        
		       	<table class="table table-hover">
		       		<thead>
		            <tr>
		                <th class="col-xs-4">Source</th>
		                <th class="col-xs-4">Destination</th>
		                <th class="col-xs-4">Fare</th>
		            </tr>
		            </thead>
		            
	      			<tr>
	        			<td class="col-xs-4">{{fareData.origin.description}}</td>
	        			<td class="col-xs-4">{{fareData.destination.description}}</td>
	        			<td class="col-xs-4">{{fareData.amount}} {{fareData.currency}}</td>
	      			</tr>
    			</table>
				
			</div>
		</div>
    </div>
    
    
    
    <div class="panel panel-default">
        
        <div class="panel-heading"><span class="lead">System Dashboard</span></div>
        
		<div class="panel-body">
		       		
			<div class="table-responsive">
		        <h4>Requests</h4>
		        
		        <table class="table table-bordered table-hover">
				    <thead>
				      <tr>
				        <th class="col-xs-6">Request Type</th>
				        <th class="col-xs-6">Number of Requests</th>
				      </tr>
				    </thead>
				    <tbody>
				      <tr class="table-success">
				        <td class="col-xs-6">Success requests</td>
				        <td class="col-xs-6">{{metrics.numberOfRequestsOK}}</td>
				      </tr>
				      <tr class="table-warning">
				        <td class="col-xs-6">Unauthorized requests</td>
				        <td class="col-xs-6">{{metrics.numberOfRequests4xx}}</td>
				      </tr>
				      <tr class="table-danger">
				        <td class="col-xs-6">Invalid requests</td>
				        <td class="col-xs-6">{{metrics.numberOfRequests5xx}}</td>
				      </tr>
				      <tr class="strong">
				        <td class="col-xs-6">Total requests</td>
				        <td class="col-xs-6">{{metrics.numberOfRequests}}</td>
				      </tr>
				    </tbody>
				  </table>
				  <br>
				  <h4>Responses</h4>
				  <table class="table table-bordered table-hover">
				    <tbody>
				      <tr>
				        <td class="col-xs-6 strong">Minimum Response Time</td>
				        <td class="col-xs-6">{{metrics.minResponseTime}}</td>
				      </tr>
				      <tr>
				        <td class="col-xs-6 strong">Maximum Response Time</td>
				        <td class="col-xs-6">{{metrics.maxResponseTime}}</td>
				      </tr>
				      <tr>
				        <td class="col-xs-6 strong">Average Response Time</td>
				        <td class="col-xs-6">{{metrics.averageResponseTime}}</td>
				      </tr>
				    </tbody>
				  </table>
    			<button type="button" class="btn btn-success float-md-right" ng-click="ctrl.fetchMetrics()">Refresh</button>
			</div>
		</div>
    </div>
</div>