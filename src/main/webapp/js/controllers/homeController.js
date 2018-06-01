app.controller('homeController', [ 
	'$rootScope',
	'$scope', 
	'$window',
	'oggettiService',
	function($rootScope, $scope, $window, oggettiService) {
		$scope.listOggettiInAsta = [];
		$scope.getOggettiInAsta = function(user) {
			oggettiService.oggettiInAsta().then(
					function(response) {
						if (response.esito == "OK") {
							$scope.listOggettiInAsta = response.data;
						} else {
							$window.alert("Errore");
						}
					});
		}
		$scope.getOggettiInAsta();

	} 
]);