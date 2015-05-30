<html ng-app="login" ng-controller="loginController">
<head>
	<#include "/common/common.ftl"/>
    <title>Main</title>
</head>
<body style="text-align:center;">
	<div class="container" style="">
		 <div class="panel panel-default" style="height:300px;width:500px;margin-top:30%;margin-left:25%;">
            <div class="panel-heading">
              	<H2>中医院冬病夏治排队系统登陆面板</h2>
            </div>
            <div class="panel-body" >
              <form name="login_form" action="${rc.contextPath}/login">
              <label for="lastname" class="col-sm-2 control-label">用户名</label>
              <div class="col-sm-10">
               <input type="text" placeholder="请输入用户名" class="form-control" name="username" ng-model="username" required>
              </div>
              <div>
              	<input style="visibility:hidden;" >
              </div>
              <label for="lastname" class="col-sm-2 control-label">密    码</label>
              <div class="col-sm-10">
                <input type="password" placeholder="请输入密码" class="form-control" name="password" ng-model="password" required>
              </div>
              <div>
              	<input style="visibility:hidden;" >
              </div>
              <div class="col-sm-5">
              <button type="submit" class="btn btn-primary form-control"  ng-disabled="login_form.$invalid">登陆</button>
              </div>
              <div class="col-sm-2">
              </div>
              <div class="col-sm-5">
              <button  class="btn btn-primary form-control"  ng-click="reset()">重置</button>
              </div>
              </form>
            </div>
               
            </div>
          </div>
	</div>
	<script src="${rc.contextPath}/resources/dbxz/js/login.js">
</script>
</body>
</html>
