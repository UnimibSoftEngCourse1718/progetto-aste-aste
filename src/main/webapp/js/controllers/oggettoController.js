app.controller('oggettoController', [ 
	'$scope', 
	'$window',
	'oggettoService',
	'categoriaService',
	function($scope, $window, oggettoService,categoriaService) {
		
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
			oggetto.nome = $scope.nomeOggetto;
			oggetto.categoria = $scope.categoria;
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