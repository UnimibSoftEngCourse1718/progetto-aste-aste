app.service('oggettiService',['$http', function ($http) {
     
    this.oggettiInAsta = function oggettiInAsta(){
        return $http({
          method: 'GET',
          url: 'rest/offerta/findAllOggettoInAsta',
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    } 
}]);