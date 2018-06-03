app.controller('utenteController', [ 
	'$scope',
	'$window',
	'userService',
	function($scope, $window, userService) {
		$scope.user = {};
		$scope.getProfile = function() {
			userService.getUtente($window.sessionStorage.USER_USERNAME).then(
					function(response) {
						if (response.esito == "OK") {
							$scope.user = response.data;
						} else {
							$window.alert("Errore");
							$scope.loggedIn = null;
						}
					});
		}
		$scope.getProfile();
	}
]);