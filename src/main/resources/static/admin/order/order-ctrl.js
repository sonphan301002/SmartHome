app.controller("order-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	$scope.oditems = [];

	$scope.initialize = function() {
		//load order
		$http.get("/rest/orders").then(resp => {
			$scope.items = resp.data;

		});
	}

	//khởi đầu
	$scope.initialize();

	//hiện chi tiết đơn hàng đồ đó
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$http.get(`/rest/orders/${item.maHD}`, item).then(resp => {
			$scope.oditems = resp.data;
			//tính tiền đồ đó
			var subtotal = 0;
			var discount = 0;
			var total = 0;
			for (var i = 0; i < $scope.oditems.length; i++) {
				var oditems = $scope.oditems[i];
				subtotal += (oditems.donGia * oditems.soLuong);
				discount += (oditems.donGia * oditems.soLuong) * oditems.giamGia / 100;
			}
			$scope.oditems.subtotal = subtotal;
			$scope.oditems.discount = discount;
			total += subtotal - discount + 30000;
			$scope.oditems.total = total;
		});
		$(".nav-tabs a:eq(0)").tab('show')
	};

	$scope.update = function() {
		Swal.fire({
			title: 'Bạn có muốn chuyển trạng thái không?',
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: 'Xác nhận',
			cancelButtonText: 'Hủy'
		}).then((result) => {
			if (result.isConfirmed) {
				var item = angular.copy($scope.form);
				$scope.form.trangThai += 1;
				item.trangThai = $scope.form.trangThai;
				$http.put(`/rest/orders/${item.maHD}`, item).then(resp => {
					var index = $scope.items.findIndex(p => p.maHD == item.maHD)
					$scope.items[index] = item;
					Swal.fire({
						icon: 'success',
						title: 'Thay đổi trạng thái thành công!',
						showConfirmButton: true,
						timer: 1500
					})
				}).catch(error => {
					Swal.fire({
						icon: 'warning',
						title: 'Thay đổi trạng thái thất bại!',
						showConfirmButton: true,
						timer: 1500
					})
					console.log("Error", error);
				});
			}
		})
	}
});