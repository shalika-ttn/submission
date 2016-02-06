// Iterate over the previous map in as many ways as possible 
def map=["shalika":23,"surbhi":22,"mishika":22,"saloni":23,"sakshi":23,"shubhi":24,
         "swati":20,"john":25,"srk":30,"abc":56,"nitin":25,"saksham":"27"]
        
 println map.containsValue(25)
println map.values()

map.find{ i,v->if(i=="mishika")
 println v }
 map.findAll{ i,v->if(v==23)
 println i }
  
map.each{ println "name :"+ it.key +" age: "+it.value }               

map.eachWithIndex {key,value,i->
println "at index"+i+"name "+ key + " : " + " age " + value
}