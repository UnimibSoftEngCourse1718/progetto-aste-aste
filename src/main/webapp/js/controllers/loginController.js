app.controller('loginController', [
		'$rootScope',
		'$scope',
		'$window',
		'userService',
		function($rootScope, $scope, $window, userService) {
			
			$scope.username = $window.sessionStorage.getItem('USER_USERNAME');
			
			$scope.getUser = function() {
				var user = {};
				user.username = $scope.usernameL;
				user.password = $scope.passwordL;
				userService.getUser(user).then(
						function(response) {
							if (response.esito == "OK") {
								$window.sessionStorage.setItem("USER_ID", response.data.idUtente);
								$window.sessionStorage.setItem("USER_USERNAME", response.data.username);
								$scope.username = $window.sessionStorage.getItem('USER_USERNAME');
								$rootScope.getSessionUser();
								$window.location.reload();
								$window.location.href = '#/home';
							} else {
								$window.alert("Le credenziali sono errate");
								$scope.loggedIn = null;
							}
						});
			}
			
			$scope.saveUser = function() {
				var user = {};
				user.username = $scope.usernameR;
				user.password = $scope.passwordR;
				user.nome = $scope.nome;
				user.cognome = $scope.cognome;
				user.ruolo = "reg";
				user.credito = 0;
				userService.saveUser(user).then(function(response) {
					if(response.esito == "OK"){
						$window.alert("Registrazione completata correttamente");
						$window.location.href = '#/login';
					}else{
						$window.alert("Errore durante la registrazione");
					}
				});
			}

		} ]);