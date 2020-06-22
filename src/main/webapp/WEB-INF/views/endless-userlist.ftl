<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Endless users</title>
    <link rel="stylesheet" href="${springMacroRequestContext.getContextPath()}/static/css/bootstrap.css">
</head>
<body>
<#--    <div id="userlist">-->
<#--        <#list users as user>-->
<#--            <div>${user}</div>-->
<#--        </#list>-->
<#--    </div>-->
<div class="col-10 mx-auto mt-5">
    <h3 class="mb-2">All users</h3>
    <table class="table">
        <thead class="table-hover">
        <th scope="col">id</th>
        <th scope="col">email</th>
        <th scope="col">password</th>
        <th scope="col">country</th>
        <th scope="col">gender</th>
        <th scope="col">birthday</th>
        </thead>
        <tbody id="userlist">
        <#list users as user>
            <tr style="height: 200px">
                <td>${user.getId()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getCountry()}</td>
                <td>${user.getGender()}</td>
                <td>${user.getBirthday()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.js"></script>
<script src="${springMacroRequestContext.getContextPath()}/static/js/script-endless.js"></script>
</body>
</html>