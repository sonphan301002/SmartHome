app.controller('paginationCtrl', function ($scope, $http) {
    $scope.items = [];

	$scope.init = function() {
		// load product
		$http.get("/rest/products/${cid}").then(resp => {
			$scope.items = resp.data;
		})
	}

	$scope.init();

	$scope.pager = {
		page: 0,
		size: 8,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		
		get count(){
			return Math.ceil(1.0 * $scope.items.length/ this.size);
		},
		
		first(){
			this.page = 0;
		},
		
		prev(){
			this.page--;
			if(this.page <0){
				this.last();
			}
		},
		
		next(){
			this.page++;
			if(this.page >= this.count){
				this.first();
			}
		},
		
		last(){
			this.page = this.count -1;
		}
	}
});