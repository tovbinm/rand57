//-------------------rand5 to rand7-------------

//Problem:
//Given a function which produces a random integer in the range [1,5], 
//write a function which produces a random integer in the range [1,7].

//----------------------------------------------

def rand5 = scala.util.Random.nextInt(5) + 1

//-------------------Solution-------------------

// Initial implementation: 7 x rand5
def rand7_1 = {
  var r = 0
  for(x <- 0 to 7) r = r + rand5 
  r%7 + 1
}
// Improved version: ~3 x rand5
def rand7_2 = {
  var vv = rand8
  while(vv==8) vv = rand8
  vv
}  
// Improved version: ~2 x rand5
def rand7_3 = {
  var vv = rand16
  while(vv>14) vv = rand16
  vv%7 + 1
}    

//-------------------Helpers-------------------
def rand2 : Int = {
   var v = rand5
   while(v==3) v = rand5
   if (v>3) return 2
   1
}
def rand4 = {
    var v = rand5-1 
    while(v>3) v = rand5-1
    v+1
}
def rand8 = {
  var r = 0 
  for(x <- 0 to 2) {
     r = r + ((rand2-1) << x)  
  }
  r+1
}
def rand16 = ((rand4-1) + ((rand4-1) << 2))+1
    

//-------------------Tests-------------------
import compat.Platform._

def testrand(size: Int, rand:()=>Int) {
   var res = Array.fill(size){0} 
   var timeElapsed = 0L
   (1 to 1000000).foreach(x => {
         val st = currentTime
         val r = rand() 
         timeElapsed = timeElapsed + currentTime - st
         res(r-1) = res(r-1) + 1
      }) 
   println(size.toString + " : " + timeElapsed.toString 
                         + "ms : " + res.mkString(","))
}
for(x<-0 to 100){
  testrand(2, rand2 _)
  testrand(4, rand4 _)
  testrand(5, rand5 _)
  testrand(7, rand7_1 _)
  testrand(7, rand7_2 _)
  testrand(7, rand7_3 _)
  testrand(8, rand8 _)
  testrand(16, rand16 _)
}