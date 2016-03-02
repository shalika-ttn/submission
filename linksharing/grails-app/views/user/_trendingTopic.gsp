<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Trending topic</h3>
    </div>
    <g:each in="${trendingTopics}" var="trend">

        <div class="panel-body tending-topic-panel-body">
            <div>
                <div class="row">
                    <div class="list-group  col-xs-3">

                        %{--<img class="img-thumbnail" src="images/user.png" height="100" width="100">--}%
                        <div class="img-thumbnail" style="float:left">
                            <span class="glyphicon glyphicon-user" style="font-size:80px"></span>
                        </div>
                    </div>

                    <div class="col-xs-9">
                        <div class="row">

                                <g:link action="show" controller="topic" params='[topicId:"${trend.id}"]' >${trend}</g:link>
                        </div>
                        <br/><br/>

                        <div class="row">
                            <div class="col-xs-4">
                                <small class="col-xs-12">@shalika</small>
                                <small class="col-xs-12"><a>Subscribe</a></small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Subscriptions</small>
                                <small class="col-xs-12">50</small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Topics</small>
                                <small class="col-xs-12">10</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div>
            </div>
            <hr/>

            <div class="row">
                <div class="list-group  col-xs-3">

                    %{--<img class="img-thumbnail" src="images/user.png" height="100" width="100">--}%
                    <div class="img-thumbnail" style="float:left">
                        <span class="glyphicon glyphicon-user" style="font-size:80px"></span>
                    </div>
                </div>

                <div class="col-xs-9">
                    <div class="row">
                        <form class="form-inline" role="form">
                            <div class="form-group">

                                <input type="text" class="form-control col-xs-4" placeholder="Grails" id="name">
                                <button type="button" class="btn ">save</button>
                                <button type="button" class="btn btn-default">cancel</button>

                            </div>
                        </form>
                    </div>
                    <br/>

                    <div class="row">
                        <div class="col-xs-4">
                            <small class="col-xs-12">@shalika</small>
                            <small class="col-xs-12"><a>Subscribe</a></small>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Subscriptions</small>
                            <small class="col-xs-12">50</small>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Topics</small>
                            <small class="col-xs-12">10</small>
                        </div>
                    </br>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="dropdown col-sm-4">
                    <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visiblity.values()}"
                              noSelection="['': '-Select visibility-']"/>
                </div>

                <div class="dropdown col-sm-4">
                    <g:select name="seriousness" from="${com.ttnd.linksharing.Enum.Seriousness.values()}"
                              noSelection="['': '-Select seriousness-']"/>
                </div>
                <i class="fa fa-envelope-o nav_icon "></i>
                <span class="glyphicon glyphicon-edit nav_icon "></span>
                <span class="glyphicon glyphicon-trash nav_icon "></span>
            </div>
            <hr/>
        </div>
    </g:each>
</div>