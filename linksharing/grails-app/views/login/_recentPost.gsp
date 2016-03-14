<div class="panel panel-primary">
    <div class="panel-heading">Recent Post
    </div>
    <g:each in="${resources1}" var="res">
        <div class="panel-body">
            <div class="row">
              %{--<g:include controller="user" action="image" params="[id:${session.user.id}]" />--}%
                <div class="col-xs-2" style="float: left" ><ls:userImage id="${res.createdBy?.id}"/></div>
                <div class="col-xs-10">



                    %{--<a href="#" class="inline" style="float:right">${res.topic.name}</a>--}%
                    <div class="row">
                    <br/>
                        <div class="col-xs-4">
                            ${res.createdBy}<span class="text-muted inline">@${res.createdBy}</span>
                        </div>

                        <div class="col-xs-6">
                            ${res}
                        </div>

                        <div class="col-xs-2">
                            <g:link action="show" controller="topic" params='[topicId: "${res.topic.id}"]'>${res.topic.name}</g:link>
                        </div>
                    </div>


                    <a href="#"><div class="fa fa-facebook-official"></div></a>
                    <a href="#"><div class="fa fa-twitter inline"></div></a>
                    <a href="#"><div class="fa fa-google-plus inline"></div></a>
                    %{--<a href="#" class="inline" style="float:right"><u>View Post</u></a>--}%
                   <div style="float: right"> <g:link  controller="resource" action="post2" params="[id:res.id]">view post</g:link>
                   </div>
                </div>

            </div>

        </div>
    </g:each>

</div>
