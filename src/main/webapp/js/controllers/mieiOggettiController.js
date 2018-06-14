app.controller('mieiOggettiController', [ 
	'$scope', 
	'$window',
	'userService',
	function($scope, $window, userService) {
		
		// Funzione che mostra tutti gli oggetti dell'utente in sessione
		$scope.getMieiOggetti = function() {
			userService.getUtente($window.sessionStorage.USER_USERNAME).then(
					function(response) {
						if (response.esito == "OK") {
							$scope.listOggetti = response.data.oggetto;
						} else {
							$window.alert("Errore");
						}
					});
		}
		$scope.getMieiOggetti();
	}
]);