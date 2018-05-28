app.controller('LoginController', [ '$scope', 'UserService',
		function($scope, UserService) {

			$scope.getUser = function(user) {
				var user = {};
				user.username = $scope.username;
				user.password = $scope.password;
				UserService.getUser(user).then(function(response) {
					if (response.esito == "OK")
						alert("Ti sei Loggato");
					else
						alert("Le credenziali sono errate");
				});
			}
			/*
			$scope.saveUser = function() {
			   $scope.submitted = true;
			     if ($scope.userForm.$valid) {
			       UserService.saveUser($scope.user)
			         .then (function success(response) {
			             $scope.message = 'User added!';
			             $scope.errorMessage = '';
			             $scope.getUsers();
			             $scope.user = null;
			             $scope.submitted = false;
			         },
			         function error(response) {
			             if (response.status == 409) {
			               $scope.errorMessage = response.data.message;
			             }
			             else {
			               $scope.errorMessage = 'Error adding user!';
			             }
			             $scope.message = '';
			       });
			     }
			}
			 */
		} ]);