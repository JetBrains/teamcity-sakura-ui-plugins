<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="intprop" uri="/WEB-INF/functions/intprop"
%><%@ include file="/include.jsp" %>

<c:choose>
  <c:when test="${BUNDLE_DEV_URL ne null}">
    <bs:linkScript>${BUNDLE_DEV_URL}/bundle.js</bs:linkScript>
  </c:when>
  <c:otherwise>
    <bs:linkScript>${teamcityPluginResourcesPath}bundle.js</bs:linkScript>
  </c:otherwise>
</c:choose>
