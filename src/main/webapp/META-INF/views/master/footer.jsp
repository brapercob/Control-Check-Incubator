

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:footer-panel>
	<acme:footer-subpanel code="master.footer.title.about">
		<acme:footer-option icon="fa fa-building" code="master.footer.label.company" action="/master/company"/>
		<acme:footer-option icon="fa fa-file" code="master.footer.label.license" action="/master/license"/>		
	</acme:footer-subpanel>
	
	<acme:footer-subpanel code="master.footer.title.social">
		<acme:footer-option icon="fab fa-linkedin" code="master.footer.label.linked-in" action="http://www.linkedin.com/" newTab="true"/>
		<acme:footer-option icon="fab fa-twitter" code="master.footer.label.twitter" action="https://twitter.com/" newTab="true"/>
	</acme:footer-subpanel>
	
	<acme:footer-subpanel code="master.footer.title.languages">
		<acme:footer-option icon="fa fa-language" code="master.footer.label.english" action="/?language=en"/>
		<acme:footer-option icon="fa fa-language" code="master.footer.label.spanish" action="/?language=es"/>
	</acme:footer-subpanel>
	
	<acme:footer-logo logo="images/logo.png">
		<acme:footer-copyright code="master.company.name"/>
	</acme:footer-logo>		
	
</acme:footer-panel>