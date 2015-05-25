<html>
<head>
	<#include "/common/common.ftl"/>
    <title>Main</title>
</head>
<body>
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
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
				目前等待前10位:
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<th>序号</th>
							<th>病历号</th>
							<th>姓名</th>
						</thead>
						<tbody>
							<td>1</th>
							<td>1000000</th>
							<td>姓名</th>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
				目前等待前11-30位:
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<th>序号</th>
							<th>病历号</th>
							<th>姓名</th>
						</thead>
						<tbody>
							<td>1</th>
							<td>1000000</th>
							<td>姓名</th>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-default">
		<div class="panel-heading">
		目前等待前31-50位:
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<th>序号</th>
					<th>病历号</th>
					<th>姓名</th>
				</thead>
				<tbody>
					<td>1</th>
					<td>1000000</th>
					<td>姓名</th>
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
</body>
</html>
