class Time
{
 int hours
 int mins
 
 Time plus(Time t)
 { 
   Time tt=new Time()
   tt.hours=(this.hours)+t.hours
    
    tt.mins=this.mins+t.mins
     tt
    
  }
  
  Time minus(Time t)
 { 
   Time tt=new Time()
    tt.hours=this.hours-t.hours
    
    tt.mins=this.mins-t.mins
    tt
    
  }
  String toString(){
        "Time : ${hours} hrs. ${mins} mins."
    }
}

def t1=new Time ([hours:7,mins:20])
def t2=new Time ([hours:4,mins:10])

t3=(t1+t2)
println t3