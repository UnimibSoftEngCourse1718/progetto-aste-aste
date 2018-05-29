app.controller('LoginController', [
		'$scope',
		'$window',
		'UserService',	
		function($scope,$window, UserService) {
			
			$scope.logOut = function() {
				$scope.loggedIn = null;
				$window.sessionStorage.removeItem("USER");
				alert("Log out");
			}
			
			$scope.loggedIn = null;
			$scope.getUser = function(user) {
				var user = {};
				user.username = $scope.usernameL;
				user.password = $scope.passwordL;
				UserService.getUser(user).then(function(response) {
					if (response.esito == "OK"){
						alert("Ti sei Loggato");
						$scope.loggedIn = true;
						$window.sessionStorage.setItem("USER", response.data.username);
						$window.location.href = '#/home';
					}else{
						alert("Le credenziali sono errate");
						$scope.loggedIn = null;
					}
				});
			}

			$scope.saveUser = function() {
				var user = {};
				user.username = $scope.usernameR;
				user.password = $scope.passwordR;
				UserService.saveUser(user).then(function(response) {
					if (response.esito == "OK"){
						alert("Ti sei Registrato");
						$window.location.href = '#/login';
					}else
						alert("Errore durante la registrazione");
				});
			}

		} ]);