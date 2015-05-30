var app = angular
		.module("show", [])
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
app.controller('showController', function($scope, $timeout, $http) {
	$scope.dbxzRecordsTop5 = dbxzRecords.slice(0, 5);
	$scope.dbxzRecords5To15 = dbxzRecords.slice(5, 15);
	$scope.dbxzRecordsAfter15 = dbxzRecords.slice(15);

	$scope.timeRun = function() {
		setInterval(function() {
			$http({
				method : 'POST',
				url : ctx + '/home/getArrangePatients'
			}).success(function(response) {
				$scope.dbxzRecordsTop10 = response.slice(0, 5);
				$scope.dbxzRecords11To30 = response.slice(5, 15);
				$scope.dbxzRecordsAfter31 = response.slice(15);
			});
		}, 1000);
	};
	$scope.timeRun();
});