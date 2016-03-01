<div class="panel panel-default">
    <div class="panel-heading">User</div>

    <g:each in="${userlist}" var="user"><br>

        <div class=row style="padding:10px">

            <div class="col-xs-7">
                <div class="img-thumbnail" style="float:left">
                    <span class="glyphicon glyphicon-user" style="font-size:80px"><span>
                </div>

                <div style="padding:10px"><h3>${user}</h3>
                    <br>

                    <p style="color:#d3d3d3">@ ${user}</p>

                </div>
            </div>

            <div class="col-xs-5">

                <br>

                <div style="float:left"><p style="color:#d3d3d3">subscription <br></p>
                    <a href="#">50</a>
                </div>

                <div>
                    <p style="color:#d3d3d3">Post</p>

                    <a href="#">30</a></div>

            </div>
        </div>
    </g:each>
</div>