app.controller("category-ctrl", function($scope, $http) {
	$scope.items = [];

	$scope.form = {};

	$scope.init = function() {
		// load category
		$http.get("/rest/categories").then(resp => {
			$scope.items = resp.data;
		})
	}

	$scope.edit = function(category) {
		$scope.form = angular.copy(category); // copy item
		$(".nav-tabs a:eq(0)").tab('show'); // chuyển lại tab đầu tiên
	}

	$scope.reset = function() {
		$scope.form = {};
	}

	$scope.add = function() {
		var item = angular.copy($scope.form);
		$http.post('/rest/categories', item).then(resp => {
			$scope.items.push(resp.data); // thêm vào trong list items
			$scope.reset();
			Swal.fire({
				icon: 'success',
				title: 'Thêm mới thành công!',
				showConfirmButton: true,
				timer: 1500
			})
		}).catch(error => {
			Swal.fire({
				icon: 'warning',
				title: 'Thêm mới thất bại!',
				showConfirmButton: true,
				timer: 1500
			})
			console.log("Error", error);
		});
	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/categories/${item.maDM}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maDM == item.maDM)
			$scope.items[index] = item;
			$scope.reset();
			Swal.fire({
				icon: 'success',
				title: 'Cập nhật thành công!',
				showConfirmButton: true,
				timer: 1500
			})
		}).catch(error => {
			Swal.fire({
				icon: 'warning',
				title: 'Cập nhật thất bại!',
				showConfirmButton: true,
				timer: 1500
			})
			console.log("Error", error);
		});
	}

	$scope.delete = function(item) {
		Swal.fire({
			title: 'Bạn có muốn xóa hay không?',
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Xác nhận',
			cancelButtonText: 'Hủy'
		}).then((result) => {
			if (result.isConfirmed) {
				$http.delete(`/rest/categories/${item.maDM}`, item).then(resp => {
					var index = $scope.items.findIndex(p => p.maDM == item.maDM)
					$scope.items.splice(index, 1);
					$scope.reset();
					Swal.fire({
						icon: 'success',
						title: 'Xóa thành công!',
						showConfirmButton: true,
						timer: 1500
					})
				}).catch(error => {
					Swal.fire({
						icon: 'warning',
						title: 'Xóa thất bại!',
						showConfirmButton: true,
						timer: 1500
					})
					console.log("Error", error);
				});
			}
		})

	}

	$scope.init();
})