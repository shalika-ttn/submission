package com.ttnd.linksharing

import com.ttnd.linksharing.VO.TopicVo

class MyTagLib {
//    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "ls"

    def checkIsRead = { attrs, body ->


        if (session.user) {

            if (attrs.isrRead)
                out << "<a href='#'>Mark as unread </a>"
            else
                out << "<a href='#'>Mark  as read</a>"
        }
    }

    def topPost = {

        List<Resource> resources = Resource.resourcePost()

        out << render(template: "/login/topPost", model: [resources: resources])

    }
    def trendingTopics = {
        if (session.user) {
            List<TopicVo> topicVos = Topic.trendingTopics()

            out << render(template: "/user/trendingTopic", model: [trendingTopics: topicVos])
        }

    }
    def canDeleteResources ={ attrs, body ->

        Closure c = {

            "Delete"
        }
        Closure e = {

            "edit"
        }
        if (session.user) {
            User user = session.user
            if (user.canDeleteResource(attrs.resourceId)) {
                println "--------------in if--------------"
                out << g.link(controller: "resource", action: "delete", params: [id: attrs.resourceId], c())
            }


        }
    }


    def checkResourceType = { attrs ->
        Resource resource = Resource.read(attrs.resource)
        if (resource instanceof LinkResource) {
            out << " <a href=\"#\" class=\"inline\" style=\"float:right;padding: 2px\"><u>View Full Site</u></a>"

        } else if (resource instanceof DocumentResource) {
            out << "<a href=\"#\" class=\"inline\" style=\"float:right;padding: 2px\"><u>Download</u></a>"
        }

    }


    def unSubscribed = { attrs, body ->
        if (session.user) {
            User user = session.user
            if (user.isSubscribed(attrs.topicId))
                out << body()


        }
    }
    def subscriptioncheck = { attrs, body ->
        Subscription subscription = attrs.subscription as Subscription
        if (session.user) {
            if (subscription.topic.createdBy.id == session.user.id) {
                out << render(template: '/user/mySubscribedAndCreatedTopics', model: [subscriptionId: subscription.id])
            } else {
                out << render(template: '/user/mySubscribedTopics')

            }
        }
    }

    def subscriptionCount = {
        if (session.user) {
            Integer subscriptioncount = Subscription.findAllByUser(session.user).size()
            out << subscriptioncount

        }

    }

    def resourceCount = { attrs ->
        if(session.user)
        {
             Topic topic=Topic.findById(attrs.topicId)
            Integer resourcecount= Resource.findAllByTopic(topic).size()
            out<< resourcecount

        }

    }


    def topicCount = { attrs ->
        if(session.user)
        {
            Integer topiccount=Topic.findAllByCreatedBy(session.user).size()
            out<< topiccount

        }

    }


}
