package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.Enum.Visiblity
import com.ttnd.linksharing.VO.RatingInfoVo
import com.ttnd.linksharing.VO.TopicVo
import com.ttnd.linksharing.Topic


class ResourceController {

    def index() {
        render "hiiiiiiiiiiii"
    }


    def show(Long id) {
        Resource resource = Resource.findById(id)


        RatingInfoVo ratingInfoVo = resource.ratingInfo
        render "Total score= $ratingInfoVo.totalScore Total votes= $ratingInfoVo.totalVotes average score= $ratingInfoVo.averageScore "

    }

    def showtopics() {   //Resource resource = Resource.findById(id)

        List<TopicVo> topicVo = Topic.trendingTopics()

        //render(template: "/user/trendingTopic", model:[topicVo:"topicVo"] )
        render topicVo

    }

    def search(ResourceSearchCo co) {
        if (co.q)
            co.visiblity = Visiblity.PUBLIC
        println("co:${co.properties}")
        List<Resource> resources = Resource.search(co).list()
        render "resources $resources"


    }

    def delete(Long id) {
        Resource resource = Resource.load(id)


        if (resource) {

            try {
                resource.delete(flush: true)
                resource.deleteFile()
                redirect(controller: "user", action: "index")
            } catch (Exception e) {
                render "$e resource could not be found hence could not be deleted"
            }
        }

    }

    def post2(Long id) {
        Resource resource = Resource.findById(id)
        if (resource)
            render(view: "/user/post", model: [post: resource])
        else
            render "failure in getting resource id"


    }





}
