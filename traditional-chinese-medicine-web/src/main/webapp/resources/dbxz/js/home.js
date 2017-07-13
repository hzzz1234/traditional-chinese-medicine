var app = angular
		.module("home", [])
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
app.controller('homeController', function($scope, $timeout, $http) {
	$scope.waitlist = waitlist;
	$scope.rescuelist = rescuelist;
	$scope.getSex = function(n) {
		if (n == 0)
			return '男';
		else
			return '女';
	};
	$scope.finish = function(i) {
		$http({
			method : 'POST',
			url : ctx + '/home/finish/' + $scope.rescuelist[i].recordid
		}).success(function(response) {
			if (response.flag == 'ok') {
				$scope.rescuelist.splice(i, 1);
			} else {
				alert("结束失败，" + response.result);
			}
		});
	};
	$scope.cancel = function(i) {
		if (confirm("确定要删除吗？")) {
			$http({
				method : 'POST',
				url : ctx + '/home/cancel/' + $scope.rescuelist[i].recordid
			}).success(function(response) {
				if (response.flag == 'ok') {
					$scope.rescuelist.splice(i, 1);
				} else {
					alert("取消失败，" + response.result);
				}
			});
		}

	};
	$scope.reback = function(i) {
		if (confirm("确定要将该病人返回排队吗？")) {
			$http({
				method : 'POST',
				url : ctx + '/home/reback/' + $scope.rescuelist[i].recordid
			}).success(function(response) {
				if (response.flag == 'ok') {
					var record = $scope.rescuelist.splice(i, 1);
					$scope.waitlist.push(record[0]);
				} else {
					alert("返回失败，" + response.result);
				}
			});
		}

	};
	$scope.reset = function() {
		$http({
			method : 'POST',
			url : ctx + '/home/reset'
		}).success(function(response) {
			if (response.flag == 'ok') {
				alert("重置成功");
			} else {
				alert("重置失败"+response.result);
			}
		});
	};
	$scope.arrange = function(patientid) {
		$http({
			method : 'POST',
			url : ctx + '/home/arrange/' + patientid
		}).success(function(response) {
			if (response.flag == 'ok') {

				$http({
					method : 'POST',
					url : ctx + '/home/getArrangePatients'
				}).success(function(response) {
					$scope.waitlist = response;
					$scope.patientid = '';
				});
			} else {
				alert("排队失败，" + response.result);
			}
		});
		$scope.patientNo = '';
	};
	$scope.up = function(i) {
		if (0 == i) {
			return;
		} else {
			var a = $scope.waitlist[i - 1];
			$scope.waitlist[i - 1] = $scope.waitlist[i];
			$scope.waitlist[i] = a;
		}
	};
	$scope.upup = function(i) {
		if (0 == i) {
			return;
		} else {
			var a = $scope.waitlist.splice(i, 1);
			$scope.waitlist.splice(0, 0, a[0]);
		}
	};
	$scope.downdown = function(i) {
		if (($scope.waitlist.length - 1) == i) {
			return;
		} else {
			var a = $scope.waitlist.splice(i, 1);
			$scope.waitlist.push(a[0]);
		}
	};
	$scope.down = function(i) {
		if (($scope.waitlist.length - 1) == i) {
			return;
		} else {
			var a = $scope.waitlist[i + 1];
			$scope.waitlist[i + 1] = $scope.waitlist[i];
			$scope.waitlist[i] = a;
		}
	};

	$scope.delete1 = function(i) {
		if (confirm("确定要删除吗？")) {
			$http({
				method : 'POST',
				url : ctx + '/home/cancel/' + $scope.waitlist[i].recordid
			}).success(function(response) {
				if (response.flag == 'ok') {
					alert("删除成功");
					$scope.waitlist.splice(i, 1);
				} else {
					alert("删除失败，" + response.result);
				}
			});
		}

	};
	$scope.rescue = function() {
		var recordid = $scope.waitlist[0].recordid;
		$http({
			method : 'POST',
			url : ctx + '/home/rescue/' + recordid
		}).success(function(response) {
			if (response.flag == 'ok') {
				$scope.rescuelist.push($scope.waitlist.splice(0, 1)[0]);
			} else {
				alert("就诊操作失败，" + response.result);
			}
		});
	};
	$scope.clean = function() {
		if (confirm("确定要清空吗？")) {
			var recordids = "";
			for (var i = 0; i < $scope.waitlist.length; i++) {
				if (0 == i) {
					recordids += $scope.waitlist[i].recordid;
				} else {
					recordids += "," + $scope.waitlist[i].recordid;
				}
			}
			$http({
				method : 'POST',
				url : ctx + '/home/clean/',
				data : {
					recordids : recordids
				}
			}).success(function(response) {
				if (response.flag == 'ok') {
					$scope.waitlist = [];
				} else {
					alert("清空失败，" + response.result);
				}
			});
		}
	};
});