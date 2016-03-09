package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import grails.converters.JSON

class SubscriptionController {

    def index() {}

    def save(Long id) {
        Topic topic = Topic.findById(id)
        println("==============${topic.properties}===================")
        if (topic) {
            Subscription subscription = new Subscription(user: session.user, topic: topic,seriousness:Seriousness.SERIOUS )

            if (subscription.save(flush: true)) {
//                flash.message = " Subscription saved ------Success "
                render "Subscription saved ------Success"
//                render ([message:"subscribed successfully"] as JSON)

            } else {
//                log.error(" Could not save subscription ${subscription}")
//                flash.message = "Topic ${subscription} dosent satisfied constraints"
//                render flash.message
                println("==============${subscription.properties}===================")
                render "Subscription not saved ------Success"

//                render ([error:"subscrition failed"] as JSON)

            }

        }
    }

    def update(long id, String seriousness) {
        Topic topic = Topic.findById(id)

        if (topic) {
            if (Seriousness.convert(seriousness)) {
                Subscription subscription = new Subscription(user: session.user, topic: topic.createdBy, seriousness: Seriousness.convert(seriousness))

                if (subscription.save()) {
                    flash.message = " Subscription saved ------Success "
                    render flash.message
                } else {
                    flash.message = "Topic ${subscription} dosent satisfied constraints----"
                    render flash.message

                }
            } else {
                flash.message = "seriousness provided could not match"
                render flash.message
            }
        } else render "Topic could not be found by particular id"


    }

    def delete(long id) {
        Map result=[:]
        Subscription subscription = Subscription.findById(id)

        if (subscription) {
            subscription.delete()
//            redirect(action: 'index',controller: 'user')
//            render "sucesss in deleting subscription"
//            render ([message:"subscription deleted successfully"] as JSON)
           result.message="subscription is delted"
        } else {
//            render "Failure in deleting subscription"
//            render([error: "subscription not deletd successfully"] as JSON)
            result.error = "subscription is delted"
        }
        render result as JSON


    }
}