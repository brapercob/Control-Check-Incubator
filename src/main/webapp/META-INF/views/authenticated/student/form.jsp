

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.student.form.label.neptun-code" path="neptunCode"/>


	
	<acme:form-submit test="${command == 'create'}" code="authenticated.student.form.button.create" action="/authenticated/student/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.student.form.button.update" action="/authenticated/student/update"/>
	<acme:form-return code="authenticated.student.form.button.return"/>
</acme:form>
