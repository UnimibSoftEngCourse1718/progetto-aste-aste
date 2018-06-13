app.controller('offerteAttiveController', [ 
	'$scope', 
	'$window',
	'offerteAttiveService',
	function($scope, $window,offerteAttiveService) {
		
		$scope.getOfferta = function() {
			offerteAttiveService.offerteAttive($window.sessionStorage.USER_ID).then(
					function(response) {
						if (response.esito == "OK") {
							$scope.listOfferta = response.data;
						} else {
							$window.alert("Errore");
							$scope.loggedIn = null;
						}
					});
		}
		$scope.getOfferta();
		
	}
]);