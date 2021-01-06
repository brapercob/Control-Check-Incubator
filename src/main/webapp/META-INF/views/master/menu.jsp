

<%@page language="java" import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">

	<acme:menu-left>

		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.book" action="/administrator/book/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.administrator.book.create" action="/administrator/book/create" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.student" access="hasRole('Student')">
			<acme:menu-suboption code="master.menu.student.book" action="/student/book/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.student.list-mine" action="/student/book-item/list-mine" />

		</acme:menu-option>

	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.become-student" action="/authenticated/student/create"
				access="!hasRole('Student')" />
			<acme:menu-suboption code="master.menu.user-account.student" action="/authenticated/student/update" access="hasRole('Student')" />
			<acme:menu-suboption code="master.menu.user-account.become-teacher" action="/authenticated/teacher/create"
				access="!hasRole('Teacher')" />
			<acme:menu-suboption code="master.menu.user-account.teacher" action="/authenticated/teacher/update" access="hasRole('Teacher')" />
			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create"
				access="!hasRole('Worker')" />
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update" access="hasRole('Worker')" />
		</acme:menu-option>
		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />

	</acme:menu-right>
</acme:menu-bar>

