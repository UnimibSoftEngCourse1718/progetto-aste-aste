app.controller('oggettiVintiController', [ 
	'$scope', 
	'$window',
	'offerteAttiveService',
	function($scope, $window,offerteAttiveService) {
		$scope.getOggVinti = function() {
			offerteAttiveService.getOggVinti($window.sessionStorage.USER_ID).then(
					function(response) {
						if (response.esito == "OK") {
							$scope.listOggVinti = response.data;
						} else {
							$window.alert("Errore");
							$scope.loggedIn = null;
						}
					});
		}
		$scope.getOggVinti();
		
	}
	
]);