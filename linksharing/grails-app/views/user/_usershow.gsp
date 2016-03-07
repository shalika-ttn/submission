<div class = "panel panel-default">


    <div class=row style="padding:10px">

        <div class="col-xs-7">
            <div class="img-thumbnail" style="float:left">
                    <ls:userImage id="${session.user?.id}"/>

            </div>
            <div style="padding:10px">  ${session.user.firstName}
                <br><p style="color:#d3d3d3">@ ${session.user.firstName}</p>

            </div>
        </div>
        <div class="col-xs-5">

            <br>
            <div style="float:left"><p style="color:#d3d3d3">subscription <br></p>
                <a href="#"> 50</a>
            </div>
            <div>
                <p style="color:#d3d3d3"> Post</p>

                <a href="#"> 30</a></div>



        </div>
    </div>



</div>