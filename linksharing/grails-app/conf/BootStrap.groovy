import com.ttnd.linksharing.DocumentResource
import com.ttnd.linksharing.Enum.Visiblity
import com.ttnd.linksharing.LinkResource
import com.ttnd.linksharing.Resource
import com.ttnd.linksharing.Topic
import com.ttnd.linksharing.User
import com.ttnd.linksharing.Constants.Constant


class BootStrap {

    def grailsApplication
    def init = { servletContext ->

        println(grailsApplication.config.grails.shalika)
        List<User> users = createUsers()
        List<Topic> topics = createTopics(users)
        List<Resource> resources=createResources(topics)
    }

    List<User> createUsers() {
        List<User> users = []
        if (User.count == 0) {
            User user1 = new User(firstName: "shalika", lastName: "singhal", email: "shalika.singhal@tothenew.com",
                    password: Constant.DEFAULT_PASSWD, userName: "sha",
                    admin: true, active: true);

            User user2 = new User(firstName: "saloni", lastName: "sharma", email: "saloni.sharma@tothenew.com",
                    password: Constant.DEFAULT_PASSWD, userName: "sal",
                    admin: false, active: true);
            try {
                if (user1.save(flush: true, failOnError: true)) {
                    users.add(user1)
                    log.info "User ${user1} saved successfully"
                }
            }
            catch (Exception e) {
                log.error "Error saving user : ${user1.errors.allErrors}"
            }
            try {
                if (user2.save(flush: true, failOnError: true)) {
                    users.add(user2)
                    log.info "User ${user2} saved successfully"
                }
            } catch (Exception e) {
                log.error "Error saving user : ${user2.errors.allErrors}"
            }
          /*  User user3 = new User(firstName: "surbhi", lastName: "dhawan", email: "surbhi.dhawan@tothenew.com",
                    password: Constant.DEFAULT_PASSWD, userName: "sur",
                    admin: false, active: true);
            try {
                if (user3.save(flush: true, failOnError: true)) {
                    users.add(user3)
                    log.info "User ${user3} saved successfully"
                }
            }
            catch (Exception e) {
                log.error "Error saving user : ${user3.errors.allErrors}"
            }*/

        } else {
            users = User.list()
        }
        users
    }

    List<Topic> createTopics(List<User> users) {
        List<Topic> topics = []
        if (Topic.count == 0) {
            users.each { User user ->
                (1..5).each {
                    Topic topic = new Topic(name: "Topic${it}", createdBy: user, visiblity: Visiblity.PUBLIC)
                    topics.add(topic)
                    if (user.addToTopics(topic).save()) {
                        topics.add(topic)
                        log.info "topic ${topic.name} saved successfully"
                    } else {
                        log.error "Error saving topic : ${topic.name}"
                    }
                }


            }
            topics
        } else {
            log.error("table not empty")
            Topic.list()
        }
    }

   /* List <Resource>createResources(List<Topic> topics) {
        List <Resource> resources=[]
        if(LinkResource.count==0&&DocumentResource.count==0) {
            topics.each { Topic topic ->

                LinkResource linkResource1 = new LinkResource(url: "www.google.com", description: "this for topic ${topic.name} ",
                        createdBy: topic.createdBy, topic: topic)
                if(linkResource1.save())
                    resources.add(linkResource1)
                else
                    log.error "Error saving resource : ${linkResource1.errors.allErrors}"
                LinkResource linkResource2 = new LinkResource(url: "www.yahoo.com", description: "this is  for topic ${topic.name}",
                        createdBy: topic.createdBy, topic: topic)
                if(linkResource2.save())
                    resources.add(linkResource2)
                else
                    log.error "Error saving resource : ${linkResource2.errors.allErrors}"

                DocumentResource documentResource1 = new DocumentResource(createdBy: topic.createdBy, topic: topic, description: "this doc for ${topic.name}",
                        filepath: "hello/d2")
                if(documentResource1.save())
                    resources.add(documentResource1)
                else
                    log.error "Error saving resource : ${documentResource1.errors.allErrors}"

                DocumentResource documentResource2 = new DocumentResource(createdBy: topic.createdBy, topic: topic, description: "this doc is for ${topic.name}",
                        filepath: "hello/d2")
                if(documentResource2.save())
                    resources.add(documentResource2)
                else
                    log.error "Error saving resource : ${documentResource2.errors.allErrors}"

            }

                resources
        }else
        {
            log.error("resources created")
            resources.addAll(LinkResource.list())
            resources.addAll(DocumentResource.list())
            resources
        }*/


        }
 /* void  createReadingItems(resources){
   resources.each{
         it.createdBy!=
   }

    }
  void  subscribeTopics(){

  }*/


    def destroy = {
    }
}
