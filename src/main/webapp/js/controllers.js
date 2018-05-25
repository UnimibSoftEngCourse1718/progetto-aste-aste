'use strict';

/* Controllers */


var app = angular.module('aste.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});


app.controller('MyCtrl1', ['$scope', 'UserFactory', function ($scope, UserFactory) {
    $scope.bla = 'bla from controller';
    UserFactory.get({}, function (userFactory) {
        $scope.firstname = userFactory.firstName;
    })
}]);

app.controller('CtrlLogin', ['$scope', 'LoginFactory', function ($scope, LoginFactory) {
	
	 $scope.myFunc = function() {
		    LoginFactory.get({}, function (response) {
		        if(response.esito == "ok")
		        		alert("bravo");
		    })
	 };
		
}]);
