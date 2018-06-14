app.controller('categoriaController', [ 
	'$scope',
	'$window',
	'categoriaService',
	function($scope, $window, categoriaService) {
		
		var i=0;
		
		$scope.creaCategoria = function() {
			
			var cat = {};
			
			var categoria = {};
			categoria.nome = $scope.nome;
			
			cat.categoria = categoria;
		
			cat.attributi = [];
			
			for(a=0;a<i;a++)
			{
				var att = {};
				att.nome = $("#att"+a).val();
				cat.attributi[a]=att;
			}
				
			categoriaService.saveCat(cat).then(function(response) {
				if(response.esito == "OK"){
					$window.alert("Categoria registrata");
					$window.location.href = '#/home';
				}else{
					$window.alert("Errore");
				}
			});
			
		}
		
		$scope.aggiungitext = function(){
			var j = i+1;
            $("#myform").append("Attributo "+ j +": <input type='text' id='att"+ i +"' name='att"+ i +"' data-ng-model='att"+ i +"'/></br>");
                i++;
        }	
	}
]);