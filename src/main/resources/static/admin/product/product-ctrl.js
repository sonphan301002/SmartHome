app.controller("product-ctrl", function($scope, $http) {
	$scope.items = [];

	$scope.form = {};

	$scope.cates = [];

	$scope.supps = [];

	$scope.init = function() {
		// load product
		$http.get("/rest/products").then(resp => {
			$scope.items = resp.data;
		})

		// load category
		$http.get("/rest/categories").then(resp => {
			$scope.cates = resp.data;
		})

		// load supplier
		$http.get("/rest/supplieres").then(resp => {
			$scope.supps = resp.data;
		})
	}

	$scope.reset = function() {
		$scope.form = {
			ngayTao: new Date(),
			ngaySua: new Date(),
			hinhAnh: 'cloud-3.png',
		};
	}

	$scope.edit = function(product) {
		$scope.form = angular.copy(product); // copy item
		$(".nav-tabs a:eq(0)").tab('show'); // chuyển lại tab đầu tiên
	}

	$scope.add = function() {
		var item = angular.copy($scope.form);
		$http.post('/rest/products', item).then(resp => {
			resp.data.ngayTao = new Date(resp.data.ngayTao);
			resp.data.ngaySua = new Date(resp.data.ngaySua);
			$scope.items.push(resp.data); // thêm vào trong list items
			$scope.reset();
			$scope.init();
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
		$http.put(`/rest/products/${item.maSP}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maSP == item.maSP)
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
				$http.delete(`/rest/products/${item.maSP}`, item).then(resp => {
					var index = $scope.items.findIndex(p => p.maSP == item.maSP)
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

	$scope.imageChanged = function(files) {
		var data = new FormData(); // đối tương FormData
		data.append('file', files[0]); // chọn file bỏ vào FormData
		$http.post('/rest/upload/images', data, { // post lên server
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.hinhAnh = resp.data.name; // trả về name
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
})