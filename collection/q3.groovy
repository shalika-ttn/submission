/* Create a set from a list containing duplicate elements. What do you observe? 
How can you achieve the same result without converting a list to a set?*/

List l=[1,1,2,3,3,3]
println l

Set s=l as Set

println s//yes duplicate elements are removed

//another way
List l2=[4,4,2,3,3,3]
l2.unique()
println l2

