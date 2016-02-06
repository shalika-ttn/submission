/*. Consider the following list: [1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ]
 Print the class name of each element.
 What's the output of the following statement? list.get(6).get(9)*/
 
 
 List l=[1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ]
 println l

//println l[1].getclass()//it didnt worked but

l.eachWithIndex{v,i-> println v.getClass()}

println l.get(6).get(9)