<nav class="navbar navbar-inverse" role="navigation">
	<div class="navbar-header">
      <a class="navbar-brand" href="#">针灸科冬病夏治就诊系统</a>
   </div>
	<div>
      <ul class="nav navbar-nav">
         <#if whichmainmenu==1><li class="active"><#else><li></#if><a href="${rc.contextPath}/home">就诊排队面板</a></li>
         <#if whichmainmenu==2><li class="active"><#else><li></#if><a href="${rc.contextPath}/User">病人信息面板</a></li>
         <li><a href="${rc.contextPath}/Show" target="_blank">病人展示面板</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <li><a href="${rc.contextPath}/quit">注销</a></li>
        </ul>
   </div>
	
</nav>