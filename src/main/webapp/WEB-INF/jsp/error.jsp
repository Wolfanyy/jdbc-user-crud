<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

<div class="form-page">

    <div class="form-card">

        <h1>Error</h1>

        <div class="error-message">
            ${error}
        </div>

        <a class="back-link"
           href="${pageContext.request.contextPath}/users">
            ← Back to users
        </a>

    </div>

</div>

</body>
</html>