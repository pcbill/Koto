<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/stylesheets/main.css" />
</head>

<body>


<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h3>
                報到
            </h3>

            <form action="/registerByPersonId" method="POST">
                號碼 <input id="personId" name="personId" type="text" forcus />
                <button type="submit" value="submit">submit</button>
            </form>

            <form action="/registerByName" method="POST">
                姓名 <input id="name" name="name" type="text"/>
                <button type="submit" value="submit">submit</button>
            </form>

            <br/>

    共有  ${people?size} 人已經完成報到
        <table class="table table-bordered table-hover">
            <tr>
                <th>號碼</th>
                <th>姓名</th>
                <th>報到時間</th>
            </tr>
            <#list people as it>
            <tr>
                <td>${it.personId}</td>
                <td>${it.name}</td>
                <td>
                    <#if it.registrationTime?? >
                    ${it.registrationTime?datetime}
                    </#if>
                </td>
            </tr>
            </#list>


</table>
        </div>
    </div>
</div>


</body>

<script> document.getElementById("personId").focus(); </script>
</html>
