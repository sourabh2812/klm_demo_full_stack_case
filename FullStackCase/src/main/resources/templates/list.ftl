<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        
       
        <div class="panel-heading"><span class="lead">KLM Flight Search</span></div>
				
		<div class="panel-body">
			
	        <div class="formcontainer">
	        
                <div class="alert alert-info" role="alert" ng-if="errorMessage">{{errorMessage}}</div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="source">Source Location</label>
	                        
	                        <div class="col-md-7">
		                        <angucomplete id="sourceLoc"
	              					placeholder="Enter source location" pause="100" selectedobject="selectedSource"
	              					localdata="locations" searchfields="description" titlefield="description"
	              					minlength="1" inputclass="form-control form-control-small"/>
							</div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="destination">Destination Location</label>
	                        
	                        <div class="col-md-7">
		                        <angucomplete id="destLoc"
	              					placeholder="Enter destination" pause="100" selectedobject="selectedDest"
	              					localdata="locations" searchfields="description" titlefield="description"
	              					minlength="1" inputclass="form-control form-control-small"/>
							</div>
							
	                    </div>
	                </div>
	

	                <div class="row">
	                    <div class="form-actions floatRight">
	                    	<button name="searchBtn" type="button" ng-click="ctrl.searchFare()" class="btn btn-primary btn-sm" ng-disabled="selectedSource.originalObject == undefined || selectedDest.originalObject == undefined">Search Best Fare</button>
	                        <button name="resetBtn" type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Search</button>
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
</div>