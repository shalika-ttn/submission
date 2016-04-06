<div class=row>
    <div class="panel panel-primary">
        <div class="panel panel-heading">Login</div>

        <div class="panel-body">

            <form action='${postUrl}' method='POST' id='loginForm' class='form-horizontal cssform' autocomplete='off'>
                <div class="form-group" style="padding:10px">
                    <label for="username" class="control-label col-xs-4">Username</label>

                    <div class="col-xs-8">
                        <g:textField name="j_username" class="form-control text_" id="username"
                                     placeholder="Enter name"/>
                        %{--<input type='text' class='text_' name='j_username' id='username'/>--}%
                    </div>
                </div>

                <div class="form-group" style="padding:10px">
                    <label for="password" class="control-label col-xs-4">Password</label>

                    <div class="col-xs-8">
                        %{--<input type='password' class='text_' name='j_password' id='password'/>--}%
                        <g:passwordField name="j_password" class="form-control text_" id="password"
                                         placeholder="password"/>
                    </div>
                </div>

                <div class="form-group">

                    <input type='checkbox' class='chk col-xs-4' name='${rememberMeParameter}' id='remember_me'
                           <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                    <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
                    %{--<label  class="col-xs-4" style="padding:10px"><a>Forgot Password</a></label>--}%
                    %{--<g:link action="forgotPassword" controller="login">Forgot Password</g:link>--}%
                    <div class="col-xs-8">
                        <input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
                        %{--<g:actionSubmit value="login" action="login" controller="login"--}%
                        %{--class="btn btn-primary">Login</g:actionSubmit>--}%
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
