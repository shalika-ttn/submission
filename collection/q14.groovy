// Find the number of occurences of a character in a string

String s="hello welcome to To The New Digital"
def map = [:] 

//s.eachWithIndex{v,i-> map[i:v]}
def x=1,n=0
 s.each{
       map.put(x,it)
         x++
   }
   println map
    println ""
   map.findAll{i,v-> if(v=='e')
                      n++
                      }
 println "e occures "+" $n"+" times"
 