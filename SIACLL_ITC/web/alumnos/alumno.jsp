<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>

<h:form id="formaUsuarios">
Welcome : <h:outputLabel value="#{loginBean.user}"></h:outputLabel>

<center>

<table>
<tr>
<td style="font-weight: bold; size: 12px; color: blue;" align="right">Usuario : </td>
<td><h:inputText value="#{loginBean.user}"/></td>
</tr>
<tr>
<td style="font-weight: bold; size: 12px; color: blue;" align="right">Password : </td>
<td><h:inputSecret value="#{loginBean.password}"/></td>
</tr>
<tr>
<td style="font-weight: bold; size: 12px; color: blue;" align="right">Nombre(s) : </td>
<td><h:inputText value="#{loginBean.nombre}"/></td>
</tr>
<tr>
<td style="font-weight: bold; size: 12px; color: blue;" align="right">Edad : </td>
<td><h:inputText value="#{loginBean.edad}"/></td>
</tr>
<tr>
<td colspan="2">
<h:commandButton value="Guardar" action="#{loginBean.guardar}"/>
<h:commandButton value="Actualizar" action="#{loginBean.actualizar}"/>
<h:commandButton value="Eliminar" action="#{loginBean.borrar}"/>
</td>

</tr>
</table>

<h:dataTable id="tablaUsuarios" value="#{loginBean.listaUsuarios}" var="obj"
border="1">

<h:column>
<f:facet name="header"><h:outputText value="Usuario"></h:outputText></f:facet>
<h:outputText value="#{obj.user}"></h:outputText>
</h:column>

<h:column>
<f:facet name="header"><h:outputText value="Nombre(s)"></h:outputText></f:facet>
<h:outputText value="#{obj.nombre}"></h:outputText>
</h:column>

<h:column>
<f:facet name="header"><h:outputText value="Edad"></h:outputText></f:facet>
<h:outputText value="#{obj.edad}"></h:outputText>
</h:column>

</h:dataTable>

</center>

</h:form>

</f:view>
</body>
</html>
