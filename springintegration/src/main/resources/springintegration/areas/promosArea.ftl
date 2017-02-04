<div>
<h2>${content.heading!}</h2>
[#list components as component ]
  [@cms.component content=component /]
[/#list]
</div>