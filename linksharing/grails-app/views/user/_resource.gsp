<div class=row>
    <div class="panel panel-default">
        <div class="panel-heading">Inbox</div>

        <g:form controller="resourceRating" action="save" params="[id:post.id]">
            <div class="panel-body">

                <li class="list-group-item" style="height:130px;">
                    %{--<div class="glyphicon glyphicon-user" style="font-size:70px;float:left;padding:10px"></div>--}%
                    <div class="col-xs-2" style="float: left" ><ls:userImage id="${post.createdBy?.id}"/></div>

                    <div>
                        <a href=# style="float:right">Post</a>

                        <p>${post.createdBy}</p>

                        <p>${post.description}</p>

                        <div style="float: left">
                            <g:select name="score" from="${[1, 2, 3, 4, 5]}"
                                      noSelection="['': '-Select vote-']"/>

                        </div>

                        <div>
                            <g:actionSubmit value="Vote" controller="ResourceRating" action="save"
                                            class="btn ">Vote</g:actionSubmit>
                        </div>
                        <a href="#"><span class="fa fa-facebook-official"></span></a>   <a href="#"><i
                            class="fa fa-tumblr-square"></i></a>
                        <a href="#"><i class="fa fa-google-plus"></i></a>

                        <div style="float:right">

                            <ls:canDeleteResources resourceId="${post.id}"/>
                            %{--<a href="#">edit</a>--}%

                            <ls:caneditResources />
                            <a href="#">download</a>
                            <a href="#">fullsize</a>

                            %{--<g:if test="${read.isRead}">--}%
                            %{--<a href="#">mark as Unread</a>--}%
                            %{--</g:if>--}%
                            %{--<ls:checkIsRead isRead="${post}">hiii--}%

                            %{--</ls:checkIsRead>--}%
                            %{--<ls:checkIsReadi post="${post.readingItems.isRead}">hiii--}%

                            %{--</ls:checkIsReadi>--}%
                            %{--<g:link  controller="user" action="post" params="[postId:read.resource?.id]">view post</g:link>--}%
                            <ls:checkResourceType resource="${post.id}"/>
                        </p>
                        </div>
                    </div>
                </li>

                %{--<li class="list-group-item" style="height:100px">--}%
                %{--<div class="glyphicon glyphicon-user " style="font-size:70px;float:left;padding:10px"></div>--}%

                %{--<div>Uday Pratap Singh--}%
                %{--<p style="font:" Lorem--}%
                %{--Ipsum"">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</p>--}%
                %{--<a href="#"><span class="fa fa-facebook-official"></span></a>   <a href="#"><i class="fa fa-tumblr-square"></i></a>--}%
                %{--<a href="#"><i class="fa fa-google-plus"></i></a>--}%

                %{--<div style="float:right"><p><a href="#">download</a>  <a href="#">fullsize</a>  <a--}%
                %{--href="#">mark as read</a>  <a href="#">view post</a></p></div>--}%
                %{--</div>--}%
                %{--</li>--}%

            </div>
        </g:form>
    </div>

</div>