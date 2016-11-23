app.controller('ConferenceCtrl', ['$scope', '$http', function($scope, $http) {

	$scope.selectedTab = 'day1';
	
	var day1StartDate = new Date("2016/10/10 00:00:00").getTime();
	var day2StartDate = new Date("2016/10/11 00:00:00").getTime();
	var day3StartDate = new Date("2016/10/12 00:00:00").getTime();
	var day4StartDate = new Date("2016/10/13 00:00:00").getTime();	
	var conferEndDate = new Date("2016/10/14 00:00:00").getTime();

	$scope.conference = {};
	$scope.conference.day1 = [];
	$scope.conference.day2 = [];
	$scope.conference.day3 = [];
	$scope.conference.day4 = [];

	$scope.getPresentations = function() {
		$http({ method: 'GET', params: {'foobar': new Date().getTime()}, url: '/conference/presentations' }).
	    success(function (data, status, headers, config) {   	
	    	$scope.conference.day1 = $scope.dateRangeFilter(data, day1StartDate, day2StartDate);
	    	$scope.conference.day2 = $scope.dateRangeFilter(data, day2StartDate, day3StartDate);
	    	$scope.conference.day3 = $scope.dateRangeFilter(data, day3StartDate, day4StartDate);
	    	$scope.conference.day4 = $scope.dateRangeFilter(data, day4StartDate, conferEndDate);
	    }).
	    error(function (data, status, headers, config) {
	        //console.log("error");
	    });
    };
    
    $scope.getPresentations();
    
    //Daterange filter
    $scope.dateRangeFilter = function (data, from, to) {
    	var result = [];
    	angular.forEach(data, function(item){
    		if(item.startDate>from && item.endDate<to){
    			result.push(item);
    		}
        });
    	return result;
    };
}]);






