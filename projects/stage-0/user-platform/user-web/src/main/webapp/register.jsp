<head>
    <jsp:directive.include
            file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
    <title>My Home Page</title>
</head>
<body>
<div class="container-lg">
    <!-- Content here -->
    <form action="/registerSubmit" method="post">
        <table align="center">
            <tr align="right">
                <td>请输入用户名:</td>
                <td><input type="text" name=name autofocus="autofocus"></td>
            </tr>
            <tr align="right">
                <td>请输入密码:</td>
                <td><input type="text" name=password></td>
            </tr>
            <tr align="right">
                <td>请输入邮箱:</td>
                <td><input type="text" name=email></td>
            </tr>
            <tr align="right">
                <td>请输入电话号码:</td>
                <td><input type="text" name=phoneNumber></td>
            </tr>
        </table>
        <input type="submit" name=register value="注册" >
        <input type="reset" name=refill value="重填" >
    </form>
</div>
</body>