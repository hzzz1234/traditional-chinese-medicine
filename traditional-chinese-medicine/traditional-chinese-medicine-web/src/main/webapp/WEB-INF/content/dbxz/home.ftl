<html ng-app="home" ng-controller="homeController">
<head>
	<#include "/common/common.ftl"/>
    <title>Main</title>
</head>
<body>
	<#include "/common/header.ftl"/>
	<div class="container" style="width:80%;">
      <div class="row">
        <div class="col-lg-6" >
          <div class="panel panel-default">
          <div class="panel-heading">
              	就诊面板
            </div>
             <div class="panel-body">
          <table class="table">
                <thead>
                  <th>序号</th>
                  <th>病历号</th>
                  <th>姓名</th>
                  <th>删除</th>
                </thead>
                <tbody>
                <tr ng-repeat="r in rescuelist">
					<td>{{ $index+1 }}</td>
					<td>{{ r.patientid }}</td>
					<td>{{ r.patientname }}</td>
                  <td>
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-ok" title="完成"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-trash" title="取消"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-repeat" title="重新排队"></i></a>&nbsp;&nbsp;
                  </td>
                </tr>
                </tbody>
           </table>
          
           </div>
           </div>
        </div>
        <div class="col-lg-6" >
          <div class="panel panel-default">
            <div class="panel-heading">
              	排队等待面板
            </div>
            <div class="panel-body" >
                <div>
                    <div class="row">
	                    <div class="col-md-8">
	                    	<input type="text" class="form-control" style="min-width:60%" placeholder="请输入病历号" name="patientNo">
	                    </div>
	                    <div class="col-md-4">
	                      <button class="btn btn-primary form-control">排  队</button>
	                    </div>
                   </div>
                   <div  style=" overflow-y:scroll;max-height:600px">
              <table class="table" >
                <thead>
                  <th><input type="checkbox">序号</th>
                  <th>病历号</th>
                  <th>姓名</th>
                  <th>操作</th>
                </thead>
                <tbody>
                <tr ng-repeat="w in waitlist">
					<td><input type="checkbox">{{ $index+1 }}</td>
					<td>{{ w.patientid }}</td>
					<td>{{ w.patientname }}</td>
                  <td>
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-arrow-up"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-arrow-down"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-trash"></i></a>&nbsp;&nbsp;
                  </td>
                </tr>
                </tbody>
              </table>
              </div>
            </div>
             <div class="panel-footer">
              <div class="row">
                    <div class="col-md-4">
                      <button class="btn btn-primary form-control">就  诊</button>
                    </div>
                    <div class="col-md-4">
                      <button class="btn btn-primary form-control">清  空</button>
                    </div>
                    <div class="col-md-4">
                      <button class="btn btn-primary form-control">重  置</button>
                    </div>
              
            </div>
          </div>
        </div>
      </div>
</div>
<script>
	var waitlist = [
		<#if dbxzMainVo.waitList??>
			<#list dbxzMainVo.waitList as w>
				{
				recordid:${w.recordid},
				patientid:${w.patientid},
				patientname:'${w.patientname}',
				},
			</#list>
		</#if>
	];
	var rescuelist = [
		<#if dbxzMainVo.rescueList??>
			<#list dbxzMainVo.rescueList as w>
				{
				recordid:${w.recordid},
				patientid:${w.patientid},
				patientname:'${w.patientname}',
				},
			</#list>
		</#if>
	];
</script>
<script src="${rc.contextPath}/resources/dbxz/js/home.js">
</script>
</body>
</html>
