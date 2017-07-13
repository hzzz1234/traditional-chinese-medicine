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
                  <th>就诊次数</th>
                  <th>性别</th>
                  <th>操作</th>
                </thead>
                <tbody>
                <tr ng-repeat="r in rescuelist">
					<td>{{ $index+1 }}</td>
					<td>{{ r.patientid }}</td>
					<td>{{ r.patientname }}</td>
					<td>{{ r.recordcount }}</td>
					<td>{{ getSex(r.patientsex) }}</td>
                  <td>
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-ok" title="完成" ng-click="finish($index)"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-trash" title="取消" ng-click="cancel($index)"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);"><i class="glyphicon glyphicon-repeat" title="重新排队" ng-click="reback($index)"></i></a>&nbsp;&nbsp;
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
             <table class="table" >
                <tbody>
                <tr>
					<td></td>
					<td style="color:red">{{ waitlist[waitlist.length-1].patientid }}</td>
					<td style="color:red">{{ waitlist[waitlist.length-1].patientname }}</td>
					<td style="color:red">{{ getSex(waitlist[waitlist.length-1].patientsex) }}</td>
                  <td>
                    <a style="color:red" href="javascript:void(0);" title="上移"><i class="icon-star" ng-click="up($index)"></i></a>&nbsp;&nbsp;
                  </td>
                </tr>
                </tbody>
              </table>
            <div class="panel-body" >
                <div>
                    <div class="row">
                    <form name="arr_form" role="form">
	                    <div class="col-md-8">
	                    	<input ng-change="arrangetextchange($event)" type="text" ng-model="patientNo" class="form-control" style="min-width:60%"  ng-pattern="/^[1-9][0-9]*/" placeholder="请输入病历号" name="patientNo" required>
	                    </div>
	                    <div class="col-md-2">
	                      <button class="btn btn-primary form-control" ng-disabled="arr_form.$invalid" ng-click="arrange(patientNo)">排  队</button>
	                    </div>

	                 </form>
                   </div>
                   <div  style=" overflow-y:scroll;max-height:75%;min-height:75%;">
              <table class="table" >
                <thead>
                  <th>序号</th>
                  <th>病历号</th>
                  <th>姓名</th>
                  <th>就诊次数</th>
                  <th>性别</th>
                  <th>操作</th>
                </thead>
                <tbody>
                <tr ng-repeat="w in waitlist">
					<td>{{ w.seq }}</td>
					<td>{{ w.patientid }}</td>
					<td>{{ w.patientname }}</td>
					<td>{{ w.recordcount }}</td>
					<td>{{ getSex(w.patientsex) }}</td>
                  <td>
                    <a href="javascript:void(0);" title="上移"><i class="icon-angle-up" ng-click="up($index)"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);" title="下移"><i class="icon-angle-down" ng-click="down($index)"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);" title="置顶"><i class="icon-double-angle-up" ng-click="upup($index)"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);" title="置底"><i class="icon-double-angle-down" ng-click="downdown($index)"></i></a>&nbsp;&nbsp;
                    <a href="javascript:void(0);" title="删除"><i class="glyphicon glyphicon-trash" ng-click="delete1($index)"></i></a>&nbsp;&nbsp;


                  </td>
                </tr>
                </tbody>
              </table>
              </div>
            </div>
             <div class="panel-footer">
              <div class="row">
                    <div class="col-md-4">
                      <button class="btn btn-primary form-control" ng-disabled="waitlist.length <= 0" ng-click="rescue()">就  诊</button>
                    </div>
                        <div class="col-md-4">
                            <button class="btn btn-primary form-control" ng-click="reset()">重  置</button>
                        </div>
                    <div class="col-md-4">
                      <button class="btn btn-primary form-control" ng-click="clean()">清  空</button>
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
				patientsex:${w.patientsex},
				recordcount:${w.recordcount}
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
				patientsex:${w.patientsex},
				recordcount:${w.recordcount}
				},
			</#list>
		</#if>
	];
</script>
<script src="${rc.contextPath}/resources/dbxz/js/home.js">
</script>
</body>
</html>
