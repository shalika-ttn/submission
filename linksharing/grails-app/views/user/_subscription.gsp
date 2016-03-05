<div class="panel panel-primary">
    <div class="panel-heading">Subscription
        <a href="#" style="float:right">View All</a>
    </div>

    <div class="panel-body">

        <g:each in="${subscriptions}" var="subscription">

            <div class=row>
                <div class="col-xs-7">
                    <div class="img-thumbnail" style="float:left">
                        <span class="glyphicon glyphicon-user" style="font-size:80px"></span>
                    </div>

                    <div style="padding:10px"><a>${subscription.topic.name}</a>
                        <br>

                        <p style="color:#d3d3d3">@uday</p>
                        <a>Unsubscribe</a>

                    </div>
                </div>

                <div class="col-xs-5">

                    <br>

                    <div style="float:left"><p style="color:#d3d3d3">subscription <br></p>
                        %{--<a href="#">50</a>--}%

                     <g:link>   <ls:subscriptionCount/>  </g:link>

                    </div>


                    <div>
                        <p style="color:#d3d3d3">Post</p>
                        %{--<a href="#">30</a></div>--}%

                   <g:link> <ls:resourceCount topicId="${subscription.topic.id}"> </ls:resourceCount> </g:link>
                    </div>
                </div>
            </div>

        %{--<ls:subscriptioncheck subscriptionId="${subscription.id}">--}%


        %{--<li class="list-group-item" style="height:130px">--}%
        %{--<div class="glyphicon glyphicon-user " style="font-size:50px;float:left;padding:10px"></div>--}%
            <div class="row">

                %{--<div class="col-xs-3"></div>--}%
                %{--<div class="col-xs-5">--}%
                <ls:subscriptioncheck subscription="${subscription}"/>
                %{--</div>--}%
            </div>

        </g:each>
    </div>
</div>