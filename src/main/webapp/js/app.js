'use strict';

// Declare app level module which depends on filters, and services
var app = angular.module('aste', []);

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/home', {
		templateUrl : 'page/home.html',
		controller : 'homeController'
	}).when('/login', {
		templateUrl : 'page/login.html',
		controller : 'loginController'
	}).when('/registrati', {
		templateUrl : 'page/registrati.html',
		controller : 'loginController'
	}).when('/profilo', {
		templateUrl : 'page/profilo.html',
		controller : 'loginController'
	}).when('/dettaglio', {
		templateUrl : 'page/dettaglio.html',
		controller : 'dettaglioController'
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
        		$("#login").hide();
        	}else{
        		$("#profilo").hide();
        		$("#logout").hide();
        		$("#login").show();
        	}
        }
        
        $rootScope.logOut = function() {
			$window.sessionStorage.removeItem("USER");
    		$("#logout").hide();
    		$("#profilo").hide();
    		$("#login").show();
    		$window.alert("Log out");
		}
    }
]);