
class jugbp1 {
  var a_max = 4
  var b_max = 3
  var a = 0
  var b = 0
  var goal = 2
  
  def checkGoal() {
    var fin = 0
    
    while (fin != 1) {
      if (a == goal || b == goal) {
        fin = 1
        println("Solution found  !")
      }
      
      else if (a == 0) {
        fillA()
      } else if (a > 0 && b != b_max) {
        transferAtoB()
      } else if (a > 0 && b == b_max) {
        emptyB()
      }
      else
        println("Solution Not Found")
    }
  }
  
  def fillA() {
    a = a_max
    println("{" + a + "," + b + "}")
  }
  
  def fillB() {
    b = b_max
    println("{" + a + "," + b + "}")
  }
  
  def transferAtoB() {
    var fin = 0
    
    while (fin != 1) {
      b += 1
      a -= 1
      
      if (b == b_max || a == 0) {
        fin = 1
      }
    }
    
    println("{" + a + "," + b + "}")
  }
  
  def emptyA() {
    a = 0
    println("{" + a + "," + b + "}")
  }
  
  def emptyB() {
    b = 0
    println("{" + a + "," + b + "}")
  }
}
