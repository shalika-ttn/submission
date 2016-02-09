/*Consider a class named "Stack" that holds a list of objects and has the following operations associated: 
1) POP - Pops the last element off the stack 2) PUSH - Pushes an element on top of the stack 3) TOP - 
Returns the element at the top of the list Implement the aforesaid class */

class Stack
{
   List l =[]
   
    void push(int element)
    {
          if(l.size()==9)
           println "stack overflow"
            else 
          { l.push(element)
           
           println "stack content is $l"
             }
     }
     void pop()
     {
          if(l.size()==0)
          println "underflow"
          else
        { println "element popped ${l.pop()}"
          println "stack content is $l "
          } 
      }
      
   }
   Stack s= new Stack()
   s.push(1)
   s.push(2)
   s.push(3)
   s.push(4)
   s.push(5)
   
   s.pop()
    s.pop()  