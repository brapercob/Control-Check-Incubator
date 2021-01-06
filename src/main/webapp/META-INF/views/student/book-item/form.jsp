
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<jstl:if test="${command == 'create'}">
		<acme:form-textbox code="student.book-item.form.label.bar-code" path="barCode" />
		<acme:form-select code="student.book-item.form.label.format" path="format">
			<acme:form-option code="student.book-item.form.label.format.pdf" selected="${format == 'PDF'}" value="PDF" />
			<acme:form-option code="student.book-item.form.label.format.soft-cover" selected="${format == 'SOFTCOVER'}" value="SOFTCOVER" />
			<acme:form-option code="student.book-item.form.label.format.hard-cover" selected="${format == 'HARDCOVER'}" value="HARDCOVER" />
			<acme:form-option code="student.book-item.form.label.format.audio-book" selected="${format == 'AUDIOBOOK'}" value="AUDIOBOOK" />
		</acme:form-select>
		<acme:form-integer code="student.book-item.form.label.loan-period" path="loanPeriod" />
	</jstl:if>

	<jstl:if test="${command == 'show'}">
		<acme:form-textbox code="student.book-item.form.label.bar-code" path="barCode" readonly="true" />
		<acme:form-moment code="student.book-item.form.label.borrowed" path="borrowed" readonly="true" />
		<acme:form-textbox code="student.book-item.form.label.format" path="format" readonly="true" />
		<acme:form-integer code="student.book-item.form.label.loan-period" path="loanPeriod" readonly="true" />
		<acme:form-textbox code="student.book-item.form.label.borrower" path="borrower.identity.fullName" readonly="true" />
		<acme:form-textbox code="student.book-item.form.label.book" path="book.title" readonly="true" />
	</jstl:if>

	<acme:form-submit test="${command == 'create'}" code="student.book-item.form.button.create"
		action="/student/book-item/create?bookId=${bookId}" />

	<input id="bookId" name="bookId" value="${bookId}" type="hidden" />

	<acme:form-return code="student.book-item.form.button.return" />

</acme:form>