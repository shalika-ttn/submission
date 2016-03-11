package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness
import grails.converters.JSON

class SubscriptionController {

    def index() {}

    def save(Long id) {
        Topic topic = Topic.findById(id)
        println("==============${topic.properties}===================")
        if (topic) {
            Subscription.withNewSession {

                Subscription subscription = new Subscription(user: session.user, topic: topic, seriousness: Seriousness.SERIOUS)

                if (subscription.save(flush: true, failOnError: true)) {
//                flash.message = " Subscription saved ------Success "
//                render "Subscription saved ------Success"
                    render([message: "subscribed successfully"] as JSON)

                } else {
//                log.error(" Could not save subscription ${subscription}")
//                flash.message = "Topic ${subscription} dosent satisfied constraints"
//                render flash.message
                    println("==============${subscription.properties}===================")
                    render "Subscription not saved ------Success"

                    render([error: "subscrition failed"] as JSON)

                }
            }

        }
    }

    def update(Long id, String seriousness) {
        Map result = [:]
        println("#################${id},,,,,,,,${seriousness}")
        Subscription subscription1 = Subscription.get(id)
        println("******************811111111111111111111${subscription1}")
        if (subscription1) {
            subscription1.seriousness = seriousness as Seriousness
            println("***************22222222222222222222222${subscription1.seriousness}")
            if (subscription1.save(flush: true)) {
                println("in if")
                result.message = "supscription seriousness updated is saved succesfully"
            } else {
                println("in else")
                result.error = "subscription seriousness updated is not saved succesfully"
            }
        }
        println(".............>>${result}")
        render result as JSON

    }

    def delete(long id) {
        Map result = [:]
        Subscription subscription = Subscription.findById(id)

        if (subscription && subscription.topic.createdBy != session.user) {
            subscription.delete(flush: true)
//            redirect(action: 'index',controller: 'user')
//            render "sucesss in deleting subscription"
//            render ([message:"subscription deleted successfully"] as JSON)
            result.message = "subscription is delted"
        } else {
//            render "Failure in deleting subscription"
//            render([error: "subscription not deletd successfully"] as JSON)
            result.error = "subscription is delted"
        }
        render result as JSON


    }
}