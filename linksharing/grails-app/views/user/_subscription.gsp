<div class="panel panel-primary">
    <div class="panel-heading">Subscription
        <a href="#" style="float:right">View All</a>
    </div>

    <div class="panel-body">

        <g:each in="${subscriptions}" var="subscription">

            <div class=row id="${subscription.id}">
                <div class="row">
                    <div class="col-xs-7">
                        <div class="img-thumbnail" style="float:left">
                            %{--<span class="glyphicon glyphicon-user" style="font-size:80px"></span>--}%
                            <ls:userImage id="${subscription.user?.id}"/>

                        </div>

                        <div style="padding:10px"><a>${subscription.topic.name}</a>
                            <br>
                            <g:link>@${subscription.user}</g:link>
                             <br/>
                            %{--<p style="color:#d3d3d3">@${subscription.user}</p>--}%
                            <g:link name="${subscription.id}"
                                    onclick="unsubscribe(${subscription.id})">Unsubscribe</g:link>

                        </div>
                    </div>

                    <div class="col-xs-5">

                        <br>

                        <div style="float:left"><p style="color:#d3d3d3">subscription <br></p>
                            %{--<a href="#">50</a>--}%

                            <g:link><ls:subscriptionCount/></g:link>

                        </div>


                        <div>
                            <p style="color:#d3d3d3">Post</p>
                            %{--<a href="#">30</a></div>--}%

                            <g:link><ls:resourceCount topicId="${subscription.topic.id}"></ls:resourceCount></g:link>
                        </div>
                    </div>
                    <br/>
                </div>

                <div>
                    %{--<div class="row">--}%
                    <ls:canUpdateTopic topicId="${subscription.topic.id}"/>
                </div>
                %{--</div>--}%
            </div>

        </g:each>
    </div>
</div>