(function(angular) {
	'use strict';

	angular.module('solucao')
	.factory('AppService', AppService);
	
	
	function AppService($http, $resource, $q, $window, $location) {
		var solucaoResource = $resource('', {}, {

			carregarMalhas : {
				method : 'POST',
				url : 'services/malhas/carregarMalhas',
				cache : false,
			}, 
			obterRotas : { 
				method : 'POST',
				url : 'services/rotas/obterRotas',
				cache : false,
			}
		});
		
		return {
			carregarMalhas : carregarMalhas,
			obterRotas: obterRotas
		}; 
		
		
		/**
		 * Metodos do Resource
		 * */
		function carregarMalhas(malha) {
			var defer = $q.defer();
			solucaoResource.carregarMalhas(malha, function(retorno) {
				defer.resolve(retorno);
			}, function(fail) {
				//$state.go('erro');
			});
			return defer.promise;
		} 
		
		function obterRotas(malha) {
			var defer = $q.defer();
			solucaoResource.obterRotas(malha, function(retorno) {
				defer.resolve(retorno);
			}, function(fail) {
				//$state.go('erro');
			});
			return defer.promise;
		}
	}
	
	


})(angular);