/*Consider the following map: Map m = [‘Computing’ : [‘Computing’ : 600, ‘Information Systems’ : 300], ‘Engineering’ : [‘Civil’ : 200, ‘Mechanical’ : 100], 
‘Management’ : [‘Management’ : 800] ] 22a) How many university departments are there? 22b) How many programs are delivered by the Computing department? 
22c) How many students are enrolled in the Civil Engineering program? */

 Map m = ['Computing' : ['Computing' : 600, 'Information Systems' : 300], 'Engineering' : ['Civil': 200, 'Mechanical' : 100], 
'Management' : ['Management': 800] ]
int num=0,num2=0;
m.each{v,i->
            num++
         }
println "Number of depratments are " + num  

m.eachWithIndex {key,value,index->
                        if(key=='Computing')
                        {    print  "programs deliverd by computing departments are "   
                         value.each{i,v->  num2++}
                            print " "+num2  }   
}
println " "
println  "Students enrolled in civil engineering are "+ m['Engineering']['Civil']