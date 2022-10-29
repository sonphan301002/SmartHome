app.controller("account-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};

	$scope.initialize = function() {
		//load tai khoan(get) AccountRestController
		$http.get("/rest/account").then(resp => {
			$scope.items = resp.data;
		});

	}

	//khoi dau(tai het dữ liệu cân thiết lên)
	$scope.initialize();

	//xoa form
	$scope.reset = function() {
		$scope.form = {};
	}

	//hien thi len form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}

	//them 
	$scope.create = function() {
		var item = angular.copy($scope.form);//tạo mới 1 sp
		$http.post(`/rest/account`, item).then(resp => {//post len rest/products
			$scope.items.push(resp.data);//push len list
			$scope.reset();
			$scope.initialize();
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

	//sua
	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/account/${item.tenND}`, item).then(resp => {//put dữ liệu lên
			//tim và thay đổi id giong vs server
			var index = $scope.items.findIndex(p => p.tenND == item.tenND);
			$scope.items[index] = item;
			$scope.initialize();
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

	//xoa
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
				$http.delete(`/rest/account/${item.tenND}`, item).then(resp => {
					//tim và thay đổi id giong vs server
					var index = $scope.items.findIndex(p => p.tenND == item.tenND);
					$scope.items.splice(index, 1);//splice để xóa
					$scope.reset();
					$scope.initialize();
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
});