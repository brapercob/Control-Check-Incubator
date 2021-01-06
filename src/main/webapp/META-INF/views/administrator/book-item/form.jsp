<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.book.form.label.title" path="title"/>
	<acme:form-moment code="administrator.book.form.label.authors" path="authors"/>
	<acme:form-textarea code="administrator.book.form.label.genre" path="genre"/>
	<acme:form-textbox code="administrator.book.form.label.subject" path="subject"/>
	<acme:form-money code="administrator.book.form.label.isbn" path="isbn"/>
	<acme:form-textbox code="administrator.book.form.label.eisbn" path="eisbn"/>
	<acme:form-money code="administrator.book.form.label.language" path="language"/>
	<acme:form-textbox code="administrator.book.form.label.numberOfPages" path="numberOfPages"/>
	
	

	<acme:form-return code="administrator.challenge.form.button.return"/>
</acme:form> 