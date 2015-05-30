<html ng-app="show" ng-controller="showController">
<head>
	<#include "/common/common.ftl"/>
    <title>Main</title>
</head>
<body >
	<!--<div class="panel panel-default">
		<div class="row">
			<div class="col-md-4">
			</div>
		</div>
		<div class="panel-heading">
		目前就诊人员:
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<th>病历号</th>
					<th>姓名</th>
					<th>状态</th>
				</thead>
			</table>
		</div>
	</div> -->
	<div class="row">
		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading" class="showfont">
				目前等待前5位:
				</div>
				<div class="panel-body">
					<table class="table">
						<thead class="showfont">
							<th style="font-size:50px;"><序号</th>
							<th style="font-size:50px;">病历号</th>
							<th style="font-size:50px;">姓名</th>
						</thead>
						<tbody class="showfont">
							<tr ng-repeat="r in dbxzRecordsTop10">
								<td style="color:red;font-size:100px;">{{ $index+1 }}</td>
								<td style="color:red;font-size:100px;">{{ r.patientid }}</td>
								<td style="color:red;font-size:100px;">{{ r.patientname }}</td>
							</tr></span>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="panel panel-default">
				<div class="panel-heading" class="showfont">
				目前等待前5-15位:
				</div>
				<div class="panel-body">
					<table class="table">
						<thead class="showfont">
							<th>序号</th>
							<th>病历号</th>
							<th>姓名</th>
						</thead>
						<tbody class="showfont">
							<tr ng-repeat="r in dbxzRecords11To30">
								<td>{{ $index+6 }}</th>
								<td>{{ r.patientid }}</th>
								<td>{{ r.patientname }}</th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="panel panel-default">
		<div class="panel-heading" class="showfont">
		目前等待前20位以后:
		</div>
		<div class="panel-body">
			<table class="table">
				<thead class="showfont">
					<th>序号</th>
					<th>病历号</th>
					<th>姓名</th>
				</thead>
				<tbody class="showfont">
					<tr ng-repeat="r in dbxzRecordsAfter31">
								<td>{{ $index+16 }}</th>
								<td>{{ r.patientid }}</th>
								<td>{{ r.patientname }}</th>
							</tr>
				</tbody>
			</table>
		</div>
	</div>
		</div>
	</div>
	<script>
		var dbxzRecords=[
			<#if dbxzShowVo.dbxzRecords??>
			<#list dbxzShowVo.dbxzRecords as w>
				{
				recordid:${w.recordid},
				patientid:${w.patientid},
				patientname:'${w.patientname}',
				},
			</#list>
		</#if>
		];
	</script>
	<script src="${rc.contextPath}/resources/dbxz/js/show.js"></script>
</body>
</html>
