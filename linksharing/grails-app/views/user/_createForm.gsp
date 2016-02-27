

        <div class="panel panel-default">
            <div class="panel panel-heading">Register</div>

            <div class="panel-body">
                <g:form class="form-horizontal">
                    <div class="form-group">
                        <label for="firstName" class="control-label col-xs-5">First Name*</label>

                        <div class="col-xs-7">
                            <g:textField name="firstName" class="form-control" id="inputFname"
                                         placeholder="First Name"/>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="lastName" class="control-label col-xs-5">Last Name*</label>

                        <div class="col-xs-7">
                            <g:textField name="lastName" class="form-control" id="lastName" placeholder="Last Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="control-label col-xs-5">Email*</label>

                        <div class="col-xs-7">
                            <g:textField name="email" class="form-control" id="inputEmail" placeholder="Email"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="userName" class="control-label col-xs-5">Username*</label>

                        <div class="col-xs-7">
                            <g:textField name="userName" class="form-control" id="email" placeholder="Email"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="control-label col-xs-5">Password*</label>

                        <div class="col-xs-7">
                            <g:textField name="password" type="password" class="form-control" id="inputPass"
                                         placeholder="******"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword" class="control-label col-xs-5">Confirm Password*</label>

                        <div class="col-xs-7">
                            <g:textField name="confirmPassword" class="form-control" id="inputConfirm"
                                         placeholder="*****"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-9"></div>

                        <div class="col-xs-3">
                            <g:actionSubmit value="register" action="register" controller="user"
                                            class="btn btn-success">Register</g:actionSubmit>

                        </div>
                    </div>
                </g:form>
            </div>
        </div>




