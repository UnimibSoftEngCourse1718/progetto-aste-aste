'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('aste', []);

	app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/home', {
		templateUrl : 'page/home.html',/*
		controller : 'AsteController'*/
	}).when('/login', {
		templateUrl : 'page/login.html',
		controller : 'LoginController'
	}).otherwise({
		redirectTo : '/home'
	});
} ]);
