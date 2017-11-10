<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Takum Prueba - Usuarios</title>
<style>
.username.ng-valid {
	background-color: lightgreen;
}

.username.ng-dirty.ng-invalid-required {
	background-color: red;
}

.username.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container" ng-controller="ProductosController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Módulo de Usuarios</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.productos.usuacodi" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Nombre</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.productos.usuanomb" name="uname"
									class="username form-control input-sm"
									placeholder="Ingrese tu nombre" required ng-maxlength="20" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.uname.$error.required">Esto es un
										campo requerido</span> <span ng-show="myForm.uname.$error.maxlength">Máximo
										tamaño requerido es 20</span> <span ng-show="myForm.uname.$invalid">Este
										campo es invalido</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Apellido</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.productos.usuaapel" name="uapel"
									class="username form-control input-sm"
									placeholder="Ingrese tu apellido" required ng-maxlength="20" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.uname.$error.required">Esto es un
										campo requerido</span> <span ng-show="myForm.uname.$error.maxlength">Máximo
										tamaño requerido es 20</span> <span ng-show="myForm.uname.$invalid">Este
										campo es invalido</span>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Dirección</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.productos.usuadire"
									class="form-control input-sm"
									placeholder="Ingrese la direccíon" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.productos.usuaemai" name="email"
									class="email form-control input-sm"
									placeholder="Ingrese su email" required />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.productos.usuacodi ? 'Agregar' : 'Actualizar'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reiniciar
								Formulario</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Lista de Usuarios</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>Cédula</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Dirección</th>
							<th>Email</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.productoss">
							<td><span ng-bind="u.usuacodi"></span></td>
							<td><span ng-bind="u.usuaterc"></span></td>
							<td><span ng-bind="u.usuanomb"></span></td>
							<td><span ng-bind="u.usuaapel"></span></td>
							<td><span ng-bind="u.usuadire"></span></td>
							<td><span ng-bind="u.usuaemai"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.usuacodi)"
									class="btn btn-success custom-width">Editar</button>
								<button type="button" ng-click="ctrl.remove(u.usuacodi)"
									class="btn btn-danger custom-width">Eliminar</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/productos_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/productos_controller.js' />"></script>
</body>
</html>