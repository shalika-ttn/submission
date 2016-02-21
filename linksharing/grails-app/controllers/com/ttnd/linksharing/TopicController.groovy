package com.ttnd.linksharing
import com.ttnd.linksharing.Enum.Visiblity
class TopicController {

    def index() { }

    def show(long id)
    {
         Topic topic=Topic.findById(id)
        if(!topic)
        {
            flash.message="topic not found"

            redirect(controller: "Login",action:"index" )

        }else {
            if(topic.visiblity==Visiblity.PUBLIC)
            {
                render "success"
                }
            else if(topic.visiblity==Visiblity.PRIVATE)
            {
                if(Subscription.findByUserAndTopic(topic.createdBy,topic))
                    render "sucess subscription"
                else {
                    flash.message="subscription not found"
                    redirect(controller: "Login", action: "index")
                }
            }

        }


    }
}
