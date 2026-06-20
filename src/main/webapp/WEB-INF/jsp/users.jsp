<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<header class="header">
    <div class="header-content">

        <div class="logo">
            User<span>CRUD</span>
        </div>

        <a class="btn btn-primary"
           href="${pageContext.request.contextPath}/users/create">
            Add User
        </a>

    </div>
</header>

<main class="container">

    <div class="page-header">
        <div>
            <h1 class="page-title">Users</h1>

            <p class="page-subtitle">
                Total users: ${users.size()}
            </p>
        </div>
    </div>

    <div class="card">

        <c:choose>

            <c:when test="${empty users}">
                <div class="empty-state">
                    No users found
                </div>
            </c:when>

            <c:otherwise>

                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Age</th>
                        <th>Actions</th>
                    </tr>
                    </thead>

                    <tbody>

                    <c:forEach var="user" items="${users}">
                        <tr>

                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.lastName}</td>
                            <td class="email">${user.email}</td>
                            <td>${user.age}</td>

                            <td class="actions-column">

                                <a class="btn btn-secondary"
                                   href="${pageContext.request.contextPath}/users/edit?id=${user.id}">
                                    Edit
                                </a>

                                <form method="post"
                                      action="${pageContext.request.contextPath}/users/delete"
                                      class="inline-form">

                                    <input type="hidden"
                                           name="id"
                                           value="${user.id}">

                                    <button type="submit"
                                            class="btn btn-danger"
                                            onclick="return confirm('Delete user?')">
                                        Delete
                                    </button>

                                </form>

                            </td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </c:otherwise>

        </c:choose>

    </div>

</main>

</body>
</html>