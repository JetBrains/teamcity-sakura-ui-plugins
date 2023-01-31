<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/include-internal.jsp"%>
<%@ page import="jetbrains.buildServer.web.util.WebUtil" %>
<c:set var="sakuraUI" value='<%= WebUtil.sakuraUIOpened(request) %>'/>

<c:choose>
  <c:when test="${sakuraUI == false}">
    <div id="plugin-container"></div>
    <script>
      (function() {
        const placeId = TeamCityAPI.Plugin.placeIds.TAB_PLUGIN_CONTAINER;
        const container = document.getElementById('plugin-container');
        ReactUI.renderPluginPlace(container, {placeId})
      })()
    </script>
  </c:when>
</c:choose>
