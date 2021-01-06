<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.book.list.label.title" path="title" width="30%"/>
	<acme:list-column code="administrator.book.list.label.authors" path="authors" width="30%"/>
	<acme:list-column code="administrator.book.list.label.genre" path="genre" width="30%"/>
	
</acme:list> 