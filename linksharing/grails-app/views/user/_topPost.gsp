<div class=row>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Top Posts</h3></div>
        <div class="panel-body">
            <span class="glyphicon glyphicon-user" style="font-size:70px; float:left"></span>
            <div class="col-xs-10">
                Shalika<span class="text-muted inline"> @shalika</span>
                <a href="#" class="inline" style="float:right">Grails</a>

                <g:each in="${resources}" var="res">
                    <p>
                        ${res}
                    </p>
                </g:each>
                %{--<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta                 felis--}%
                %{--</p>--}%
                %{--<a href="#"><div class="fa fa-facebook-official"></div></a>--}%
                <a href="#"><div class="fa fa-twitter inline"></div></a>
                <a href="#"><div class="fa fa-google-plus inline"></div></a>
                <a href="#" class="inline" style="float:right"><u>View Post</u></a>
            </div>

        </div>

    </div>
</div>