app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/product", {
		templateUrl: "/admin/product/product.html",
		controller: "product-ctrl"
	})
<<<<<<< HEAD
	.when("/product-add", {
		templateUrl: "/admin/product/add-product.html",
		controller: "product-ctrl"
	})
=======
>>>>>>> e25c5e4f1893f3031b96ee537d3e99fc3524c4ac
	.when("/category", {
		templateUrl: "/admin/category/category.html",
		controller: "category-ctrl"
	})
	.when("/account", {
		templateUrl: "/admin/account/account.html",
		controller: "account-ctrl"
	})
<<<<<<< HEAD
	.when("/account-add", {
		templateUrl: "/admin/account/add-accounts.html",
		controller: "account-ctrl"
	})
=======
//	.when("/account-add", {
//		templateUrl: "/admin/account/add-accounts.html",
//		controller: "account-ctrl"
//	})
>>>>>>> e25c5e4f1893f3031b96ee537d3e99fc3524c4ac
	.when("/authority", {
		templateUrl: "/admin/authority/authority.html",
		controller: "authority-ctrl"
	})
	.when("/supplier", {
<<<<<<< HEAD
		templateUrl: "/admin/supplier/NCC.html",
=======
		templateUrl: "/admin/supplier/supplier.html",
>>>>>>> e25c5e4f1893f3031b96ee537d3e99fc3524c4ac
		controller: "supplier-ctrl"
	})
	.when("/order", {
		templateUrl: "/admin/order/donhang.html",
		controller: "order-ctrl"
	})
<<<<<<< HEAD
=======
	.when("/unauthorized", {
		templateUrl: "/admin/authority/authorized.html",
		controller: "authority-ctrl"
	})
>>>>>>> e25c5e4f1893f3031b96ee537d3e99fc3524c4ac
	.otherwise({
		templateUrl: "/admin/order/donhang.html",
		controller: "order-ctrl"
	})
})