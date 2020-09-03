<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-textbox code="authenticated.investment-round.form.label.ticker" path="ticker" placeholder="SSS-YY-123456" />
	<acme:form-moment code="authenticated.investment-round.form.label.creation-date" path="creationDate" />
	<acme:form-textbox code="authenticated.investment-round.form.label.kind-of-round" path="kindOfRound" />
	<acme:form-textbox code="authenticated.investment-round.form.label.title" path="title" />
	<acme:form-textarea code="authenticated.investment-round.form.label.description" path="description" />
	<acme:form-money code="authenticated.investment-round.form.label.amount" path="amount" />
	<acme:form-url code="authenticated.investment-round.form.label.optional-link" path="optionalLink" />
	<jstl:if test="${pagbad != null}">
		<acme:form-textarea code="authenticated.investment-round.form.label.pagbad" path="pagbad.description" />
	</jstl:if>
	
	
	<jstl:if test="${isInvestor and applied}">
		<strong> <acme:message code="authenticated.investment-round.form.label.applied" />
		</strong>
	</jstl:if>


	<jstl:if test="${isCreatorInv and isInvestor}">
		<strong> <acme:message code="authenticated.investment-round.form.is-creator" />
		</strong>
	</jstl:if>

	<acme:form-submit test="${isInvestor and not applied and not isCreatorInv}" method="get"
		code="authenticated.investment-round.form.button.apply" action="/investor/application/create?invId=${ivID}" />
	<acme:form-submit method="get" code="authenticated.investment-round.form.button.work-programme"
		action="/authenticated/activity/list?id=${ivID}" />
	<acme:form-submit method="get" code="authenticated.investment-round.form.button.accounting-records"
		action="/authenticated/accounting-record/list?id=${ivID}" />

	<acme:form-return code="authenticated.investment-round.form.button.return" />

</acme:form>