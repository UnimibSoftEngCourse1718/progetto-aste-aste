app.controller('dettaglioController', [ 
	'$scope', 
	'$window',
	'oggettoService',
	'$routeParams',
	function($scope, $window, oggettoService, $routeParams) {
		
		// Funzione per trovare un oggetto a partire da un id
		$scope.oggetto = {};
		$scope.getOggetto = function() {
			
			oggettoService.findOggetto($routeParams.id).then(
					function(response) {
						if (response.esito == "OK") {
							$scope.oggetto = response.data;
						} else {
							$window.alert("Errore");
						}
					});
		};
		$scope.getOggetto();
		
		// Funzione per fare un'offerta
		$scope.doOfferta = function() {
			
			var utente = {};
			utente.idUtente = $window.sessionStorage.USER_ID;
			
			var oggetto = {};
			oggetto.idOggetto = $scope.oggetto.idOggetto;
			
			var offerta = {};
			offerta.stato = "ATTIVO";
			offerta.importo = parseFloat($scope.importoOfferta);
			offerta.idOggetto = oggetto;
			offerta.idUtente = utente;
			//Formato data per MySql
			offerta.data =  (new Date ((new Date((new Date(new Date())).toISOString() )).getTime() - ((new Date()).getTimezoneOffset()*60000))).toISOString().slice(0, 19).replace('T', ' ');
			
			oggettoService.doOfferta(offerta).then(
					function(response) {
						if(response.esito == "OK"){
							$window.alert("Offerta effettuata correttamente");
						} else{
							$window.alert("Errore durante l'offerta");
						}
					});
		}
		
	}]);