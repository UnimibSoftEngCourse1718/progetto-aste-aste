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
	}).when('/credito', {
		templateUrl : 'page/credito.html',
		controller : 'creditoController'
	}).when('/offerteAttive', {
		templateUrl : 'page/offerteAttive.html',
		controller : 'offerteAttiveController'
	}).when('/creaCategoria', {
		templateUrl : 'page/creaCategoria.html',
		controller : 'categoriaController'
	}).when('/mieiOggetti', {
		templateUrl : 'page/mieiOggetti.html',
		controller : 'mieiOggettiController'
	}).when('/oggVinti', {
		templateUrl : 'page/oggVinti.html',
		controller : 'oggettiVintiController'
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
        		$("#user").show();
        	}else{
        		$("#profilo").hide();
        		$("#logout").hide();
        		$("#login").show();
        		$("#user").hide();
        	}
        }
        $rootScope.getSessionUser();
        
        $rootScope.logOut = function() {
			$window.sessionStorage.removeItem("USER_USERNAME");
			$window.sessionStorage.removeItem("USER_ID");
			$rootScope.getSessionUser();
		}
    }
]);