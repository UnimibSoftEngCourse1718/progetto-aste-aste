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
		controller : 'utenteController'
	}).when('/aggiungiOgg', {
		templateUrl : 'page/aggiungiOgg.html',
		controller : 'oggettoController'
	}).when('/dettaglio/:id', {
		templateUrl : 'page/dettaglio.html',
		controller : 'dettaglioController'
	}).otherwise({
		redirectTo : '/home'
	});
	

}]);

app.run(['$rootScope', '$window',
    function($rootScope, $window){
        $rootScope.getSessionUser = function(){
        	if($window.sessionStorage.getItem('USER_USERNAME')!= null){
        		$("#profilo").show();
        		$("#logout").show();
        		$("#login").hide();
        	}else{
        		$("#profilo").hide();
        		$("#logout").hide();
        		$("#login").show();
        	}
        }
        $rootScope.getSessionUser();
        $rootScope.logOut = function() {
			$window.sessionStorage.removeItem("USER_USERNAME");
			$window.sessionStorage.removeItem("USER_ID");
	    		$("#logout").hide();
	    		$("#profilo").hide();
	    		$("#login").show();
	    		$window.alert("Log out");
		}
    }
]);