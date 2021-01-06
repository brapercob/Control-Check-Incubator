

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>

	<acme:list-column code="student.book-item.list.label.book" path="book.title" width="30%" />
	<acme:list-column code="student.book-item.list.label.borrowed" path="borrowed" width="30%" />
	<acme:list-column code="student.book-item.list.label.loan-period" path="loanPeriod" width="30%" />

	

</acme:list>