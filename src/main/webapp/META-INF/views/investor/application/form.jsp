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

<acme:form>

	<jstl:if test="${command == 'create'}">
		<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" placeholder="SSS-YY-123456" />
		<acme:form-textarea code="investor.application.form.label.statement" path="statement" />
		<acme:form-money code="investor.application.form.label.investment-offer" path="investmentOffer" />

		<%--Tiene request investment--%>
		<jstl:if test="${havePagbad}">
			<acme:form-textbox code="investor.application.form.label.pagbad-application.offer" path="pagbadApplication.pagbadOffer" />
			<acme:form-textbox code="investor.application.form.label.pagbad-application.link" path="pagbadApplication.pagbadOfferLink" />
			<acme:form-password code="investor.application.form.label.pagbad-application.password" path="pagbadApplication.passwordLink" />
		</jstl:if>
	</jstl:if>
	<jstl:if test="${command == 'show'}">
		<acme:form-textbox code="investor.application.form.label.investment-ticker" path="investment.ticker" placeholder="SSS-YY-123456"
			readonly="true" />
		<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" placeholder="SSS-YY-123456" readonly="true" />
		<acme:form-moment code="investor.application.form.label.creation-date" path="creationDate" readonly="true" />
		<acme:form-textarea code="investor.application.form.label.statement" path="statement" readonly="true" />
		<acme:form-money code="investor.application.form.label.investment-offer" path="investmentOffer" readonly="true" />
		<acme:form-money code="investor.application.form.label.status" path="status" readonly="true" />

		<%--Tiene request investment--%>
		<jstl:if test="${havePagbad}">
			<acme:form-textbox code="investor.application.form.label.pagbad-application.offer" path="pagbadApplication.pagbadOffer" readonly="true" />
			<acme:form-textbox code="investor.application.form.label.pagbad-application.link" path="pagbadApplication.pagbadOfferLink"
				readonly="true" />
			<acme:form-textbox code="investor.application.form.label.pagbad-application.password" path="pagbadApplication.passwordLink"
				readonly="true" />
		</jstl:if>
	</jstl:if>

	<jstl:if test="${status != 'PENDING' and command == 'show'}">
		<acme:form-textarea code="investor.application.form.label.rejectReason" path="rejectReason" readonly="true" />
	</jstl:if>

	<acme:form-submit test="${command == 'create'}" code="investor.application.form.button.apply"
		action="/investor/application/create?invId=${ivID}" />

	<acme:form-return code="investor.application.form.button.return" />

	<input id="ivID" name="ivID" value="${ivID}" type="hidden" />
	<input id="havePagbad" name="havePagbad" value="${havePagbad}" type="hidden" />

</acme:form>