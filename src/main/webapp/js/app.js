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
	}).when('/registrati', {
		templateUrl : 'page/registrati.html',
		controller : 'LoginController'
	}).when('/profilo', {
		templateUrl : 'page/profilo.html',
		controller : 'LoginController'
	}).otherwise({
		redirectTo : '/home'
	});
	

} ]);

app.run(['$rootScope', '$window',
    function($rootScope, $window){
        $rootScope.getSessionUser = function(){
        	if($window.sessionStorage.getItem('USER')!= null){
        		$("#profilo").show();
        		$("#logout").show();
        	}else{
        		$("#logout").hide();
        		$("#profilo").hide();
        	}
        }
        
        $rootScope.logOut = function() {
			$window.sessionStorage.removeItem("USER");
    		$("#logout").hide();
    		$("#profilo").hide();
			alert("Log out");
		}
    }
]);