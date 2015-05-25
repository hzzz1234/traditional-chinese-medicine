<html>
<head>
	<#include "/common/common.ftl"/>
    <title>Main</title>
</head>
<body>
	<#include "/common/header.ftl"/>
	<div class="container" style="width:80%;">
		<div class="panel panel-default">
			<div class="panel-heading">
	              	查询面板
	            </div>
	         <div class="panel-body">
	              <div class="row">
	                <div class="col-md-8">
	                  <div class="row">
	                    <div class="col-md-8">
	                      <input text="text" class="form-control" placeholder="请输入病人信息:病历号/名字">
	                    </div>
	                    <div class="col-md-2">
	                      <button  class="btn btn-default form-control">查询</button>
	                    </div>
	                  </div>
	                </div>
	              </div>
	              <div>
	              <div>
	                <table class="table">
	                  <thead>
	                    <th>病历号</th>
	                    <th>姓名</th>
	                    <th>年龄</th>
	                    <th>性别</th>
	                    <th>症状</th>
	                    <th>联系方式</th>
	                    <th>详情</th>
	                  </thead>
                      <tbody>
                        <tr>
	                  </tr>
	                  <tr>
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
							<form role="form">
								<fieldset>
									<legend>病人信息</legend>
									<div class="form-group">
										<label for="id">病历号</label>
										<input type="text" disabled class="form-control" id="id" name="id">
										<label for="name">姓名</label>
										<input type="text" class="form-control" id="name" name="name">
										<label for="age">年龄</label>
										<input type="number"  class="form-control" id="age" name="age">
										<label for="sex">性别</label>&nbsp;&nbsp;
										<input type="radio" name="sex">男
										<input type="radio" name="sex">女
										<br/>
										<label for="contact">联系方式</label>
										<input type="text" class="form-control" id="contact" name="contact">
										<label for="symptom">症状</label>
										<textarea row="3" class="form-control" id="symptom" name="symptom" ></textarea>
										<label for="medication">方药</label>
										<div class="row">
											<div class="col-md-10">
												<input type="text" class="form-control" id="medication" name="medication">
											</div>
											<div class="col-md-2">
												<a data-toggle="modal" data-target="#myModal" class="btn btn-default" class="form-control" style="min-width: 20%;">方药添加</a>
											</div>
										</div>
										<br/>
										<div style="text-align:center;">
											<button class="btn btn-primary " style="min-width: 20%;">保存修改</button>&nbsp;&nbsp;&nbsp
											<button class="btn btn-primary" style="min-width: 20%;">重    置</button>
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
										<tr>
											<td>1</td>
											<td>11111</td>
											<td><i class="glyphicon glyphicon-trash"></i></td>
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
							<form role="form" class="form-search">
								<fieldset>
								<legend>病人信息</legend>
								<div class="form-group">
									<label for="id">病历号</label>
									<input type="text" class="form-control" id="id" name="id">
									<label for="name">姓名</label>
									<input type="text" class="form-control" id="name" name="name">
									<label for="age">年龄</label>
									<input type="number"  class="form-control" id="age" name="age">
									<label for="sex">性别</label>&nbsp;&nbsp;
									<input type="radio" name="sex">男
									<input type="radio" name="sex">女
									<br/>
									<label for="contact">联系方式</label>
									<input type="text" class="form-control" id="contact" name="contact">
									<label for="symptom">症状</label>
									<textarea rows="3" class="form-control" id="symptom" name="symptom"></textarea>
									<label for="medication">方药</label>
									<div class="row">
										<div class="col-md-10">
											<input type="text" class="form-control" id="medication" name="medication">
										</div>
										<div class="col-md-2">
											<a class="btn btn-default" data-toggle="modal" data-target="#myModal" class="form-control" style="min-width: 20%;">方药添加</a>
										</div>
									</div>
									<br/>
									<div style="text-align:center;">
										<button class="btn btn-primary " style="min-width: 20%;">添加人员</button>&nbsp;&nbsp;&nbsp
										<button class="btn btn-primary" style="min-width: 20%;">重置</button>
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
	         		<div class="col-md-10">
	         			<input type="text" class="form-control" placeholder="方药名称">
	         		</div>
	         		<div class="col-md-2">
	         			<button class="btn btn-primary form-control" >添加</button>
	         		</div>
	         	</div>
	         	<br/>
				<div class="row">
	         		<div class="col-md-10">
	         			<select size="10" class="form-control" multiple="multiple">
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
         					<option value="">默认选择</option>
      					</select>
	         		</div>
	         		<div class="col-md-2" >
	         			<button class="btn btn-primary form-control" style="vertical-align:center;">删除</button>
	         		</div>
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
	</script>
</body>
</html>
