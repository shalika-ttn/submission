 File f=new File("regex.groovy")
 String s=f.text.replaceAll("[\t \n]","") 
 
 f.text=s
 