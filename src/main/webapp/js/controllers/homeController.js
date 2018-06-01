app.controller('homeController', [ 
	'$rootScope',
	'$scope', 
	'$window',
	'oggettoService',
	function($rootScope, $scope, $window, oggettoService) {
		$scope.listOggettiInAsta = [];
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
		$scope.getOggettiInAsta();

	} 
]);