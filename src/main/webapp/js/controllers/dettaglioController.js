app.controller('dettaglioController', [ 
	'$scope', 
	'$window',
	'oggettoService',
	'offerteAttiveService',
	'threadAsteService',
	'$routeParams',
	function($scope, $window, oggettoService,offerteAttiveService,threadAsteService, $routeParams) {
		
		// Funzione per trovare un oggetto a partire da un id
		$scope.oggetto = {};
		$scope.astaTime = null;
		$scope.getOggetto = function() {
			
			oggettoService.findOggetto($routeParams.id).then(
					function(response) {
						if (response.esito == "OK") {
							$scope.oggetto = response.data;
							// funzione per calcolare il tempo rimanete
							// dell'asta
							findFirstOfferteByOggetto($scope.oggetto);
						} else {
							$window.alert("Errore");
						}
					});
		};
		$scope.getOggetto();

		var astaTimeInterval = setInterval(astaTimeFunction, 1000);
		
		var findFirstOfferteByOggetto = function(oggetto){
			offerteAttiveService.findFirstOfferteByOggetto(oggetto).then(	
				function(response) {
					if (response.esito == "OK") {
						$scope.astaTimeIniziale = response.data;
					} else {
						$window.alert("Errore");
					}
				});
		}
		
		function astaTimeFunction(){
			var stamp = $scope.oggetto.tempoAsta - Math.floor((new Date().valueOf() - $scope.astaTimeIniziale) / 1000 / 60) ;
			if($scope.astaTimeIniziale!=null){
				var string = "Mancano: " + stamp + " minuti al termine dell'asta";
				if(stamp<=0){
					clearInterval(astaTimeInterval);
					string = "VENDUTO";
				}
				
				document.getElementById("demo").innerHTML = string;
			}
		}
		
		// Funzione per fare un'offerta
		$scope.doOfferta = function() {
			
			var utente = {};
			utente.idUtente = $window.sessionStorage.USER_ID;
			
  			var offerta = {};
  			offerta.stato = "ATTIVO";
  			offerta.importo = parseFloat($scope.importoOfferta);
  			offerta.idOggetto = $scope.oggetto;
  			offerta.idUtente = utente;
  			// Formato data per MySql
  			// offerta.data = (new Date ((new Date((new Date(new
  			// Date())).toISOString() )).getTime() - ((new
  			// Date()).getTimezoneOffset()*60000))).toISOString().slice(0,
  			// 19).replace('T', ' ');
  			offerta.data = new Date();
  			findFirstOfferteByOggetto($scope.oggetto);
  			oggettoService.doOfferta(offerta).then(
				function(response) {
					if(response.esito == "OK"){
						$window.alert("Offerta effettuata correttamente");
						if($scope.astaTimeIniziale==null){
							threadAsteService.run($scope.oggetto).then(function(response) {
								if(response.esito == "OK"){
									$window.alert("Oggetto " + $scope.oggetto.nome + " venduto");
								} else{
									$window.alert("Errore");
								}
							});
							findFirstOfferteByOggetto($scope.oggetto);
						}
							
					} else{
						$window.alert("Errore");
					}
				}
			);
		}
		
		if ($window.sessionStorage.getItem('USER_USERNAME') != null) 
			$scope.enabled = true;
		else
			$scope.enabled = false;
		
	}]);