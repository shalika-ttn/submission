<div class=row>
    <div class="panel panel-primary">
        <div class="panel-heading">Inbox</div>

        <div class="panel-body">
            <g:each in="${readingItems}" var="read">

                <li class="list-group-item" style="height:110px;">

                    %{--<div class="glyphicon glyphicon-user" style="font-size:70px;float:left;padding:10px"></div>--}%
                    <div class="col-xs-2" style="float: left" ><ls:userImage id="${read.resource.createdBy?.id}"/></div>

                    <div>
                        <a href=# style="float:right">Post</a>

                        <p>${read.user.firstName}  ${read.isRead}</p>

                        <p>${read.resource.description}</p>
                        <a href="#"><span class="fa fa-facebook-official"></span></a>   <a href="#"><i
                            class="fa fa-tumblr-square"></i></a>
                        <a href="#"><i class="fa fa-google-plus"></i></a>

                        <div style="float:right">
                            <ls:checkResourceType resource="${read.resource.id}"/>

                            %{--<g:link controller="documentResource" action="download" params="[id:read.resource.id]">download </g:link>--}%
                            %{--<a href="#">download</a>--}%

                            %{--<g:if test="${read.isRead}">--}%
                            %{--<a href="#">mark as Unread</a>--}%
                            %{--</g:if>--}%
                            <ls:checkIsRead isRead="${read.isRead}">
                            </ls:checkIsRead>
                            <g:link controller="user" action="post"
                                    params="[postId: read.resource?.id]">view post</g:link>

                        </p>
                        </div>
                    </div>
                </li>
            </g:each>

        </div>
    </div>
</div>