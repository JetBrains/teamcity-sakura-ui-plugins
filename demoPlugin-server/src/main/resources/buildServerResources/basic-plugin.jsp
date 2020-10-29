<%@ include file="/include.jsp" %>

<div class="dummy-plugin-wrapper">Here is a basic plugin. Build Configuration is <c:out value="${buildType != null ? buildType.name : ''}" /></div>
<div>UI Context is: <c:out value="${param['pluginUIContext']}"></c:out></div>
