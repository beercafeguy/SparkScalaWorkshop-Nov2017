var t1=0
var t2=1
for (i <-0 to 10){
  println(t1)
  var nex=t1+t2
  println(nex)
  t1=t2
  t2=nex
}

val tup=(1,2,3,4)
println(tup._1)
val m="Hem"->20
