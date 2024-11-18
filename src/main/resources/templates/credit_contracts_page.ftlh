<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Credit contracts</title>
</head>
<#include "nav.ftlh">
<body>

<h1>Подписать кредитный договор</h1>
<table>
    <tr>
        <th>ID заявки</th>
        <th>ФИО</th>
        <th>Одобренная сумма</th>
        <th>Срок в днях</th>
        <th>Дата заявки</th>
        <th>Действие</th>
    </tr>
    <#if creditContractsList?has_content>
        <#list creditContractsList as contract>
            <tr>
                <th>${(contract.id)!}</th>
                <th>${(contract.creditRequest.user.firstName)!} ${(contract.creditRequest.user.lastName)!} ${(contract.creditRequest.user.patronymic)!}</th>
                <th>${(contract.approvedAmount)!}</th>
                <th>${(contract.approvedDaysPeriod)!}</th>
                <th>${(contract.creditRequest.requestDate)!}</th>
                <th><a href="/creditContracts/${contract.id}/sign"><button>Sign</button></a></th>
            </tr>
        </#list>
    </#if>
</table>

</body>
</html>