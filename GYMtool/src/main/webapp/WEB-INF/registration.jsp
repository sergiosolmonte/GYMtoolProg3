<%@ include file= "../base.jsp"%>

<div style="overflow-y: scroll;overflow-x:hidden;height:80%;margin:0 auto auto 40px;">
    <h1 class="great">Register</h1>
    <form action="registration" method="post">
        <div class="row">
            <p class="col-md-6">
                <label for="firstname">Nome:</label><br>
                <input type="text" id="firstname" name="firstname"><br>
            </p>
            <p class="col-md-6">
                <label for="lastname">Cognome:</label><br>
                <input type="text" id="lastname" name="lastname"><br>
            </p>
            <p class="col-md-6">
                <label for="username">Username:</label><br>
                <input type="text" id="username" name="username"><br>
            </p>
            <p class="col-md-6">
                <label for="email">Email:</label><br>
                <input type="text" id="email" name="email"><br>
            </p>
            <p class="col-md-6">
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br>
            </p>
            <p class="col-md-6">
                <label for="birthdate">Data di nascita:</label><br>
                <input type="date" id="birthdate" name="birthdate"><br>
            </p>
            <p class="col-md-6">
                <label for="password2">Conferma Password:</label><br>
                <input type="password" id="password2" name="password2"><br>
            </p>
        </div>
        <p class="great" style="margin:0 auto;display: block"><input type="submit" value="Registrati"></p>
    </form>
</div>
