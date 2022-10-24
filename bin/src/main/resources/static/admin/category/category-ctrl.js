app.controller("category-ctrl", function($scope, $http) {
	$scope.items = [];
	
	$scope.form = {};
	
	$scope.init = function(){
		// load category
		$http.get("/rest/categories").then(resp => {
			$scope.items = resp.data;
		})
	}
	
	$scope.edit = function(category){
		$scope.form = angular.copy(category); // copy item
		$(".nav-tabs a:eq(0)").tab('show'); // chuyển lại tab đầu tiên
	}
	
	$scope.reset = function(){
		$scope.form = {};
	}
	
	$scope.add = function(){
		var item = angular.copy($scope.form);
		$http.post('/rest/categories', item).then(resp => {
			$scope.items.push(resp.data); // thêm vào trong list items
			$scope.reset();
			alert("Thêm mới thành công")
		}).catch(error => {
			alert("Thêm mới thất bại");
			console.log("Error", error);
		});
	}
	
	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/categories/${item.maDM}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maDM == item.maDM)
			$scope.items[index] = item;
			$scope.reset();
			alert("Cập nhật thành công")
		}).catch(error => {
			alert("Cập nhật thất bại");
			console.log("Error", error);
		});
	}
	
	$scope.delete = function(item) {
		$http.delete(`/rest/categories/${item.maDM}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maDM == item.maDM)
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa thành công")
		}).catch(error => {
			alert("Xóa thất bại");
			console.log("Error", error);
		});
	}
	
	$scope.init();
})