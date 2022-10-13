app.controller("product-ctrl", function($scope, $http) {
	$scope.items = [];
	
	$scope.form = {};
	
	$scope.cates = [];
	
	$scope.supps = [];
	
	$scope.init = function(){
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
	
	$scope.reset = function(){
		$scope.form = {
			ngayTao: new Date(),
			ngaySua: new Date(),
			hinhAnh: 'cloud-3.png',
		};
	}
	
	$scope.edit = function(product){
		$scope.form = angular.copy(product); // copy item
		$(".nav-tabs a:eq(0)").tab('show'); // chuyển lại tab đầu tiên
	}
	
	$scope.add = function(){
		var item = angular.copy($scope.form);
		$http.post('/rest/products', item).then(resp => {
			resp.data.ngayTao = new Date(resp.data.ngayTao);
			resp.data.ngaySua = new Date(resp.data.ngaySua);
			$scope.items.push(resp.data); // thêm vào trong list items
			$scope.reset();
			alert("Thêm mới thành công")
		}).catch(error => {
			alert("Thêm mới thất bại");
			console.log("Error", error);
		});
	}
	
	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http.put(`/rest/products/${item.maSP}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maSP == item.maSP)
			$scope.items[index] = item;
			$scope.reset();
			alert("Cập nhật thành công")
		}).catch(error => {
			alert("Cập nhật thất bại");
			console.log("Error", error);
		});
	}
	
	$scope.delete = function(item) {
		$http.delete(`/rest/products/${item.maSP}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maSP == item.maSP)
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa thành công")
		}).catch(error => {
			alert("Xóa thất bại");
			console.log("Error", error);
		});
	}
	
	$scope.deleteCate = function(item) {
		$http.delete(`/rest/categories/${item.maDM}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.maDM == item.maDM)
			$scope.items.splice(index, 1);
			alert("Xóa thành công")
		}).catch(error => {
			alert("Xóa thất bại");
			console.log("Error", error);
		});
	}
	
	$scope.imageChanged = function(files) {
		var data = new FormData(); // đối tương FormData
		data.append('file', files[0]); // chọn file bỏ vào FormData
		$http.post('/rest/upload/images', data, { // post lên server
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.image = resp.data.name; // trả về name
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		})
	}
	
	$scope.init();
})