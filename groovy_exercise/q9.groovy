def currentDir = new File("/home/shalika/groovy-example")

currentDir.eachFile( FileType.FILES) {
new File("home/shalika/groovynew.txt").text= it.text
}