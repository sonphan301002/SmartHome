<<<<<<< HEAD
app.controller("authority-ctrl", function($scope, $http) {
	
=======
app.controller("authority-ctrl", function($scope, $http, $location) {
	$scope.roles = [];
	
	$scope.admins = [];
	
	$scope.authorities = [];
	
	$scope.init = function(){
		// load role
		$http.get("/rest/roles").then(resp => {
			$scope.roles = resp.data;
		})
		
		// load staff and director
		$http.get("/rest/accounts?admin=true").then(resp => {
			$scope.admins = resp.data;
		})
		
		// load authorities and staff and director
		$http.get("/rest/authorities?admin=true").then(resp => { // tải các quyền
			$scope.authorities = resp.data;
		}).catch(error => {
			$location.path("/unauthorized")
		})
	}
	
	$scope.authority_of = function(acc, role){
		if($scope.authorities){ // có hay k
			return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id); // tìm kiếm
		}
	}
	
	$scope.authority_changed = function(acc, role){
		var authority = $scope.authority_of(acc, role);
		
		if(authority){ // đã cấp quyền => thu hồi
			$scope.revoke_authority(authority);
		}else{ // chưa đc cấp quyền => cấp quyền
			authority = {account: acc, role: role};
			$scope.grant_authority(authority);
		}
	}
	
	$scope.grant_authority = function(authority){
		$http.post(`/rest/authorities`, authority).then(resp => {
			$scope.authorities.push(resp.data);
			alert("Cấp quyền thành công");
		}).catch(error => {
			alert("Cấp quyền thất bại");
			console.log("Error", error);
		})
	}
	
	$scope.revoke_authority = function(authority){
		$http.delete(`/rest/authorities/${authority.maPQ}`).then(resp => {
			var index = $scope.authorities.findIndex(a => a.maPQ == authority.maPQ);
			$scope.authorities.splice(index, 1); // xóa
			alert("Thu hồi thành công");
		}).catch(error => {
			alert("Thu hồi thất bại");
			console.log("Error", error);
		})
	}
	
	$scope.init();
>>>>>>> e25c5e4f1893f3031b96ee537d3e99fc3524c4ac
})