app.controller("authority-ctrl", function($scope, $http, $location) {
	$scope.roles = [];

	$scope.admins = [];

	$scope.authorities = [];

	$scope.init = function() {
		// load role
		$http.get("/rest/roles").then(resp => {
			$scope.roles = resp.data;
		})

		// load staff and director
		$http.get("/rest/account?admin=true").then(resp => {
			$scope.admins = resp.data;
		})

		// load authorities and staff and director
		$http.get("/rest/authorities?admin=true").then(resp => { // tải các quyền
			$scope.authorities = resp.data;
		}).catch(error => {
			$location.path("/unauthorized")
		})
	}

	$scope.authority_of = function(acc, role) {
		if ($scope.authorities) { // có hay k
			return $scope.authorities.find(ur => ur.taiKhoan.tenND == acc.tenND && ur.vaiTro.maVT == role.maVT); // tìm kiếm
		}
	}

	$scope.authority_changed = function(acc, role) {
		var authority = $scope.authority_of(acc, role);

		if (authority) { // đã cấp quyền => thu hồi
			$scope.revoke_authority(authority);
		} else { // chưa đc cấp quyền => cấp quyền
			authority = { taiKhoan: acc, vaiTro: role };
			$scope.grant_authority(authority);
		}
	}

	$scope.grant_authority = function(authority) {
		$http.post(`/rest/authorities`, authority).then(resp => {
			$scope.authorities.push(resp.data);
			Swal.fire({
				icon: 'success',
				title: 'Cấp quyền thành công',
				showConfirmButton: true,
				timer: 1500
			})
		}).catch(error => {
			Swal.fire({
				icon: 'warning',
				title: 'Cấp quyền thất bại',
				showConfirmButton: true,
				timer: 1500
			})
			console.log("Error", error);
		})
	}

	$scope.revoke_authority = function(authority) {
		$http.delete(`/rest/authorities/${authority.maPQ}`).then(resp => {
			var index = $scope.authorities.findIndex(a => a.maPQ == authority.maPQ);
			$scope.authorities.splice(index, 1); // xóa
			Swal.fire({
				icon: 'success',
				title: 'Thu hồi thành công',
				showConfirmButton: true,
				timer: 1500
			})
		}).catch(error => {
			Swal.fire({
				icon: 'warning',
				title: 'Thu hồi thất bại',
				showConfirmButton: true,
				timer: 1500
			})
			console.log("Error", error);
		})
	}

	$scope.init();
})