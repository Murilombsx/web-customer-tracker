<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<hr>
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role(s): <security:authentication property="principal.authorities" />
		</p>
	<hr>
	
	<div id="container">
		<div id="content">
		
			<security:authorize access="hasRole('ADMIN')">
				<input type="button" value="Add Costumer"
					onClick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
				/>
			</security:authorize>
			
			<form:form action="searchCustomer" method="GET">
                Search customer: <input type="text" name="searchName" />
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<security:authorize access="hasRole('ADMIN')">
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
					</security:authorize>
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td>
							<a href="${updateLink}">Update</a>
							<security:authorize access="hasRole('ADMIN')">
								|	
								<a href="${deleteLink}"
								onClick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" >Delete</a>
							</security:authorize>
						</td>
						
					</tr>
				</c:forEach>
			</table>
			
			<form:form action="${pageContext.request.contextPath}/logout"
							method="POST">
				<input type="submit" value="Logout" class="logout-button"/>
			</form:form>
		</div>
	</div>

</body>

</html>









