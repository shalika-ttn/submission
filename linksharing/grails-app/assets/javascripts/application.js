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

function success(data, id) {
    $("#alert").html(data.message);


    var messageAlert = $(".messageAlert");
    for (item in data) {
        if (item === "message") {
            messageAlert.text(data[item]);
            messageAlert.addClass("alert-success");
            $("#" + id).remove();
            messageAlert.css({'display': 'block'});
        }
        else {
            messageAlert.text(data[item]);
            messageAlert.addClass("alert-danger");
            messageAlert.css({'display': 'block'});
        }
    }
}

function subscriptionsuccess(data) {
    var messageAlert = $(".messageAlert");
    alert(data.message)
    for (item in data) {
        if (item === "message") {
            messageAlert.text(data[item]);
            messageAlert.addClass("alert-success");
            messageAlert.css({'display': 'block'});
        }
        else {
            messageAlert.text(data[item]);
            messageAlert.addClass("alert-danger");
            messageAlert.css({'display': 'block'});
        }
    }
}
function unsubscribe(id) {
    event.preventDefault();
    $.ajax({
        url: '/subscription/delete',
        data: {id: id},
        method: 'post',
        success: function (data) {
            success(data, id)
        },
        error: function (data) {
            alert(data.error)
        }
    })
}




$(document).ready(function () {

    $(".seriousness").change(function () {
        console.log("............." + $(this).attr('topicId') + "---------" + $(this).val());
        $.ajax({
            url: "/subscription/update",
            data: {id: $(this).attr('topicId'), seriousness: $(this).val()},
            success: subscriptionsuccess

        });
    });


    $(".visibility").change(function () {
        console.log("............." + $(this).attr('topicId') + "---------" + $(this).val());
        $.ajax({
            url: "/topic/update",
            data: {id: $(this).attr('topicId'), visiblity: $(this).val()},
            success: subscriptionsuccess

        });
    });

   $(".subscribe").click(function(event){
       alert("hello");

       event.preventDefault();
       $.ajax({
           url: '/subscription/save',
           data: {id: $(this).attr('id')},
           method: 'post',
           success: subscriptionsuccess,
           error: function () {
               alert("some error occured")
           }
       });
   });


    //$(".subscriptionDelete").click(function(event){
    //    alert("Do you want Topic to get delete");
    //
    //    event.preventDefault();
    //    $.ajax({
    //
    //        url: '/topic/delete',
    //        data: {id:$(this).attr('id')},
    //        method: 'post',
    //        success: subscriptionsuccess,
    //        error: function () {
    //            alert("some error occured")
    //        }
    //    });
    //});


    $("#clearSearchPostBox").click(function () {
        $("#searchPostBox").val("")
    });

    $("#findSearchPostBox").click(function() {
        topicId = $(this).attr('topicId')

        $.ajax({
            url: "/resource/search",
            data: {q: $('#searchPostBox').val(), topicId: topicId},
            method:'post',
            success: function (result) {
                alert(result)
                //$("#topicPosts").html(result)
            }
        });
    });



});

//
//$(function () {
//
//    $('#registerForm').validate({
//        rules: {
//            'firstName': {
//                required: true
//            },
//            'lastName': {
//                required: true
//            },
//            'password': {
//                required: true,
//                minlength: 5
//            },
//            'confirmPassword': {
//                required: true,
//                confirm: true
//            },
//            'userName': {
//                required: true,
//                remote: {
//                    url: "/login/validateUserName",
//                    type: "post"
//                }
//            },
//            'emailID': {
//                required: true,
//                email: true,
//                remote: {
//                    url: "/login/validateEmail",
//                    type: "post"
//                }
//            }
//        },
//        submitHandler: function (form) {
//            form.submit();
//        }
//
//    });
//
//    jQuery.validator.addMethod("confirm", function (value, element) {
//        var result = false;
//        var password = $('#registerForm input[id=password]').val();
//
//        if (password === value) {
//            result = true;
//        }
//        return result;
//    }, "Confirm password not matched with password");
//
//})