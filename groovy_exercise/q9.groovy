def currentDir = new File("groovy-example")

currentDir.eachFile(groovy.io.FileType.FILES) {
new File("groovy-example/groovy_new.txt").append( it.text)
}