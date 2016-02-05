def currentDir = new File("groovy-example")

/*currentDir.eachFile(groovy.io.FileType.FILES) {
new File("groovy-example/groovy_new.txt").append( it.text)
}
new File("groovy-example/groovy_new.txt").readLines()*/
new File ("groovy-example/groovy_new.txt").eachLine
{ i,l-> 
        if((l%2)!=0) 
       //println(i+"==========================="+l) 
           new File("groovy-example/groovy_new1.txt").append("$l $i \n")      
           
}