app.controller("report-ctrl", function($scope, $http) {
	$scope.doanhThu = [];
	
	$scope.doanhThu = function(nam){
		$http.get(`rest/reports/${nam}`).then(resp => {
			$scope.doanhThu = resp.data
		})
	}
})