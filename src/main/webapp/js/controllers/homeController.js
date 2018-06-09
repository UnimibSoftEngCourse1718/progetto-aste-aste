app.controller('homeController', [ 
	'$rootScope',
	'$scope', 
	'$window',
	'oggettoService',
	function($rootScope, $scope, $window, oggettoService) {
		$scope.listOggettiInAsta = [];
		$scope.listOggetti = [];
		$scope.getOggettiInAsta = function(user) {
			oggettoService.oggettiInAsta().then(
					function(response) {
						if (response.esito == "OK") {
							$scope.listOggettiInAsta = response.data;
						} else {
							$window.alert("Errore");
						}
					});
		};
		
		$scope.findAll = function() {
			oggettoService.findAll().then(
					function(response) {
						if (response.esito == "OK") {
							$scope.listOggetti = response.data;
						} else {
							$window.alert("Errore");
						}
					});
		};
		$scope.findAll();

	} 
]);