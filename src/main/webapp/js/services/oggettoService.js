app.service('oggettoService',['$http', function ($http) {
     
    this.oggettiInAsta = function oggettiInAsta(){
        return $http({
          method: 'GET',
          url: 'rest/offerta/findAllOggettoInAsta',
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        });
    }
    
    // Chiamata a backend per prendere un oggetto dato l'id
    this.findOggetto = function findOggetto(id) {
        return $http({
          method: 'GET',
          url: 'rest/oggetto/findById/' + id,
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        });
    }
}]);