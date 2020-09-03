<%@ include file="/include.jsp" %>

<c:if test="${not empty buildType}">
    <div>
        The selected build configuration: <c:out value="${buildType.name}"/>
    </div>
</c:if>

<div class="basic-plugin-wrapper">Here is a basic plugin.</div>
