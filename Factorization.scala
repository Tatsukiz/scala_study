import scala.math.sqrt

object Factorization extends App {

  def factorization(target: Int): Map[Int, Int] = {
    val maxDivisor = sqrt(target).toInt

    def factorizationRec(target: Int, divisor: Int, acc: Map[Int, Int]): Map[Int, Int] = {
      if (divisor > maxDivisor){
        if (target == 1) acc else acc + (target -> 1)
      } else if (target % divisor == 0) {
        val nextAcc = acc + (divisor -> (acc.getOrElse(divisor, 0) + 1))
        factorizationRec(target / divisor, divisor, nextAcc)
      } else {
        factorizationRec(target, divisor + 1, acc)
      }
    }
    factorizationRec(target, 2, Map())
  }

  println(factorization(510510))
}