app.service('userService',['$http', function ($http) {
     
    this.saveUser = function saveUser(user){
        return $http({
          method: 'POST',
          url: 'rest/utente/save',
          data: user,
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }
    
    this.getUser = function getUsers(user){
        return $http({
          method: 'POST',
          url: 'rest/utente/login',
          data: user,
          headers:'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }
     
    this.getUtente = function getUtente(username){
        return $http({
          method: 'GET',
          url: 'rest/utente/findByNome/'+username,
          headers:'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }
 
}]);