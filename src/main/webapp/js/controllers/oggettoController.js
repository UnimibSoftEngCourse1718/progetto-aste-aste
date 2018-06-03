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
			var oggetto = {};
			var attributiValore = {};
			userService.getUtente($window.sessionStorage.getItem('USER_USERNAME')).then(
					function(response) {
						if (response.esito == "OK") {
							oggetto.utente = response.data;
						} else {
							$window.alert("Errore");
						}
					});
			oggetto.nome = $scope.nomeOggetto;
			oggetto.categoria = $scope.categoria;
			for (i = 0; i < $scope.listAttributi.length; i++) { 
				var string = "attributo_"+i;
				attributiValore[$scope.listAttributi[i].idAttributo] = $scope.$eval(string);
			}
			oggetto.attributiValore = attributiValore;
			
			oggettoService.saveOggetto(oggetto).then(
					function(response) {
						if (response.esito == "OK") {
							$window.alert("Aggiunto");
						} else {
							$window.alert("Errore");
						}
					});
		};
	}
]);