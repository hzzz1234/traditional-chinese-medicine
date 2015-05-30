var app = angular
		.module("user", [])
		.config(
				function($httpProvider) {
					$httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
					$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
					// Override $http service's default transformRequest
					$httpProvider.defaults.transformRequest = [ function(data) {
						/**
						 * The workhorse; converts an object to
						 * x-www-form-urlencoded serialization.
						 * 
						 * @param {Object}
						 *            obj
						 * @return {String}
						 */
						var param = function(obj) {
							var query = '';
							var name, value, fullSubName, subName, subValue, innerObj, i;
							for (name in obj) {
								value = obj[name];
								if (value instanceof Array) {
									for (i = 0; i < value.length; ++i) {
										subValue = value[i];
										fullSubName = name + '[' + i + ']';
										innerObj = {};
										innerObj[fullSubName] = subValue;
										query += param(innerObj) + '&';
									}
								} else if (value instanceof Object) {
									for (subName in value) {
										subValue = value[subName];
										fullSubName = name + '[' + subName
												+ ']';
										innerObj = {};
										innerObj[fullSubName] = subValue;
										query += param(innerObj) + '&';
									}
								} else if (value !== undefined
										&& value !== null) {
									query += encodeURIComponent(name) + '='
											+ encodeURIComponent(value) + '&';
								}
							}
							return query.length ? query.substr(0,
									query.length - 1) : query;
						};
						return angular.isObject(data)
								&& String(data) !== '[object File]' ? param(data)
								: data;
					} ];
				});
app.controller('userController', function($scope, $timeout, $http,$filter) {
	$scope.patients = patients;
	$scope.prescriptions = prescriptions;
	$scope.newPatient={};
	$scope.newPatient.sex=0;
	$scope.maxId= maxId;
	$scope.getSex = function(n){
		if(n==0)
			return '男';
		else
			return '女';
	}
	
	$scope.query = function(n){
		$http({
			method:'POST',
			url:ctx+'/User/query',
			data:{condition:n}
		}).success(function(response){
			$scope.patients = response.result;
		});
	};
	$scope.getPatient = function(pid){
		$http({
			method:'GET',
			url:ctx+'/User/getUser/'+pid
		}).success(function(response){
			$scope.selectedPatient = response.result;
			$scope.selectedPatient.selectedPrescriptions = [];
			for(var i=0;i<response.result.dbxzprescriptions.length;i++){
				for(var j=0;j<$scope.prescriptions.length;j++){
					if(response.result.dbxzprescriptions[i].id==$scope.prescriptions[j].id){
						$scope.selectedPatient.selectedPrescriptions.push($scope.prescriptions[j]);
					}
				}
			}
		});
	};
	$scope.newQueryReset =function(){
	 		$scope.newPatient.id='';
			$scope.newPatient.age='';
			$scope.newPatient.name='';
			$scope.newPatient.symptom='';
			$scope.newPatient.contact='';
			$scope.newPatient.sex=0;
		
	};
	$scope.addMedicine = function(m){
		$http({
			method:'POST',
			url:ctx+'/User/addMedicine/',
			data:{medicine:m}
		}).success(function(response){
			if(response.flag=='ok'){
				$scope.prescriptions.push(response.result);
				$scope.medicine='';
			}else{
				alert("添加失败，"+response.result)
			}
		});
	};
	$scope.updatePatient =function(){
		
		var prescriptionids ="";
		for(var i=0;i<$scope.selectedPatient.selectedPrescriptions.length;i++){
			if(i==0){
				prescriptionids += $scope.selectedPatient.selectedPrescriptions[i].id;
			}else{
				prescriptionids += ","+$scope.selectedPatient.selectedPrescriptions[i].id;
			}
		}
		var data = {
			id : $scope.selectedPatient.dbxzpatient.id,
			name:$scope.selectedPatient.dbxzpatient.name,
			age:$scope.selectedPatient.dbxzpatient.age,
			sex:$scope.selectedPatient.dbxzpatient.sex,
			contact:$scope.selectedPatient.dbxzpatient.contact,
			symptom:$scope.selectedPatient.dbxzpatient.symptom,
			prescriptionids:prescriptionids
		}
		$http({
			method:'POST',
			url:ctx+'/User/updateUser/',
			data:data
		}).success(function(response){
			if(response.flag=='ok'){
				alert("修改成功");
				$scope.condition=$scope.selectedPatient.dbxzpatient.name;
				$scope.query($scope.selectedPatient.dbxzpatient.name);
			}else{
				alert("修改失败，"+response.result)
			}
		});
	};
	$scope.addPatient=function(){
		var prescriptionids ="";
		for(var i=0;i<$scope.newPatient.selectedPrescriptions.length;i++){
			if(i==0){
				prescriptionids += $scope.newPatient.selectedPrescriptions[i].id;
			}else{
				prescriptionids += ","+$scope.newPatient.selectedPrescriptions[i].id;
			}
		}
		var data = {
			id : $scope.newPatient.id,
			name:$scope.newPatient.name,
			age:$scope.newPatient.age,
			sex:$scope.newPatient.sex,
			contact:$scope.newPatient.contact,
			symptom:$scope.newPatient.symptom,
			prescriptionids:prescriptionids
		}
		$http({
			method:'POST',
			url:ctx+'/User/addUser/',
			data:data
		}).success(function(response){
			if(response.flag=='ok'){
				alert("添加成功");
				$scope.newQueryReset();
				$scope.condition=$scope.newPatient.name;
				$scope.query($scope.newPatient.name);
				$scope.maxId = response.maxId;
			}else{
				alert("添加失败，"+response.result)
			}
		});
	}
	$scope.deleteRecord = function(recordid){
		if(confirm("确定要删除吗？")){
			$http({
				method:'POST',
				url:ctx+'/User/deleteRecord/'+recordid
			}).success(function(response){
				if(response.flag=='ok'){
					alert("删除成功");
					for(var i=0;i<$scope.selectedPatient.dbxztreatrecords.length;i++){
						if($scope.selectedPatient.dbxztreatrecords[i].id==recordid){
							$scope.selectedPatient.dbxztreatrecords.splice(i,1); 
							break;
						}
					}
				}else{
					alert("添加失败，"+response.result)
				}
			});
		}
	}
	$scope.deletePatient =function(patientid){
	if(confirm("确定要删除吗？")){
		$http({
			method:'POST',
			url:ctx+'/User/deletePatient/'+patientid
		}).success(function(response){
			if(response.flag=='ok'){
				alert("删除成功");
				
				for(var i=0;i<$scope.patients.length;i++){
					if($scope.patients[i].id==patientid){
						$scope.patients.splice(i,1); 
						break;
					}
				}
			}else{
				alert("添加失败，"+response.result)
			}
		});
		}
	}
	$scope.deletePrescriptions=function(){
		if(confirm("确定要删除吗？")){
			var prescriptionids ="";
			for(var i=0;i<$scope.selectedPrescriptions.length;i++){
				if(i==0){
					prescriptionids += $scope.selectedPrescriptions[i].id;
				}else{
					prescriptionids += ","+$scope.selectedPrescriptions[i].id;
				}
			}
			var data={prescriptions:prescriptionids};
			$http({
				method:'POST',
				url:ctx+'/User/deletePrescriptions/',
				data:data
			}).success(function(response){
				if(response.flag=='ok'){
					alert("删除成功");
					$scope.selectedPrescriptions= [];
					$http({
						method:'GET',
						url:ctx+'/User/getPrescriptions/'
						}).success(function(response){
							$scope.prescriptions = response;
						});
				}else{
					alert("添加失败，"+response.result)
				}
			});
		}
	}
});