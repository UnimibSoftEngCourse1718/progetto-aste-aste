app.controller('dettaglioController', [ 
	'$scope', 
	'$window',
	'oggettoService',
	'$routeParams',
	function($scope, $window, oggettoService, $routeParams) {
		
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
	}
]);