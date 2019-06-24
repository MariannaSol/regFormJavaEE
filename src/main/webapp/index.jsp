<!DOCTYPE html>
<html>
<head>
    <title>Start Page</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="block1">
<form action="registration" method="post" >
    <h2>Save User</h2>
    <b>Login</b><br>
    <input type="text" name="username" pattern="^[a-z0-9'_-]{3,15}$"><br><br>
    <b>Password</b><br>
    <input type="password" name="pass" pattern="^[a-z0-9@&-_#]{6,15}$"><br><br>
    <b>E-mail</b><br>
    <input type="text" name="mail" pattern="^[a-z]+[0-9a-z_-]+@[0-9a-z]+\.[a-z]{2,5}$"><br><br>
    <b>Birthday</b><br>
    <input type="number" name="day" placeholder="day" pattern="^[0-9]{1,2}$"><br>
    <input type="number" name="month" placeholder="month" pattern="^[0-9]{1,2}$"><br>
    <input type="number" name="year" placeholder="year" pattern="^[0-9]{4,4}$"><br><br>
    <b>Enter your gender:</b><br>
    <input name="gender" type="radio" value="male"  checked> Male <br>
    <input name="gender" type="radio" value="female" > Female <br><br>
    <b>Interface language:</b>
    <select name="language" size="1">
        <option selected value="ukrainian">Ukrainian
        <option value="russian">Russian
        <option value="english">English
        <option value="german">German
        <option value="martian">Martian language
    </select><br><br>
    <b>Terms of service</b><br>
    I agree<input type="checkbox" name="option1" value="yes"><br>

    <input type="submit" align="center" style="color: green">
    <input type="reset" align="center">
</form>
</div>

<div class="block1"><h2>Search by name...</h2>
    <form action="find" method="post">
    <b>Name</b><br>
    <input type="text" name="nameToFind"><br><br>

    <input type="submit" align="center" style="color: green">
    <input type="reset" align="center">
    </form>
</div>

<div class="block1"><h2>Delete user</h2>
    <form action="delete" method="get">
        <b>ID</b><br>
        <input type="number" name="idToDelete"><br><br>

        <input type="submit" align="center" style="color: green">
        <input type="reset" align="center">
        </form>
</div>

</body>
</html>
