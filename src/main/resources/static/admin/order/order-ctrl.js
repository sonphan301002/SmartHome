app.controller("order-ctrl", function($scope, $http) {
    $scope.items  = [];
    $scope.form = {};

    $scope.initialize = function() {
        //load product
        $http.get("/rest/orders").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });
        // //load category
        // $http.get("/rest/categories").then(resp => {
        //     $scope.cates = resp.data;
        // });
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

    //chỉnh sửa
    $scope.edit = function(item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs button:eq(0)").tab('show')
    };

    //thêm mới
    $scope.create = function() {
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm sản phẩm thành công!");
        }).catch(error => {
            alert("Lỗi thêm sản phẩm!");
            console.log("Error", error);
        });
    };

    //cập nhật
    $scope.update = function() {
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập nhật sản phẩm thành công!");
        }).catch(error => {
            alert("Lỗi cập nhật sản phẩm!");
            console.log("Error", error);
        });
    };

    //xóa
    $scope.delete = function(item) {
        var item = angular.copy($scope.form);
        $http.delete(`/rest/products/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xóa sản phẩm thành công!");
        }).catch(error => {
            alert("Lỗi xóa sản phẩm!");
            console.log("Error", error);
        });
    };

    //upload hình ảnh
    $scope.imageChanged = function(files) {
        var data = new FormData(); // đối tương FormData
        data.append('file', files[0]); // chọn file bỏ vào FormData
        $http.post('/rest/upload/img', data, { // post lên server
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.image = resp.data.name; // trả về name
        }).catch(error => {
            alert("Lỗi upload hình ảnh");
            console.log("Error", error);
        })
    }

    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
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
            this.page = this.count -1;
        }
    }
});