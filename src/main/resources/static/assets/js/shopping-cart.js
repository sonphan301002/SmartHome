const app = angular.module("shopping-cart-app", [])

app.controller("shopping-cart-ctrl", function($scope, $http) {
	$scope.cart = {
		items: [],
		//thêm sản phẩm vào giỏ hàng
		add(maSP) {
			//kiểm tra xem giỏ hàng đã có mặt hàng này hay chưa
			var item = this.items.find(item => item.maSP == maSP);
			if (item) {
				//nếu mặt hàng đã có thì tăng số lượng
				item.soLuong++;
				this.saveToLocalStorage();
				Swal.fire({
					icon: 'success',
					title: 'Thêm vào giỏ thành công',
					showConfirmButton: true
				});
			} else {
				//tải sản phẩm từ server về
				$http.get(`/rest/products/${maSP}`).then(resp => {
					resp.data.soLuong = 1;
					//thêm vào danh sách
					this.items.push(resp.data);
					this.saveToLocalStorage();
					Swal.fire({
						icon: 'success',
						title: 'Thêm vào giỏ thành công',
						showConfirmButton: true
					});
				})
			}
		},
		//xóa sản phẩm khỏi giỏ hàng
		remove(maSP) {
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
					//tìm vị trí của sản phẩm trong giỏ hàng
					var index = this.items.findIndex(item => item.maSP == maSP);
					//xóa sản phẩm khỏi mảng
					this.items.splice(index, 1);
					//lưu lại
					this.saveToLocalStorage();
					location.reload();
				}
			})
		},
		
		clear(){
			this.items= []; // items rổng
			this.saveToLocalStorage();
		},
		
		//xóa toàn bộ sản phẩm trong giỏ hàng
        clear(){
            this.items = []
            this.saveToLocalStorage();
        },
		//tính tổng tiền của một sản phẩm
		amt_of(item) { },
		//tính tổng số lượng các mặt hàng trong giỏ hàng
		get count() {
			return this.items
				.map(item => item.soLuong)
				.reduce((total, soLuong) => total += soLuong, 0);
		},
		//tính tổng tiền các mặt hàng trong giỏ hàng
		get amount() {
			return this.items
				.map(item => item.soLuong * item.gia)
				.reduce((total, soLuong) => total += soLuong, 0);
		},
		//lưu giỏ hàng vào local storage
		saveToLocalStorage() {
			//đổi mảng sang json
			var json = JSON.stringify(angular.copy(this.items));
			//lưu chuổi json vào local
			localStorage.setItem("cart", json);
		},
		//đọc giỏ hàng từ local storage
		loadFromLocalStorage() {
			var json = localStorage.getItem("cart")
			this.items = json ? JSON.parse(json) : [];
		}
	}

	$scope.cart.loadFromLocalStorage();

// ORDERS
	$scope.items = [];
	$scope.detail = [];
	$scope.info = {};

	$scope.initialize = function() {
		//load order
		$http.get("/rest/orders").then(resp => {
			$scope.items = resp.data;
		});
	}

	$scope.initialize();
	
	$scope.order = {
		ngayTao: new Date(),
		ngaySua: new Date(),
		trangThai: 1,
		thanhToan: "",
		taiKhoan: {tenND: $("#tenND").text()},
		get hoaDonChiTiet() {
			return $scope.cart.items.map(item => {
				return {
					sanPham: {maSP: item.maSP},
					donGia: item.gia,
					soLuong: item.soLuong,
					giamGia: item.giamGia,
					VAT: item.VAT
				}
			})
		},
		purcharse() {
			var order = angular.copy(this);
			//Đặt hàng
			$http.post("/rest/orders", order).then(resp => {
				Swal.fire({
					icon: 'success',
					title: 'Thanh toán thành công',
					showConfirmButton: true
				});
				// Xóa toàn bộ sản phẩm trong giỏ hàng
				$scope.cart.clear();
				// Chuyển trang
				location.href = "/order/orderDetail/" + resp.data.maHD;
			}).catch(error => {
				Swal.fire({
					icon: 'warning',
					title: 'Thanh toán thất bại',
					showConfirmButton: true
				})
				console.log(error);
			})
		},
	};

	$scope.detail = function(item) {
		$scope.info = angular.copy(item)
		$http.get(`/rest/orders/${item.maHD}`, item).then(resp => {
			$scope.detail = resp.data;
			
			var subtotal = 0;
			var VAT = 0.05;
			var discount = 0;
			var total = 0;

			for (var i = 0; i < $scope.detail.length; i++) {
				var detail = $scope.detail[i];
				subtotal += (detail.donGia * detail.soLuong);
				discount += (detail.donGia * detail.soLuong) * detail.giamGia / 100;
			}

			$scope.detail.subtotal = subtotal;
			$scope.detail.discount = discount;

			total += subtotal + (subtotal * VAT) - discount + 30000;

			$scope.detail.total = total;
		});
		location.href= "/order/orderDetail/" + item.maHD;
	};
	$scope.pager = {
		page: 0,
		size: 4,
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