var app = angular.module('flapperNews', [ 'ui.router', 'ui.bootstrap']);
var urlBase = "http://localhost:9080/springHibernateAngularWeb/";
// app.options('*', cors());
// http://stackoverflow.com/questions/27499872/cors-issue-when-rest-api-application-serverexpress-and-angulars-js-application

app.config([ '$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

	// Home URLs
	$stateProvider.state('home', {
		url : '/home',
		templateUrl : 'resources/displays/home.html',
		controller : 'MainCtrl',
		data: {
			requireLogin: false
		}
	}); // end state home

	// Login module URLs
	$stateProvider.state('login', {
		url: '/login',
		templateUrl: 'resources/displays/login/index.html',
		controller: 'LoginCtrl',
		data: {
			requireLogin: true
		}
	}); // end state Emp

	// Employee module URLs
	$stateProvider.state('emp', {
		url: '/emp',
		abstract: true,
		templateUrl: 'resources/displays/emp/index.html',
		controller: 'EmpCtrl',
		data: {
			requireLogin: true
		}
	}); // end state Emp
	$stateProvider.state('emp.list', {
		url: '',
		templateUrl: 'resources/displays/emp/list.html',
		controller: 'EmpCtrl',
		resolve: {
			empsPromise: ['empFact', function(empFact) {
				return empFact.getAll();
			}]
		}
	}); // end state emp
	$stateProvider.state('emp.new', {
		url: '/new',
		templateUrl: 'resources/displays/emp/new.html',
		controller: 'EmpCtrl',
		resolve: {
			newPromise: ['empFact', function(empFact) {
				return empFact.resetAll();
			}]
		}
	}); // end state emp.new
	$stateProvider.state('emp.edit', {
		url: '/{id}',
		templateUrl: 'resources/displays/emp/edit.html',
		controller: 'EmpCtrl',
		resolve: {
			empPromise: ['$stateParams', 'empFact', function($stateParams, empFact) {
				return empFact.get($stateParams.id);
			}]
		}
	}); // end state emp.edit
	$urlRouterProvider.otherwise('home');
} ]);	// End of REST url configuration

app.factory('empFact', ['$http', '$state',	function($http, $state) {
		var o = {
			employees: [],
			employee: {},
			alerts: [],
		};
		
		o.resetAll = function() {
			console.log("reset All called");
			o.employees = [];
			o.employee = {};
			o.alerts = [];
		}

		o.get = function(id) {
			console.log('Before calling REST service for EmpId: '+id);
			return $http.get(urlBase+'json/employee/'+id).then(function(res) {
				console.log('After calling REST service for EmpId: '+id);
				angular.copy(res.data, o.employee);
				console.log('The JSOn emp data from REST Service: '+o.employee.firstName);
			})
			console.log('getting Employee details for Employee Id: '+id);
			// var empps = o.getAll();
			// var emp = empps[id];
			// angular.copy(emp, o.employee);
			console.log('Employee size are: '+empps.length);
			console.log('All employees data are: '+empps);
			console.log('Employee details are: '+emp);
			// return emp;
		};
		
		o.getAll = function() {
			console.log('getting all configs from url: '+urlBase + 'json/getAllEmp/');
			return $http.get(urlBase + 'json/').success(function(data) {
				o.employees = [];
				angular.copy(data, o.employees);
			});
		};

		o.updateEmployee = function(employee) {
			console.log("Updating employee");
			$http.post(urlBase+'json/update', employee).success(function(data) {
				o.setAlert("success", "Successfully updated config!");
				console.log("Successfully updated Employee! status = "+status);
				// console.log("Successfully updated Employee! status =
				// "+status+", data = "+data);
				
				$state.go('emp.list');
			})
			.error(function(data, status) {
				console.log("Error updating! status = "+status+", data = "+data);
				o.setAlert("danger", "Error updating config!");
			});
			return true;
		}

		o.addEmployee = function(employee) {
			console.log("Creating New employee");
			// $http.get('/#/emp/0').success(function(data) {
			$http.post(urlBase+'json/update', employee).success(function(data) {
				o.setAlert("success", "Successfully added employee!");
				console.log("Successfully added Employee! status = "+status);
				console.log("Successfully updated Employee! status = "+status+", data = "+data);
				$state.go('emp.list');				
			})
			.error(function(data, status) {
				console.log("Error updating! status = "+status+", data = "+data);
				o.setAlert("danger", "Error updating config!");
			});
			return true;
		}

		o.deleteEmployee = function(id) {
			console.log("Deleting Employee! ID = "+id);

			var confirmed = window.confirm("Are you sure you want to delete?");
			console.log("Deleting config "+id+" confirmed = "+confirmed);
			
			if(confirmed) {

				$http,delete(urlBase+'json/delete?empId='+id).success(function(data) {
					o.setAlert("success", "Successfully added employee!");
					console.log("Successfully added Employee! status = "+status);
					console.log("Successfully updated Employee! status = "+status+", data = "+data);
					$state.go('emp.list');				
				})
				.error(function(data, status) {
					console.log("Error updating! status = "+status+", data = "+data);
					o.setAlert("danger", "Error updating config!");
				});
				return true;
			}
			// $state.go('emp.list');
			// $state.reload();
		}

		o.setAlert = function(type, msg) {
			console.log("Setting alert type %s, msg %s", type, msg);
			// reset the alert
			o.alerts=[];
			o.alerts.push({type: type, msg: msg});
		}
		return o;
	}]
);

