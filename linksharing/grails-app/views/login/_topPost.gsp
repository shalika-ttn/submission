<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Top Posts</h3></div>

    <div class="panel-body">
        <g:each in="${resources}" var="res"><br>

            <div class="row">
                <div class="col-xs-4">
                    <div class="img-thumbnail" >
                        <span class="glyphicon glyphicon-user" style="font-size:80px"></span>
                    </div>
                </div>


                <div class="col-xs-4">
                    ${res.createdBy}<span class="text-muted inline">@shalika</span>


                    <p>${res.description}</p>
                    %{--<g:paginate  maxsteps="1" total="${resourceCount}" controller="login" action="topPost"/>--}%

                    %{--<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta                 felis--}%
                    %{--</p>--}%
                    <a href="#"><div class="fa fa-facebook-official"></div></a>
                    <a href="#"><div class="fa fa-twitter inline"></div></a>
                    <a href="#"><div class="fa fa-google-plus inline"></div></a>
                </div>

                <div class="col-xs-3" style="float: right">
                    <div class="row">
                        <a href="#" class="inline" style="float:right">${res.topic}</a>
                    </div>
                     <div class="row"> <br/> <br/></div>
                    <div class="row">

                        <a href="#" class="inline" style="float:right"><u>View Post</u></a>
                    </div>
                </div>
            </div>

        %{--<span class="glyphicon glyphicon-user" style="font-size:70px; float:left"></span>--}%

        %{--<div class="col-xs-10">--}%
        %{--${res.createdBy}<span class="text-muted inline">@shalika</span>--}%
        %{--<a href="#" class="inline" style="float:right">${res.topic}</a>--}%
        %{---------------${resourceCount}--}%

        %{--<g:each in="${resource}" var="res">--}%
        %{--${res}<br>--}%


        %{--<p>${res.description}</p>--}%
        %{--<g:paginate  maxsteps="1" total="${resourceCount}" controller="login" action="topPost"/>--}%

        %{--<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta                 felis--}%
        %{--</p>--}%
        %{--<a href="#"><div class="fa fa-facebook-official"></div></a>--}%
        %{--<a href="#"><div class="fa fa-twitter inline"></div></a>--}%
        %{--<a href="#"><div class="fa fa-google-plus inline"></div></a>--}%
        %{--<a href="#" class="inline" style="float:right"><u>View Post</u></a>--}%
        %{--</div>--}%
        </g:each>
    </div>

</div>
