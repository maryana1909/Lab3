<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Customer</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-6">
      <c:if test="${!requestScope.customerList.isEmpty()}">
        <table class="table">
          <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Имя</th>
            <th scope="col">Почта</th>
            <th scope="col">Город</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="customer" items="${requestScope.customerList}">
            <tr>
              <td scope="row">${customer.id}</td>
              <td>${customer.name}</td>
              <td>${customer.email}</td>
              <td>${customer.city}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:if>
    </div>
  </div>
</div>

<div class="container-fluid">
  <div class="row">
    <div class="col-6">
      <h3>Поиск:</h3>
      <form action="${pageContext.request.contextPath}/find" method="post" class="flex-container">
        <div class="form-group">
          <label>ID покупателя:</label>
          <input type="number" name="id">
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-success" value="Поиск">
          <input type="submit" class="btn btn-success" name="reset" value="Сбросить"/>
        </div>
      </form>
    </div>
  </div>

  <div class="border-top my-3"></div>

  <div class="row">
    <div class="col-6">
      <form action="${pageContext.request.contextPath}/add" method="post">
        <legend>Добавление</legend>
        <div class="form-group">
          <label>ФИО:</label>
          <input type="text" name="name" required>
        </div>
        <div class="form-group">
          <label>Email:</label>
          <input type="text" name="email" required>
        </div>
        <div class="form-group">
          <label>Город:</label>
          <input type="text" name="city" required>
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-success" value="Добавить">
        </div>
      </form>
    </div>
  </div>

  <div class="border-top my-3"></div>

  <div class="row">
    <div class="col-6">
      <form action="${pageContext.request.contextPath}/remove" method="post">
        <h3>Удаление</h3>
        <div class="form-group">
          <label>ID покупателя:</label>
          <input type="number" name="remove_id" required>
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-success" value="Удалить">
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>