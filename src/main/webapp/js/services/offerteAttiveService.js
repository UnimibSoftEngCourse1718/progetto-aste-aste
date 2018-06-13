app.service('offerteAttiveService',['$http', function ($http) {
    //Restituisce le offerte attive di un utente
    this.offerteAttive = function offerteAttive(id){
        return $http({
          method: 'GET',
          url: 'rest/offerta/findAllOfferteUtente/'+ id,
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        });
    }
}]);