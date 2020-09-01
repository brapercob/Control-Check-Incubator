
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-textbox code="entrepreneur.accounting-record.form.label.title" path="title" />
	<acme:form-textbox code="entrepreneur.accounting-record.form.label.status" path="status" />
	<acme:form-textbox code="entrepreneur.accounting-record.form.label.creationMoment" path="creationMoment" />
	<acme:form-textarea code="entrepreneur.accounting-record.form.label.body" path="body" />
	<acme:form-textbox code="entrepreneur.accounting-record.form.label.entrepreneur" path="bookkeeper.userAccount.identity.fullName" />
	<acme:form-textbox code="entrepreneur.accounting-record.form.label.investmentRound" path="investmentRound.ticker" />


	<acme:form-return code="entrepreneur.accounting-record.form.button.return" />


</acme:form>
