<div class=row>

    <div class="panel panel-default">
        <div class="panel-heading">Trending Topics</div>

        <li class="list-group-item" style="height:130px;">

            <div class="col-xs-7">
                <div class="img-thumbnail" style="float:left">
                    <span class="glyphicon glyphicon-user" style="font-size:80px"></span>
                </div>

                <div style="padding:10px"><a>Grails</a>
                    <br>

                    <p style="color:#d3d3d3">@uday</p>
                    <a>Subscribe</a>

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

        </li>

        <div class="row" style="padding:10px">
            <div class="col-xs-3">

                <div class="img-thumbnail" style="float:left;padding:20px">
                    <span class="glyphicon glyphicon-user" style="font-size:70px"></span>
                </div>

            </div>

            <div class="col-xs-9">
                <div class="row">
                    <g:form class="form-inline" role="form">
                        <div class="form-group">

                            <g:textField name="text" class="form-control col-xs-4" placeholder="Grails" id="name"/>
                            <button type="button" class="btn btn-primary">save</button>
                            <button type="button" class="btn btn-default">cancel</button>

                        </div>
                    </g:form>
                </div>
                <br/>

                <div class="row">
                    <div class="col-xs-4">
                        %{--<small class="col-xs-12">@shalika</small>--}%
                        %{--<small class="col-xs-12"><a>Subscribe</a></small>--}%
                    %{--</div>--}%

                    %{--<div class="col-xs-4">--}%
                        %{--<small class="col-xs-12">Subscriptions</small>--}%
                        %{--<small class="col-xs-12">50</small>--}%
                    %{--</div>--}%

                    %{--<div class="col-xs-4">--}%
                        %{--<small class="col-xs-12">Topics</small>--}%
                        %{--<small class="col-xs-12">10</small>--}%
                    %{--</div>--}%
                        <g:each in="${topicVo}" var="t">
                             ${t}
                        </g:each>
                </br>
                </div>
            </div>
        </div>

        <div class=row>
            <br>

            <div align="center" style="margin-left:100px">
                <div class="col-xs-4">
                    %{--<g:select class="form-control" rows="5" id="topic" style="height:100px,width:30px">--}%
                    %{--<option>Serious</option>--}%
                    %{--<option>A2</option>--}%
                    %{--<option>A3</option>--}%
                    %{--<option>A4</option>--}%
                    %{--</g:select>--}%

                    <g:select name="topic" from="${listOfTopics}" optionKey="id"
                              noSelection="['': '-Select topic-']"/>
                </div>

                <div class="col-xs-3">
                    <div class="row">
                        %{--<select class="form-control" rows="5" id="topic">--}%
                        %{--<option>Private</option>--}%
                        %{--<option>A2</option>--}%
                        %{--<option>A3</option>--}%
                        %{--<option>A4</option>--}%
                        %{--</select>--}%

                        <g:select name="topic" from="${listOfTopics}" optionKey="id"
                                  noSelection="['': '-Select topic-']"/>

                    </div>
                </div>
            </div>

            <button><i class="glyphicon glyphicon-envelope" style="font-size:15px"></i></button>
            <button><i class="glyphicon glyphicon-file" style="font-size:15px"></i></button>
            <button><i class="glyphicon glyphicon-trash" style="font-size:15px"></i></button>
        </div>

    </div>

</div>