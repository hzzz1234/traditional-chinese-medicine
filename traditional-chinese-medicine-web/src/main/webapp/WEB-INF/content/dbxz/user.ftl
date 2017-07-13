<html ng-app="user" ng-controller="userController">
<head>
	<#include "/common/common.ftl"/>
    <title>Main</title>
</head>
<body>
	<#include "/common/header.ftl"/>
	<div class="container" style="width:80%;">
		<div class="panel panel-default" >
			<div class="panel-heading">
	              	查询面板
			</div>
	         <div class="panel-body">
	              <div class="row">
	                <div class="col-md-8">
	                <form name="query_form">
	                  <div class="row">
	                    <div class="col-md-8">
	                      <input text="text" class="form-control"  placeholder="请输入病人信息:病历号/名字" ng-model="condition" required>
	                    </div>
	                    <div class="col-md-2">
	                      <button  class="btn btn-primary form-control" ng-click="query(condition)" ng-disabled="query_form.$invalid">查询</button>
	                    </div>
	                 </form>
	                  </div>
	                </div>
	              </div>
	              <div>
	              <div style="overflow-y:scroll;max-height:35%;">
	                <table class="table">
	                  <thead>
	                    <th>病历号</th>
	                    <th>姓名</th>
	                    <th>年龄</th>
	                    <th>敷药年限</th>
	                    <th>性别</th>
	                    <th>联系方式</th>
	                    <th>操作</th>
	                  </thead>
                      <tbody>
                        <tr ng-repeat="p in patients">
                          <td>{{ p.id }}</td>
                          <td>{{ p.name }}</td>
                          <td>{{ p.age }}</td>
                          <td>{{ p.duration }}</td>
                          <td>{{ getSex(p.sex) }}</td>
                          <td>{{ p.contact }}</td>
                          <td><a href="javascript:void(0);" ng-click="getPatient(p.id)" class="btn btn-link">详情</a>&nbsp;&nbsp;<a href="javascript:void(0);" ng-click="deletePatient(p.id)"><i class="glyphicon glyphicon-trash"></i></a></td>
                        </tr>
                      </tbody>
	                </table>

	            </div>
	            </div>
		</div>
	</div>
	<div class="panel panel-default">
			<div class="panel-heading">
	              	病人信息修改面板
	            </div>
		<div class="panel-body">
			<ul id="myTab" class="nav nav-tabs">
			    <li class="active"><a href="#updateUser" data-toggle="tab">修改病人信息</a></li>
			    <li ><a href="#insertUser" data-toggle="tab">添加病人信息</a></li>
			</ul>
			<div class="tab-content">
				<div id="updateUser" class="tab-pane fade in active">
					<div class="row">
						<div class="col-md-6">
							<form role="form" name="update_form">
								<fieldset>
									<legend>病人信息</legend>
									<div class="form-group">
										<label for="id">病历号</label>
										<input type="text" disabled class="form-control" id="id" name="id" ng-model="selectedPatient.dbxzpatient.id" required>
										<label for="name">姓名</label>
										<input type="text" class="form-control" id="name" name="name" ng-model="selectedPatient.dbxzpatient.name" required>
										<label for="age">年龄</label>
										<input type="number"  class="form-control" id="age" name="age" ng-model="selectedPatient.dbxzpatient.age" required>
                                        <label for="age">敷药年限</label>
                                        <input type="number"  class="form-control" id="duration" name="duration" ng-model="selectedPatient.dbxzpatient.duration" required>
										<label for="sex">性别</label>&nbsp;&nbsp;
										<input type="radio" name="sex" ng-model="selectedPatient.dbxzpatient.sex" ng-value="0">男
										<input type="radio" name="sex" ng-model="selectedPatient.dbxzpatient.sex" ng-value="1">女
										<br/>
										<label for="contact">联系方式</label>
										<input type="text" placeholder="请输入11位数字" class="form-control" id="contact" ng-maxlength="11" ng-minlength="11"  name="contact" ng-model="selectedPatient.dbxzpatient.contact">
										<label for="symptom">症状</label>
										<textarea row="3" class="form-control" id="symptom" name="symptom" ng-model="selectedPatient.dbxzpatient.symptom"></textarea>
										<label for="medication">方药:
											<span ng-repeat="p in selectedPatient.selectedPrescriptions">
											{{ p.medication }}
										</label>
										<div class="row">
											<div class="col-md-9">
												<select  multiple="multiple" class="form-control" size="5" id="medication1" name="medication1" ng-model="selectedPatient.selectedPrescriptions" ng-options="p.medication   for p in prescriptions">
												</select>
											</div>
											<div class="col-md-3">
												<a data-toggle="modal" data-target="#myModal" class="btn btn-default" class="form-control" style="min-width: 20%;">方药添加</a>
											</div>
										</div>
										<br/>
										<div style="text-align:center;">
											<button class="btn btn-primary " style="min-width: 20%;" ng-disabled="update_form.$invalid" ng-click="updatePatient()">保存修改</button>&nbsp;&nbsp;&nbsp
									</div>
								   </div>
								</fieldset>
							</form>
						</div>
						<div class="col-md-6">
							<legend>就诊记录</legend>
							<div>
								<table class="table">
									<thead>
										<th>序号</th>
										<th>就诊时间</th>
										<th>操作</th>
									</thead>
									<tbody>
										<tr ng-repeat="record in selectedPatient.dbxztreatrecords">
											<td>{{ $index+1 }}</td>
											<td>{{ record.starttime|date:'medium' }}</td>
											<td><a href="javascript:void(0);"><i class="glyphicon glyphicon-trash" ng-click="deleteRecord(record.id)"></i></a></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div id="insertUser" class="tab-pane fade">
					<div class="row">
						<div class="col-md-6">		
							<form name="new_form">
								<fieldset>
								<legend>病人信息</legend>
								<div class="form-group">
                                        <label for="id">病历号<font style="color:red;">(推荐:{{ maxId }})</font></label>
									<input type="number" class="form-control" id="id" name="id" ng-model="newPatient.id" required >
									<label for="name">姓名</label>
									<input type="text" class="form-control" id="name" name="name" ng-model="newPatient.name" required>
									<label for="age">年龄</label>
									<input type="number"  class="form-control" id="age" name="age" ng-model="newPatient.age" required>
                                    <label for="age">敷药年限</label>
                                    <input type="number"  class="form-control" id="duration" name="duration" ng-model="newPatient.duration" required>
                                    <label for="sex">性别</label>&nbsp;&nbsp;
									<input type="radio" name="sex" ng-model="newPatient.sex" ng-value="0" checked>男
									<input type="radio" name="sex" ng-model="newPatient.sex" ng-value="1">女
									<br/>
									<label for="contact">联系方式</label>
									<input type="text" placeholder="请输入11位数字" class="form-control" id="contact" name="contact" ng-model="newPatient.contact" ng-maxlength="11" ng-minlength="11"  required>
									<label for="symptom">症状</label>
									<textarea rows="3" class="form-control" id="symptom" name="symptom" ng-model="newPatient.symptom"></textarea>
									<label for="medication">方药</label>
									<div class="row">
										<div class="col-md-9">
											<select multiple="multiple" size="5" class="form-control" id="medication" name="medication" ng-model="newPatient.selectedPrescriptions" ng-options="p.medication for p in prescriptions">
											</select>
										</div>
										<div class="col-md-3">
											<a class="btn btn-default" data-toggle="modal" data-target="#myModal" class="form-control" style="min-width: 20%;">方药添加</a>
										</div>
									</div>
									<br/>
									<div style="text-align:center;">
										<button class="btn btn-primary " style="min-width: 20%;" ng-disabled="new_form.$invalid" ng-click="addPatient()">添加人员</button>&nbsp;&nbsp;&nbsp
										<button class="btn btn-primary" style="min-width: 20%;" ng-click="newQueryReset()">重置</button>
									</div>
								</div>
								</fieldset>
							</form>
						</div>
				    </div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="myModalLabel">方药添加</h4>
	         </div>
	         <div class="modal-body">
	         	<div class="row">
	         	<form name="med_form">
	         		<div class="col-md-10">
	         			<input type="text" class="form-control" placeholder="方药名称" required ng-model="medicine">
	         		</div>
	         		<div class="col-md-2">
	         			<button class="btn btn-primary form-control" ng-disabled="med_form.$invalid" ng-click="addMedicine(medicine)">添加</button>
	         		</div>
	         	</form>
	         	</div>
	         	<br/>
				<div class="row">
					<form name="pre_form">
	         		<div class="col-md-10">
	         			<select size="10" class="form-control" ng-model="selectedPrescriptions" ng-options=" p.medication for p in prescriptions" multiple="multiple" required>
      					</select>
	         		</div>
	         		<div class="col-md-2" >
	         			<button class="btn btn-primary form-control" style="vertical-align:center;" ng-disabled="pre_form.$invalid" ng-click="deletePrescriptions()">删除</button>
	         		</div>
	         		</form>
	         	</div>
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">关闭
	            </button>
	         </div>
	      </div><!-- /.modal-content -->
	</div>
	<script>
		var patients=[
			<#if dbxzUserVo.dbxzPatients??>
				<#list dbxzUserVo.dbxzPatients as p>
					{
						id:${p.id},
						name:'${p.name!''}',
						age:${p.age},
                        duration:${p.duration!0},
						sex:${p.sex},
						symptom:'${p.symptom!''}',
						contact:'${p.contact!''}'
					},
				</#list>
			</#if>
		];
		itemCount = ${dbxzUserVo.page.itemCount};
		pages=[
			<#list 1..dbxzUserVo.page.pageCount as pa>
				${pa},
			</#list>
		];
		var prescriptions=[
			<#if dbxzUserVo.dbxzprescriptions??>
					<#list dbxzUserVo.dbxzprescriptions as p>
						{
							id:${p.id},
							medication:"${p.medication!''}"
						},
					</#list>
				</#if>
		];
		var maxId = ${maxId};
	</script>
	<script src="${rc.contextPath}/resources/dbxz/js/user.js"></script>
	
</body>
</html>
