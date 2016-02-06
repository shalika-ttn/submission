/* Sort the given list in descending order having 
distinct elements: [14,12, 11,10, 16, 15,12, 10, 99, 90, 14, 16, 35] */
 List l=[14,12, 11,10, 16, 15,12, 10, 99, 90, 14, 16, 35] 
println  l.unique().sort{-it}