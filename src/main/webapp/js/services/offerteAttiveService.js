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
    
    this.findFirstOfferteByOggetto = function findFirstOfferteByOggetto(oggetto){
        return $http({
          method: 'POST',
          url: 'rest/offerta/findFirstOfferteByOggetto',
          data: oggetto,
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        });
    }
    
    // Funzione per trovare l' offerta massima corrente
    this.findMaxOffertaByOggetto = function findMaxOffertaByOggetto(oggetto) {
    	
    	return $http({
            method: 'POST',
            url: 'rest/offerta/findMaxOfferteByOggetto',
            data: oggetto,
            headers: 'Accept:application/json'
          }).then( function(response){
              return response.data;
          });
    	
    }
}]);