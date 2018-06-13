app.controller('categoriaController', [ 
	'$scope',
	'$window',
	'categoriaService',
	function($scope, $window, categoriaService) {
		$scope.creaCategoria = function() {
			
			var cat = {};
			
			var categoria = {};
			categoria.nome = $scope.nome;
			
			var att1 = {};
			att1.nome = $scope.att1;
			var att2 = {};
			att2.nome = $scope.att2;
			
			cat.categoria = categoria;
			cat.attributi = [att1,att2];
			
			categoriaService.saveCat(cat).then(function(response) {
				if(response.esito == "OK"){
					$window.alert("Categoria registrata");
					$window.location.href = '#/home';
				}else{
					$window.alert("Errore");
				}
			});
			
		}
		
	}
]);