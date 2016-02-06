//Remove all records from a list whose index is odd
 
 List first=["l1","l2","l3","l4"]
 println first
 List L=[]
 first.eachWithIndex{v,i-> if(i%2!=0)
                              L[i]=v    }
first.removeAll(L)
 println first