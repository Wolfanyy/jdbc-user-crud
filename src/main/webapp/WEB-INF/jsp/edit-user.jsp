<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Edit User</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="form-page">

    <div class="form-card">

        <h1>Edit User</h1>

        <c:if test="${not empty error}">
            <div class="error-message">
                    ${error}
            </div>
        </c:if>

        <form method="post"
              action="${pageContext.request.contextPath}/users/edit">

            <input type="hidden"
                   name="id"
                   value="${user.id}">

            <input type="text"
                   name="name"
                   placeholder="Name"
                   value="${user.name}"
                   required>

            <input type="text"
                   name="lastName"
                   placeholder="Last Name"
                   value="${user.lastName}"
                   required>

            <input type="email"
                   name="email"
                   placeholder="Email"
                   value="${user.email}"
                   required>

            <input type="number"
                   name="age"
                   placeholder="Age"
                   value="${user.age}"
                   min="1"
                   max="100"
                   required>

            <button type="submit"
                    class="btn btn-primary">
                Update User
            </button>

        </form>

        <a class="back-link"
           href="${pageContext.request.contextPath}/users">
            ← Back to users
        </a>

    </div>

</div>

</body>
</html>