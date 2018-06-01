app.controller('oggettoController', [ 
	'$scope', 
	'$window',
	'oggettoService',
	'categoriaService',
	'$routeParams',
	function($scope, $window, oggettoService,categoriaService, $routeParams) {
		
		$scope.listCategoria = {};
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
	}
]);