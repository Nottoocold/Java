<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>User List</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
  </head>

  <body>
  <div class="container">
    <c:if test="${users != null}">
      <table class="table table-bordered table-striped">
        <h2>${date}</h2>
        <tr>
          <th>Name</th>
          <th>Age</th>
        </tr>
        <c:forEach items="${users}" var="user">
          <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
          </tr>
        </c:forEach>
      </table>
    </c:if>
  </div>
  </body>
</html>
