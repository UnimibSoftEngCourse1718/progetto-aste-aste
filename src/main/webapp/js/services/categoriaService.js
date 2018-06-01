app.service('categoriaService',['$http', function ($http) {
    //Restituisce gli oggetti in asta
    this.findAllCategoria = function findAllCategoria(){
        return $http({
          method: 'GET',
          url: 'rest/categoria/findAll',
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        });
    }
}]);