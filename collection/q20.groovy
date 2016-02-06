//Try the following code on a map: println map.class println map.getClass() What do you observe? 
def map=["shalika":23,"surbhi":22,"mishika":22,"saloni":23,"sakshi":23,"shubhi":24,
         "swati":20,"john":25,"srk":30,"abc":56,"nitin":25,"saksham":"27"
        ]
        def map2=[1:"a",2:"b",3:"c"]
        
        def map3=map+map2
        
        println map3
        
        println map3.class//showing null because no such property exist
        println map3.getClass()//showing class of map
        