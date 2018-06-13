app.service('creditoService',['$http', function ($http) {
     
    this.addCredito = function addCredito(credito){
        return $http({
          method: 'POST',
          url: 'rest/credito/save',
          data: credito,
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }
 
}]);