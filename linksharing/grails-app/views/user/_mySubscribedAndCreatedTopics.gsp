<div class=row style="padding:10px">
    %{--<div align="center" style="margin-left:100px">--}%
    <div class="row">
        <div class="col-xs-1"></div>

        <div class="col-xs-3">
            <g:select name="seriousness" from="${com.ttnd.linksharing.Enum.Seriousness.values()}"
                      noSelection="['': 'Select seriousness']"/>
        </div>

        <div class="col-xs-1"></div>

        <div class="col-xs-2">
            <div class="row">
                <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visiblity.values()}"
                          noSelection="['': 'select visibility']"/>
            </div>
        </div>

        <div class="col-xs-1"></div>

        <div class="col-xs-3">
            <button><i class="glyphicon glyphicon-envelope" style="font-size:15px"></i></button>
            <button><i class="glyphicon glyphicon-file" style="font-size:15px"></i></button>
            <g:link action="delete" controller="subscription" params="[id: subscriptionId]"><i
                    class="glyphicon glyphicon-trash" style="font-size:15px"></i></g:link>

        </div>
    </div>
</div>