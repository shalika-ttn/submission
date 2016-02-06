/*. Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz”
 instead of the number and for the multiples of five print “Buzz”. 
For numbers which are multiples of both three and five print "FizzBuzz". */

(1..100).each{
           if((it%3==0)&&(it%5==0))
            println "FIZZBUZZ"
            else if(it%5==0)
            println "BUZZ"
            else if(it%3==0)
            println "FIZZ"
                else println it
 }