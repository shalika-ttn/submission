// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self
//= require bootstrap
//=require font-awesome


if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);
}

function success(data,id)
{
    alert(data.message);

    $("#alert").html(data.message);

    var messageAlert = $(".messageAlert");
    for (item in data) {
        if (item === "message") {
            messageAlert.text(data[item]);
            messageAlert.addClass("alert-success");
            //$("#" + id).remove();
        }
        else {
            messageAlert.text(data[item]);
            messageAlert.addClass("alert-danger");
        }
    }
}

function unsubscribe(id) {
    event.preventDefault();
    $.ajax({
        url: '/subscription/delete',
        data: {id: id},
        method: 'post',
        success: function(data)
        {
            success(data,id)
        },
        error: function (data) {
            alert(data.error)
        }
    })
}



function subscribe(id) {
    event.preventDefault();
    $.ajax({
        url: '/subscription/save',
        data: {id: id},
        method: 'post',
        success: function (data) {
            alert(data);
            //	$("#"+id).remove();
            //	$("#alert").html(data.message);

            //var messageAlert = $(".messageAlert");
            //for (item in data) {
            //	if (item === "message") {
            //		messageAlert.text(data[item]);
            //		messageAlert.addClass("alert-success");
            //	}
            //	else {
            //		messageAlert.text(data[item]);
            //		messageAlert.addClass("alert-danger");
            //	}
            //}

        },
        error: function () {
            alert("some error occured")
        }
    })
}

$(document).ready(function () {

    $(".seriousness").change(function () {
        $.ajax({
            url: "/subscription/update",
            data: {id: $(this).attr('topicId'), seriousness: $(this).val()},
            success: function(data)
            {
                success(data,id)
            },

        });
    });
}