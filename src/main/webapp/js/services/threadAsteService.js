app.service('threadAsteService',['$http', function ($http) {
    //Restituisce gli oggetti in asta
    this.run = function run(oggetto){
        return $http({
          method: 'POST',
          url: 'rest/threadAste/run',
          data: oggetto,
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        });
    }
}]);