app.controller('MainCtrl', [
	'$scope',
	function($scope) {
		$scope.test='This is home!!';
		
	} // end function($scope)
	
])// end main controller

app.controller('EmpCtrl', [ '$scope', '$stateParams', 'empFact', function($scope, $stateParams, empFact) {
	$scope.test = 'Hello world from AngularJS EmpCtrl and this value is configured with TEST!';

	$scope.employees = empFact.employees;
	$scope.emp = empFact.employee;
	$scope.alerts = empFact.alerts;
	$scope.displayedCollection = [].concat($scope.employees);
	console.log("Alerts size = "+$scope.alerts.length);
	console.log("displayedCollection size = "+$scope.displayedCollection.length);

	$scope.addEmp = function() {
		empFact.addEmployee($scope.emp)
	};

	$scope.updateEmployee = function() {
		empFact.updateEmployee($scope.emp);
	};

	$scope.updateEmployee = function() {
		empFact.updateEmployee($scope.emp);
	};

	$scope.addEmployee = function() {
		empFact.updateEmployee($scope.emp);
	};

	$scope.deleteEmployee = function(id) {
		empFact.deleteEmployee(id);
	};

} ]);

app.controller('NavCtrl', [
	'$scope', '$rootScope',
	'$location', '$http',
	function($scope, $rootScope, $location, $http) {
		$scope.isTopNavActive = function(viewLocation) {
			var active = ($location.path().indexOf(viewLocation) == 0);
			return active;
		};
		$scope.isActive = function(viewLocation) {
			var active = $location.path().match('^'+viewLocation+'$');
			return active;
		};

		
		//https://spring.io/blog/2015/01/12/the-login-page-angular-js-and-spring-security-part-ii
			var authenticate = function(credentials, callback) {

		    var headers = credentials ? {authorization : "Basic "
		        + btoa(credentials.username + ":" + credentials.password)
		    } : {};

		    $http.get('login', {headers : headers}).success(function(data) {
		      if (data.name) {
		        $rootScope.authenticated = true;
		      } else {
		        $rootScope.authenticated = false;
		      }
		      callback && callback();
		    }).error(function() {
		      $rootScope.authenticated = false;
		      callback && callback();
		    });

		  }

		  authenticate();
		  $scope.credentials = {};
		  $scope.login = function() {
		      authenticate($scope.credentials, function() {
		        if ($rootScope.authenticated) {
		          $location.path("/");
		          $scope.error = false;
		        } else {
		          $location.path("/login");
		          $scope.error = true;
		        }
		      });
		  };
		  ////// end of spring security-II integration
		
		// LOGIN Related code starts here
		$scope.loginX = function () {
			var credentials = { j_username: $scope.username, j_password: $scope.password };
			$http.post('login', credentials).success(function (result, status, headers) {
				console.log("Success in login at server: "+status);
				console.log("Success in login at server: "+result.name);
				console.log("Success in login at server: "+result.status);

			   if (result.name) {
			        $rootScope.authenticated = true;
			      } else {
			        $rootScope.authenticated = false;
			      }
			      callback && callback();
			    }).error(function() {
			      $rootScope.authenticated = false;
			      callback && callback();
			    });
		};
		// LOGIN Related code ends here

		// LOGIN Related code starts here
		// http://blog.jdriven.com/2014/10/stateless-spring-security-part-2-stateless-authentication/
		$scope.login1 = function () {
			var credentials = { j_username: $scope.username, j_password: $scope.password };
			$http.post('/api/login', credentials).success(function (result, status, headers) {
				$scope.authenticated = true;
				console.log("Success in login at server: "+status);
				console.log("Success in login at server: "+result);
				TokenStorage.store(headers('X-AUTH-TOKEN'));
			});  
		};
		// LOGIN Related code ends here
	}
])// end nav controller

