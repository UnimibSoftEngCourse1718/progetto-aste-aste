app.service('userService',['$http', function ($http) {
     
    this.saveUser = function saveUser(user){
        return $http({
          method: 'POST',
          url: 'rest/user/save',
          data: user,
          headers: 'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }
     
    this.getUser = function getUsers(user){
        return $http({
          method: 'POST',
          url: 'rest/user/find',
          data: user,
          headers:'Accept:application/json'
        }).then( function(response){
            return response.data;
        } );
    }
 
}]);