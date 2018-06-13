app.controller('creditoController', [ 
	'$rootScope',
	'$scope', 
	'$window',
	'creditoService',
	'userService',
	function($rootScope, $scope, $window, creditoService,userService) {
		var utente = {};
		$scope.getCredito = function(user) {
			userService.getUtente($window.sessionStorage.getItem("USER_USERNAME")).then(
					function(response) {
						if (response.esito == "OK") {
							utente = response.data;
							$scope.credito = response.data.credito;
						} else {
							$window.alert("Errore");
						}
					});
		};
		$scope.getCredito();	
		
		$scope.addCredito = function(user) {
			var credito = {};
			credito.idUtente = utente;
			credito.azione = 1;
			credito.quantita = $scope.aggCredito;
			creditoService.addCredito(credito).then(
					function(response) {
						if (response.esito == "OK") {
							$scope.getCredito();
						} else {
							$window.alert("Errore");
						}
					});
		};
		
		$scope.changeCredito = function(user) {
			if($scope.credito - $scope.cambiaCredito<0)
				$window.alert("Non hai abbastanza crediti");
			else{
				var credito = {};
				credito.idUtente = utente;
				credito.azione = 0;
				credito.quantita = $scope.cambiaCredito;
				creditoService.addCredito(credito).then(
						function(response) {
							if (response.esito == "OK") {
								$scope.getCredito();
							} else {
								$window.alert("Errore");
							}
						});
			}
		};

	} 
]);