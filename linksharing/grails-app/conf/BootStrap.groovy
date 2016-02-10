class BootStrap {

    def grailsApplication
    def init = { servletContext ->


       def abc=  grailsApplication.linksharing.config.shalika
  println "$abc"
    }
    def destroy = {
    }
}
