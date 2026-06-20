<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create User</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="form-page">

    <div class="form-card">

        <h1>Create User</h1>

        <form method="post"
              action="${pageContext.request.contextPath}/users/create">

            <input type="text"
                   name="name"
                   placeholder="Name"
                   required>

            <input type="text"
                   name="lastName"
                   placeholder="Last Name"
                   required>

            <input type="email"
                   name="email"
                   placeholder="Email"
                   required>

            <input type="number"
                   name="age"
                   placeholder="Age"
                   min="1"
                   max="100"
                   required>

            <button class="btn btn-primary" type="submit">
                Save User
            </button>

        </form>

    </div>

</div>

</body>
</html>