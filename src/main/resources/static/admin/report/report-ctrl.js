app.controller("report-ctrl", function($scope, $http) {
    $scope.items = [];
    $scope.i = [];
    $scope.j = [];

    $scope.thongKe = function() {
        // load thống kê sản phẩm theo category
        $http.get("/rest/reports").then(resp => {
            $scope.items = resp.data;
        })
    }

    $scope.doanhThuHomNay = function() {
        // load thống kê doanh thu ngày hôm nay
        $http.get("/rest/reports/getDoanhThu").then(resp => {
            $scope.i = resp.data;
        })
    }

    $scope.sanPhamHomNay = function() {
        // load sản phẩm bán được ngày hôm nay
        $http.get("/rest/reports/getSanPham").then(resp => {
            $scope.j = resp.data;
        })
    }

    $scope.doanhThuHomNay();
    $scope.sanPhamHomNay();
    $scope.thongKe();

})