//Write a method which retruns the value of passed key from a search string of the form "http://www.google.com?name=johny&age=20&hobby=cricket" 

String s="http://www.google.com?name=johny&age=20&hobby=cricket"
List l=s.tokenize("?")
List l1=l[1].tokenize("&")
println l1

Map m=[:]
List l2=[]
l1.each{   l2=it.tokenize("=")
            m.put(l2[0],l2[1])
            }
 println m
 m.each{ println "$it.key and $it.value "
     
         }
  
 