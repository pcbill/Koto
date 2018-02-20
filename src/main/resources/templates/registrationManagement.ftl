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
    <div class="col-md-3">
      <h3>
        報到管理
      </h3>

      手動報到
      <form action="/createPerson" method="POST">
        <div class="form-group">

        <label>姓名</label>
        <input class="form-control" name="name" type="text" /><br/>

        <label>號碼</label>
        <input class="form-control" name="personId" type="text" /><br/>

        <button type="submit" value="submit">submit</button>
        </div>
      </form>
    </div>

    <div class="col-md-6">
        <br/>
        共有 ${people?size} 人已經完成報到, ${totalCount} in database
        <table class="table table-bordered table-hover">
          <tr>
            <th>操作</th>
            <th>號碼</th>  
            <th>姓名</th>  
            <th>報到時間</th>
          </tr>
            <#list people as it>
          <tr>
            <td><a class="btn btn-primary" href='/deleteRegistration/${it.id}'>刪除</a></td>
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
</html>
