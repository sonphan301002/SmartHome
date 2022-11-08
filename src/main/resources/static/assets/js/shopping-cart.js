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

	$scope.order = {
		ngayTao: new Date(),
		ngaySua: new Date(),
		trangThai: 1,
		hoTen: "",
		dienThoai: "",
		email: "",
		diaChi: "",
		ghiChu: "",
		trangThai: 1,
		taiKhoan: {tenND: $("#username").text()},
		get hoaDonChiTiet() {
			return $scope.cart.items.map(item => {
				return {
					sanPham: {maSP: item.maSP},
					donGia: item.gia,
					soLuong: item.soLuong,
					giamGia: item.giamGia,
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
				$scope.cart.clear();
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
		update() {
			var order = angular.copy(this);
			//Đặt hàng
			$http.put(`/rest/orders/${maHD}`, order).then(resp => {
				Swal.fire({
					icon: 'success',
					title: 'Cập nhật thành công',
					showConfirmButton: true
				});
				location.reload();
			}).catch(error => {
				Swal.fire({
					icon: 'warning',
					title: 'Cập nhật thất bại',
					showConfirmButton: true
				});
				console.log(error);
			})
		}
	}
})