app.controller("supplier-ctrl", function($scope, $http) {
	$scope.items = [];

	$scope.form = {};

	$scope.init = function() {
		// load supplier
		$http.get("/rest/supplieres").then(resp => {
			$scope.items = resp.data;
		})
	}

	$scope.edit = function(supplier) {
		$scope.form = angular.copy(supplier); // copy item
		$(".nav-tabs a:eq(0)").tab('show'); // chuyển lại tab đầu tiên
	}

	$scope.reset = function() {
		$scope.form = {};
	}

	$scope.add = function() {
		var item = angular.copy($scope.form);
		$http.post('/rest/supplieres', item).then(resp => {
			$scope.items.push(resp.data); // thêm vào trong list items
			$scope.reset();
			Swal.fire({
				icon: 'success',
				title: 'Thêm mới thành công',
				showConfirmButton: true,
				timer: 1500
			})
		}).catch(error => {
			Swal.fire({
				icon: 'success',
				title: 'Thêm mới thất bại',
				showConfirmButton: true,
				timer: 1500
			})
			console.log("Error", error);
		});
	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/supplieres/${item.maNCC}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maNCC == item.maNCC)
			$scope.items[index] = item;
			$scope.reset();
			Swal.fire({
				icon: 'success',
				title: 'Cập nhật thành công',
				showConfirmButton: true,
				timer: 1500
			})
		}).catch(error => {
			Swal.fire({
				icon: 'success',
				title: 'Cập nhật thất bại',
				showConfirmButton: true,
				timer: 1500
			})
			console.log("Error", error);
		});
	}

	$scope.delete = function(item) {
		Swal.fire({
			title: 'Bạn có muốn xóa hay không',
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Xác nhận',
			cancelButtonText: 'Hủy'
		}).then((result) => {
			if (result.isConfirmed) {
				$http.delete(`/rest/supplieres/${item.maNCC}`, item).then(resp => {
					var index = $scope.items.findIndex(p => p.maNCC == item.maNCC)
					$scope.items.splice(index, 1);
					$scope.reset();
					Swal.fire({
						icon: 'success',
						title: 'Xóa thành công',
						showConfirmButton: true,
						timer: 1500
					})
				}).catch(error => {
					Swal.fire({
						icon: 'success',
						title: 'Xóa thất bại',
						showConfirmButton: true,
						timer: 1500
					})
					console.log("Error", error);
				});
			}
		})
	}
	
	$scope.imageChanged = function(files) {
		var data = new FormData(); // đối tương FormData
		data.append('file', files[0]); // chọn file bỏ vào FormData
		$http.post('/rest/upload/images', data, { // post lên server
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.logo = resp.data.name; // trả về name
		}).catch(error => {
			Swal.fire({
				icon: 'warning',
				title: 'Lỗi tải ảnh!',
				showConfirmButton: true,
				timer: 1500
			})
			console.log("Error", error);
		})
	}

	$scope.init();
})