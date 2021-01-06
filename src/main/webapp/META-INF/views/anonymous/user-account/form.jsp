

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.user-account.label.username" path="username"/>
	<acme:form-password code="anonymous.user-account.label.password" path="password"/>
	<acme:form-password code="anonymous.user-account.label.confirmation" path="confirmation"/>
	
	<acme:form-textbox code="anonymous.user-account.label.name" path="identity.name"/>
	<acme:form-textbox code="anonymous.user-account.label.surname" path="identity.surname"/>
	<acme:form-textbox code="anonymous.user-account.label.email" path="identity.email"/>
	 
	<acme:form-checkbox code="anonymous.user-account.label.accept" path="accept"/>
	
	<acme:form-submit code="anonymous.user-account.button.create" action="/anonymous/user-account/create"/>
  	<acme:form-return code="anonymous.user-account.button.return"/>
</acme:form>
