<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Создание заявки на оформление кредита</title>
</head>
<#include "nav.ftlh">
<body>
<form action="createCreditRequest" method="post">
    <table>


    <tr>
        <td><label for="firstName">Фамилия</label></td>
        <td><input name="firstName" id="firstName" type="text" required></td>
    </tr>
    <tr>
        <td><label for="lastName">Имя</label></td>
        <td><input name="lastName" id="lastName" type="text" required></td>
    </tr>
    <tr>
        <td><label for="patronymic">Отчество</label></td>
        <td><input name="patronymic" id="patronymic" type="text"></td>
    </tr>
    <tr>
        <td><label for="passport">Паспортные данные</label></td>
        <td><input name="passport" id="passport" type="number" required></td>
    </tr>
    <tr>
        <td><label for="maritalStatus">Семейное положение</label></td>
       <td><input name="maritalStatus" id="maritalStatus" type="text" ></td>
    </tr>
    <tr>
        <td><label for="contactPhoneNumber">Контактный телефон</label></td>
        <td><input name="contactPhoneNumber" id="contactPhoneNumber" type="tel" required></td>
    </tr>
    <tr>
        <td><label for="address">Адрес прописки</label></td>
        <td><input name="address" id="address" type="text"></td>
    </tr>
    <tr>
        <td>Сведения о занятости</td>
        <td>
            <table>
                <tr>
                    <td><label for="dateWorkFrom">Период работы с</label></td>
                    <td><input name="dateWorkFrom" id="dateWorkFrom" type="date"></td>

                </tr>
                <tr>
                    <td><label for="dateWorkTo">Период работы по</label></td>
                    <td><input name="dateWorkTo" id="dateWorkTo" type="date"></td>
                </tr>
                <tr>
                    <td><label for="position">Должность</label></td>
                    <td><input name="position" id="position" type="text"></td>
                </tr>
                <tr>
                    <td><label for="companyName">Название организации</label></td>
                    <td><input name="companyName" id="companyName" type="text"></td>
                </tr>
            </table>

        </td>
    </tr>

    <div>
        <td><label for="desiredAmount">Сумма желаемого кредита</label></td>
        <td><input name="desiredAmount" id="desiredAmount" type="number"></td>
    </div>
    </table>
    <input type="submit" value="Отправить заявку">
</form>
</body>
</html>