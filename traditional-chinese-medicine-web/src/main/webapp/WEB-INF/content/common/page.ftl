<#if (page.curPage)??>
    <#if (page.pageCount < 10) >
        <#assign showPageStartIndex=1>
        <#assign showPageEndIndex=page.pageCount>
    <#else>
        <#if (page.curPage < 5 )>
            <#assign showPageStartIndex=1>
            <#assign showPageEndIndex=10>
        <#elseif ((page.pageCount - page.curPage ) < 4  )>
            <#assign showPageStartIndex=page.pageCount-8>
            <#assign showPageEndIndex=page.pageCount>
        <#else>
            <#assign showPageStartIndex=page.curPage-4>
            <#assign showPageEndIndex=page.curPage+5>
        </#if>
    </#if>
    <#if (page.itemCount > 0)>
        <#assign startNo= page.startItem+1>
    <#else>
        <#assign startNo= 0 >
    </#if>
    <#if (page.pageSize*page.curPage < page.itemCount)>
        <#assign endNo= page.pageSize*page.curPage>
    <#else>
        <#assign endNo= page.itemCount>
    </#if>
<div class="pagination  pagination-simple" style="width:100%;z-index:666;">
    <div class="pagination-centered" style="width:100%">
        <ul>
            <li><a>显示 ${startNo} to ${endNo},共${page.itemCount}条</a></li>
            <#if (page.itemCount > 0)>
                <li class="<#if (page.curPage-1 == 0)>disabled</#if>">
                    <a href="javascript:void(0);" <#if (page.curPage-1 == 0)><#else>onclick="jumpPage(${page.curPage-1});"</#if>>«</a>
                </li>
                <li class="<#if (page.curPage-1 == 0)>disabled</#if>">
                    <a href="javascript:void(0);" <#if (page.curPage-1 == 0)><#else>onclick="jumpPage(1);"</#if>>首页</a>
                </li>
                <#if page.pageCount??>
                    <#list showPageStartIndex..showPageEndIndex as p>
                        <li class="<#if (p == page.curPage)> active</#if>">
                            <a href="javascript:void(0);" <#if (p != page.curPage)>onclick="jumpPage(${p})"</#if> >${p}</a>
                        </li>
                    </#list>
                </#if>
                <li class="<#if (page.curPage == page.pageCount)>disabled</#if>">
                    <a href="javascript:void(0);" <#if (page.curPage == page.pageCount)><#else>onclick="jumpPage(${page.pageCount});"</#if>>末页</a>
                </li>
                <li class="<#if (page.curPage == page.pageCount)>disabled</#if>">
                    <a href="javascript:void(0);" <#if (page.curPage == page.pageCount)><#else>onclick="jumpPage(${page.curPage+1});"</#if> >»</a>
                </li>
            </#if>
            <li><a>共<#if (page.itemCount > 0)> ${page.pageCount}<#else>0</#if>页</a></li>
        </ul>
    </div>
</div>
</#if>