(function(angular) {
	'use strict';

	angular.module('solucao')
	.controller('AppCtrl', AppCtrl);

	function AppCtrl($scope, $window, AppService) { 
		
		var vmAppCtrl = this;
		
		$scope.errosload = [];

		$scope.obterRotas = function(){
			$scope.errosload = [];
			if(vmAppCtrl.malhaDistribuicao  != undefined){
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
			}else{
				vmAppCtrl.erro = {};
				vmAppCtrl.erro.mensagem = "Nenhum arquivo selecionado!";
				$scope.errosload.push(vmAppCtrl.erro);
			}
		 }
		
		
		$scope.carregarMalhas = function(){
			$scope.errosload = [];
			if(vmAppCtrl.malha  != undefined){
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
			}else{
				vmAppCtrl.erro = {};
				vmAppCtrl.erro.mensagem = "Nenhum arquivo selecionado!";
				$scope.errosload.push(vmAppCtrl.erro);
			}
			
			 
		 }
		
		
		$scope.mapaUploadedFile = function(element) {
			$scope.errosload = [];
			var reader = new FileReader();
			reader.onload = function () {
				var malhasJson = reader.result;
				$scope.$apply();
				
				vmAppCtrl.malha = angular.fromJson(malhasJson);
			}
			
			$scope.$apply(function($scope) {
				vmAppCtrl.files = element.files;
			});
			
			var nome = vmAppCtrl.files[0].name;
			if(nome.substring(nome.length-5,nome.length) == ".json"){
				reader.readAsText(element.files[0]);
			}else{
				vmAppCtrl.erroLoad = {};
				vmAppCtrl.erroLoad.mensagem = "Arquivo inválido!";
				$scope.errosload.push(vmAppCtrl.erroLoad);
				$scope.$apply();
			}
		}
		
		
		$scope.rotaUploadedFile = function(element) {
			$scope.errosload = [];
			var reader = new FileReader();
			reader.onload = function () {
				var rotasJson = reader.result;
				$scope.$apply();
								
				vmAppCtrl.malhaDistribuicao = angular.fromJson(rotasJson);
			}
			
			$scope.$apply(function($scope) {
				vmAppCtrl.files = element.files;
			});
			
			var nome = vmAppCtrl.files[0].name;
			if(nome.substring(nome.length-5,nome.length) == ".json"){
				reader.readAsText(element.files[0]);
			}else{
				vmAppCtrl.erroLoad = {};
				vmAppCtrl.erroLoad.mensagem = "Arquivo inválido!";
				$scope.errosload.push(vmAppCtrl.erroLoad);
				$scope.$apply();
			}
			
		}
		
	}
	
})(angular); 