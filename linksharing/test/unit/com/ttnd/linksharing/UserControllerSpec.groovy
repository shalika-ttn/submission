package com.ttnd.linksharing

import com.ttnd.linksharing.CO.ResourceSearchCo
import com.ttnd.linksharing.CO.TopicSearchCo
import com.ttnd.linksharing.CO.UserCo
import com.ttnd.linksharing.Enum.Visiblity
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([User, ReadingItem, Subscription])
class UserControllerSpec extends Specification {

    @IgnoreRest
    void "test for index"() {
        given:
        // User user = session.user
        controller.session.user = new User()
        Subscription.metaClass.static.findAllByUser = { return [new Subscription()] }

        ReadingItem.metaClass.static.findAllByUser = { user, map -> return [new ReadingItem()] }
        User.metaClass.subscribedTopics = [new Topic()]
        when:
        controller.index()
        then:
        view == "/user/dashboard"
        model.subscriptions.size() == 1
        model.readingItems.size() == 1
        model.listOfTopics.size() == 1
    }
//    @IgnoreRest
    void "test for register when user is already registerd"() {
        given:
        UserCo co = new UserCo()
        controller.session.user = new User()
        when:
        controller.register(co)
        then:
        response.contentAsString == "already registered"


    }

    @IgnoreRest
    void "testing for register action for a new user"() {
        given:
        params.pic = ["hii"]
        UserCo co = new UserCo(firstName: "shalikaa", lastName: "singhall", email: "sha@gmail.com", password: "abcd123",
                userName: "shal", confirmPassword: "abcd123")
        User user = new User(firstName: co.firstName, lastName: co.lastName, email: co.email, password: co.password,
                userName: co.userName, confirmPassword: co.confirmPassword)
        user.save(flush: true)
//        controller.session.user = new User()
        when:
        controller.register(co)
        then:
        view == "/user/register"


    }

    def profile(ResourceSearchCo co) {

        co.max = co.max ?: 5
        co.offset = co.offset ?: 0
        TopicSearchCo topicSearchCo = new TopicSearchCo(id: co.id, visiblity: co.visiblity, max: co.max, offset: co.offset)
        User user = User.findById(co.id)
        Integer totalCount = Resource.countByCreatedBy(user)
        List<Topic> topic = topicService.search(topicSearchCo)
        List<Topic> subscriptionTopic = subscriptionService.search(topicSearchCo)
        Integer totalCount1 = Subscription.countByUser(user)

        List<Resource> resourceList = resourceService.search(co)
        if (!request.xhr) {
            render(view: "/user/profile", model: [topics       : topic, subscriptions: subscriptionTopic, resources: resourceList, co: co, totalCount: totalCount
                                                  , totalCount1: totalCount1])

        } else
            render(template: "/user/resourceAjax", model: [resources: resourceList, co: co, totalCount: totalCount])

    }

    def "test for profile action"() {
        given:
        ResourceSearchCo resourceSearchCo = new ResourceSearchCo(max: 5, offset: 0, topicId: 4, visiblity: Visiblity.PUBLIC, id: 2)
        TopicSearchCo topicSearchCo=new TopicSearchCo(id:resourceSearchCo.id,visiblity:resourceSearchCo.visiblity,max:5,offset: 0)
        User user = new User(id: resourceSearchCo.id).save(validate: false)
        and:
        Integer count = Resource.metaClass.countByCreatedBy { User user1 ->
            2
        }
        and:
        def mockedTopicService=Mock(TopicService)
        List<Topic> topicList= mockedTopicService.search(topicSearchCo)
        and:
        def mockedSubscriptionService=Mock(SubscriptionService)
        List<Topic> topicList2= mockedSubscriptionService.search(topicSearchCo)
        and:
        Integer count2 = Subscription.metaClass.countByUser { User user1 ->
            3
        }
           and:
           .1



//        when:


    }


}


}
