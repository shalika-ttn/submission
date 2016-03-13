package com.ttnd.linksharing.DTO

class EmailDTO {


    List<String> to
    String view
    String subject
    Map model

    static constraints =
            {
                model(nullable: true)
                to(nullable: false)
                view(nullable: false)
                subject(nullable: false)
            }


}
