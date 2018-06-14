app.controller('oggettoController', [ 
	'$scope', 
	'$window',
	'oggettoService',
	'categoriaService',
	'userService',
	function($scope, $window, oggettoService,categoriaService,userService) {
		
		$scope.listCategoria = [];
		$scope.listAttributi = [];
		$scope.getListCategoria = function() {			
			categoriaService.findAllCategoria().then(
					function(response) {
						if (response.esito == "OK") {
							$scope.listCategoria = response.data;
						} else {
							$window.alert("Errore");
						}
					});
		};
		$scope.getListCategoria();
		
		$scope.caricaAttributi = function() {
			$scope.listAttributi = $scope.categoria.attributi;
		};	
		
		$scope.aggiungiOggetto = function() {
			var body = {};
			var oggetto = {};
			var attributiValore = {};
			userService.getUtente($window.sessionStorage.getItem('USER_USERNAME')).then(
				function(response) {
					if (response.esito == "OK") {
						oggetto.utente = response.data;
						oggetto.nome = $scope.nomeOggetto;
						oggetto.categoria = $scope.categoria;
						oggetto.tempoAsta = $scope.tempoAsta;
						for (let i = 0; i < $scope.listAttributi.length; i++) { 
							var string = "attributo_"+i;
							attributiValore[$scope.listAttributi[i].idAttributo] = $("#"+string).val();
						}
						body.attributiValore = attributiValore;
						body.oggetto = oggetto;
						oggettoService.saveOggetto(body).then(
								function(response) {
									if (response.esito == "OK") {
										$window.alert("Aggiunto");
										$window.location.href = '#/profilo';
									} else {
										$window.alert("Errore");
									}
								});
					} else {
						$window.alert("Errore");
					}
				});
		};
	}
]);