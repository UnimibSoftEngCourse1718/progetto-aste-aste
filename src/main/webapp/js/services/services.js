'use strict';

/* Services */

var services = angular.module('aste.services', ['ngResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/aste/rest/users', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});

services.factory('LoginFactory', function ($resource) {
    	$http({
    	    url: "/aste/rest/login/accedi",
    	    method: "POST",
    	    data: {"foo":"bar"}
    	}).success(function(data, status, headers, config) {
    	    $scope.data = data;
    	}).error(function(data, status, headers, config) {
    	    $scope.status = status;
    	});
});
