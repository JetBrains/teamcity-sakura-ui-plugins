<%@ include file="/include.jsp" %>

<div id="SakuraUI-Plugin" class="controlled-plugin-wrapper hidden">
  <div class="js-static-part">
    <h2>There is a controlled plugin wrapper.</h2>
    <p>Do not forget to make it invisible till the moment it's ready to be shown. You can use either the predefined CSS class 'hidden' or use JS-based templates</p>
  </div>
  <div class="js-dynamic-part"></div>
</div>

<bs:linkScript>
  ${teamcityPluginResourcesPath}controlled-plugin-jsp.js
</bs:linkScript>
