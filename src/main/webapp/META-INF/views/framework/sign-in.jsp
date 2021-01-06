

<%@ page language="java" %>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<jstl:if test="${param.error != null}">
	<acme:alert-error>
		<acme:message code="master.sign-in.error.text"/>
	</acme:alert-error>
</jstl:if>

<acme:form>
	<acme:form-textbox code="master.sign-in.label.username" path="username"/>
	<acme:form-password code="master.sign-in.label.password" path="password"/>
	<acme:form-checkbox code="master.sign-in.label.remember-me" path="remember"/>

	<acme:form-submit code="master.sign-in.button.sign-in" action="/master/sign-in"/>
	<acme:form-return code="master.sign-in.button.return"/>
</acme:form>
