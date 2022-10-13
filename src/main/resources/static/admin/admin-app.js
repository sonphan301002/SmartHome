app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/product", {
		templateUrl: "/admin/product/product.html",
		controller: "product-ctrl"
	})
	.when("/product-add", {
		templateUrl: "/admin/product/add-product.html",
		controller: "product-ctrl"
	})
	.when("/category", {
		templateUrl: "/admin/category/category.html",
		controller: "category-ctrl"
	})
	.when("/account", {
		templateUrl: "/admin/account/index.html",
		controller: "account-ctrl"
	})
	.when("/account-add", {
		templateUrl: "/admin/account/add-accounts.html",
		controller: "account-ctrl"
	})
	.when("/authority", {
		templateUrl: "/admin/authority/authority.html",
		controller: "authority-ctrl"
	})
	.when("/supplier", {
		templateUrl: "/admin/supplier/NCC.html",
		controller: "supplier-ctrl"
	})
	.when("/order", {
		templateUrl: "/admin/order/donhang.html",
		controller: "order-ctrl"
	})
	.otherwise({
		templateUrl: "/admin/order/donhang.html",
		controller: "order-ctrl"
	})
})