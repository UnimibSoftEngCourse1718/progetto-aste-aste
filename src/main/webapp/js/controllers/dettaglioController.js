app.controller('dettaglioController', [ 
	'$scope', 
	'$window',
	'oggettoService',
	'offerteAttiveService',
	'threadAsteService',
	'userService',
	'$routeParams',
	function($scope, $window, oggettoService,offerteAttiveService,threadAsteService,userService, $routeParams) {
		
		var utente = {};
		
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
		
		var findFirstOfferteByOggetto = function(oggetto) {
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

			getMaxOfferta();
			
			if($scope.astaTimeIniziale!=null) {

				var string = "Mancano: " + stamp + " minuti al termine dell'asta";
				if(stamp<=0){
					clearInterval(astaTimeInterval);
					string = "VENDUTO";
				}
				
				if(document.getElementById("demo"))
					document.getElementById("demo").innerHTML = string;
			}
		}
		
		userService.getUtente($window.sessionStorage.USER_USERNAME).then(	
				function(response) {
					if (response.esito == "OK") {
						utente = response.data;
					} else {
						$window.alert("Errore");
					}
				});
		
		// Funzione per fare un'offerta
		$scope.doOfferta = function() {			
			
			if(utente.credito>=parseFloat($scope.importoOfferta)){
	  			var offerta = {};
	  			offerta.stato = "ATTIVO";
	  			offerta.importo = parseFloat($scope.importoOfferta);
	  			offerta.idOggetto = $scope.oggetto;
	  			offerta.idUtente = utente;
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
								
						}else{
							$window.alert("Errore");
						}
					}
				);
			}else
				$window.alert("Non hai abbastanza credito");
		}
		
		// Mi serve per capire se mostrare o no l'immagine e il nome dell'utente connesso
		if ($window.sessionStorage.getItem('USER_USERNAME') != null) 
			$scope.enabled = true;
		else
			$scope.enabled = false;
		
		
		function getMaxOfferta() {
			// Cerco l'offerta maggiore corrente
			var offerta = {};
			
			offerteAttiveService.findMaxOffertaByOggetto($scope.oggetto).then(function(response) {
				
				if(response.esito == "OK") {

					offerta = response.data;

					if (offerta)
						$scope.offerer = "Offerta corrente: " + offerta.importo;
					else
						$scope.offerer = "Nessuna offerta corrente";
					
				}
				else
					$window.alert("Errore");
				
			});
		}
		
		
	}]);