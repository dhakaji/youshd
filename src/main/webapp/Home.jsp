<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.youshd.response.EarningResponse" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Youshd</title>
</head>
<body>
<font size="5">INPUT TABLE</font><br />
<form:form method="GET" action="/getEarnings" modelAttribute="orderStatus">
    <table border="1" cellpadding="5">
        <tr>
            <td><form:label path="angela">Angela</form:label></td>
            <td><form:input type="text" path="angela"/></td>
        </tr>
        <tr>
            <td><form:label path="maria">Maria</form:label></td>
            <td><form:input type = "text" path="maria"/></td>
        </tr>
        <tr>
            <td><form:label path="bob">Bob</form:label></td>
            <td><form:input type = "text" path="bob"/></td>
        </tr>
        <tr>
            <td><form:label path="meggieb">MeggieB</form:label></td>
            <td><form:input type = "text" path="meggieb"/></td>
        </tr>
        <tr>
            <td><form:label path="jimi">Jimi</form:label></td>
            <td><form:input type = "text" path="jimi"/></td>
        </tr>
        <tr>
            <td><form:label path="hendrix">Hendrix</form:label></td>
            <td><form:input type = "text" path="hendrix"/></td>
        </tr>
        <tr>
            <td><form:label path="nusrat">Nusrat</form:label></td>
            <td><form:input type = "text" path="nusrat"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<%--<div align="left">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <tr>--%>
<%--            <td>Angela</td>--%>
<%--            <td><input type="text" id="angela" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Maria</td>--%>
<%--            <td><input type="text" id="maria" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Bob</td>--%>
<%--            <td><input type="text" id="bob" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>MeggieB</td>--%>
<%--            <td><input type="text" id="meggieb" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Jimi</td>--%>
<%--            <td><input type="text" id="jimi" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Hendrix</td>--%>
<%--            <td><input type="text" id="hendrix" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Nusrat</td>--%>
<%--            <td><input type="text" id="nusrat" /></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</div>--%>
<br />
<br />
<%--${responseList}--%>
<%--${responseList.size()}--%>
<%--${responseList.get(0)}--%>
<%--<%! List eList = (ArrayList).getAttribute("responseList");%>--%>
<font size="5">OUTPUT TABLE</font><br />
<div align="left">
    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>discount</th>
            <th>cashback</th>
            <th>total</th>
        </tr>
<%--        <tr>--%>
<%--            <td>Angela</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Maria</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Bob</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>MeggieB</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Jimi</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Hendrix</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Nusrat</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--            <td>0</td>--%>
<%--        </tr>--%>
<%--        <c:forEach var="data" items="${responseList}">--%>
<%--            <tr>--%>
<%--                <td>Hello</td>--%>
<%--                <td>${data}</td>--%>
<%--&lt;%&ndash;                <td>${data.getUserId()}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>${data.getDiscount()}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>${data.getCashback()}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td>${data.getTotalEarning()}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <td><c:out value="${value here}" /></td>&ndash;%&gt;--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        <%--%>
<%--            for(int i=0; i< 7;i++){%>--%>
        <tr>
            <td>${responseList.get(0).getUserName()}</td>
            <td>${responseList.get(0).getDiscount()}</td>
            <td>${responseList.get(0).getCashback()}</td>
            <td>${responseList.get(0).getTotalEarning()}</td>
        </tr>
        <tr>
            <td>${responseList.get(1).getUserName()}</td>
            <td>${responseList.get(1).getDiscount()}</td>
            <td>${responseList.get(1).getCashback()}</td>
            <td>${responseList.get(1).getTotalEarning()}</td>
        </tr>
        <tr>
            <td>${responseList.get(2).getUserName()}</td>
            <td>${responseList.get(2).getDiscount()}</td>
            <td>${responseList.get(2).getCashback()}</td>
            <td>${responseList.get(2).getTotalEarning()}</td>
        </tr>
        <tr>
            <td>${responseList.get(3).getUserName()}</td>
            <td>${responseList.get(3).getDiscount()}</td>
            <td>${responseList.get(3).getCashback()}</td>
            <td>${responseList.get(3).getTotalEarning()}</td>
        </tr>
        <tr>
            <td>${responseList.get(4).getUserName()}</td>
            <td>${responseList.get(4).getDiscount()}</td>
            <td>${responseList.get(4).getCashback()}</td>
            <td>${responseList.get(4).getTotalEarning()}</td>
        </tr>
        <tr>
            <td>${responseList.get(5).getUserName()}</td>
            <td>${responseList.get(5).getDiscount()}</td>
            <td>${responseList.get(5).getCashback()}</td>
            <td>${responseList.get(5).getTotalEarning()}</td>
        </tr>
        <tr>
            <td>${responseList.get(6).getUserName()}</td>
            <td>${responseList.get(6).getDiscount()}</td>
            <td>${responseList.get(6).getCashback()}</td>
            <td>${responseList.get(6).getTotalEarning()}</td>
        </tr>
<%--        <%}%>--%>
    </table>
</div>

</body>
</html>