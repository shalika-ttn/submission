class Time
{
 int hours
 int mins
 
 Time plus(Time t)
 { 
   Time tt=new Time()
   if(this.mins+t.mins>60)
   {tt.mins=(this.mins+t.mins)-60
    tt.hours=(this.hours)+t.hours+1
   }else{
    
   tt.hours=(this.hours)+t.hours
    
    tt.mins=this.mins+t.mins
     }
     tt
    
  }
  
  Time minus(Time t)
 { 
   Time tt=new Time()
   if(this.mins>t.mins)
   {
    tt.hours=this.hours-t.hours
    
    tt.mins=this.mins-t.mins}
    else
    {tt.hours=t.hours-this.hours
    
    tt.mins=t.mins-this.mins
    }
    tt
    
  }
  String toString(){
        "Time : ${hours} hrs. ${mins} mins."
    }
}

def t1=new Time ([hours:7,mins:56])
def t2=new Time ([hours:4,mins:10])

t3=(t1+t2)
println "After overloading plus operator $t3"
t3=t2-t1
println "After overloading minus operator $t3"

