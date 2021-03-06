<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="student.book.form.label.title" path="title"/>
	<acme:form-textarea code="student.book.form.label.authors" path="authors"/>
	<acme:form-textbox code="student.book.form.label.genre" path="genre"/>
	<acme:form-textbox code="student.book.form.label.subject" path="subject"/>
	<acme:form-textbox code="student.book.form.label.isbn" path="isbn"/>
	<acme:form-textbox code="student.book.form.label.eisbn" path="eisbn"/>
	<acme:form-textbox code="student.book.form.label.language" path="language"/>
	<acme:form-integer code="student.book.form.label.numberOfPages" path="numberOfPages"/>
	<acme:form-integer code="student.book.form.label.quantity" path="quantity"/>	
	
	<acme:form-submit test="${command == 'create'}" 
		code="administrator.book.form.button.create"
		action="/administrator/book/create"/>
	<acme:form-return code="administrator.book.form.button.return"/>
</acme:form> 