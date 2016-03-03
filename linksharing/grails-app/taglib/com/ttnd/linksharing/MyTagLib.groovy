package com.ttnd.linksharing

import com.ttnd.linksharing.VO.TopicVo

class MyTagLib {
//    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "ls"

    def checkIsRead = { attrs, body ->


        if (session.user) {

            if(attrs.isrRead)
            out<< "<a href='#'>Mark as unread </a>"
            else
                out<< "<a href='#'>Mark  as read</a>"
        }
    }

 def topPost={

         List<Resource>resources= Resource.resourcePost()

          out<< render(template:"/login/topPost" , model: [resources: resources])

 }
    def trendingTopics={
        if(session.user)
        {
             List<TopicVo> topicVos = Topic.trendingTopics()

            out<< render(template:"/user/trendingTopic" , model: [trendingTopics: topicVos])
        }

    }
//    def viewPost = { attrs, body ->
//
//
//        if (session.user) {
//
//            if(attrs.resource)
//                out<< render[view :""]
//            else
//                out<< "<a href='#'>Mark  as read</a>"
//        }
//    }


}
