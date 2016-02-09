do
{
   var amount= prompt("enter for amount","amount");
   }
while(amount==null|| isNaN(amount)||amount=="");

do
{
   var years= prompt("enter for years","years");
   }
while(years==null|| isNaN(years)||years=="");

do
{
   var interest= prompt("enter for interest","interest");
   }
while(interest==null|| isNaN(interest)||interest=="");

var simple=(amount*years*interest)/100;
document.write("simple interest is "+simple); 