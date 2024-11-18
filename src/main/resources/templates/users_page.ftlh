<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<#include "nav.ftlh">
<body>

<h1>Поиск пользователей</h1>
<form action="/users/search" method="get">
    <div><label for="firstName">Имя</label><input name="firstName" id="firstName" type="text"></div>
    <div><label for="lastName">Фамилия</label><input name="lastName" id="lastName" type="text"></div>
    <div><label for="patronymic">Отчество</label><input name="patronymic" id="patronymic" type="text"></div>
    <div><label for="passport">Серия,Номер паспорта</label><input name="passport" id="passport" type="number"></div>
    <div><label for="contactPhoneNumber">Контактный телефон</label><input name="contactPhoneNumber" id="contactPhoneNumber" type="number"></div>
<input type="submit" value="Искать">
</form>
<table>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Семейное положение</th>
        <th>Контактный телефон</th>
    </tr>
    <#if userList?has_content>
    <#list userList as user>
        <tr>
            <th>${(user.firstName)!}</th>
            <th>${(user.lastName)!}</th>
            <th>${(user.patronymic)!}</th>
            <th>${(user.maritalStatus)!}</th>
            <th>${(user.contactPhoneNumber)!}</th>
        </tr>
    </#list>
    </#if>
</table>

</body>
</html>