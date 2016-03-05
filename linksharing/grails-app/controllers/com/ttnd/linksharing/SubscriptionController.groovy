package com.ttnd.linksharing

import com.ttnd.linksharing.Enum.Seriousness

class SubscriptionController {

    def index() {}

    def save(long id) {
        Topic topic = Topic.findById(id)
        if (topic) {
            Subscription subscription = new Subscription(user: session.user, topic: topic.createdBy)

            if (subscription.save()) {
                flash.message = " Subscription saved ------Success "
                render flash.message
            } else {
                log.error(" Could not save subscription ${subscription}")
                flash.message = "Topic ${subscription} dosent satisfied constraints"
                render flash.message

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
        Subscription subscription = Subscription.findById(id)

        if (subscription) {
            subscription.delete()
            redirect(action: 'index',controller: 'user')
//            render "sucesss in deleting subscription"
        } else
            render "Failure in deleting subscription"


    }
}