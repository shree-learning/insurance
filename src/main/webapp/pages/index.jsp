<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>

	<div class="container">
		<h3>Report Application</h3>

		<form:form action="search" modelAttribute="request" method="post"
			class="p-3">
			<table>
				<tr>
					<td >Plan Names :</td>
					<td><form:select path="planName" class="form-select">
							<form:option value="">-SELECT-</form:option>
							<form:options items="${planNames}" />
						</form:select></td>

					<td>Plan Status :</td>
					<td><form:select path="planStatus" class="form-select">
							<form:option value="">-SELECT-</form:option>
							<form:options items="${planStatus}" />
						</form:select></td>
					<td>Gender :</td>
					<td><form:select path="gender" class="form-select">
							<form:option value="">-SELECT-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="FeMale">Fe-Male</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date" /></td>
					<td>End Date:</td>
					<td><form:input path="endDate" type="date" /></td>
				</tr>
				<tr>
					<td><a href="/" class="btn btn-secondary">RESET</a></td>
					<td><input class="btn btn-primary" type="submit"
						value="search" /></td>
				</tr>
			</table>
		</form:form>
		<hr>

		<p>Search Results</p>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Holder Name</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${searchResult}" var="searchData"
					varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${searchData.citizenName}</td>
						<td>${searchData.planName}</td>
						<td>${searchData.planStatus}</td>
						<td>${searchData.planStartDate}</td>
						<td>${searchData.planEndDate}</td>
					</tr>
				</c:forEach>
			</tbody>
			<div>
				<c:if test="${empty searchResult}">
					<td colspan="6" style="text-align: center">No Result found</td>
				</c:if>
			</div>
		</table>

		<hr>
		Export : <a href="excel">Excel</a> <a href="pdf">pdf</a>
		<p>${msg}</p>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

	<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>

</body>
</html>