'use strict';

// Declare app level module which depends on filters, and services
angular.module('aste', ['aste.filters', 'aste.services', 'aste.directives', 'aste.controllers']).
    config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/home', {templateUrl: 'home.html'});
        $routeProvider.otherwise({redirectTo: '/home'});
        $routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
        $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller:"CtrlLogin"});
    }]);
