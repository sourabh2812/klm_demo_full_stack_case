<div class="generic-container">
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