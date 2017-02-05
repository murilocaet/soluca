(function(angular) {
	'use strict';
	
	angular
		.module('solucao')
		.config(setRoutes);
	
	function setRoutes($routeProvider) {
				
		$routeProvider
		    .when("/", {
		        templateUrl : "js/app/views/telaInicial.html",
		        controller: 'AppCtrl'
		    })
		    .when("/home", {
		        templateUrl : "js/app/views/telaInicial.html",
		        controller: 'AppCtrl'
		    })
		    .when("/mapas", {
		        templateUrl : "js/app/mapas/views/mapas.html",
		        controller: 'AppCtrl'
		    })
		    .when("/rotas", {
		        templateUrl : "js/app/rotas/views/rotas.html",
		        controller: 'AppCtrl'
		    })
		    .when("/ajuda", {
		        templateUrl : "js/app/views/ajuda.html",
		        controller: 'AppCtrl'
		    });
	  };
})(angular);
