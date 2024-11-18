<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Credit requests</title>
</head>
<#include "nav.ftlh">
<body>

<h1>Одобренные заявки по кредитам</h1>
<table>
    <tr>
        <th>ID заявки</th>
        <th>ФИО</th>
        <th>Желаемая сумма</th>
        <th>Дата заявки</th>
    </tr>
    <#if creditRequestList?has_content>
        <#list creditRequestList as request>
            <tr>
                <th>${(request.id)!}</th>
                <th>${(request.user.firstName)!} ${(request.user.lastName)!} ${(request.user.patronymic)!}</th>
                <th>${(request.desiredAmount)!}</th>
                <th>${(request.requestDate)!}</th>
            </tr>
        </#list>
    </#if>
</table>

</body>
</html>