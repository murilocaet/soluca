(function(angular) {
	'use strict';

	angular.module('solucao')
	.controller('AppCtrl', AppCtrl);

	function AppCtrl($scope, $window, AppService) { 
		
		var vmAppCtrl = this;

		$scope.obterRotas = function(){
			 AppService.obterRotas(vmAppCtrl.malhaDistribuicao).then(function(retorno){
				 if(retorno.rotas != null || retorno.rotas != undefined){
					 $scope.rotasProcessadas = [];
					 if(retorno.rotas.length != undefined){
						 for(var i= 0; i < retorno.rotas.length; i++){
							 $scope.rotasProcessadas.push(retorno.rotas[i]);
						 }
					 }else{
						 $scope.rotasProcessadas.push(retorno.rotas);
					 }
				 }
				 if(retorno.erros != null || retorno.erros != undefined){
					 $scope.errosProcessados = [];
					 if(retorno.erros.length != undefined){
						 for(var i= 0; i < retorno.erros.length; i++){
							 $scope.errosProcessados.push(retorno.erros[i]);
						 }
					 }else{
						 $scope.errosProcessados.push(retorno.erros);
					 }
				 }
			 });
		 }
		
		
		$scope.carregarMalhas = function(){
			 AppService.carregarMalhas(vmAppCtrl.malha).then(function(retorno){
				 
				 if((retorno.malhas != null || retorno.malhas != undefined)){
					 $scope.malhas = [];
					 if(retorno.malhas.length != undefined){
						 for(var i= 0; i < retorno.malhas.length; i++){
							 vmAppCtrl.malha = {};
							 vmAppCtrl.malha.nome = retorno.malhas[i].nome;
							 vmAppCtrl.malha.rotas = [];
							 if(retorno.malhas[i].rotas.length != undefined){
								 for(var j= 0; j < retorno.malhas[i].rotas.length; j++){
									 vmAppCtrl.malha.rotas.push(retorno.malhas[i].rotas[j]);
								 }
							 }else{
								 vmAppCtrl.malha.rotas.push(retorno.malhas[i].rotas);
							 }
							 $scope.malhas.push(vmAppCtrl.malha);
						 }
					 }else{
						 vmAppCtrl.malha = {};
						 vmAppCtrl.malha.nome = retorno.malhas.nome;
						 vmAppCtrl.malha.rotas = [];
							
						 if(retorno.malhas.rotas.length != undefined){
							 for(var i= 0; i < retorno.malhas.rotas.length; i++){
								 vmAppCtrl.malha.rotas.push(retorno.malhas.rotas[i]);
							 }
						 }else{
							 vmAppCtrl.malha.rotas.push(retorno.malhas.rotas);
						 }
						 $scope.malhas.push(vmAppCtrl.malha);
					 }
				 }
			 });
		 }
		
		
		$scope.mapaUploadedFile = function(element) {
			
			var reader = new FileReader();
			reader.onload = function () {
				var malhasJson = reader.result;
				$scope.$apply();
				
				vmAppCtrl.malha = angular.fromJson(malhasJson);
			}
			
			$scope.$apply(function($scope) {
				vmAppCtrl.files = element.files;
			});
			
			reader.readAsText(element.files[0]);
		}
		
		
		$scope.rotaUploadedFile = function(element) {
			
			var reader = new FileReader();
			reader.onload = function () {
				var rotasJson = reader.result;
				$scope.$apply();
								
				vmAppCtrl.malhaDistribuicao = angular.fromJson(rotasJson);
			}
			
			$scope.$apply(function($scope) {
				vmAppCtrl.files = element.files;
			});
			
			reader.readAsText(element.files[0]);
		}
		
	}
	
})(angular); 