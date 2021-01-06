

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-url code="authenticated.teacher.form.label.personal-web" path="personalWeb"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.teacher.form.button.create" action="/authenticated/teacher/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.teacher.form.button.update" action="/authenticated/teacher/update"/>
	<acme:form-return code="authenticated.teacher.form.button.return"/>
</acme:form>
