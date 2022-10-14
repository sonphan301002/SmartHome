app.controller("account-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	
	$scope.initialize = function() {
		//load tai khoan(get) AccountRestController
		$http.get("/rest/account").then(resp => {
			$scope.items = resp.data;
//			$scope.items.forEach(item => {
//				item.createDate = new Date(item.createDate)//chuyen doi ngay thang
//			})
		});

		//load category
//		$http.get("/rest/categories").then(resp => {
//			$scope.cates = resp.data;
//
//		});

	}
	//khoi dau(tai het dữ liệu cân thiết lên)
	$scope.initialize();
	
	//xoa form
	$scope.reset = function() {
		$scope.form = {
			

		};
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
			//resp.data.createDate = new Date(resp.data.createDate)//chuyen doi ngay
			$scope.items.push(resp.data);//push len list
			$scope.reset();
			$scope.initialize();
			alert("Them moi thanh cong!");
		}).catch(error => {
			alert("Loi them moi san pham!");
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
			alert("Cap nhat thanh cong!");
		}).catch(error => {
			alert("Loi cap nhat san pham!");
			console.log("Error", error);
		});
	}
	
	//xoa
	$scope.delete = function(item) {
		$http.delete(`/rest/account/${item.tenND}`, item).then(resp => {

			//tim và thay đổi id giong vs server
			var index = $scope.items.findIndex(p => p.tenND == item.tenND);
			$scope.items.splice(index, 1);//splice để xóa
			$scope.reset();
			$scope.initialize();
			alert("Xoa thanh cong!");
		}).catch(error => {
			alert("Loi xoa san pham!");
			console.log("Error", error);
		});
	}
	
	//phan trang
	$scope.pager = {
		page: 0,
		size: 10,
		get items() {//lọc sp theo trang
			var start = this.page * this.size;//vị trí bắt đầu
			return $scope.items.slice(start, start + this.size);
		},
		get count() {//tính tổng số trang
			return Math.ceil(1.0 * $scope.items.length / this.size);//tong so phan tu chi cho kich thước
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}
});