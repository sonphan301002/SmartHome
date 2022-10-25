app.controller("order-ctrl", function($scope, $http) {
<<<<<<< HEAD
	
})
=======
    $scope.items  = [];
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

    //reset form
    $scope.reset = function() {
        $scope.form = {
            createDate: new Date(),
            image: "upload.png",
            available: true,
        }
    };

    //hiện chi tiết đơn hàng đồ đó
    $scope.edit = function(item) {
        $scope.form = angular.copy(item);
        $http.get(`/rest/orders/${item.maHD}`,item).then(resp => {
            $scope.oditems = resp.data;
            //tính tiền đồ đó
            var subtotal = 0;
            var discount = 0;
            var total = 0;
            for(var i = 0; i < $scope.oditems.length; i++){
                var oditems = $scope.oditems[i];
               subtotal += (oditems.donGia * oditems.soLuong);
               discount += (oditems.donGia * oditems.soLuong)*oditems.giamGia / 100;
            }
            $scope.oditems.subtotal = subtotal;
            $scope.oditems.discount = discount;
            total += subtotal - discount + 30000;
            $scope.oditems.total = total;
        });
        $(".nav-tabs a:eq(0)").tab('show')
    };

    $scope.update = function(){
        var item = angular.copy($scope.form);
        $scope.form.trangThai += 1;
        item.trangThai = $scope.form.trangThai;
        $http.put(`/rest/orders/${item.maHD}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.maHD == item.maHD)
            $scope.items[index] = item;
            alert("Cập nhật trạng thái đơn hàng thành công")
        }).catch(error => {
            alert("Cập nhật trạng thái đơn hàng thất bại");
            console.log("Error", error);
        });
    }
});
>>>>>>> e25c5e4f1893f3031b96ee537d3e99fc3524c4ac
