app.controller("report-ctrl", function($scope, $http) {
    $scope.items = [];

    $scope.thongKe = function() {
        // load thống kê sản phẩm theo category
        $http.get("/rest/reports").then(resp => {
            $scope.items = resp.data;
        })
    }
    $scope.thongKe();

    function buildChart(id) {
        const data = {
            labels: [
                'Red',
                'Blue',
                'Yellow'
            ],
            datasets: [{
                label: 'My First Dataset',
                data: [300, 50, 100],
                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(54, 162, 235)',
                    'rgb(255, 205, 86)'
                ],
                hoverOffset: 4
            }]
        };
        const config = {
            type: 'doughnut',
            data: data,
        };
        let ctx = document.getElementById(id).getContext("2d")

        new Chart(ctx, config);
    }
})