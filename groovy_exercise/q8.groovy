def check={l,item-> if(l.contains(item))
                      1
                     }
 List  l=new ArrayList(3)
 3.times{i->l.add(i)}
 
 
        println (check(l,2)==1)
        
        
        
        