package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Seriousness
import com.ttnd.linksharing.Enum.Visiblity
import grails.converters.JSON

class TopicController {

    def index() {
        render "this is topic domain"


    }

    def show(ResourceSearchCo co) {
        //Topic topic=Topic.findById(id)
        Topic topic = Topic.read(co.topicId)
        if (!topic) {
            flash.message = "topic not found"

            redirect(controller: "Login", action: "index")

        } else {
            if (topic.visiblity == Visiblity.PUBLIC) {

                render(view: 'show', model: [userlist: topic.subscribedUser, topics: topic])

            } else if (topic.visiblity == Visiblity.PRIVATE) {
                if (Subscription.findByUserAndTopic(topic.createdBy, topic))
                    render "sucess subscription"
                else {
                    flash.message = "subscription not found"
                    redirect(controller: "login", action: "index")
                }
            }

        }


    }


    def save(String name, String visibility) {
        Topic topic = new Topic(name: name, createdBy: session.user, visiblity: Visiblity.convert(visibility))

        if (topic.save()) {
            // flash.message = "Success "
            //render (view: 'dashboard',controller:'user')
            // render flash.message

            render(view: 'save')
        } else {
            log.error(" Could not save Topic ${topic.name}")
            flash.message = "Topic ${topic.name} dosent satisfied constraints"
            render flash.message

        }

    }

    def sent(String email, String name) {
        User user = User.findByEmail(email)
        Topic topic = Topic.findByName(name)

        if (user && topic) {
            Subscription subscription = new Subscription(user: user, topic: topic)

            if (subscription.save()) {
                flash.message = " Subscription saved ------Success "
                render flash.message
            } else {
                log.error(" Could not save subscription ${subscription}")
                flash.message = "Topic ${subscription.properties} dosent satisfied constraints"
                render flash.message

            }
        } else render " Either user email or topic name invalid"

    }

    def update(Long id, String visiblity) {
        Map result = [:]
//        println("#################${id},,,,,,,,${seriousness}")
//        Subscription subscription1 = Subscription.get(id)
        Topic topic = Topic.get(id)

//        println("******************811111111111111111111${subscription1}")

        if (topic) {
            topic.visiblity = visiblity as Visiblity

//            println("***************22222222222222222222222${subscription1.seriousness}")
            if (topic.save(flush: true)) {
                println("in if")
                result.message = "topic visiblity updated  saved succesfully"
            } else {
                println("in else")
                result.error = "topic visiblity updated not succesfully"
            }
        }
        println(".............>>${result}")
        render result as JSON

    }

    def delete(Long id) {
        Topic topic = Topic.findById(id)
        if (topic) {
            topic.delete(flush: true)
            render(view: "delete")
        } else
            render "cant delete topic"

    }


}
