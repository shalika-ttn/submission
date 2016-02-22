package com.ttnd.linksharing
import com.ttnd.linksharing.Enum.Visiblity
class TopicController {

    def index() { }

    def show(long id)
    {
         //Topic topic=Topic.findById(id)
          Topic topic=Topic.read(id)
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
    def save(String name,String seriousness)
    {
        Topic topic=new Topic(name:name,createdBy: session.user,visiblity:Visiblity.convert(seriousness))

         if(topic.save()) {
             flash.message = "Success "
             render flash.message
         }else {
             log.error(" Could not save Topic ${topic.name}")
             flash.message = "Topic ${topic.name} dosent satisfied constraints"
             render flash.message

         }

    }
}
